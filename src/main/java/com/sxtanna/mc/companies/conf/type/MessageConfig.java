package com.sxtanna.mc.companies.conf.type;

import com.sxtanna.mc.companies.conf.base.Config;
import com.sxtanna.mc.companies.lang.base.LangKey;

import java.util.Optional;

public interface MessageConfig extends Config
{

	Optional<String> getCustomLangValue(final LangKey key);

}
