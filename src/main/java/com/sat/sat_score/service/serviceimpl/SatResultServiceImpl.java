package com.sat.sat_score.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sat.sat_score.entity.SatResult;
import com.sat.sat_score.repository.SatResultRepository;
import com.sat.sat_score.service.SatResultService;

@Service
public class SatResultServiceImpl implements SatResultService {

    @Autowired
    SatResultRepository satResultRepository;

    @Override
    public String insert(SatResult satResult) {
        if(isAlreadyExist(satResult.getName())){
            return "result with "+satResult.getName()+" already exist";
        }else{
            satResultRepository.save(satResult);
            return "result of "+satResult.getName()+" saved successfully";
        }
    }

    @Override
    public List<SatResult> viewAllData() {
        return satResultRepository.viewAllData();
    }

    @Override
    public int getRank(String name) {
        if(!isAlreadyExist(name)){
            return -1;
        }else{
            return satResultRepository.getRank(name);
        }
    }

    @Override
    public String updateScore(String name, long satScore) {
        if(!isAlreadyExist(name)){
            return "result with "+name+" doesn't exist";
        }else{
            return satResultRepository.updateScore(name, satScore);
        }
    }

    @Override
    public String delete(String name) {
        if(!isAlreadyExist(name)){
            return "result with "+name+" doesn't exist";
        }else{
            return satResultRepository.remove(name);
        }
    }


    @Override
    public boolean isAlreadyExist(String name) {
        return satResultRepository.isExist(name);
    }
    
}
