package controller;

import model.Category;
import model.Employee;
import service.CategoryService;
import service.EmployeeService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "employees")
public class EmployeeController extends HttpServlet {
     private EmployeeService employeeService = new EmployeeService();
     private CategoryService categoryService = new CategoryService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch(action){
            case "home":
                showHome(request, response);
                break;
case "create":
    showCreate(request, response);
    break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/home.jsp");
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("employees", employees);
        dispatcher.forward(request,response);
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        dispatcher.forward(request,response);


    }
    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        req.setAttribute("idEdit", idEdit);
        Employee employeeEdit = employeeService.findById(idEdit);
        req.setAttribute("employeeEdit", employeeEdit);
        List<Category> list = this.categoryService.findAll();
        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(req, resp);
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.delete(idDelete);
        response.sendRedirect("http://localhost:8080/employees?action=home");
    }



        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch(action){

            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
        }
    }
    private void createEmployee(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException{
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String salary = req.getParameter("salary");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Category category = new Category(idCategory);
        Employee employee = new Employee(name, email, address, phone, salary, category);
        employeeService.add(employee);
        response.sendRedirect("/employees?action=home");
    }
    private void editEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String salary = req.getParameter("salary");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));

        Category category = new Category(idCategory);
        Employee employee = new Employee(name, email, address, phone, salary, category);
        employeeService.edit(id, employee);
        resp.sendRedirect("/employees?action=home");
    }
}