package com.uce.edu.demo.service.funcional;

//caracteristica de una interface funcional,
//esta anotacion no es obligatoria
@FunctionalInterface
public interface IPersona {

	//una interface funcional solo tiene o expresa una unica funcion
	public String comer();
}
