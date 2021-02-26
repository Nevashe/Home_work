package homework5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(){
        this.name = "Petrov Sidr Ivanovoch";
        this.position = "designer";
        this.email = "PSI@gmail.com";
        this.phoneNumber = "88005553535";
        this.salary = 60000;
        this.age = 40;
    }

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name =  name;
        this.position =  position;
        this.email =  email;
        this.phoneNumber =  phoneNumber;
        this.salary =  salary;
        this.age =  age;
    }




    public static void printEmployee(String name, String position, String email, String phoneNumber, int salary, int age){
        System.out.println(name);
        System.out.println("Position: " + position);
        System.out.println("email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }
}
