package pl.coderslab.dao;

import pl.coderslab.models.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static final String DATE_FORMAT = "uuuu-MM-dd";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public void saveToDB(Connection conn, Vehicle vehicle) throws SQLException {

        if(vehicle.getId() == 0) {
            String sql = "INSERT INTO vehicles (model, mark, buildYear, registrationNumber, nextInspection) " +
                    "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, vehicle.getModel());
            preparedStatement.setString(2, vehicle.getMark());
            preparedStatement.setInt(3, vehicle.getBuildYear());
            preparedStatement.setString(4, vehicle.getRegistrationNumber());
            preparedStatement.setString(5, vehicle.getNextInspection().toString());
            preparedStatement.executeUpdate();
        }
        else {
            String sql = "UPDATE vehicles SET model=?, mark=?, buildYear=?, registrationNumber=?, nextInspection=? " +
                    "WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, vehicle.getModel());
            preparedStatement.setString(2, vehicle.getMark());
            preparedStatement.setInt(3, vehicle.getBuildYear());
            preparedStatement.setString(4, vehicle.getRegistrationNumber());
            preparedStatement.setString(5, vehicle.getNextInspection().toString());
            preparedStatement.setInt(6, vehicle.getId());
            preparedStatement.executeUpdate();
        }
    }
    public void deleteVehicle(Connection conn, int id) throws SQLException {

        String sql = "DELETE FROM vehicles WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public List<Vehicle> loadAllVehicles(Connection conn) throws SQLException {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Vehicle loadVehicle = loadDataFromDB(resultSet);
            vehicles.add(loadVehicle);
        }
        return vehicles;
    }
    public Vehicle loadById(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM vehicle WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Vehicle loadVehicle = loadDataFromDB(resultSet);
            return loadVehicle;
        }
        return null;
    }
    private Vehicle loadDataFromDB(ResultSet resultSet) throws SQLException {

        Vehicle loadVehicle = new Vehicle();
        loadVehicle.setId(resultSet.getInt("id"));
        loadVehicle.setModel(resultSet.getString("model"));
        loadVehicle.setMark(resultSet.getString("mark"));
        loadVehicle.setBuildYear(resultSet.getInt("buildYear"));
        loadVehicle.setRegistrationNumber(resultSet.getString("registrationNumber"));
        String nextInspection = resultSet.getString("nextInspection");
        loadVehicle.setNextInspection(LocalDate.parse(nextInspection, FORMAT));
        return loadVehicle;
    }
}
