package com.sxtanna.mc.companies.base;

import com.sxtanna.mc.companies.util.Helper;
import com.sxtanna.mc.companies.util.func.ExceptionCatchingConsumer;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public interface RequiresPlugin
{

	Plugin getPlugin();


	default Logger getLogger()
	{
		return getPlugin().getLogger();
	}

	default Server getServer()
	{
		return getPlugin().getServer();
	}

	default Collection<Player> getOnlinePlayers()
	{
		//noinspection unchecked
		return ((Collection<Player>) getServer().getOnlinePlayers());
	}


	default Optional<Player> getPlayer(final UUID uuid)
	{
		return Optional.ofNullable(getServer().getPlayer(uuid));
	}



	default BukkitTask task(ExceptionCatchingConsumer<BukkitRunnable> runnable)
	{
		return new BukkitRunnable()
		{

			@Override
			public void run()
			{
				Helper.ignoreException(() -> runnable.accept(this));
			}

		}.runTask(getPlugin());
	}

	default BukkitTask taskAsync(ExceptionCatchingConsumer<BukkitRunnable> runnable)
	{
		return new BukkitRunnable()
		{

			@Override
			public void run()
			{
				Helper.ignoreException(() -> runnable.accept(this));
			}

		}.runTaskAsynchronously(getPlugin());
	}


	default BukkitTask later(long delay, ExceptionCatchingConsumer<BukkitRunnable> runnable)
	{
		return new BukkitRunnable()
		{

			@Override
			public void run()
			{
				Helper.ignoreException(() -> runnable.accept(this));
			}

		}.runTaskLater(getPlugin(), delay);
	}

	default BukkitTask laterAsync(long delay, ExceptionCatchingConsumer<BukkitRunnable> runnable)
	{
		return new BukkitRunnable()
		{

			@Override
			public void run()
			{
				Helper.ignoreException(() -> runnable.accept(this));
			}

		}.runTaskLaterAsynchronously(getPlugin(), delay);
	}


	default BukkitTask timer(long delay, long period, ExceptionCatchingConsumer<BukkitRunnable> runnable)
	{
		return new BukkitRunnable()
		{

			@Override
			public void run()
			{
				Helper.ignoreException(() -> runnable.accept(this));
			}

		}.runTaskTimer(getPlugin(), delay, period);
	}

	default BukkitTask timerAsync(long delay, long period, ExceptionCatchingConsumer<BukkitRunnable> runnable)
	{
		return new BukkitRunnable()
		{

			@Override
			public void run()
			{
				Helper.ignoreException(() -> runnable.accept(this));
			}

		}.runTaskTimerAsynchronously(getPlugin(), delay, period);
	}

}
