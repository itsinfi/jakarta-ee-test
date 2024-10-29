package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mais_hibernate")
public class MaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }
    
    @Column(name = "sorte")
    private String sorte;

    public String getSorte() {
        return sorte;
    }
    
    public void setSorte(String value) {
        this.sorte = value;
    }

    @Column(name = "pflanzdatum")
    private String pflanzdatum;

    public String getPflanzdatum() {
        return pflanzdatum;
    }

    public void setPflanzdatum(String pflanzdatum) {
        this.pflanzdatum = pflanzdatum;
    }

    @Column(name = "erntezeit")
    private String erntezeit;
    
    public String getErntezeit() {
        return erntezeit;
    }

    public void setErntezeit(String erntezeit) {
        this.erntezeit = erntezeit;
    }

    @Column(name = "menge_tonnen")
    private int menge_tonnen;
    
    public int getMenge_tonnen() {
        return menge_tonnen;
    }

    public void setMenge_tonnen(int menge_tonnen) {
        this.menge_tonnen = menge_tonnen;
    }

    @Column(name = "feldnummer")
    private int feldnummer;

    public int getFeldnummer() {
        return feldnummer;
    }

    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    @Column(name = "duengemittel")
    private String duengemittel;
    
    public String getDuengemittel() {
        return duengemittel;
    }

    public void setDuengemittel(String duengemittel) {
        this.duengemittel = duengemittel;
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
