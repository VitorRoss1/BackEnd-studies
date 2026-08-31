
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private List<Task> list_of_tasks;

//contructor
    public User(int id, String name, String email){
    this.id = id;
    this.name = name;
    this.email = email;
    this.list_of_tasks = new ArrayList<>();
}

//getters
public String getname(){ return name;}
public String getemail(){return email;}
public int  getid(){return id;}
public List<Task> get_tasks_list() { return list_of_tasks; }


//setters(edit)
public void setname(String name){this.name = name;}
public void setemail(String email){this.email = email;}
public void setid(int id){this.id = id;}

//list users


//set user_tasks
public void user_tasks(Task list_of_tasks) {
  list_of_tasks.add(Task);}
}
//list users tasks



}