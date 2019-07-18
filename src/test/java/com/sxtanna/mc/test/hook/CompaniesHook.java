package com.sxtanna.mc.test.hook;

import com.sxtanna.mc.companies.Companies;
import com.sxtanna.mc.companies.base.State;
import org.bukkit.plugin.Plugin;

public final class CompaniesHook implements State
{

	private static CompaniesHook INSTANCE;


	public static CompaniesHook get(Plugin plugin)
	{
		if (INSTANCE == null)
		{
			INSTANCE = new CompaniesHook(plugin);
		}

		return INSTANCE;
	}



	private final Companies companies;

	private CompaniesHook(final Plugin plugin)
	{
		this.companies = plugin.getServer().getServicesManager().load(Companies.class);
	}


	public boolean ready()
	{
		return this.companies != null;
	}


	@Override
	public void load()
	{

	}

	@Override
	public void kill()
	{

	}

}
