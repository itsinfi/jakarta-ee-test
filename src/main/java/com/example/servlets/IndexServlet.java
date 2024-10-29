package com.example.servlets;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
    
    public ArrayList<String> getDbTestEntries() throws SQLException, ClassNotFoundException {

        Date startDate = new Date();

        Class.forName("com.mysql.cj.jdbc.Driver"); // otherwise does not work on glassfish servlet server somehow :/
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jarkarta-ee-test?useSSL=false&serverTimezone=UTC", "root", "");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mais, feld WHERE mais.feldnummer = feld.feldnummer");

        ArrayList<String> result = new ArrayList<String>();

        while (resultSet.next()) {
            String resultString = "";

            resultString += "{";
            resultString += "id: " + resultSet.getInt("mais.id") + ", ";
            resultString += "sorte: " + resultSet.getString("mais.sorte") + ", ";
            resultString += "pflanzdatum: " + resultSet.getString("mais.pflanzdatum") + ", ";
            resultString += "erntezeit: " + resultSet.getString("mais.erntezeit") + ", ";
            resultString += "menge_tonnen: " + resultSet.getInt("mais.menge_tonnen") + ", ";
            resultString += "feldnummer: " + resultSet.getInt("mais.feldnummer") + ", ";
            resultString += "duengemittel: " + resultSet.getString("mais.duengemittel") + ", ";
            resultString += "anmerkungen: " + resultSet.getString("mais.anmerkungen");
            resultString += "}";

            resultString += "{";
            resultString += "id: " + resultSet.getInt("feld.feldnummer") + ", ";
            resultString += "id: " + resultSet.getInt("feld.groesse_ha") + ", ";
            resultString += "id: " + resultSet.getString("feld.bodenart") + ", ";
            resultString += "id: " + resultSet.getString("feld.standort") + ", ";
            resultString += "id: " + resultSet.getString("feld.besitzer") + ", ";
            resultString += "id: " + resultSet.getString("feld.anmerkungen") + ", ";
            resultString += "}";

            result.add(resultString);
        }
        
        Date endDate = new Date();

        result.add("Zeit:" + String.valueOf(endDate.getTime() - startDate.getTime()) + "ms");

        return result;

    }
}
