package pl.coderslab.dao;

import pl.coderslab.models.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public void saveToDB(Connection conn, Employee employee) throws SQLException {

        if(employee.getId() == 0) {
            String sql = "INSERT INTO employees (name, surname, address, phone, note, costPerHour) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getNote());
            preparedStatement.setDouble(6, employee.getCostPerHour());
            preparedStatement.executeUpdate();
        }
        else {
            String sql = "UPDATE employees SET name=?, surname=?, address=?, phone=?, note=?, costPerHour=? " +
                    "WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getNote());
            preparedStatement.setDouble(6, employee.getCostPerHour());
            preparedStatement.setInt(7, employee.getId());
            preparedStatement.executeUpdate();
        }
    }
    public void deleteEmployee(Connection conn, int id) throws SQLException {

        String sql = "DELETE FROM employees WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public List<Employee> loadAllEmployees(Connection conn) throws SQLException {

        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            employees.add(loadDataFromDB(resultSet));
        }
        return employees;
    }
    public Employee loadById(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM employees WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return loadDataFromDB(resultSet);
        }
        return null;
    }
    private Employee loadDataFromDB(ResultSet resultSet) throws SQLException {

        Employee loadEmployee = new Employee();
        loadEmployee.setId(resultSet.getInt("id"));
        loadEmployee.setName(resultSet.getString("name"));
        loadEmployee.setSurname(resultSet.getString("surname"));
        loadEmployee.setAddress(resultSet.getString("address"));
        loadEmployee.setNote(resultSet.getString("note"));
        loadEmployee.setCostPerHour(resultSet.getDouble("costPerHour"));
        return loadEmployee;
    }
}
