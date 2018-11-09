package workshop3.dao;

import workshop3.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private static final String DATE_FORMAT = "uuuu-MM-dd";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public void saveToDB(Connection conn, Order order) throws SQLException {

        if(order.getId() == 0) {
            String sql = "INSERT INTO orders (acceptanceForRepair, expectedStartOfRepair, startOfRepair, " +
            "employeeId, detailsOfProblem, detailsOfRepair, status, vehicleId, repairCost, replacementsCost, " +
                        "costPerHour, numberOfHours) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, order.getAcceptanceForRepair().toString());
            preparedStatement.setString(2, order.getExpectedStartOfRepair().toString());
            preparedStatement.setString(3, order.getStartOfRepair().toString());
            preparedStatement.setInt(4, order.getEmployeeId());
            preparedStatement.setString(5, order.getDetailsOfProblem());
            preparedStatement.setString(6, order.getDetailsOfRepair());
            preparedStatement.setString(7, order.getStatus());
            preparedStatement.setInt(8, order.getVehicleId());
            preparedStatement.setDouble(9, order.getRepairCost());
            preparedStatement.setDouble(10, order.getReplacementsCost());
            preparedStatement.setDouble(11, order.getCostPerHour());
            preparedStatement.setDouble(12, order.getNumberOfHours());
            preparedStatement.executeUpdate();
        }
        else {
            String sql = "UPDATE oders SET acceptanceForRepair=?, expectedStartOfRepair=?, startOfRepair=?, " +
                    "employeeId=?, detailsOfProblem=?, detailsOfRepair=?, status=?, vehicleId=?, repairCost=?, " +
                    "replacementsCost=?, costPerHour=?, numberOfHours=? WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, order.getAcceptanceForRepair().toString());
            preparedStatement.setString(2, order.getExpectedStartOfRepair().toString());
            preparedStatement.setString(3, order.getStartOfRepair().toString());
            preparedStatement.setInt(4, order.getEmployeeId());
            preparedStatement.setString(5, order.getDetailsOfProblem());
            preparedStatement.setString(6, order.getDetailsOfRepair());
            preparedStatement.setString(7, order.getStatus());
            preparedStatement.setInt(8, order.getVehicleId());
            preparedStatement.setDouble(9, order.getRepairCost());
            preparedStatement.setDouble(10, order.getReplacementsCost());
            preparedStatement.setDouble(11, order.getCostPerHour());
            preparedStatement.setDouble(12, order.getNumberOfHours());
            preparedStatement.setInt(13, order.getId());
            preparedStatement.executeUpdate();
        }
    }
    public void deleteOrder(Connection conn, int id) throws SQLException {

        String sql = "DELETE FROM orders WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public List<Order> loadAllOrders(Connection conn) throws SQLException {

        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            orders.add(loadDataFromDB(resultSet));
        }
        return orders;
    }
    public Order loadById(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM orders WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return loadDataFromDB(resultSet);
        }
        return null;
    }
    private Order loadDataFromDB(ResultSet resultSet) throws SQLException {

        Order loadOrder = new Order();
        loadOrder.setId(resultSet.getInt("id"));
        String acceptanceForRepair = resultSet.getString("acceptanceForRepair");
        loadOrder.setAcceptanceForRepair(LocalDate.parse(acceptanceForRepair, FORMAT));
        String expectedStartOfRepair = resultSet.getString("expectedStartOfRepair");
        loadOrder.setExpectedStartOfRepair(LocalDate.parse(expectedStartOfRepair, FORMAT));
        String startOfRepair = resultSet.getString("startOfRepair");
        loadOrder.setStartOfRepair(LocalDate.parse(startOfRepair, FORMAT));
        loadOrder.setEmployeeId(resultSet.getInt("employeeId"));
        loadOrder.setDetailsOfProblem(resultSet.getString("detailsOfProblem"));
        loadOrder.setDetailsOfRepair(resultSet.getString("detailsOfRepair"));
        loadOrder.setStatus(resultSet.getString("status"));
        loadOrder.setVehicleId(resultSet.getInt("vehicleId"));
        loadOrder.setRepairCost(resultSet.getDouble("repairCost"));
        loadOrder.setReplacementsCost(resultSet.getDouble("replacementsCost"));
        loadOrder.setCostPerHour(resultSet.getDouble("costPerHour"));
        loadOrder.setNumberOfHours(resultSet.getDouble("numberOfHours"));
        return loadOrder;
    }
}
