package schoolManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teacher {

    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String white = "\u001B[37m";

    public static Map<String, Teacher> database = new HashMap<>();
    public static Scanner input = new Scanner(System.in);


    private String teacherID;
    private  String teacherName;
    private  String department;
    public static int index = 1000;


    public Teacher(String teacherName, String department) {
        this.teacherName = teacherName;
        this.department = department;
        teacherID = teacherIDCreator();
        index++;
    }


    public static String teacherIDCreator() {
        return "S" + index;
    }


    public static void addTeacher() {
        System.out.println("*".repeat(15) + " Add New Teacher " + "*".repeat(15));
        while (true) {
            System.out.println("Teacher Name");
            String name = input.next();
            System.out.println("Department");
            String department = input.next();
            String ID = teacherIDCreator();
            database.put(teacherIDCreator(), new Teacher(name, department));
            System.out.println("Teacher successfully enrolled");
            makeAChoice();

        }

    }

    public static void getTeachertList() {
        System.out.println("*".repeat(50));
        System.out.println("Teacher ID \t\t Teacher Name \t\t Department");
        for (Map.Entry<String, Teacher> teachers : database.entrySet()) {
            System.out.println(teachers.getValue().teacherID + "\t\t\t | " + teachers.getValue().teacherName + "\t\t\t | " + teachers.getValue().department);
        }
        System.out.println();
        makeAChoice();
    }



    public static void makeAChoice() {
        System.out.println(yellow +"***** Make a New Choice *****\n1 - Continue Adding Teachers\n2 - Return Teacher Menu\n3 - Return Homepage \nPress Any to Quite");
        String choice = input.next();
        if (choice.equals("1")) {
            addTeacher();
        } else if (choice.equals("2")) {
            TeacherMenu.teacherMenu();
        } else if (choice.equals("3")) {
            HomePage.welcome();
        } else {
            System.out.println("Exiting the Program");
            System.exit(0);

        }
    }

    public static void search(){
        System.out.println("Input Teacher Name: ");
        String tName = input.next();
        boolean finder = false;
        for (Map.Entry<String, Teacher> data : database.entrySet()){
            if (tName.equalsIgnoreCase(data.getValue().teacherName)){
                finder = true;
                toString(data);
            }
        }
        if (!finder){
            System.out.println("Teacher not found");
        }
        System.out.println();
        makeAChoice();
    }

    public static void toString(Map.Entry<String, Teacher> data){
        System.out.println("Teacher ID \t\t Teacher Name \t\t Teacher Department");
        System.out.println(data.getValue().teacherID + "\t\t\t | " + data.getValue().teacherName + "\t\t\t | " + data.getValue().department);
    }

    public static void deleting(){
        System.out.println("Input Teacher Name: ");
        String sName = input.next();
        for (Map.Entry<String, Teacher> data : database.entrySet()){
            if (sName.equalsIgnoreCase(data.getValue().teacherName)){
                database.remove(data.getKey());
                System.out.println("Teacher deleted! ");
            }else{
                System.out.println("Teacher not found");
            }

        }
        System.out.println();
        makeAChoice();

    }


}