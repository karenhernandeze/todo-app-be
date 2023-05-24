package karenhernandeze.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
public class Task {

    public Task() {
    }

    private @Id @GeneratedValue Long id;
    @Size(min = 1, max = 120)
    @Column(nullable = false)
    private String text;
    @Column(nullable = true)
    private LocalDate dueDate; //OPTIONAL
    @Column(nullable = false)
    private  Boolean done;
    @Column(nullable = true)
    private LocalDate doneDate; 
    @Column(nullable = false)
    private String priority;
    @Column(nullable = false)
    private LocalDate creationDate;

    public Task(String text, LocalDate dueDate, Boolean done, LocalDate doneDate, String priority, LocalDate creationDate) {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDate getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(LocalDate doneDate) {
        this.doneDate = doneDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return id + "," + text + "," + dueDate  + "," + done  + "," + doneDate  + "," + priority  + "," + creationDate;
    }
}


