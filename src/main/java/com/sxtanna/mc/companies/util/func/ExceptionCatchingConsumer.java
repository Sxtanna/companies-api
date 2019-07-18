package com.sxtanna.mc.companies.util.func;

@FunctionalInterface
public interface ExceptionCatchingConsumer<T>
{

	void accept(T data) throws Exception;

}
