package workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop6.entity.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUserId(Long id);
}
