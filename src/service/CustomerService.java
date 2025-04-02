package service;

import model.*;
import Connection.*;

import java.sql.*;
import java.util.*;

public class CustomerService {
    public List<Customer> getAllCustomer(){
        List<Customer> customers = new ArrayList<>();

        String query = "select * from CUSTOMERS";

        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()){
                customers.add(new Customer(
                        resultSet.getString("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PHONE"),
                        resultSet.getDate("REGISTRATION_DATE"),
                        resultSet.getInt("RENT_h")
                ));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return customers;
    }
}
