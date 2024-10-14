package com.example.beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entities.ValueEntity;
import com.example.hibernate.HibernateUtil;

// import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * Bean class to handle saving result from index.xhtml via hibernate sync into value_entities table as a new entry
 */
@Named("valueBean")
@RequestScoped
public class ValueBean {

    /**
     * value for value for an element to be stored inside value_entities table
     */
    private String value;

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

    /**
     * save the result from the form from index.xhtml to a new value object and transmit it by using a transaction and hibernate
     * 
     * TODO: fix deprecated session.save method call
     * 
     * @return
     */
    public String save() {
        ValueEntity valueEntity = new ValueEntity();
        valueEntity.setValue(value);

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
    
            session.save(valueEntity);
    
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index.xhtml?faces-redirect=true";
    }
    
}
