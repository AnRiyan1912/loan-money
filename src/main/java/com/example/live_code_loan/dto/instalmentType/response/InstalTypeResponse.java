package com.example.live_code_loan.dto.instalmentType.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InstalTypeResponse {
    private String id;
    private String instalmentType;
}
