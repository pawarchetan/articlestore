package com.upday.store.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class RandomNumberGenerator implements IdentifierGenerator {
    public static String generate() {
        return UUID.randomUUID().toString();
    }

    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return UUID.randomUUID().toString();
    }
}