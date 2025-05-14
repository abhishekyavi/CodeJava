package CodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender,
            String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Name : " + name + ", age : " + age
                + ", Gender : " + gender + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(
                new Employee(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employee(
                112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employee(
                113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employee(
                114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(
                new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new Employee(
                116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new Employee(
                117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new Employee(
                118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new Employee(
                119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new Employee(
                120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new Employee(
                121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new Employee(
                122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new Employee(
                123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new Employee(
                124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(
                new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new Employee(
                126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new Employee(
                127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));

        return employeeList;
    }

    public static void main(String[] args) {
        // sorting
        getEmployeeList()
                .stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("*************************************");

        getEmployeeList()
                .stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(
                "******************with ternary operator*******************");

        getEmployeeList()
                .stream()
                .sorted((o1, o2) -> o1.getSalary() > o2.getSalary() ? 1
                        : o1.getSalary() < o2.getSalary() ? -1
                                : 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        getEmployeeList()
                .stream()
                .collect(
                        Collectors.groupingBy(e -> e.getGender(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "--" + v));

        // grouping by
        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()))
                .forEach((k, v) -> System.out.println(k + "-->>>" + v));

        System.out.println("******with function and collectorsr****");

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "--" + v));

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(),
                        Collectors.mapping(e -> e.getName(), Collectors.toList())))
                .forEach((k, v) -> System.out.println(k + "-------" + v));

        System.out.println("******with function and collectorsr****");

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new,
                        Collectors.mapping(e -> e.getName(), Collectors.toList())))
                .forEach((k, v) -> System.out.println(k + "---->" + v));

        System.out.println("*************************************");

        // avg salary of each dept

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(),
                        Collectors.averagingDouble(e -> e.getSalary())))
                .forEach((k, v) -> System.out.println(k + " " + v));

        // avg age of male n female empployee

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(
                        e -> e.getGender(), Collectors.averagingDouble(e -> e.getSalary())))
                .forEach((k, v) -> System.out.println(k + " " + v));

        // name of employee who joined after 2015

        getEmployeeList()
                .stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(e -> e.getName() + " -------" + e.getYearOfJoining())
                .forEach(e -> System.out.println(e));

        // no of employee in each department

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "--" + v));

        // find the oldeest employee his age and department
        Optional<Employee> emp = getEmployeeList().stream().max(
                Comparator.comparingInt(e -> e.getAge()));
        System.out.println(emp.get().getAge() + " " + emp.get().getDepartment()
                + " " + emp.get().getName());

        // avrage and total salry of the orgnization

        DoubleSummaryStatistics salarystats = getEmployeeList().stream().collect(
                Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Avg--" + salarystats.getAverage());
        System.out.println("Max--" + salarystats.getMax());
        System.out.println("Min--" + salarystats.getMin());
        System.out.println("Sum--" + salarystats.getSum());

        // Find out the highest experienced employees in the organization
        Optional<Employee> maxExpEmp = getEmployeeList().stream().max(
                Comparator.comparing(Employee::getYearOfJoining));
        System.out.println(maxExpEmp.get().getName() + "--"
                + maxExpEmp.get().getAge() + "--" + maxExpEmp.get().getSalary());

        // Fetch the highest-paid male and female employee

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getGender(),
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((k, v) -> System.out.println(k + "----" + v));

        // Fetch the lowest-paid male and female employee

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getGender(),
                        Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((k, v) -> System.out.println(k + " " + v));

        // Get the highest-paid employee in each department
        System.out.println("****highest-paid employee in each dept******");

        getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(),
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((k, v) -> System.out.println(k + "-- " + v));

        // 11. Get the details of the highest paid employee in the organization?
        Optional<Employee> heighestPaidEmp = getEmployeeList().stream().collect(
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(heighestPaidEmp.get());

        // Get the details of the youngest male employee in the product development
        // department?

        Optional<Employee> youngestemp = getEmployeeList().stream()
                .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                .min(Comparator.comparing(Employee::getAge));
        System.out.println(" youngest Employee" + youngestemp.get());

        // Who has the most working experience in the organization?

        Optional<Employee> mostExpEmp = getEmployeeList().stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        // Optional<Employee> mostExpEmp = getEmployeeList().stream()
        // .min(Comparator.comparingInt(Employee::getYearOfJoining));

        System.out.println("-" + mostExpEmp.get());

        // Who is the oldest employee in the organization?

        Optional<Employee> oldestEmp = getEmployeeList().stream().max(Comparator.comparing(Employee::getAge));
        System.out.println(oldestEmp.get());

        // . What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics salarystatsofEmp = getEmployeeList().stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(salarystatsofEmp.getAverage());
        System.out.println(salarystatsofEmp.getSum());

        // List down the names of all employees in each department?

        getEmployeeList().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(),
                        Collectors.mapping(e -> e.getName(), Collectors.toList())))
                .forEach((k, v) -> System.out.println(k + " " + v));

        // Separate the employees who are younger or equal to 30 years from those older
        // than 30 years.

        getEmployeeList().stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30))
                .forEach((k, v) -> System.out.println(k + "-------->" + v));

        List.of(1, 2, 3, 4, 5, 6).stream().collect(Collectors.partitioningBy(e -> e % 2 == 0))
                .forEach((k, v) -> System.out.println(k + "---" + v));

    }
}



