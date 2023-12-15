package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.constant.EInstalmentType;
import com.example.live_code_loan.dto.instalmentType.response.InstalTypeResponse;
import com.example.live_code_loan.entity.InstalmentType;
import com.example.live_code_loan.repository.InstalmentTypeRepository;
import com.example.live_code_loan.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstalmentTypeServiceRepository implements InstalmentTypeService{
    private final InstalmentTypeRepository instalmentTypeRepository;

    @Override
    public InstalTypeResponse create(InstalmentType instalmentType) {
        InstalmentType saveInstalmentType = instalmentTypeRepository.save(instalmentType);
        return InstalTypeResponse.builder()
                .id(saveInstalmentType.getId())
                .instalmentType(saveInstalmentType.getInstalmentType().name())
                .build();
    }

    @Override
    public InstalTypeResponse update(InstalmentType instalmentType) {
        InstalTypeResponse instalTypeResponse = getBYId(instalmentType.getId());
        if (instalmentType != null){
            InstalmentType saveInstalmentType =  instalmentTypeRepository.save(InstalmentType.builder()
                    .id(instalmentType.getId())
                    .instalmentType(instalmentType.getInstalmentType())
                    .build());
            return instalTypeResponse.toBuilder()
                    .id(saveInstalmentType.getId())
                    .instalmentType(saveInstalmentType.getInstalmentType().name())
                    .build();
        }

        return null;
    }

    @Override
    public InstalTypeResponse getBYId(String id) {
        InstalmentType instalmentType = instalmentTypeRepository.findById(id).orElse(null);
        if (instalmentType == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instalment type not found");
        }
        return InstalTypeResponse.builder()
                .id(instalmentType.getId())
                .instalmentType(instalmentType.getInstalmentType().name())
                .build();
    }

    @Override
    public List<InstalTypeResponse> getAll() {
        List<InstalmentType> instalmentTypes = instalmentTypeRepository.findAll();
        return instalmentTypes.stream().map(instalmentType ->
                InstalTypeResponse.builder()
                        .id(instalmentType.getId())
                        .instalmentType(instalmentType.getInstalmentType().name())
                        .build()).toList();
    }

    @Override
    public void remove(String id) {
        InstalTypeResponse instalTypeResponse = getBYId(id);
        if (instalTypeResponse!=null){
            instalmentTypeRepository.delete(InstalmentType.builder()
                            .id(instalTypeResponse.getId())
                            .instalmentType(EInstalmentType.valueOf(instalTypeResponse.getInstalmentType()))
                    .build());
        }
    }
}
