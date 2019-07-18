package com.sxtanna.mc.companies.conf.type;

import com.sxtanna.mc.companies.conf.base.Config;
import com.sxtanna.mc.companies.data.DatabaseType;
import org.bukkit.Material;

public interface CompanyConfig extends Config
{

	Material getDefaultCompanyIcon();


	DatabaseType getCompanyDatabaseType();

	DatabaseType getProductDatabaseType();

	DatabaseType getStafferDatabaseType();

}
