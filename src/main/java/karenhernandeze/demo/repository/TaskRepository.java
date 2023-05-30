package karenhernandeze.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karenhernandeze.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByDoneAndPriorityAndTextContaining(Boolean boolean1, String string, String string2);
}

