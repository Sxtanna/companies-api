package com.sxtanna.mc.companies.data.core;

import com.sxtanna.mc.companies.core.Staffer;
import com.sxtanna.mc.companies.data.Database;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

public interface StafferDatabase extends Database
{

	void saveStaffer(Staffer data);

	void loadStaffer(UUID uuid, Consumer<Optional<Staffer>> consumer);


	void bulkSaveStaffers(Collection<Staffer> data);

	void bulkLoadStaffers(Collection<UUID> uuids, Consumer<Map<UUID, Optional<Staffer>>> consumer);

}
