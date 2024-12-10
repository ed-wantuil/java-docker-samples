package ed_wantuil.java_docker_sample.controller;

import ed_wantuil.java_docker_sample.controller.dto.mapper.BookMapper;
import ed_wantuil.java_docker_sample.controller.dto.request.BookRequest;
import ed_wantuil.java_docker_sample.controller.dto.response.BookResponse;
import ed_wantuil.java_docker_sample.entity.Book;
import ed_wantuil.java_docker_sample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookMapper bookMapper;

    private final BookService bookService;

    @PostMapping
    public BookResponse createBook(@RequestBody  final BookRequest bookRequest){
        Book book = bookMapper.bookRequestToBook(bookRequest);

        book = bookService.createBook(book);

        return bookMapper.bookToBookResponse(book);
    }

    @GetMapping
    public List<BookResponse> getBooks() {

        List<Book> bookList = bookService.getBooks();

        return bookList.stream()
                .map(bookMapper::bookToBookResponse)
                .toList();
    }
}
