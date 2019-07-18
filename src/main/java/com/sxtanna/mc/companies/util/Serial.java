package com.sxtanna.mc.companies.util;

import com.sxtanna.mc.companies.util.func.ExceptionCatchingFunction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Optional;

public final class Serial
{

	private Serial() {}


	// base
	private static <T> Optional<String> objectToBase64(T data, ExceptionCatchingFunction<OutputStream, ObjectOutputStream> streamFunction)
	{
		try (ByteArrayOutputStream stream = new ByteArrayOutputStream(); ObjectOutputStream output = streamFunction.apply(stream))
		{
			// write
			output.writeObject(data);

			// encode
			return Optional.of(Base64.getEncoder().encodeToString(stream.toByteArray()));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return Optional.empty();
	}

	private static <T> Optional<T> base64ToObject(String text, ExceptionCatchingFunction<InputStream, ObjectInputStream> streamFunction)
	{

		try (ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(text)); ObjectInputStream input = streamFunction.apply(stream))
		{
			//noinspection unchecked
			return Optional.ofNullable(((T) input.readObject()));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return Optional.empty();
	}


	// bukkit
	public static Optional<String> itemStackToBase64(ItemStack data)
	{
		return objectToBase64(data, BukkitObjectOutputStream::new);
	}

	public static Optional<ItemStack> base64ToItemStack(String text)
	{
		return base64ToObject(text, BukkitObjectInputStream::new);
	}

}
