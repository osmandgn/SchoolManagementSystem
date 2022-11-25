package schoolManagementSystem;

import java.util.Scanner;

public class HomePage {
    public static final String green = "\u001B[32m";

    public static void welcome(){
        System.out.println(green+"*".repeat(25) + " Welcome to School Management System " + "*".repeat(25));
        System.out.println("1 - Student Menu\n2 - Teacher Menu\nQ - Quit");
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease make a choice: ");

        while (true){
            String choice = input.next();
            if (choice.equalsIgnoreCase("Q")){
                System.out.println("Exiting the system");
                break;
            }else if(choice.equals("1")){
                StudentMenu.studentMenu();;
                break;
            } else if (choice.equals("2")) {
                TeacherMenu.teacherMenu();;
                break;
            }else {
                System.out.println("Invalid Section");
                System.out.println("\nMake a New Choice: ");
            }
        }


    }







}
