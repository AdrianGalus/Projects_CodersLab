package workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop6.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTweetId(Long id);
}
