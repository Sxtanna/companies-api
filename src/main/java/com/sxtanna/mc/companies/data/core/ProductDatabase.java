package com.sxtanna.mc.companies.data.core;

import com.sxtanna.mc.companies.core.Product;
import com.sxtanna.mc.companies.data.Database;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

public interface ProductDatabase extends Database
{

	void saveProduct(Product data);

	void loadProduct(UUID uuid, Consumer<Optional<Product>> consumer);

}
