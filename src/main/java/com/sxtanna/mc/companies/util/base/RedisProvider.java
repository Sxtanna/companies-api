/*
package com.sxtanna.mc.companies.util.base;

import redis.clients.jedis.Jedis;

import java.util.Optional;
import java.util.function.Consumer;

public interface RedisProvider extends DatabaseProvider<Jedis>
{

	@Override
	default boolean autoCloseResource()
	{
		return true;
	}


	default void get(Object k, Consumer<Optional<String>> consumer)
	{
		useConnection(connection ->
					  {
					  	consumer.accept(Optional.ofNullable(connection.get(k.toString())));
					  });
	}

	default void set(Object k, Object v)
	{
		useConnection(connection ->
					  {
						  if (v == null)
						  {
							  connection.del(k.toString());
						  }
						  else
						  {
							  connection.set(k.toString(), v.toString());
						  }
					  });
	}

}
*/
