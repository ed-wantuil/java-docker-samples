package ed_wantuil.java_docker_sample.repository;

import ed_wantuil.java_docker_sample.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
}
