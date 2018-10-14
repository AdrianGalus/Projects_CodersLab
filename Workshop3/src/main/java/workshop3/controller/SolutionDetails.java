package workshop3.controller;

import workshop2.Solution;
import workshop3.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SolutionDetails", urlPatterns = {"/SolutionDetails"})
public class SolutionDetails extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maybeId = request.getParameter("id");
        if(!maybeId.matches("[1-9]+[0-9]*")) {
            response.getWriter().append("Błędny parametr");
        }
        int solutionId = Integer.parseInt(maybeId);
        Solution solution = null;
        try {
            Connection conn = DbUtil.getConn();
            solution = Solution.loadById(conn, solutionId);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/SolutionDetails.jsp").forward(request, response);
    }
}
