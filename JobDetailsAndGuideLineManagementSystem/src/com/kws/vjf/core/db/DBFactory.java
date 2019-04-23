package com.kws.vjf.core.db;

import com.kws.vjf.core.dao.AbstractDataAccessObject;




public class DBFactory
{
	public DBFactory()
	{
		new AbstractDataAccessObject().getConnection();
	}
}
