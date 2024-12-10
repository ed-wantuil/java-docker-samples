package ed_wantuil.java_docker_sample.controller.dto.response;

import lombok.Builder;

@Builder
public record MemberResponse(String id,
                             String name,
                             String address,
                             String phone,
                             String email) {
}
