package karenhernandeze.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Task {

    public Task() {
    }

    private @Id @GeneratedValue Long id;
    @Size(min = 1, max = 120)
    @Column(nullable = false)
    private String text;
    @Column(nullable = true)
    private LocalDateTime  dueDate; //OPTIONAL
    @Column(nullable = false)
    private  Boolean done;
    @Column(nullable = true)
    private LocalDateTime  doneDate; 
    @Column(nullable = false)
    private String priority;
    @Column(nullable = false)
    private LocalDateTime  creationDate;

    public Task(String text, LocalDateTime  dueDate, Boolean done, LocalDateTime  doneDate, String priority, LocalDateTime  creationDate) {
        this.text = text;
        this.dueDate = dueDate;
        this.done = done;
        this.doneDate = doneDate;
        this.priority = priority;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime  getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime  dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime  getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(LocalDateTime  doneDate) {
        this.doneDate = doneDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime  getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime  creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return id + "," + text + "," + dueDate  + "," + done  + "," + doneDate  + "," + priority  + "," + creationDate;
    }
}


