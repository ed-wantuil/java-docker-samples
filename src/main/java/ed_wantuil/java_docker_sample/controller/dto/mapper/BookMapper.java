package ed_wantuil.java_docker_sample.controller.dto.mapper;

import ed_wantuil.java_docker_sample.controller.dto.request.BookRequest;
import ed_wantuil.java_docker_sample.controller.dto.response.BookResponse;
import ed_wantuil.java_docker_sample.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book bookRequestToBook(final BookRequest bookRequest) {
        return Book.builder()
                .title(bookRequest.title())
                .author(bookRequest.author())
                .genre(bookRequest.genre())
                .isbn(bookRequest.isbn())
                .status(bookRequest.status())
                .build();
    }

    public BookResponse bookToBookResponse(final Book book) {
        return BookResponse.builder()
                .id(book.getId().toString())
                .title(book.getTitle())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .isbn(book.getIsbn())
                .status(book.getStatus())
                .build();
    }
}
