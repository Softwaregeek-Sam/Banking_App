package dev.sumit.bank_app.comments;

import dev.sumit.bank_app.bankingcore.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByAccount(Account account);
}
