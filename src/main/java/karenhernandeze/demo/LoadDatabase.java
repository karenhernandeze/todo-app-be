package karenhernandeze.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

import karenhernandeze.demo.model.Task;
import karenhernandeze.demo.repository.TaskRepository;

@Configuration
public class LoadDatabase {
    
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(TaskRepository repository) {

    return args -> {
      Task task = new Task("Finish Front-End", LocalDateTime.parse("2023-06-27T10:10:45"), false, null, "low", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task2 = new Task("Finish Back-End", LocalDateTime.parse("2023-07-12T11:15:25"), true, LocalDateTime.parse("2023-06-20T11:15:25"), "low", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task3 = new Task("Finish Task-3", LocalDateTime.parse("2023-05-31T12:20:15"), true, LocalDateTime.parse("2023-06-20T12:20:15"), "medium", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task4 = new Task("Finish Task-4", LocalDateTime.parse("2023-06-02T13:25:05"), true, LocalDateTime.parse("2023-06-20T13:25:05"), "high", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task5 = new Task("Finish Task-5", LocalDateTime.parse("2023-08-12T14:30:40"), false, null, "medium", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task6 = new Task("Finish Task-6", LocalDateTime.parse("2023-05-30T15:35:42"), false, null, "high", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task7 = new Task("Finish Task-7", LocalDateTime.parse("2023-05-28T16:36:37"), true, LocalDateTime.parse("2023-06-20T16:36:37"), "low", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task8 = new Task("Finish Task-8", LocalDateTime.parse("2023-07-11T17:38:32"), true, LocalDateTime.parse("2023-06-20T17:38:32"), "medium", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task9 = new Task("Finish Task-9", LocalDateTime.parse("2023-06-18T18:40:22"), false, null, "high", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task10 = new Task("Finish Task-10", LocalDateTime.parse("2023-06-14T19:45:21"), true, LocalDateTime.parse("2023-06-20T19:45:21"), "high", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task11 = new Task("Finish Task-11", LocalDateTime.parse("2023-05-27T20:50:57"), false, null, "low", LocalDateTime.parse("2023-05-30T10:30:45"));
      Task task12 = new Task("Finish Task-12", LocalDateTime.parse("2023-07-02T21:55:33"), true, LocalDateTime.parse("2023-06-20T21:55:33"), "low", LocalDateTime.parse("2023-05-30T10:30:45"));

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

