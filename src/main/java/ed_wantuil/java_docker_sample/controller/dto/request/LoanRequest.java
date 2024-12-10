package ed_wantuil.java_docker_sample.controller.dto.request;

import java.time.LocalDateTime;

public record LoanRequest(String bookId,
                          String memberId,
                          LocalDateTime loanDate,
                          LocalDateTime dueDate,
                          String status) {
}
