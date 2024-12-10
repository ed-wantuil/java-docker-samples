package ed_wantuil.java_docker_sample.controller.dto.mapper;

import ed_wantuil.java_docker_sample.controller.dto.request.LoanRequest;
import ed_wantuil.java_docker_sample.controller.dto.response.LoanResponse;
import ed_wantuil.java_docker_sample.entity.Book;
import ed_wantuil.java_docker_sample.entity.Loan;
import ed_wantuil.java_docker_sample.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoanMapper {

    private final BookMapper bookMapper;

    private final MemberMapper memberMapper;

    public Loan loanRequestToLoan(LoanRequest loanRequest) {
        return Loan.builder()
                .book(Book.builder()
                        .id(UUID.fromString(loanRequest.bookId()))
                        .build())
                .member(Member.builder()
                        .id(UUID.fromString(loanRequest.memberId()))
                        .build())
                .loanDate(loanRequest.loanDate())
                .dueDate(loanRequest.dueDate())
                .status(loanRequest.status())
                .build();
    }

    public LoanResponse loanToLoanResponse(Loan loan) {
        return LoanResponse.builder()
                .id(loan.getId().toString())
                .book(bookMapper.bookToBookResponse(loan.getBook()))
                .member(memberMapper.memberToMemberResponse(loan.getMember()))
                .loanDate(loan.getLoanDate())
                .dueDate(loan.getDueDate())
                .status(loan.getStatus())
                .build();
    }
}
