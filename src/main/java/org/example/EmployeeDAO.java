package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private DatabaseConnector databaseConnector;

    public EmployeeDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void addEmployee(String name, int age, String position, float salary) throws SQLException {
        String query = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = databaseConnector.getConnection().prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, position);
            statement.setFloat(4, salary);
            statement.executeUpdate();
        }
    }

    public void updateEmployee(int id, String name, int age, String position, float salary) throws SQLException {
        String query = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement statement = databaseConnector.getConnection().prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, position);
            statement.setFloat(4, salary);
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = databaseConnector.getConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Statement statement = databaseConnector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String position = resultSet.getString("position");
                float salary = resultSet.getFloat("salary");
                employees.add(new Employee(id, name, age, position, salary));
            }
        }
        return employees;
    }
}
