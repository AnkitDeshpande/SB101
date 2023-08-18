package com.masai.Q3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
    private static EntityManagerFactory emFactory;

    public static EntityManager connect() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory("Insurance");
        }
        return emFactory.createEntityManager();
    }

}
