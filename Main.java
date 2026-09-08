import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Nível 1 (Edição e Remoção): Implementar funcionalidades para editar usuário, editar tarefa, remover tarefa e remover usuário.
Nível 2 (Buscas): Implementar busca de usuário pelo nome e busca de tarefa pelo título.
Nível 3 (Estatísticas): Mostrar total de usuários cadastrados, total de tarefas, tarefas concluídas e pendentes.
Nível 4 (Ordenação): Ordenar tarefas por prioridade, prazo ou título utilizando Stream API e Comparators.
 */

public class Main {
      static Scanner scanner = new Scanner(System.in);
      static int choice;
      static private List<User> users_list = new ArrayList<>();
      
      public static void main(String[] args) {
 do { 
           System.out.println(" === TASK MANAGER ===");
           System.out.println(" 1 - ADD USER");
           System.out.println(" 2 - LIST USERS");
           System.out.println(" 3 - EDIT USER");
           System.out.println(" 4 - DELETE USER");
           System.out.println(" 5 - ADD TASK");
           System.out.println(" 6 - EDIT TASK");
           System.out.println(" 7 - DELETE TASK");
           System.out.println(" 8 - ADD DATED TASK");
           System.out.println(" 9 - LIST USER TASKS");
           System.out.println("10 - MARK TASK AS DONE");
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
        edit_user();
        break;

     case 4: 
        delete_user();
        break;

     case 5:
        add_task();
        break;

     case 6:
        edit_task();
        break;

     case 7:
        delete_task();
        break;

     case 8:
        add_dated_task();
        break;

     case 9: 
        list_user_tasks();
        break;
     
     case 10: 
        mark_task_done();
        break;
 }
 } while (choice != 0 );
        scanner.close();
      }


      //put on managers class later
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

     static void edit_user(){
        User user = select_user_prompt();
        if (user == null) return;

        System.out.println("Current name: " + user.getname());
        System.out.println("Type the new user name:");
        scanner.nextLine();
        user.setname(scanner.nextLine());

        System.out.println("Current ID: " + user.getid());
        System.out.println("Type the new user ID:");
        user.setid(scanner.nextInt());

        System.out.println("Current email: " + user.getemail());
        System.out.println("Type the new user email:");
        user.setemail(scanner.next());

        System.out.println("User updated!");
     }

   //===============================================================================================================
     static void delete_user(){
        User user = select_user_prompt();
        if (user == null) return;

        users_list.remove(user);
        System.out.println("User deleted!");
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

     static void edit_task(){
        User user = select_user_prompt();
        if (user == null) return;

        if (user.get_tasks_list().isEmpty()) {
           System.out.println(user.getname() + " has no Tasks");
           return;
        }

        System.out.println("\n=== TASKS FOR " + user.getname().toUpperCase() + " ===");
        for (int i = 0; i < user.get_tasks_list().size(); i++) {
           System.out.println(i + " - " + user.get_tasks_list().get(i));
        }

        System.out.println("Type the task number to edit:");
        int taskNumber = scanner.nextInt();
        if (taskNumber < 0 || taskNumber >= user.get_tasks_list().size()) {
           System.out.println("Invalid task number!");
           return;
        }

        Task task = user.get_tasks_list().get(taskNumber);
        System.out.println("Current subject: " + task.get_task_subject());
        System.out.println("Type the new subject:");
        scanner.nextLine();  // \n consuming
        task.set_subject(scanner.nextLine());

        System.out.println("Current priority: " + task.get_priority());
        System.out.println("Type the new priority value(0,1,2):");
        task.set_priority(scanner.nextInt());

        if (task instanceof DatedTask datedTask) {
           System.out.println("Current due date: " + datedTask.get_due_date());
           System.out.println("Type the new due date:");
           scanner.nextLine(); // \n consuming
           datedTask.set_due_date(scanner.nextLine());
        }

        System.out.println("Task updated!");
     }

  //===============================================================================================================
     static void delete_task(){
        User user = select_user_prompt();
        if (user == null) return;

        if (user.get_tasks_list().isEmpty()) {
           System.out.println(user.getname() + " has no Tasks");
           return;
        }

        System.out.println("\n=== TASKS FOR " + user.getname().toUpperCase() + " ===");
        for (int i = 0; i < user.get_tasks_list().size(); i++) {
           System.out.println(i + " - " + user.get_tasks_list().get(i));
        }

        System.out.println("Type the task number to delete:");
        int taskNumber = scanner.nextInt();
        if (taskNumber >= 0 && taskNumber < user.get_tasks_list().size()) {
           user.get_tasks_list().remove(taskNumber);
           System.out.println("Task deleted!");
        } else {
           System.out.println("Invalid task number!");
        }
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

        // Creates a new list ordered by priority
        List<Task> orderedTasks = user.get_tasks_list()
           .stream() //transform the task list into a stream
           .sorted(Comparator.comparing(task -> task.get_priority().getValue())) // 
           .toList(); //transform the stream back into a list

        for (Task t : orderedTasks) {
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
           user.get_tasks_list().get(taskNumber).mark_as_done(); //user.isDone = true
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
