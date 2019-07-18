package com.sxtanna.mc.companies.util;

import com.sxtanna.mc.companies.Companies;
import com.sxtanna.mc.companies.data.base.MySQLProvider;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

public final class SQLite implements MySQLProvider
{

	private final File localFile;
	private final Companies companies;

	private final AtomicReference<Connection> connection = new AtomicReference<>();


	public SQLite(final Companies companies, final String name)
	{
		this.companies = companies;
		this.localFile = new File(companies.getPlugin().getDataFolder(), name + ".db");
	}


	@Override
	public void load()
	{
		if (!this.localFile.exists() && Helper.ignoreException(() -> !this.localFile.createNewFile()).orElse(false))
		{
			throw new IllegalStateException("Unable to create " + localFile + " SQLite file.");
		}

		try
		{
			Class.forName("org.sqlite.JDBC");
			connection.set(DriverManager.getConnection("jdbc:sqlite:" + localFile));
		}
		catch (SQLException ex)
		{
			companies.getPlugin().getLogger().log(Level.SEVERE, "failed to load sqlite connection", ex);
		}
		catch (ClassNotFoundException ex)
		{
			companies.getPlugin().getLogger().log(Level.SEVERE, "failed to load sqlite sqlite implementation", ex);
		}
	}

	@Override
	public void kill()
	{
		Helper.ignoreException(() -> connection.get().close());
	}


	@Override
	public Plugin getPlugin()
	{
		return companies.getPlugin();
	}


	@Override
	public boolean autoCloseResource()
	{
		return false;
	}

	@Override
	public Optional<Connection> getConnection()
	{
		return Optional.ofNullable(connection.get());
	}

}
