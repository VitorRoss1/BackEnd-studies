import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.classfile.instruction.SwitchCase;

public class Main {
      Scanner scanner = new Scanner(System.in);
      int choice;
      private List<User> users_list = new ArrayList<>();  
      private List<Task> user_tasks = new ArrayList<>();

 do { 
           System.out.println(" === TASK MANAGER ===");
           System.out.println(" 1 - ADD USER");
           System.out.println(" 2 - LIST USERS");
           System.out.println(" 3 - ADD TASK");
           System.out.println(" 4 - ADD DATED TASK");
           System.out.println(" 5 - LIST USER TASKS");
           System.out.println(" 6 - MARK TASK AS DONE");
           System.out.println(" 0 - CLOSE");
           choice = scanner.nextInt();
     
      
    switch (choice) {
     case 1:
     public void register_user(Scanner scanner){

        System.out.println("Type User name:");
        String name = scanner.next();
        System.out.println("Type User Id:");
        int id = scanner.nextInt();
        System.out.println("Type User email:");
        String email = scanner.next();

        User newUser = new User(name, id, email);  //instanciate object
        users_list.add(newUser);                          //adds to list
        System.out.println("User registered!");
        break;
     }


     case 2: 
       //list users_list
        public void listusers_list(){
        if(users_list.isEmpty()){
            System.out.println("users not registered");}

        else{ 
        for(User x : users_list){ System.out.print(x); }   // for-each ("user") in "users_list" {print};; x = temporary reference
        }
        break;
     }


     case 3: 


     public void add_task(Scanner scanner)
        {
        System.out.println("Type your task subject");
        String subject = scanner.nextLine(); //nextLine() reads the hole line

        System.out.println("Type your task priority value(0,1,2)");
        int priority  = Integer.parseInt(scanner.next()); //next() reads one token
       //validates string sequence and converts to int

        // Instanciate and add task
        Task newTask = new Task(subject);
        newTask.set_priority(priority);
        user_tasks.add(newTask); 
        System.out.println("Task created");
        }
     break;


     case 4: 
        public void add_dated_task(Scanner scanner)
        {
        System.out.println("Type your task subject");
        String  subject = scanner.nextLine();

        System.out.println("Type your task priority value(0,1,2)");
        int priority  = Integer.parseInt(scanner.next());

        System.out.println("Type your task due date)");
        String dueDate  = scanner.next(); //regex later maybe
         
        // Instanciate and add task
        Task newDatedTask = new Task(subject);
        newDatedTask.set_priority(priority);
        user_tasks.add(newDatedTask);
        System.out.println("Dated Task created");
        }
     break;


     case 5: 

    public void list_user_tasks() {
      if (user_tasks.isEmpty()) {
       System.out.println("User Has no Tasks");
      return;
      }

      for (Task t : user_tasks) {  
      System.out.println("| Código:" + d.getCodigo() + " | " +d.get_priority()+ " | ");
      System.out.println(); // '/n' entre os prereq's
      }
      System.out.println("Now listing dated tasks:");
      for (Task t : user_tasks) {  
      System.out.println("| Código:" + d.getCodigo() + " | " +d.get_priority()+ " | ");
      System.out.println(); // '/n' entre os prereq's
      }
      }
     break;


     
     case 6: 

     break;
      


 } while (choice != 0 );
        scanner.close();  //closes "scanf" 
     }
}
