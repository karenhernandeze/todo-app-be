package karenhernandeze.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Filters {
    public Filters(){
    }

    @Size(min = 1, max = 120)
    @Column(nullable = true)
    private @Id String text;
    @Column(nullable = true)
    private LocalDate dueDate; 
    @Column(nullable = true)
    private  Boolean done;
    @Column(nullable = true)
    private String priority;

    public Filters(String text, LocalDate dueDate, Boolean done, String priority) {
        this.text = text;
        this.dueDate = dueDate;
        this.done = done;
        this.priority = priority;
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
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String toString() {
        return text + "," + dueDate  + "," + done  + "," + priority;
    }
}

