package com.sxtanna.mc.companies;

import com.sxtanna.mc.companies.base.RequiresPlugin;
import com.sxtanna.mc.companies.base.State;
import com.sxtanna.mc.companies.conf.type.CompanyConfig;
import com.sxtanna.mc.companies.conf.type.MySQLDBConfig;
//import com.sxtanna.mc.companies.conf.type.RedisDBConfig;
import com.sxtanna.mc.companies.core.Company;
import com.sxtanna.mc.companies.core.Product;
import com.sxtanna.mc.companies.core.Staffer;
import com.sxtanna.mc.companies.data.type.DataDatabase;
import com.sxtanna.mc.companies.data.type.NameDatabase;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

public interface Companies extends State, RequiresPlugin
{

	CompanyConfig config();


	MySQLDBConfig createOrLoadMySQLDBConfig();

	//RedisDBConfig createOrLoadRedisDBConfig();


	NameDatabase nameDatabase();

	DataDatabase dataDatabase();


	void getOrLoadCompany(UUID uuid, Consumer<Optional<Company>> consumer);

	void getOrLoadProduct(UUID uuid, Consumer<Optional<Product>> consumer);

	void getOrLoadStaffer(UUID uuid, Consumer<Optional<Staffer>> consumer);


	// should probably not expose these
	Company createCompany(UUID owner, String name);

	Product createProduct(UUID owner, UUID companyUUID);

	Staffer createStaffer(UUID owner, String name);

}