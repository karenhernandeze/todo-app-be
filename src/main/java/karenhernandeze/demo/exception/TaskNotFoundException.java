package karenhernandeze.demo.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String exception) {
        super(exception);
    }

}