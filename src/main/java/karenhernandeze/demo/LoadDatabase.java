package karenhernandeze.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

import karenhernandeze.demo.model.Task;
import karenhernandeze.demo.repository.TaskRepository;

@Configuration
public class LoadDatabase {
    
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(TaskRepository repository) {

    return args -> {
      Task task = new Task("Finish Front-End", LocalDate.parse("2023-05-29"), false, LocalDate.parse("2023-05-28"), "low", LocalDate.parse("2023-05-10"));
      Task task2 = new Task("Finish Back-End", LocalDate.parse("2023-06-10"), false, LocalDate.parse("2023-05-30"), "low", LocalDate.parse("2023-05-12"));

      log.info("Preloading " + repository.save(task));
      log.info("Preloading " + repository.save(task2));
    };
  }
}
