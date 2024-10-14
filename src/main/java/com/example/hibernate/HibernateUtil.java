package com.example.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.schema.Action;

import com.example.entities.ValueEntity;

/*
 * Hibernate Config Util class
 * 
 * TODO: prettify
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    // MySQL
                    .applySetting(AvailableSettings.DIALECT,
                            "org.hibernate.dialect.MySQLDialect")
                    .applySetting(AvailableSettings.JAKARTA_JDBC_URL,
                            "jdbc:mysql://localhost:3306/jarkarta-ee-test?useSSL=false&serverTimezone=UTC")
                    // Credentials
                    .applySetting(AvailableSettings.JAKARTA_JDBC_USER, "root")
                    .applySetting(AvailableSettings.JAKARTA_JDBC_PASSWORD, "")
                    // Automatic schema export
                    .applySetting(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION, Action.SPEC_ACTION_DROP_AND_CREATE)
                    // SQL statement logging
                    .applySetting(AvailableSettings.SHOW_SQL, true)
                    .applySetting(AvailableSettings.FORMAT_SQL, true)
                    .applySetting(AvailableSettings.HIGHLIGHT_SQL, true)
                    .build();
            
            Metadata metadata = new MetadataSources(standardRegistry)
                    .addAnnotatedClass(ValueEntity.class)
                    .getMetadataBuilder()
                    .build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
