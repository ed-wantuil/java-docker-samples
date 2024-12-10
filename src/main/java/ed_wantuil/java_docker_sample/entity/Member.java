package ed_wantuil.java_docker_sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private String address;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "member")
    private List<Loan> loans;

}
