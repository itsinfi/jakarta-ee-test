package com.example.beans;

import com.example.entities.MaisEntity;
import com.example.hibernate.EntityManagerService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

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
            
            EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();

            entityManager.getTransaction().begin();

            MaisEntity mais = new MaisEntity();
            mais.setSorte(this.sorte);
            mais.setPflanzdatum(this.pflanzdatum);
            mais.setErntezeit(this.erntezeit);
            mais.setMenge_tonnen(this.menge_tonnen);
            mais.setFeldnummer(this.feldnummer);
            mais.setDuengemittel(this.duengemittel);
            mais.setAnmerkungen(this.anmerkungen);

            entityManager.persist(mais);

            entityManager.getTransaction().commit();

            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/?faces-redirect=true";
    }
    
}
