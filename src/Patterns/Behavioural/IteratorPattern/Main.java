package Patterns.Behavioural.IteratorPattern;


import java.util.ArrayList;
import java.util.List;

interface iterator<T> {
    boolean hasNext();

    T next();
}

interface Aggregate<T> {
    iterator<T> createIterator();
}

class Employee {
    private String name;
    private Integer salary;

    Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public Integer getSalary() {
        return this.salary;
    }
}

class EmployeeIterator implements iterator<Employee> {

    private List<Employee> employeeList;
    private Integer index = 0;

    @Override
    public boolean hasNext() {
        return index < employeeList.size();
    }

    @Override
    public Employee next() {
        if (index < employeeList.size()) {
            return employeeList.get(index++);
        }
        return null;
    }

    EmployeeIterator(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

class Company implements Aggregate<Employee> {

    List<Employee> employeeList;

    Company(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public iterator<Employee> createIterator() {
        return new EmployeeIterator(this.employeeList);
    }
}

 class Main {

       public static void main(String[] args) {
           List<Employee> employeeList = new ArrayList<>();
           Employee employee1 = new Employee("Naveen", 10000);
           Employee employee2 = new Employee("Kulshreshtha", 5000);
           employeeList.add(employee1);
           employeeList.add(employee2);

           Company company = new Company(employeeList);
           iterator<Employee> iterator = company.createIterator();

           Integer totalSalary = 0;

           while (iterator.hasNext()) {
               totalSalary += iterator.next().getSalary();
           }

           System.out.println(totalSalary);
       }

 }
