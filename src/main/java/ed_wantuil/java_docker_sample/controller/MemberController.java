package ed_wantuil.java_docker_sample.controller;

import ed_wantuil.java_docker_sample.controller.dto.mapper.MemberMapper;
import ed_wantuil.java_docker_sample.controller.dto.request.MemberRequest;
import ed_wantuil.java_docker_sample.controller.dto.response.MemberResponse;
import ed_wantuil.java_docker_sample.entity.Member;
import ed_wantuil.java_docker_sample.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;

    private final MemberService memberService;

    @PostMapping
    public MemberResponse createMember(@RequestBody final MemberRequest memberRequest) {
        Member member = memberMapper.memberRequestToMember(memberRequest);

        member = memberService.createMember(member);

        return memberMapper.memberToMemberResponse(member);
    }
}
