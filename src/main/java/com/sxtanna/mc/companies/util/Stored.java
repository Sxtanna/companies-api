package com.sxtanna.mc.companies.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sxtanna.mc.companies.base.Loads;
import com.sxtanna.mc.companies.base.Named;
import com.sxtanna.mc.companies.base.Unique;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class Stored<T extends Unique<I>, I> implements Loads
{

	private final File root;
	private final Type type;

	private final Class<? extends T> clazz;


	public Stored(final File root, final Type type, final Class<? extends T> clazz)
	{
		this.root = root;
		this.type = type;

		this.clazz = clazz;
	}


	@Override
	public void load()
	{
		if (!this.root.exists() && !this.root.mkdirs())
		{
			throw new IllegalStateException("Unable to create " + getType() + " Stored folder.");
		}
	}


	public File getRoot()
	{
		return root;
	}

	public Type getType()
	{
		return type;
	}


	public Stream<File> walkFileTree(int maxDepth)
	{
		return walkFileTree(maxDepth, file -> true);
	}

	public Stream<File> walkFileTree(int maxDepth, Predicate<File> filter)
	{
		return Helper.ignoreException(() -> Files.walk(getRoot().toPath(), maxDepth)).orElse(Stream.empty()).map(Path::toFile).filter(filter);
	}


	public void save(T data)
	{
		final File file = getFileFor(data.getUUID(), true);

		type.save(file, data);
	}

	public void load(I uuid, Consumer<Optional<T>> consumer)
	{
		final File file = getFileFor(uuid, false);

		if (file.exists())
		{
			type.load(file, clazz, consumer);
		} else
		{
			consumer.accept(Optional.empty());
		}
	}


	private File getFileFor(I uuid, boolean create)
	{
		final File file = new File(root, uuid + "." + type.getExtension());

		if (create)
		{
			Helper.ignoreException(file::createNewFile);
		}

		return file;
	}


	public static final Type JSON = new Type.JSON();


	public abstract static class Type implements Named
	{

		private final String name;
		private final String extension;


		Type(final String name, final String extension)
		{
			this.name = name;
			this.extension = extension;
		}


		@Override
		public String getName()
		{
			return name;
		}

		public String getExtension()
		{
			return extension;
		}


		abstract <T> void save(File file, T data);

		abstract <T> void load(File file, Class<? extends T> clazz, Consumer<Optional<T>> consumer);


		static final class JSON extends Type
		{

			private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().enableComplexMapKeySerialization().serializeSpecialFloatingPointValues().setPrettyPrinting().create();


			JSON()
			{
				super("Json", "json");
			}


			@Override
			<T> void save(final File file, final T data)
			{
				try(FileWriter writer = new FileWriter(file))
				{
					GSON.toJson(data, writer);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}

			@Override
			<T> void load(final File file, final Class<? extends T> clazz, final Consumer<Optional<T>> consumer)
			{
				try(FileReader reader = new FileReader(file))
				{
					consumer.accept(Optional.ofNullable(GSON.fromJson(reader, clazz)));
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
					consumer.accept(Optional.empty());
				}
			}

		}

	}

}
