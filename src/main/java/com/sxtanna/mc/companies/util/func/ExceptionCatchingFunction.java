package com.sxtanna.mc.companies.util.func;

@FunctionalInterface
public interface ExceptionCatchingFunction<T, R>
{

	R apply(T t) throws Exception;

}
