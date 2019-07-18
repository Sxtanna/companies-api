package com.sxtanna.mc.companies.core;

import com.sxtanna.mc.companies.base.Named;
import com.sxtanna.mc.companies.base.Owned;
import com.sxtanna.mc.companies.base.RequiresPlugin;
import com.sxtanna.mc.companies.base.State;
import com.sxtanna.mc.companies.base.Unique;
import org.bukkit.Material;

import java.util.Set;
import java.util.UUID;

public interface Company extends Named, State, Unique<UUID>, Owned<UUID>, RequiresPlugin
{

	Material getIcon();


	Set<Staffer> staffers();

	Set<Product> products();


	UUID DEFAULT_UUID = UUID.randomUUID();

	String DEFAULT_NAME = "";

}
