package service;

import model.*;
import Connection.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    public List<Vehicle> getAllVehicle() {

        List<Vehicle> vehicles = new ArrayList<>();

        String query = "select * from vehicles";

        try(Connection sql = DatabaseConnection.getConnection();
                            Statement statement = sql.createStatement();
                            ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()){
                vehicles.add(new Vehicle(
                        resultSet.getString("LICENSE_PLATE"),
                        resultSet.getString("OWNER_ID"),
                        resultSet.getString("TYPE_ID"),
                        resultSet.getString("PARKING_SPOT"),
                        resultSet.getDate("PARKING_DATE"),
                        resultSet.getDate("CHECK_IN_TIME"),
                        resultSet.getDate("CHECK_OUT_TIME"),
                        resultSet.getDouble("fee")
                ));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicles;
    }
}
