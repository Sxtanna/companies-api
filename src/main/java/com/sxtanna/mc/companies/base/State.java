package com.sxtanna.mc.companies.base;

import java.util.function.Consumer;

public interface State extends Loads, Kills
{

	static void attemptLoad(State state)
	{
		if (state == null)
		{
			return;
		}

		state.load();
	}

	static void attemptKill(State state)
	{
		if (state == null)
		{
			return;
		}

		state.kill();
	}


	static void attemptLoad(State state, Consumer<Exception> consumer)
	{
		try
		{
			attemptLoad(state);
		}
		catch (Exception ex)
		{
			consumer.accept(ex);
		}
	}

	static void attemptKill(State state, Consumer<Exception> consumer)
	{
		try
		{
			attemptKill(state);
		}
		catch (Exception ex)
		{
			consumer.accept(ex);
		}
	}

}
