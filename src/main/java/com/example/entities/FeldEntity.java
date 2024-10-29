package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feld_hibernate")
public class FeldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feldnummer")
    private int feldnummer;

    public int getFeldnummer() {
        return feldnummer;
    }
    
    @Column(name = "groesse_ha")
    private int groesse_ha;

    public int getGroesse_ha() {
        return groesse_ha;
    }
    public void setGroesse_ha(int groesse_ha) {
        this.groesse_ha = groesse_ha;
    }

    @Column(name = "bodenart")
    private String bodenart;
    
    public String getBodenart() {
        return bodenart;
    }
    public void setBodenart(String bodenart) {
        this.bodenart = bodenart;
    }

    @Column(name = "standort")
    private String standort;
    
    public String getStandort() {
        return standort;
    }
    public void setStandort(String standort) {
        this.standort = standort;
    }

    @Column(name = "besitzer")
    private String besitzer;
    
    public String getBesitzer() {
        return besitzer;
    }
    public void setBesitzer(String besitzer) {
        this.besitzer = besitzer;
    }

    @Column(name = "anmerkungen")
    private String anmerkungen;

    public String getAnmerkungen() {
        return anmerkungen;
    }
    public void setAnmerkungen(String anmerkungen) {
        this.anmerkungen = anmerkungen;
    }

}
