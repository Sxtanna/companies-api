package com.sxtanna.mc.companies.lang;

import com.sxtanna.mc.companies.lang.base.LangKey;

import com.sxtanna.mc.companies.util.Helper;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Map;

public final class Lang
{

	private static final Map<LangKey, String> LANG_CACHE = Helper.newMap();


	public static void load(final LangKey key, final String val)
	{
		LANG_CACHE.put(key, val);
	}


	public static void kill()
	{
		LANG_CACHE.clear();
	}

	public static void kill(final LangKey key)
	{
		LANG_CACHE.remove(key);
	}


	public static String make(final LangKey key, final Object... placeholders)
	{
		if (placeholders.length % 2 != 0)
		{
			throw new IllegalArgumentException("Placeholders must all have values: " + Arrays.toString(placeholders));
		}

		String message = Helper.lazyGetOrDefault(LANG_CACHE, key, key::getDefaultValue);

		if (placeholders.length != 0)
		{
			for (int i = 0; i < placeholders.length; i += 2)
			{
				Object k = placeholders[i];
				Object v = placeholders[i + 1];

				if (!(k instanceof String))
				{
					throw new IllegalArgumentException("Placeholder values has an object out of position: " + k.getClass() + "[" + i + "]{" + k + "}");
				}

				message = message.replace("{" + k + "}", v.toString());
			}
		}

		return message;
	}

	public static void send(final CommandSender recipient, final LangKey key, final Object... placeholders)
	{
		recipient.sendMessage(ChatColor.translateAlternateColorCodes('&', make(key, placeholders)));
	}

}
