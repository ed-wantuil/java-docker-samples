package ed_wantuil.java_docker_sample.controller.dto.mapper;

import ed_wantuil.java_docker_sample.controller.dto.request.MemberRequest;
import ed_wantuil.java_docker_sample.controller.dto.response.MemberResponse;
import ed_wantuil.java_docker_sample.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member memberRequestToMember(final MemberRequest memberRequest) {
        return Member.builder()
                .name(memberRequest.name())
                .address(memberRequest.address())
                .phone(memberRequest.phone())
                .email(memberRequest.email())
                .build();
    }

    public MemberResponse memberToMemberResponse(final Member member) {
        return MemberResponse.builder()
                .id(member.getId().toString())
                .name(member.getName())
                .address(member.getAddress())
                .phone(member.getPhone())
                .email(member.getEmail())
                .build();
    }
}
