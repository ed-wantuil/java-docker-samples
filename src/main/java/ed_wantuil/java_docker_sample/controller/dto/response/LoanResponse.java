package ed_wantuil.java_docker_sample.controller.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record LoanResponse(String id,
                           BookResponse book,
                           MemberResponse member,
                           LocalDateTime loanDate,
                           LocalDateTime dueDate,
                           String status) {
}
