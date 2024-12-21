package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Додавання нового співробітника
        employeeDAO.addEmployee("Іван Іванов", 30, "Програміст", 5000.0f);

        // Оновлення інформації про співробітника
        employeeDAO.updateEmployee(1, "Іван Петров", 32, "Програміст", 6000.0f);

        // Видалення співробітника
        employeeDAO.deleteEmployee(1);

        // Отримання інформації про всіх співробітників
        List<Employee> employees = employeeDAO.getEmployees();
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Ім'я: " + employee.getName() + ", Вік: " + employee.getAge() + ", Посада: " + employee.getPosition() + ", Зарплата: " + employee.getSalary());
        }
    }
}
