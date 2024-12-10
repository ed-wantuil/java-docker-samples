package ed_wantuil.java_docker_sample.service;

import ed_wantuil.java_docker_sample.entity.Member;
import ed_wantuil.java_docker_sample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
       return memberRepository.save(member);
    }
}
