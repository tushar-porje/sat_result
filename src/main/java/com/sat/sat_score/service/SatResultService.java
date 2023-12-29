package com.sat.sat_score.service;
import java.util.List;

import com.sat.sat_score.entity.SatResult;

public interface SatResultService {

    String insert(SatResult satResult);
    List<SatResult> viewAllData();
    int getRank(String name);
    String updateScore(String name,long satScore);
    String delete(String name);
    boolean isAlreadyExist(String name);

}