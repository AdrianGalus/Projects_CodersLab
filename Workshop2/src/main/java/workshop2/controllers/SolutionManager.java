package workshop2.controllers;

import workshop2.models.Solution;
import workshop3.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SolutionManager", urlPatterns = {"/solutionManager"})
public class SolutionManager extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activity = request.getParameter("activity");
        if(activity == null) {
            response.sendRedirect("/panelAdmin");
        }
        int id;
        String description;
        int exerciseId;
        int usersId;
        Solution solution;
        Connection conn;
        try {
            switch (activity) {
                case "add":
                    description = request.getParameter("description");
                    exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
                    usersId = Integer.parseInt(request.getParameter("usersId"));
                    solution = new Solution(exerciseId, usersId);
                    solution.setDescription(description);
                    conn = DbUtil.getConn();
                    solution.saveToDB(conn);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    description = request.getParameter("description");
                    exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
                    usersId = Integer.parseInt(request.getParameter("usersId"));
                    solution = new Solution(exerciseId, usersId);
                    solution.setId(id);
                    solution.setDescription(description);
                    conn = DbUtil.getConn();
                    solution.saveToDB(conn);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    solution = new Solution();
                    solution.setId(id);
                    conn = DbUtil.getConn();
                    solution.delete(conn);
                    break;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/PanelAdmin.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        readActivity(request, response);
        getServletContext().getRequestDispatcher("/SolutionForm.jsp").forward(request, response);
    }
    public static void readActivity(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String activity = request.getParameter("activity");
        if(activity == null) {
            response.sendRedirect("/panelAdmin");
        }
        switch(activity) {
            case "add":
                request.setAttribute("activity", "add");
                break;
            case "edit":
                request.setAttribute("activity", "edit");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("activity", "delete");
                request.setAttribute("id", id);
                break;
        }
    }
}
