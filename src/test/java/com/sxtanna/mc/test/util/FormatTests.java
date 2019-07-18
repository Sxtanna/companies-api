package com.sxtanna.mc.test.util;

import com.sxtanna.mc.companies.util.Format;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

final class FormatTests
{

	@Test
	void testFormatBasicFunction()
	{
		final String format = Format.function("User", new String[]{"name"}, new Object[]{"Sxtanna"});

		assertThat(format)
				.isEqualTo("User[name: Sxtanna]");
	}


	@Test
	void testFormatInterFunction()
	{
		final String format = Format.function("User", "name", "Sxtanna");

		assertThat(format)
				.isEqualTo("User[name: Sxtanna]");
	}

	@Test
	void testFormatInterFunctionIncorrect()
	{
		assertThatThrownBy(() -> Format.function("User", "name", "Sxtanna", "size"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageStartingWith("ParamsAndValues must have a value for every parameter: ");
	}

}
