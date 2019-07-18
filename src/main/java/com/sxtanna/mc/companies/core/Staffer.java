package com.sxtanna.mc.companies.core;

import com.sxtanna.mc.companies.base.Named;
import com.sxtanna.mc.companies.base.State;
import com.sxtanna.mc.companies.base.Unique;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface Staffer extends Named, State, Unique<UUID>
{

	Optional<UUID> getCompanyUUID();

	Set<Product> products();


	UUID DEFAULT_UUID = UUID.randomUUID();
	String DEFAULT_NAME = "";

}
