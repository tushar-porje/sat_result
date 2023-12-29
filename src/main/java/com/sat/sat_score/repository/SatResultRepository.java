package com.sat.sat_score.repository;

import java.util.List;

import com.sat.sat_score.entity.SatResult;

public interface SatResultRepository {

    String save(SatResult satResult);
    List<SatResult> viewAllData();
    int getRank(String name);
    String updateScore(String name,long satScore);
    String remove(String name);
    boolean isExist(String name);
    boolean getPassStatus(long score);
}
