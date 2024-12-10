package ed_wantuil.java_docker_sample.controller.dto.response;

import lombok.Builder;

@Builder
public record BookResponse(String id,
                           String title,
                           String author,
                           String genre,
                           String isbn,
                           String status) {
}
