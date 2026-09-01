import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.classfile.instruction.SwitchCase;

public class Main {
      Scanner scanner = new Scanner(System.in);
      int choice;
      private List<User> users_list = new ArrayList<>();  


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
            System.out.println("user not registered");}

        else{ 
        for(User x : users_list){ System.out.print(x); }   // for-each ("user") in "users_list" {print}; x = temporary reference
        }
        break;
    }
     case 3: 
     break;
     case 4: 
     break;
     case 5: 
     break;
     case 6: 
     break;
      


 } while (choice != 0 );
        scanner.close();  //closes "scanf" 
     }
}
