package homework5;

public class Main {

    public static void main(String[] args) {

        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231221", 30000, 30);
        emplArray[1] = new Employee("Petrov Evgeniy", "Accountant", "Petrov@gmail.com", "89115467894", 112800, 40);
        emplArray[2] = new Employee("Smirnov Vasiliy Aleksandrovich", "Builder", "vasssya@mail.ru", "89991632852", 65500, 60);
        emplArray[3] = new Employee("Kalyagin Viktor", "Cashier", "VikYaga@inbox.ru", "+7 495 532 32 32", 15000, 450);
        emplArray[4] = new Employee("Prostov Nikita", "Cook", "proSSto@ya.ru", "89655131351", 45000, 25);

        for (int i = 0; i < emplArray.length; i++) {
            if (emplArray[i].getAge() < 40) {
                Employee.printEmployee(emplArray[i].getName(), emplArray[i].getPosition(), emplArray[i].getEmail(), emplArray[i].getPhoneNumber(), emplArray[i].getSalary(), emplArray[i].getAge());
            }
        }
    }
}

