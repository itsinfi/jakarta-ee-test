package com.example.hibernate;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerService {

    private static EntityManagerFactory entityManagerFactory;

    static {
        EntityManagerService.entityManagerFactory = Persistence.createEntityManagerFactory("mais");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return EntityManagerService.entityManagerFactory;
    }
    
}
