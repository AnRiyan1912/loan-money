package com.example.live_code_loan.dto.instalmentType.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InstalmentTypeRequest {
    private String id;
    private String instalmentType;
}
