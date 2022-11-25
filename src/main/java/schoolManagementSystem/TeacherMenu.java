package schoolManagementSystem;

import java.util.Scanner;

public class TeacherMenu {
    public static final String yellow = "\u001B[33m";

    public static void teacherMenu(){
        System.out.println(yellow+"*".repeat(15) +  "# Welcome to the Teacher Menu #" + "*".repeat(15) +"\n1 - Adding\n" +
                "2 - Searching\n" +
                "3 - Listing\n" +
                "4 - Deleting\n" +
                "5 - Home\n" +
                "Q - Exit");
        Scanner input = new Scanner(System.in);
        System.out.println("Please make a choice: ");

        while (true){
            String choice = input.next();
            if (choice.equalsIgnoreCase("Q")){
                System.out.println("Exiting the system");
                break;
            }else if(choice.equals("1")){
                Teacher.addTeacher();
                break;
            } else if (choice.equals("2")) {
                Teacher.search();
                break;
            }else if (choice.equals("3")) {
                Teacher.getTeachertList();
                break;
            }else if (choice.equals("4")) {
                Teacher.deleting();
                break;
            }else if (choice.equals("5")) {
                HomePage.welcome();
                break;
            }else {
                System.out.println("Invalid Section");
                System.out.println("\nMake a New Choice: ");
            }
        }




    }
}
