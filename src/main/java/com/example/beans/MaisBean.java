package com.example.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

// import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * Bean class to handle saving result from index.xhtml via hibernate sync into value_entities table as a new entry
 */
@Named("maisBean")
@RequestScoped
public class MaisBean {

    
    private String sorte;
    private String pflanzdatum;
    private String erntezeit;
    private int menge_tonnen;
    private int feldnummer;
    private String duengemittel;
    private String anmerkungen;

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }
    public String getPflanzdatum() {
        return pflanzdatum;
    }

    public void setPflanzdatum(String pflanzdatum) {
        this.pflanzdatum = pflanzdatum;
    }

    public String getErntezeit() {
        return erntezeit;
    }

    public void setErntezeit(String erntezeit) {
        this.erntezeit = erntezeit;
    }

    public int getMenge_tonnen() {
        return menge_tonnen;
    }

    public void setMenge_tonnen(int menge_tonnen) {
        this.menge_tonnen = menge_tonnen;
    }

    public int getFeldnummer() {
        return feldnummer;
    }

    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    public String getDuengemittel() {
        return duengemittel;
    }

    public void setDuengemittel(String duengemittel) {
        this.duengemittel = duengemittel;
    }

    public String getAnmerkungen() {
        return anmerkungen;
    }
    public void setAnmerkungen(String anmerkungen) {
        this.anmerkungen = anmerkungen;
    }
    
    public String save() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // otherwise does not work on glassfish servlet server somehow :/
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jarkarta-ee-test?useSSL=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO mais(sorte, pflanzdatum, erntezeit, menge_tonnen, feldnummer, duengemittel, anmerkungen) VALUES (?, ?, ?, ?, ?, ?, ?);");
            
            stmt.setString(1, sorte);
            stmt.setString(2, pflanzdatum);
            stmt.setString(3, erntezeit);
            stmt.setInt(4, menge_tonnen);
            stmt.setInt(5, feldnummer);
            stmt.setString(6, duengemittel);
            stmt.setString(7, anmerkungen);

            stmt.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index.xhtml?faces-redirect=true";
    }
    
}
