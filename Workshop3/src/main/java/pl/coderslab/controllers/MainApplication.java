package pl.coderslab.controllers;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MainApplication", urlPatterns = {"/main"})
public class MainApplication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderDao orderDao = new OrderDao();
        try {
            Connection conn = DbUtil.getConn();
            List<Order> orders = orderDao.loadAllOrders(conn);
            request.setAttribute("orders", orders);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
