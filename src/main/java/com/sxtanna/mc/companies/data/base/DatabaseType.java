package com.sxtanna.mc.companies.data.base;

import java.util.Optional;

public enum DatabaseType
{

	FOLDER,

	REMOTE_MYSQL,
	//REMOTE_REDIS,

	MAPPED;


	public static Optional<DatabaseType> byName(String name)
	{
		for (final DatabaseType type : values())
		{
			if (name.equalsIgnoreCase(type.name()))
			{
				return Optional.of(type);
			}
		}

		return Optional.empty();
	}

}
