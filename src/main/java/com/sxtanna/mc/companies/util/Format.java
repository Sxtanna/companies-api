package com.sxtanna.mc.companies.util;

import java.util.Arrays;

public final class Format
{

	private Format(){}


	public static String function(String name, String[] params, Object[] values)
	{
		StringBuilder builder = new StringBuilder(name);

		builder.append('[');

		for (int i = 0; i < params.length; i++)
		{
			String param = params[i];
			Object value = i < values.length ? values[i] : "null";

			builder.append(param);
			builder.append(':');
			builder.append(' ');
			builder.append(value);

			if (i < params.length - 1)
			{
				builder.append(',');
				builder.append(' ');
			}
		}

		builder.append(']');

		return builder.toString();
	}

	public static String function(String name, Object... paramsAndValues)
	{
		if (paramsAndValues.length == 0)
		{
			return function(name, EMPTY_PARAMS, EMPTY_VALUES);
		}

		if (paramsAndValues.length % 2 != 0)
		{
			throw new IllegalArgumentException("ParamsAndValues must have a value for every parameter: " + Arrays.toString(paramsAndValues));
		}

		int length = paramsAndValues.length / 2;

		String[] params = new String[length];
		Object[] values = new Object[length];


		int index = 0;

		for (int i = 0; i < length; i += 2)
		{
			Object param = paramsAndValues[i];
			Object value = paramsAndValues[i + 1];


			if (!(param instanceof String))
			{
				throw new IllegalArgumentException("Object in param position is not a string: " + param);
			}


			params[index] = ((String) param);
			values[index] = value;


			index++;
		}

		return function(name, params, values);
	}

	public static String removeSuffix(String original, String suffix)
	{
		return !original.endsWith(suffix) ? original : original.substring(0, original.length() - suffix.length());
	}


	private static final String[] EMPTY_PARAMS = new String[]{};
	private static final Object[] EMPTY_VALUES = new Object[]{};

}
