package com.sxtanna.mc.companies.lang;

import com.sxtanna.mc.companies.lang.base.LangKey;
import com.sxtanna.mc.companies.util.Helper;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public final class Lang
{

	private static final Map<LangKey, String> LANG_CACHE = Helper.newMap();


	public static void init(final LangKey key, final String val)
	{
		LANG_CACHE.put(key, val);
	}

	public static void send(final CommandSender recipient, final LangKey key)
	{
		recipient.sendMessage(ChatColor.translateAlternateColorCodes('&', Helper.lazyGetOrDefault(LANG_CACHE, key, key::getDefaultValue)));
	}

}
