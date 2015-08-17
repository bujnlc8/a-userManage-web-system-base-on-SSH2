package com.haihuiling.common;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.Oracle10gDialect;

public class Oracle11gDialect extends Oracle10gDialect {
	public Oracle11gDialect() {
		super();
		registerHibernateType(Types.DECIMAL, Hibernate.BIG_DECIMAL.getName());
		registerHibernateType(Types.NVARCHAR, Hibernate.STRING.getName());
		registerHibernateType(Types.LONGVARCHAR,Hibernate.STRING.getName());
		registerHibernateType(-1, Hibernate.STRING.getName());
	}
}
