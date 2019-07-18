package com.sxtanna.mc.companies.data.base;

import com.sxtanna.mc.companies.base.RequiresPlugin;
import com.sxtanna.mc.companies.base.State;
import com.sxtanna.mc.companies.util.func.ExceptionCatchingConsumer;

import java.util.Optional;
import java.util.logging.Level;

public interface DatabaseProvider<T extends AutoCloseable> extends State, RequiresPlugin
{

	Optional<T> getConnection();

	boolean autoCloseResource();


	default void useConnection(ExceptionCatchingConsumer<T> consumer)
	{
		try
		{
			final T connection = getConnection().orElseThrow(() -> new IllegalStateException("Connection unavailable"));
			consumer.accept(connection);

			if (autoCloseResource())
			{
				connection.close();
			}
		}
		catch (Exception ex)
		{
			getLogger().log(Level.SEVERE, "failed to use connection", ex);
		}
	}

}
