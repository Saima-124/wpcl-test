
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        if (args.length != 1) {
            displayMenu();
            return;
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                Random rand = new Random();
                int idx = rand.nextInt(e.length);
                System.out.println(e[idx]);
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newEmployee = args[0].substring(1);
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                bufferedWriter.write(", " + newEmployee);
                bufferedWriter.close();
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                boolean found = false;
                String searchEmployee = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (employees[i].equals(searchEmployee)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                int wordCount = 0;
                for (String employee : employees) {
                    wordCount += employee.split(" ").length;
                }
                System.out.println(wordCount + " word(s) found");
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                String employeeToUpdate = args[0].substring(1);
                for (int i = 0; i < e.length; i++) {
                    if (employees[i].equals(employeeToUpdate)) {
                        e[i] = "Updated";
                    }
                }
                writeEmployeesToFile(employees);
            } catch (Exception e) {

            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                String employeeToDelete = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeToDelete);
                writeEmployeesToFile(employeeList.toArray(new String[0]));
            } catch (Exception e) {

            }
            System.out.println("Data Deleted.");
        }
    }
}
