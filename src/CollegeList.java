import java.util.Scanner;

public class CollegeList
{
    public static void main(String[] args) {
        Employee e = new Employee();
        Faculty f = new Faculty();
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true){
            System.out.print("Press E for Employee, F for  Faculty, S for Student: ");
            String choice2 = sc.nextLine().toUpperCase();
            choice = choice2;
            if (choice2.matches("[EFS]")){
                break;
            }else {
                System.out.println("Invalid choice please try again\n");
            }
        }

            switch (choice) {
                case "E" -> {
                    System.out.println("Please fill out the information below:");
                    System.out.print("Name: ");
                    e.setName(sc.nextLine());
                    System.out.print("Contact Number: ");
                    e.setContactNumber(sc.next());
                    System.out.print("Salary: ");
                    e.setSalary(sc.nextDouble());
                    System.out.print("Department: ");
                    e.setDepartment(sc.next());
                    System.out.println("-------------------------");
                    System.out.println("Name: " + e.getName());
                    System.out.println("Contact Number: " + e.getContactNumber());
                    System.out.println("Salary: " + e.getSalary());
                    System.out.println("Department: " + e.getDepartment());
                }
                case "F" -> {
                    System.out.println("Please fill out the information below:");
                    System.out.print("Name: ");
                    f.setName(sc.nextLine());
                    System.out.print("Contact Number: ");
                    f.setContactNumber(sc.nextLine());
                    System.out.print("Salary: ");
                    f.setSalary(sc.nextInt());
                    System.out.print("Department: ");
                    f.setDepartment(sc.next());
                    System.out.println("Press 'Y' if the faculty member is regular/tenured, Press 'N' if not");
                    String status = sc.next().toUpperCase();
                    if (status.equals("Y")) {
                        f.setStatus(true);

                    } else if (status.equals("N")) {
                        f.setStatus(false);
                    }
                    System.out.println("-------------------------");
                    System.out.println("Name: " + f.getName());
                    System.out.println("Contact Number: " + f.getContactNumber());
                    System.out.println("Salary: " + f.getSalary());
                    System.out.println("Department: " + f.getDepartment());
                    System.out.println("Status (Regular): " + f.isRegular());
                }
                case "S" -> {
                    System.out.println("Please fill out the information below:");
                    System.out.print("Name: ");
                    s.setName(sc.nextLine());
                    System.out.print("Contact Number: ");
                    s.setContactNumber(sc.next());
                    System.out.print("Program (Ex. BSIT, BSCS):  ");
                    s.setProgram(sc.next());

                    while (true) {
                        System.out.print("Year Level (1-4): ");
                        s.setYearLevel(sc.next());
                        if (s.getYearLevel() >= 1 && s.getYearLevel() <= 4) {
                            System.out.println("-------------------------");
                            System.out.println("Name: " + s.getName());
                            System.out.println("Contact Number: " + s.getContactNumber());
                            System.out.println("Salary: " + s.getProgram());
                            System.out.println("Year Level: " + s.getYearLevel());
                            break;
                        } else {
                            System.out.println("Invalid choice please try again (choose 1-4)");
                        }
                    }
                }
            }
    }
}

class Person
{
    private String name;
    private String contactNum;

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public void setContactNumber(String c){
        this.contactNum = c;
    }

    public String getContactNumber(){
        return contactNum;
    }
}

class Student extends Person
{
    private String program;
    private int yearLevel;
    public void setProgram(String p){
        this.program = p;
    }
    public String getProgram(){
        return program;
    }

    public void setYearLevel(String y){
        this.yearLevel = Integer.parseInt(y);
    }

    public int getYearLevel(){
        return yearLevel;
    }

}

class Employee extends Person
{
    private double salary;
    private String department;

    public void setSalary(double s){
        this.salary = s;
    }
    public double getSalary(){
        return salary;
    }

    public void setDepartment(String d){
        this.department = d;
    }
    public String getDepartment(){
        return department;
    }
}

class Faculty extends Employee
{
    private boolean status; //if its private modifier cannot be access into other class that's why setter method needed
    //I don't know if there's another way because according to UML no parameters either

    public boolean isRegular() {
        return status;
    }

    public void setStatus(boolean updateStatus){ //added setter method may minus pts ba to sir hahaha
        status = updateStatus;
    }
}


