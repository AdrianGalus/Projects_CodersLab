package workshop2.controllers;

import workshop2.models.UserGroup;
import workshop2.utils.DbUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoadUserGroups", urlPatterns = {"/LoadUserGroups"})
public class LoadUserGroups extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserGroup[] userGroups = new UserGroup[0];
        try {
            Connection conn = DbUtil.getConn();
            userGroups = UserGroup.loadAllGroups(conn);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("userGroups", userGroups);
        getServletContext().getRequestDispatcher("/UserGroups.jsp").forward(request, response);
    }
}
