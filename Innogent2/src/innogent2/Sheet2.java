/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innogent2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author lenovo
 */
public class Sheet2 {
    public static void main(String []args){
//        uploadStudent("D:\\Student.csv");
        int maleCount=0;
        int femaleCount=0;
        List<Employee> employeeList = new ArrayList<Employee>();
         
employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
employeeList.add(new Employee(255, "Ali Baig", 23,"Male", "Infrastructure", 2018, 12700.0));
employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        Map<String, Long> genderCount=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCount);
        
        System.out.println(employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet()));
        
        Map<String, Double> averageAge=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAge);
        
        Optional<Employee> highestSalary=
        employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(highestSalary);
        Employee highestSalaryEmployee=highestSalary.get();
        System.out.println("Emplyee ID:"+highestSalaryEmployee.getId());
        System.out.println("Emplyee name:"+highestSalaryEmployee.getName());
        System.out.println("Emplyee age:"+highestSalaryEmployee.getAge());
        System.out.println("Emplyee Gender:"+highestSalaryEmployee.getGender());
        System.out.println("Emplyee Department:"+highestSalaryEmployee.getDepartment());
        System.out.println("Emplyee Year of Joining:"+highestSalaryEmployee.getYearOfJoining());
        System.out.println("Emplyee Salary:"+highestSalaryEmployee.getSalary());
        
        System.out.println(employeeList.stream().filter(e->e.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toSet()));
        
        Map<String, Long> employeeCount = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        System.out.println("Departmentwise Employee count :- \n" + employeeCount);
        
        Map<String, Double> averageSalaryDept= employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(Employee:: getSalary)));
        System.out.println("Average Salary: "+averageSalaryDept);
        
        Optional<Employee> youngestMaleEmployee = employeeList.stream().filter(e -> "Product Development".equals(e.getDepartment())).collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        Employee youngestMaleEmployeeDtl=youngestMaleEmployee.get();
        System.out.println("Emplyee ID:"+youngestMaleEmployeeDtl.getId());
        System.out.println("Emplyee name:"+youngestMaleEmployeeDtl.getName());
        System.out.println("Emplyee age:"+youngestMaleEmployeeDtl.getAge());
        System.out.println("Emplyee Gender:"+youngestMaleEmployeeDtl.getGender());
        System.out.println("Emplyee Department:"+youngestMaleEmployeeDtl.getDepartment());
        System.out.println("Emplyee Year of Joining:"+youngestMaleEmployeeDtl.getYearOfJoining());
        System.out.println("Emplyee Salary:"+youngestMaleEmployeeDtl.getSalary());
        
        Map<String,Long> genderCountDept=employeeList.stream().filter(e -> "Sales And Marketing".equals(e.getDepartment())).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Gender count of Sales and Marketing Department\n"+genderCountDept);
        
        Map<String,Double> avgMaleAndFemaleSalary=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average Salary of male and female:\n"+avgMaleAndFemaleSalary);
        
        Map<String ,List<String>> deptEmployeeName=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        deptEmployeeName.forEach((department, employeeNames) -> {
            System.out.println("Department: " + department);
            employeeNames.forEach(name -> System.out.println("  " + name));
        });
        
        DoubleSummaryStatistics avgEmployeeSalary=employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary = "+avgEmployeeSalary.getAverage());
        System.out.println("Total Salary = "+avgEmployeeSalary.getSum());
        
        List<String> groupEmployeeByAge=employeeList.stream().filter(e -> e.getAge() > 25).map(e->e.getName()).collect(Collectors.toList());
        System.out.println("Employee name whose age is more than 25:\n"+groupEmployeeByAge);
        List<String> youngerEmployeeByAge=employeeList.stream().filter(e -> e.getAge() <= 25).map(e->e.getName()).collect(Collectors.toList());
        System.out.println("Employee name whose age is more than 25:\n"+youngerEmployeeByAge);
        
        Optional<Employee> oldestEmployee = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployeeDtl=oldestEmployee.get();
        System.out.println("Emplyee name:"+oldestEmployeeDtl.getName());
        System.out.println("Emplyee age:"+oldestEmployeeDtl.getAge());
        System.out.println("Emplyee department:"+oldestEmployeeDtl.getDepartment());

    }
    
    
    
}
