package com.example.servlets;

import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Web Servlet to handle index call
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet {

    /**
     * getter to get results from test table from mysql db and then redirect to index.xhtml jsf page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<String> result = getDbTestEntries();
            // resp.getOutputStream().println(result.toString());
            req.setAttribute("dbResults", result);

            req.getRequestDispatcher("/index.xhtml").forward(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            resp.getOutputStream().println("Error: " + e);
        }
    }
    
    /**
     * read and put out all entries from test table inside mysql db
     * (no hibernate used here)
     * 
     * // TODO: add a different request using hibernate to try out lazy loading
     * 
     * @return all entries from test table
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<String> getDbTestEntries() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver"); // otherwise does not work on glassfish servlet server somehow :/
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jarkarta-ee-test?useSSL=false&serverTimezone=UTC", "root", "");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM test");

        ArrayList<String> result = new ArrayList<String>();

        while (resultSet.next()) {
            String resultElement = "";

            resultElement += resultSet.getString("1") + ", ";
            resultElement += resultSet.getString("2") + ", ";
            resultElement += resultSet.getString("3") + ", ";
            resultElement += resultSet.getString("4") + "\n";

            result.add(resultElement);
        }

        return result;

    }
}
