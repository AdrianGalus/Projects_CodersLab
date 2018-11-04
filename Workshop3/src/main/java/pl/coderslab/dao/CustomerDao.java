package pl.coderslab.dao;

import pl.coderslab.models.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String DATE_FORMAT = "uuuu-MM-dd";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public void saveToDB(Connection conn, Customer customer) throws SQLException {

        if(customer.getId() == 0) {
            String sql = "INSERT INTO customers (name, surname, birthDate) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getBirthDate().toString());
            preparedStatement.executeUpdate();
        }
        else {
            String sql = "UPDATE customers SET name=?, surname=?, birthDate=? WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getBirthDate().toString());
            preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();
        }
    }
    public void deleteCustomer(Connection conn, int id) throws SQLException {

        String sql = "DELETE FROM customers WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public List<Customer> loadAllCustomers(Connection conn) throws SQLException {

        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            customers.add(loadDataFromDB(resultSet));
        }
        return customers;
    }
    public Customer loadById(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM customers WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return loadDataFromDB(resultSet);
        }
        return null;
    }
    private Customer loadDataFromDB(ResultSet resultSet) throws SQLException {

        Customer loadCustomer = new Customer();
        loadCustomer.setId(resultSet.getInt("id"));
        loadCustomer.setName(resultSet.getString("name"));
        loadCustomer.setSurname(resultSet.getString("surname"));
        String birthDate = resultSet.getString("birthDate");
        loadCustomer.setBirthDate(LocalDate.parse(birthDate, FORMAT));
        return loadCustomer;
    }
}
