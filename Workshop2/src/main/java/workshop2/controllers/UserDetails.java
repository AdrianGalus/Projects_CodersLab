package workshop2.controllers;

import workshop2.models.Solution;
import workshop2.models.User;
import workshop3.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UserDetails", urlPatterns = {"/UserDetails"})
public class UserDetails extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        Solution[] solutions = new Solution[0];
        String maybeId = request.getParameter("id");
        if(!maybeId.matches("[1-9]+[0-9]*")) {
            response.getWriter().append("Błędne id");
        }
        int userId = Integer.parseInt(maybeId);
        try {
            Connection conn = DbUtil.getConn();
            user = User.loadById(conn, userId);
            solutions = Solution.loadAllByUserId(conn, userId);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("user", user);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/UserDetails.jsp").forward(request, response);
    }
}
