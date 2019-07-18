package com.sxtanna.mc.companies.util.func;

@FunctionalInterface
public interface ExceptionCatchingSupplier<T>
{

	T get() throws Exception;

}
