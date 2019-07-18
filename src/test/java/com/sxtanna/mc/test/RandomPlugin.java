package com.sxtanna.mc.test;

import org.bukkit.plugin.java.JavaPlugin;

public final class RandomPlugin extends JavaPlugin
{


	@Override
	public void onEnable()
	{
		if (!getServer().getPluginManager().isPluginEnabled("Companies"))
		{
			getLogger().severe("Companies not found!");
			getServer().getPluginManager().disablePlugin(this);

			return;
		}

		com.sxtanna.mc.test.hook.CompaniesHook.get(this).load();
	}

	@Override
	public void onDisable()
	{
		com.sxtanna.mc.test.hook.CompaniesHook.get(this).kill();
	}

}
