package ed_wantuil.java_docker_sample.controller;

import ed_wantuil.java_docker_sample.controller.dto.mapper.LoanMapper;
import ed_wantuil.java_docker_sample.controller.dto.request.LoanRequest;
import ed_wantuil.java_docker_sample.controller.dto.response.LoanResponse;
import ed_wantuil.java_docker_sample.entity.Loan;
import ed_wantuil.java_docker_sample.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanMapper loanMapper;

    private final LoanService loanService;

    @PostMapping
    public LoanResponse createLoan(@RequestBody final LoanRequest loanRequest){
        Loan loan = loanMapper.loanRequestToLoan(loanRequest);

        loan = loanService.createLoan(loan);

        return loanMapper.loanToLoanResponse(loan);
    }
}
