package online.cx.javabasic.oop.company;

import java.util.Objects;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/23 17:36
 */
public class Employee {

    String name;
    int salary;

    void work(){

    }

    void getPaid(BankEndPoint bank){
        bank.payment(name, salary);
    }

    static void loadAllEmployees(){

    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
