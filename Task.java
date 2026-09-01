

public class Task {

    private String subject;
    private Priority task_Priority;

    public Task(String subject){
        this.subject = subject;
        this.task_Priority = Priority.MEDIUM; //default priority
    }

    //setters
    public void set_subject(String subject){this.subject = subject;}
    public void set_priority(int value) {
    this.task_Priority = Priority.values()[value]; //values return an array with all enum values(h,m,l) //[which to access]
    }
    
    //getters
    public String get_task_subject() { return this.subject; }
    public Priority get_priority() { return this.task_Priority; }
}
    