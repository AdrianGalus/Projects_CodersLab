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

@WebServlet(name = "UserGroupManager", urlPatterns = {"/userGroupManager"})
public class UserGroupManager extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activity = request.getParameter("activity");
        if(activity == null) {
            response.sendRedirect("/panelAdmin");
        }
        int id;
        String name;
        UserGroup userGroup;
        Connection conn;
        try {
            switch(activity) {
                case "add":
                    name = request.getParameter("name");
                    userGroup = new UserGroup(name);
                    conn = DbUtil.getConn();
                    userGroup.saveToDB(conn);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    name = request.getParameter("name");
                    userGroup = new UserGroup(name);
                    userGroup.setId(id);
                    conn = DbUtil.getConn();
                    userGroup.saveToDB(conn);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    userGroup = new UserGroup();
                    userGroup.setId(id);
                    conn = DbUtil.getConn();
                    userGroup.delete(conn);
                    break;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SolutionManager.readActivity(request, response);
        getServletContext().getRequestDispatcher("/UserGroupForm.jsp").forward(request, response);
    }
}
