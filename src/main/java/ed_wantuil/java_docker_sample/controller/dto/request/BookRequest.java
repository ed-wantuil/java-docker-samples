package ed_wantuil.java_docker_sample.controller.dto.request;

public record BookRequest(String title,
                          String author,
                          String genre,
                          String isbn,
                          String status) {
}
