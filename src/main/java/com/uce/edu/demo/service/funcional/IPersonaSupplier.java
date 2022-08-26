package com.uce.edu.demo.service.funcional;


@FunctionalInterface
public interface IPersonaSupplier<T> {

	public T getNombre();//En la nomenclatura ,
	//el nombre de la funcion se inicia con el prefijo get y despues se puede seguir con el nombre
}
