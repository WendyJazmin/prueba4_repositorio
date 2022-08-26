package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
	//este no va a tener 2 dipos de datos

	public T apply(T arg1);
}
