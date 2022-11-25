package schoolManagementSystem;

import java.util.Scanner;

public class StudentMenu {
    public static void studentMenu(){
        System.out.println("*".repeat(15) +  "# Welcome to the Student Menu #" + "*".repeat(15) +"\n1 - Adding\n" +
                "2 - Listing\n" +
                "3 - Seach\n" +
                "4 - Deleting\n" +
                "5 - Home\n" +
                "Q - Exit\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Please make a choice: ");

        while (true){
            String choice = input.next();
            if (choice.equalsIgnoreCase("Q")){
                System.out.println("Exiting the system");
                break;
            }else if(choice.equals("1")){
                Student.addStudent();
                break;
            } else if (choice.equals("2")) {
                Student.getStudentList();
                break;
            }else if (choice.equals("3")) {
                Student.search();
                break;
            }else if (choice.equals("4")) {
                TeacherMenu.teacherMenu();
                break;
            }else if (choice.equals("5")) {
                TeacherMenu.teacherMenu();
                break;
            }else {
                System.out.println("Invalid Section");
                System.out.println("\nMake a New Choice: ");
            }
        }







    }
}
