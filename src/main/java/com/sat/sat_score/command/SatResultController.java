package com.sat.sat_score.command;

import org.springframework.web.bind.annotation.RestController;

import com.sat.sat_score.entity.SatResult;
import com.sat.sat_score.service.SatResultService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/sat-result")
public class SatResultController {

    @Autowired
    SatResultService satResultService;
    
    @PostMapping("/insert")
    public ResponseEntity<String> insertData(@RequestBody SatResult satResult) {
        
        String insertStatus = satResultService.insert(satResult);
        return ResponseEntity.ok(insertStatus);
    }

    @GetMapping("/view-all")
    public ResponseEntity<List<SatResult>> viewAllData() {
        List<SatResult> satResults=satResultService.viewAllData();
        return ResponseEntity.ok(satResults);
    }

    @GetMapping("/get-rank/{name}")
    public ResponseEntity<Integer> getRank(@PathVariable String name) {
        int rank=satResultService.getRank(name);
        return ResponseEntity.ok(rank);
    }

    @PutMapping("/update-score/{name}")
    public ResponseEntity<String> updateScore(@PathVariable String name, @RequestParam long newScore) {
        String updateStatus= satResultService.updateScore(name, newScore);
        return ResponseEntity.ok(updateStatus);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteRecord(@PathVariable String name) {
        String deleteStatus=satResultService.delete(name);
        return new ResponseEntity<String>(deleteStatus, HttpStatus.OK);
    }
}
