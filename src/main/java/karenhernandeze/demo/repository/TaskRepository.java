package karenhernandeze.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karenhernandeze.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}

