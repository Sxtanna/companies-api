package com.sxtanna.mc.companies.data.core;

import com.sxtanna.mc.companies.core.Company;
import com.sxtanna.mc.companies.data.Database;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

public interface CompanyDatabase extends Database
{

	void saveCompany(Company data);

	void loadCompany(UUID uuid, Consumer<Optional<Company>> consumer);


	void bulkLoadCompanies(Consumer<Collection<Company>> consumer);

}
