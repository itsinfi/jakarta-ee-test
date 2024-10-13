package com.example;

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

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<String> result = runDataBaseTest();
            // resp.getOutputStream().println(result.toString());
            req.setAttribute("dbResults", result);

            req.getRequestDispatcher("/index.xhtml").forward(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            resp.getOutputStream().println("Error: " + e);
        }
    }
    
    public ArrayList<String> runDataBaseTest() throws SQLException, ClassNotFoundException {

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
