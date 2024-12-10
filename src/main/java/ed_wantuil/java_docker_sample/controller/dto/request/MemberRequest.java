package ed_wantuil.java_docker_sample.controller.dto.request;

public record MemberRequest(String name,
                            String address,
                            String phone,
                            String email) {
}
