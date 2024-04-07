package model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String salary;
    private Category category;

    public Employee(int id, String name, String email, String address, String phone, String salary, Category category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.category = category;
    }

    public Employee(String name, String email, String address, String phone, String salary, Category category) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
