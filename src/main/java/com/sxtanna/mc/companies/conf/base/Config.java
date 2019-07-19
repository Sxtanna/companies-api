package com.sxtanna.mc.companies.conf.base;

import com.sxtanna.mc.companies.base.Loads;
import com.sxtanna.mc.companies.base.Named;
import com.sxtanna.mc.companies.base.RequiresPlugin;
import com.sxtanna.mc.companies.base.Saves;
import org.bukkit.configuration.Configuration;

import java.io.File;
import java.util.Optional;

public interface Config extends Named, Loads, Saves, RequiresPlugin
{

	File getFile();


	default Optional<String> getValueAtPath(final Configuration config, final String path)
	{
		return Optional.ofNullable(config).map(conf -> conf.getString(path));
	}

}
