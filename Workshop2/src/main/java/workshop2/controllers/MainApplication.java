package workshop2.controllers;

import workshop2.models.Solution;
import workshop2.utils.DbUtil;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "MainApplication", urlPatterns = {"/Main"})
public class MainApplication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config = getServletConfig();
        int limit = Integer.parseInt(config.getInitParameter("number-solutions"));
        Solution[] solutions = new Solution[0];
        try {
            Connection conn = DbUtil.getConn();
            solutions = Solution.loadAllSolutions(conn, limit);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
