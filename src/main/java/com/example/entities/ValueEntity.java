package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *  Value Entity class to map value_entities table with hibernate.
 */
@Entity
@Table(name = "value_entities")
public class ValueEntity {

    /**
     * primary key id for the value_entities table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    /**
     * test value to be stored inside the mysql db
     */
    @Column(name = "value")
    private String value;

    /**
     * getter for id
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * getter for value
     * 
     * @return value
     */
    public String getValue() {
        return value;
    }
    
    /**
     * setter for value
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}
