package com.sxtanna.mc.companies.conf.type;

import com.sxtanna.mc.companies.conf.base.Config;

public interface MySQLDBConfig extends Config
{

	String getHost();

	String getPort();


	String getDatabase();

	String getUsername();

	String getPassword();

}
