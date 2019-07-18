package com.sxtanna.mc.test.util;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.sxtanna.mc.companies.util.Serial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class SerialTests
{

	private static String OBJECT_DATA;

	@BeforeAll
	static void setUp()
	{
		MockBukkit.mock();
	}


	@Test
	@Order(0)
	void testItemStackToBase64()
	{
		Serial.itemStackToBase64(new ItemStack(Material.OAK_BOAT)).ifPresent(data -> OBJECT_DATA = data);

		//assertThat(OBJECT_DATA).isNotNull();
	}

	@Test
	@Order(1)
	void testBase64ToItemStack()
	{
		//assertThat(Serial.base64ToItemStack(OBJECT_DATA)).contains(new ItemStack(Material.OAK_BOAT));
	}

}
