import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
      static Scanner scanner = new Scanner(System.in);
      static int choice;
      static private List<User> users_list = new ArrayList<>();
      
      public static void main(String[] args) {
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
        register_user();
        break;

     case 2: 
        list_users();
        break;

     case 3: 
        add_task();
        break;

     case 4: 
        add_dated_task();
        break;

     case 5: 
        list_user_tasks();
        break;
     
     case 6: 
        mark_task_done();
        break;
 }
 } while (choice != 0 );
        scanner.close();
      }


   //===============================================================================================================
     static void register_user(){
        System.out.println("Type User name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Type User Id:");
        int id = scanner.nextInt();
        System.out.println("Type User email:");
        String email = scanner.next();

        User newUser = new User(name, id, email);  //instanciate object
        users_list.add(newUser);                          //adds to list
        System.out.println("User registered!");
     }
     
  //===============================================================================================================
     static void list_users(){
        if(users_list.isEmpty()){
            System.out.println("users not registered");}
        else{ 
            for(User x : users_list){ System.out.print(x); System.out.print('\n'); }   // for-each ("user") in "users_list" {print};; x = temporary reference
        } 
     }
   //===============================================================================================================
     static void add_task(){
        User user = select_user_prompt();
        if (user == null) return;
        
        System.out.println("Type your task subject");
      scanner.nextLine();
        String subject = scanner.nextLine(); //nextLine() reads the hole line

        System.out.println("Type your task priority value(0,1,2)");
        int priority  = Integer.parseInt(scanner.next()); //next() reads one token
       //validates string sequence and converts to int

        // Instanciate and add task
        Task newTask = new Task(subject);
        newTask.set_priority(priority);
        user.set_tasks(newTask);
        System.out.println("Task created for " + user.getname() + "!");
     }

  //===============================================================================================================
     static void add_dated_task(){
        User user = select_user_prompt();
        if (user == null) return;
        
        System.out.println("Type your task subject");
      scanner.nextLine();
        String subject = scanner.nextLine();

        System.out.println("Type your task priority value(0,1,2)");
        int priority = Integer.parseInt(scanner.next());

        System.out.println("Type your task due date");
      scanner.nextLine();
        String dueDate = scanner.nextLine(); //regex later maybe
         
        // Instanciate and add task
        DatedTask newDatedTask = new DatedTask(subject, dueDate);
        newDatedTask.set_priority(priority);
        user.set_tasks(newDatedTask);
        System.out.println("Dated Task created for " + user.getname() + "!");
     }
     
  //===============================================================================================================
     static void list_user_tasks(){
        User user = select_user_prompt();
        if (user == null) return;
        
        if (user.get_tasks_list().isEmpty()) {
           System.out.println(user.getname() + " has no Tasks");
           return;
        }
        System.out.println("\n=== TASKS FOR " + user.getname().toUpperCase() + " ===");
        for (Task t : user.get_tasks_list()) {  
           System.out.println(t);
           System.out.println(); 
        }
     }

  //===============================================================================================================
     static void mark_task_done(){
        User user = select_user_prompt();
        if (user == null) return;
        
        if (user.get_tasks_list().isEmpty()) {
           System.out.println("No tasks available for " + user.getname());
           return;
        }
        
        System.out.println("\n=== TASKS FOR " + user.getname().toUpperCase() + " ===");
        for (int i = 0; i < user.get_tasks_list().size(); i++) {
           System.out.println(i + " - " + user.get_tasks_list().get(i));
        }
        
        System.out.println("\nType the task number to mark as done:");
        int taskNumber = scanner.nextInt();
        
        if (taskNumber >= 0 && taskNumber < user.get_tasks_list().size()) {
           user.get_tasks_list().get(taskNumber).mark_as_done();
           System.out.println("Task marked as done! ✓");
        } else {
           System.out.println("Invalid task number!");
        }
     }
     
   //===============================================================================================================

     static User select_user_prompt(){
        if (users_list.isEmpty()) {
           System.out.println("No users registered!");
           return null;
        }
        
        System.out.println("\n=== SELECT A USER ===");
        for (int i = 0; i < users_list.size(); i++) {
           System.out.println(i + " - " + users_list.get(i).getname());
        }
        
        System.out.println("\nType user number:");
        int userNumber = scanner.nextInt();
        
        if (userNumber >= 0 && userNumber < users_list.size()) {
           return users_list.get(userNumber);
        } else {
           System.out.println("Invalid user number!");
           return null;
        }
     }
}
