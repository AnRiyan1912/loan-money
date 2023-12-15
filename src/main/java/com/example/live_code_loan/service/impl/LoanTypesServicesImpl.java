package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.dto.loanType.response.LoanResponse;
import com.example.live_code_loan.entity.LoanType;
import com.example.live_code_loan.repository.LoanTypesRepository;
import com.example.live_code_loan.service.LoanTypesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanTypesServicesImpl implements LoanTypesServices {
    private final LoanTypesRepository loanTypesRepository;


    @Override
    public LoanResponse create(LoanType loanType) {
        LoanType saveLoanType = loanTypesRepository.save(loanType);
        return LoanResponse.builder()
                .id(saveLoanType.getId())
                .maxLoan(saveLoanType.getMaxLoan())
                .type(saveLoanType.getType())
                .build();
    }

    @Override
    public LoanResponse update(LoanType loanType) {
        LoanResponse loanResponse = getBYId(loanType.getId());
        if (loanResponse != null) {
          LoanType saveLoanType =   loanTypesRepository.save(LoanType.builder()
                            .id(loanResponse.getId())
                            .type(loanResponse.getType())
                            .maxLoan(loanResponse.getMaxLoan())
                    .build());
          return LoanResponse.builder()
                  .id(saveLoanType.getId())
                  .maxLoan(saveLoanType.getMaxLoan())
                  .type(saveLoanType.getType())
                  .build();
        }
        return null;
    }

    @Override
    public LoanResponse getBYId(String id) {
        LoanType loanType = loanTypesRepository.findById(id).orElse(null);
        if (loanType == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan type not found")
        }
        return LoanResponse.builder()
                .id(loanType.getId())
                .type(loanType.getType())
                .maxLoan(loanType.getMaxLoan())
                .build();
    }

    @Override
    public List<LoanResponse> getAll() {
        List<LoanType> loanResponseList = loanTypesRepository.findAll();
        return loanResponseList.stream().map(loanType ->
                        LoanResponse.builder()
                                .id(loanType.getId())
                                .type(loanType.getType())
                                .maxLoan(loanType.getMaxLoan())
                                .build()
                ).toList();
    }

    @Override
    public void remove(String id) {
            LoanResponse loanResponse = getBYId(id);
            if (loanResponse != null) {
                loanTypesRepository.delete(LoanType.builder()
                                .id(loanResponse.getId())
                                .maxLoan(loanResponse.getMaxLoan())
                                .type(loanResponse.getType())
                        .build());
            }
    }
}
