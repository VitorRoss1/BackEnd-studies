

public class Task {

    protected  String subject; //allow subclass access
    protected  Priority task_Priority;
    protected  boolean isDone = false;

    public Task(String subject){
        this.subject = subject;
        this.task_Priority = Priority.MEDIUM; //default
    }

    //setters
    public void set_subject(String subject){this.subject = subject;}
    public void set_priority(int value) {
    this.task_Priority = Priority.values()[value]; //values return an array with all enum values(h,m,l) //[which to access]
    }
    
    //getters
    public String get_task_subject() { return this.subject; }
    public Priority get_priority() { return this.task_Priority; }
    public boolean is_done() { return this.isDone; }
     //mark as done
    public void mark_as_done() { this.isDone = true; }
    public void mark_as_not_done() { this.isDone = false; }

    //default string output for the class
    @Override
    public String toString() {
        String status = isDone ? " DONE" : " PENDING"; //condition ? value_if_true : value_if_false
        return "| Subject: " + subject + " | Priority: " + task_Priority + " | Status: " + status + " |";
    }
}
    