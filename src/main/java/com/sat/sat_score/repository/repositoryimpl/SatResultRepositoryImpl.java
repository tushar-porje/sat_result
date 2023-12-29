package com.sat.sat_score.repository.repositoryimpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sat.sat_score.entity.SatResult;
import com.sat.sat_score.repository.SatResultRepository;

@Repository
public class SatResultRepositoryImpl implements SatResultRepository{
    
    private HashMap<String,SatResult> satMap=new HashMap<>();

    @Override
    public String save(SatResult satResult) {
        satResult.setPassed(getPassStatus(satResult.getSatScore()));
        satMap.put(satResult.getName(), satResult);
        return satResult.getName();
    }

    @Override
    public List<SatResult> viewAllData() {
        return satMap.values().stream().toList();
    }

    @Override
    public int getRank(String name) {

        // List<SatResult> passedResult= satMap.values().stream().filter(x->x.isPassed()).toList();
        List<SatResult> mutablePassedResult=new ArrayList<>(satMap.values());
        // Collections.sort(mutablePassedResult,Comparator.comparingLong(SatResult::getSatScore));
        mutablePassedResult.sort(Comparator.comparingLong(SatResult::getSatScore).reversed());

        int rank = 0;
        for (int i = 0; i < mutablePassedResult.size(); i++) {
            if (mutablePassedResult.get(i).getName().equals(name)) {
                rank = i + 1;
                break;
            }
        }

        return rank;
    }

    @Override
    public String updateScore(String name, long satScore) {
        SatResult updateSatResult=satMap.get(name);
        updateSatResult.setSatScore(satScore);
        updateSatResult.setPassed(getPassStatus(updateSatResult.getSatScore()));
        satMap.put(name, updateSatResult);

        return name+" score is updated";
    }

    @Override
    public String remove(String name) {
        satMap.remove(name);

        return name+" result is removed";
    }

    @Override
    public boolean isExist(String name) {
        return satMap.containsKey(name);
    }

    @Override
    public boolean getPassStatus(long score) {
        if(score>30) return true;
        return false;
    }
    

}
