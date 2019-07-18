package com.sxtanna.mc.companies.util;

import com.sxtanna.mc.companies.util.func.ExceptionCatchingConsumer;
import com.sxtanna.mc.companies.util.func.ExceptionCatchingRunnable;
import com.sxtanna.mc.companies.util.func.ExceptionCatchingSupplier;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Helper
{

	private Helper()
	{
	}


	public static void ignoreException(ExceptionCatchingRunnable runnable)
	{
		try
		{
			runnable.run();
		}
		catch (Exception ignored)
		{
		}
	}

	public static <T> Optional<T> ignoreException(ExceptionCatchingSupplier<T> function)
	{
		T data = null;

		try
		{
			data = function.get();
		}
		catch (Exception ignored)
		{
		}

		return Optional.ofNullable(data);
	}


	public static <T, R> List<R> map(Collection<T> collection, Function<T, R> function)
	{
		return collection.stream().map(function).collect(Collectors.toList());
	}


	public static <T> Set<T> newSet()
	{
		return new HashSet<>();
	}

	public static <T> List<T> newList()
	{
		return new ArrayList<>();
	}

	public static <K, V> Map<K, V> newMap()
	{
		return new HashMap<>();
	}


	public static <T> T apply(T data, Consumer<T> consumer)
	{
		ignoreException(() -> consumer.accept(data));
		return data;
	}

	public static File ensureExists(File file)
	{
		Helper.ignoreException(file.getParentFile()::mkdirs);
		Helper.ignoreException(file::createNewFile);

		return file;
	}


	public static int toInt(String data, int fallback)
	{
		return ignoreException(() -> Integer.parseInt(data)).orElse(fallback);
	}

}
