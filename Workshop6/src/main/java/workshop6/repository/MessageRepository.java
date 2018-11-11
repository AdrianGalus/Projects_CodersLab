package workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop6.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByReceiverId(Long id);
    List<Message> findAllBySenderId(Long id);
}
