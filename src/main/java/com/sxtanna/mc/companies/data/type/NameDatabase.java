package com.sxtanna.mc.companies.data.type;

import com.sxtanna.mc.companies.data.Database;

import java.util.Optional;
import java.util.UUID;

public interface NameDatabase extends Database
{

	void saveName(UUID uuid, String name);

	Optional<String> loadName(UUID uuid);

}
