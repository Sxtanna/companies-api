package com.sxtanna.mc.companies.data.base;

import com.sxtanna.mc.companies.util.func.ExceptionCatchingConsumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface MySQLProvider extends DatabaseProvider<Connection>
{

	@Override
	default boolean autoCloseResource() {
		return true;
	}


	default void push(String statementString, ExceptionCatchingConsumer<PreparedStatement> prepare)
	{
		useConnection(connection ->
					  {
						  try (final PreparedStatement statement = connection.prepareStatement(statementString))
						  {
							  prepare.accept(statement);
							  statement.execute();
						  }
					  });
	}


	default void pull(String statementString, ExceptionCatchingConsumer<PreparedStatement> prepare, ExceptionCatchingConsumer<ResultSet> consume)
	{
		useConnection(connection ->
					  {
						  try (final PreparedStatement statement = connection.prepareStatement(statementString))
						  {
							  prepare.accept(statement);

							  try (final ResultSet resultSet = statement.executeQuery())
							  {
								  consume.accept(resultSet);
							  }
						  }
					  });
	}

}
