package com.example.servlets;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.entities.MaisEntity;
import com.example.hibernate.EntityManagerService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
        
        ArrayList<String> result = new ArrayList<String>();
        
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();

        String qlString = "SELECT e from MaisEntity e";
        TypedQuery<MaisEntity> query = entityManager.createQuery(qlString, MaisEntity.class);
        List<MaisEntity> mais = query.getResultList();

        result.add(String.valueOf(mais.size()));

        Iterator<MaisEntity> it = mais.iterator();

        while (it.hasNext()) {
            MaisEntity currentMais = it.next();

            String resultString = "";

            resultString += "{";
            resultString += "id: " + currentMais.getId() + ", ";
            resultString += "sorte: " + currentMais.getSorte() + ", ";
            resultString += "pflanzdatum: " + currentMais.getPflanzdatum() + ", ";
            resultString += "erntezeit: " + currentMais.getErntezeit() + ", ";
            resultString += "menge_tonnen: " + currentMais.getMenge_tonnen() + ", ";
            resultString += "feldnummer: " + currentMais.getFeldnummer() + ", ";
            resultString += "duengemittel: " + currentMais.getDuengemittel() + ", ";
            resultString += "anmerkungen: " + currentMais.getAnmerkungen();
            resultString += "}";

            result.add(resultString);
        }

        entityManager.close();

        Date endDate = new Date();

        result.add("Zeit:" + String.valueOf(endDate.getTime() - startDate.getTime()) + "ms");

        return result;

    }
}
