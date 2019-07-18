package com.sxtanna.mc.companies.data;

import com.sxtanna.mc.companies.base.Named;
import com.sxtanna.mc.companies.base.RequiresPlugin;
import com.sxtanna.mc.companies.base.State;
import com.sxtanna.mc.companies.base.Unique;
import com.sxtanna.mc.companies.data.base.DatabaseType;

public interface Database extends Named, State, Unique<DatabaseType>, RequiresPlugin
{

	default void databaseNotReady(String attempted, String reason)
	{
		throw new IllegalStateException("Database[" + getName() +"] attempted Function["+ attempted +"], but was not ready: " + reason);
	}

}
