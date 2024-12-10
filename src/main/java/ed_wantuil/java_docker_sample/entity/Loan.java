package ed_wantuil.java_docker_sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Loan {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    private LocalDateTime loanDate;

    private LocalDateTime dueDate;

    private String status;

}
