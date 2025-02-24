
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
                for (String employee : readEmployeesFromFile()) {
                    System.out.println(employee);
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployeesFromFile();
                System.out.println(employees[new Random().nextInt(employees.length)]);
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(Constants.EMPLOYEES_FILE_PATH, true));
                bufferedWriter.write(", " + args[0].substring(1));
                bufferedWriter.close();
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                for (String employee : readEmployeesFromFile()) {
                    if (employee.equals(args[0].substring(1))) {
                        System.out.println("Employee found!");
                        break;
                    }
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                int wordCount = 0;
                for (String employee : readEmployeesFromFile()) {
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
                for (int i = 0; i < e.length; i++) {
                    if (employees[i].equals(args[0].substring(1))) {
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
                List<String> employeeList = new ArrayList<>(Arrays.asList(readEmployeesFromFile()));
                employeeList.remove(args[0].substring(1));
                writeEmployeesToFile(employeeList.toArray(new String[0]));
            } catch (Exception e) {

            }
            System.out.println("Data Deleted.");
        }
    }

}

private static String[] readEmployeesFromFile() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream(Constants.EMPLOYEES_FILE_PATH)));
    String line = bufferedReader.readLine();
    bufferedReader.close();
    return line.split(",");
}

private static void writeEmployeesToFile(String[] employees) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(Constants.EMPLOYEES_FILE_PATH));
    bufferedWriter.write(String.join(",", employees));
    bufferedWriter.close();
}
