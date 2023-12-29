package com.sat.sat_score.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class SatResult {
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String city;
    @NonNull
    private String country;
    @NonNull
    private long pincode;
    @NonNull
    private long satScore;
    private boolean passed;
}
