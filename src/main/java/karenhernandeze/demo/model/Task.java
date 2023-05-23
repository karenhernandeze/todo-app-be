package karenhernandeze.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Task {

    public Task() {
    }

    private @Id @GeneratedValue Long id;
    @Size(min = 1, max = 120)
    private String text;
    private String dueDate; //OPTIONAL
    private Boolean done;
    private String doneDate;
    private String priority;
    private String creationDate;

    public Task(String text, String dueDate, Boolean done, String doneDate, String priority, String creationDate) {
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return id + "," + text + "," + dueDate  + "," + done  + "," + doneDate  + "," + priority  + "," + creationDate;
    }
}


