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
      Task task2 = new Task("Finish Task-3", LocalDate.parse("2023-06-21"), true, LocalDate.parse("2023-05-20"), "medium", LocalDate.parse("2023-05-22"));
      Task task3 = new Task("Finish Task-4", LocalDate.parse("2023-07-11"), false, LocalDate.parse("2023-06-30"), "low", LocalDate.parse("2023-06-11"));
      Task task4 = new Task("Finish Back-End", LocalDate.parse("2023-06-10"), true, LocalDate.parse("2023-05-30"), "high", LocalDate.parse("2023-05-12"));
      Task task5 = new Task("Finish Front-End", LocalDate.parse("2023-05-29"), false, LocalDate.parse("2023-05-28"), "low", LocalDate.parse("2023-05-10"));
      Task task6 = new Task("Finish Task-3", LocalDate.parse("2023-06-21"), true, LocalDate.parse("2023-05-20"), "medium", LocalDate.parse("2023-05-22"));
      Task task7 = new Task("Finish Task-4", LocalDate.parse("2023-07-11"), false, LocalDate.parse("2023-06-30"), "low", LocalDate.parse("2023-06-11"));
      Task task8 = new Task("Finish Back-End", LocalDate.parse("2023-06-10"), true, LocalDate.parse("2023-05-30"), "high", LocalDate.parse("2023-05-12"));
      Task task9 = new Task("Finish Front-End", LocalDate.parse("2023-05-29"), false, LocalDate.parse("2023-05-28"), "low", LocalDate.parse("2023-05-10"));
      Task task10 = new Task("Finish Task-3", LocalDate.parse("2023-06-21"), true, LocalDate.parse("2023-05-20"), "medium", LocalDate.parse("2023-05-22"));
      Task task11 = new Task("Finish Task-4", LocalDate.parse("2023-07-11"), false, LocalDate.parse("2023-06-30"), "low", LocalDate.parse("2023-06-11"));
      Task task12 = new Task("Finish Back-End", LocalDate.parse("2023-06-10"), true, LocalDate.parse("2023-05-30"), "high", LocalDate.parse("2023-05-12"));

      log.info("Preloading " + repository.save(task));
      log.info("Preloading " + repository.save(task2));
      log.info("Preloading " + repository.save(task3));
      log.info("Preloading " + repository.save(task4));
      log.info("Preloading " + repository.save(task5));
      log.info("Preloading " + repository.save(task6));
      log.info("Preloading " + repository.save(task7));
      log.info("Preloading " + repository.save(task8));
      log.info("Preloading " + repository.save(task9));
      log.info("Preloading " + repository.save(task10));
      log.info("Preloading " + repository.save(task11));
      log.info("Preloading " + repository.save(task12));
    };
  }
}
