package ed_wantuil.java_docker_sample.service;

import ed_wantuil.java_docker_sample.entity.Book;
import ed_wantuil.java_docker_sample.entity.Loan;
import ed_wantuil.java_docker_sample.entity.Member;
import ed_wantuil.java_docker_sample.exception.NotFoundException;
import ed_wantuil.java_docker_sample.repository.BookRepository;
import ed_wantuil.java_docker_sample.repository.LoanRepository;
import ed_wantuil.java_docker_sample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public Loan createLoan(Loan loan) {

        Optional<Member> memberOptional = memberRepository.findById(loan.getMember().getId());
        Member member = memberOptional.orElseThrow(() -> new NotFoundException("Member not found"));
        loan.setMember(member);

        Optional<Book> bookOptional = bookRepository.findById(loan.getBook().getId());
        Book book = bookOptional.orElseThrow(() -> new NotFoundException("Book not found"));
        loan.setBook(book);

        return loanRepository.saveAndFlush(loan);
    }
}
