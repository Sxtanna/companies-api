package com.sxtanna.mc.companies.core;

import com.sxtanna.mc.companies.base.Owned;
import com.sxtanna.mc.companies.base.Unique;

import java.util.UUID;

public interface Product extends Unique<UUID>, Owned<UUID>
{

	String asBase64();


	UUID getCompanyUUID();


	UUID DEFAULT_UUID = UUID.randomUUID();

}
