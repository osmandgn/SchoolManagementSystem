package schoolManagementSystem;

import java.util.*;

public class Student {

    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String white = "\u001B[37m";

    public static Map<String, Student> database = new HashMap<>();
    public static Scanner input = new Scanner(System.in);


    private String studentID;
    private  String studentName;
    private  int studentAge;
    private  String studentClass;
    public static int index = 1000;


    public Student(String studentName, int studentAge, String studentClass) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentClass = studentClass;
        studentID = studentIDCreator();
        index++;
    }


    public static String studentIDCreator() {
        return "S" + index;
    }


    public static void addStudent() {
        System.out.println("*".repeat(15) + " Add New Student " + "*".repeat(15));
        while (true) {
            System.out.println("Student Name");
            String name = input.nextLine();
            System.out.println("Student Class");
            String studentClass = input.next();
            System.out.println("Student Age");
            int age = input.nextInt();
            String ID = studentIDCreator();
            database.put(studentIDCreator(), new Student(name, age, studentClass));
            System.out.println("Student successfully enrolled");
            makeAChoice();

        }

    }

    public static void getStudentList() {
        System.out.println("*".repeat(50));
        System.out.println("Student ID \t\t Student Name \t\t Sutdent Age");
        for (Map.Entry<String, Student> students : database.entrySet()) {
            System.out.println(students.getValue().studentID + "\t\t\t | " + students.getValue().studentName + "\t\t\t | " + students.getValue().studentAge);
        }
        System.out.println();
        makeAChoice();
    }

    public static void searchStudent() {

    }


    public static void makeAChoice() {
        System.out.println(yellow +"***** Make a New Choice *****\n1 - Continue Adding Students\n2 - Return Student Menu\n3 - Return Homepage \nPress Any to Quite");
        String choice = input.next();
        if (choice.equals("1")) {
            addStudent();
        } else if (choice.equals("2")) {
            StudentMenu.studentMenu();
            ;
        } else if (choice.equals("3")) {
            HomePage.welcome();
        } else {
            System.out.println("Exiting the Program");
            System.exit(0);

        }
    }

    public static void search(){
        System.out.println("Input Student Name: ");
        String sName = input.next();
        boolean finder = false;
        for (Map.Entry<String, Student> data : database.entrySet()){
            if (sName.equalsIgnoreCase(data.getValue().studentName)){
                finder = true;
                toString(data);
            }
        }
        if (!finder){
            System.out.println("Student not found");
        }
        System.out.println();
        makeAChoice();
    }

    public static void toString(Map.Entry<String, Student> data){
        System.out.println("Student ID \t\t Student Name \t\t Sutdent Age");
        System.out.println(data.getValue().studentID + "\t\t\t | " + data.getValue().studentName + "\t\t\t | " + data.getValue().studentAge);
    }

    public static void deleting(){
        System.out.println("Input Student Name: ");
        String sName = input.next();
        for (Map.Entry<String, Student> data : database.entrySet()){
            if (sName.equalsIgnoreCase(data.getValue().studentName)){
                database.remove(data.getKey());
                System.out.println("Student deleted! ");
            }else{
                System.out.println("Student not found");
            }

        }
        System.out.println();
        makeAChoice();

    }


}
