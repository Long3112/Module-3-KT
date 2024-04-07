package service;

import model.Category;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService<Employee>{
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Employee employee) {
        String sql = "insert into employee (name, email, address, phone, salary, idCategory) values (?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getEmail());
            preparedStatement.setString(3,employee.getAddress());
            preparedStatement.setString(4,employee.getPhone());
            preparedStatement.setString(5,employee.getSalary());
            preparedStatement.setInt(6,employee.getCategory().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from employee where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Employee employee) {
        String sql = "update employee  set name = ?, email = ?, address = ?, phone = ?, salary = ?, idDepartment = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getCategory().getId());
            preparedStatement.setInt(7,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "select employee.*, c.name  as nameCategory from employee join category c on c.id=employee.idCategory;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String salary = resultSet.getString("salary");
                int idCategory = resultSet.getInt("idCategory");
                String nameCategory = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                Employee employee = new Employee(id, name, email,address,phone,salary,category);
                employees.add(employee) ;           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public Employee findById(int id) {
        String sql = "select employee.*, d.name as 'nameDepartment' from staff join department d on staff.idDepartment = d.id where staff.id = ?;";
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String salary = resultSet.getString("salary");
                int idCategory = resultSet.getInt("idCategory");
                String nameCategory = resultSet.getString("nameDepartment");
                Category category = new Category(idCategory, nameCategory);
                employee = new Employee(id,name,email,address,phone,salary,category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
