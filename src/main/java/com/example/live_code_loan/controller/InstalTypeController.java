package com.example.live_code_loan.controller;

import com.example.live_code_loan.constant.AppPath;
import com.example.live_code_loan.dto.commondResponse.CommondResponse;
import com.example.live_code_loan.dto.customer.response.CustomerUserResponse;
import com.example.live_code_loan.dto.instalmentType.response.InstalTypeResponse;
import com.example.live_code_loan.entity.InstalmentType;
import com.example.live_code_loan.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.instalmentType)
public class InstalTypeController {
    private final InstalmentTypeService instalmentTypeService;
    @PostMapping
    public ResponseEntity<?> getCustomerById (@RequestBody InstalmentType instalmentType) {
        InstalTypeResponse instalmentTypeResponse = instalmentTypeService.create(instalmentType);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<InstalTypeResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crete installment type")
                        .data(instalmentTypeResponse)
                        .build()
        );
    }
    @GetMapping(AppPath.id)
    public ResponseEntity<?> getById (@PathVariable String id) {
        InstalTypeResponse instalmentTypeResponse = instalmentTypeService.getBYId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<InstalTypeResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully get installment type")
                        .data(instalmentTypeResponse)
                        .build()
        );
    }
    @PutMapping
    public ResponseEntity<?> updateInstalmentType (@RequestBody InstalmentType instalmentType) {
        InstalTypeResponse instalmentTypeResponse = instalmentTypeService.update(instalmentType);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<InstalTypeResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully update installment type")
                        .data(instalmentTypeResponse)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllInstalmentType () {
        List<InstalTypeResponse> instalTypeResponseList = instalmentTypeService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<List<InstalTypeResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully fetch installment type")
                        .data(instalTypeResponseList)
                        .build()
        );
    }
    @DeleteMapping(AppPath.id)
    public ResponseEntity<?> deleteInstalmentById (@PathVariable String id) {
        instalmentTypeService.remove(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<InstalTypeResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully delete instalment type")
                        .build()
        );
    }

}
