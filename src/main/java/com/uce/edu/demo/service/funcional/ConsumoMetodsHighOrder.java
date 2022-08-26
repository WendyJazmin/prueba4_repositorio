package com.uce.edu.demo.service.funcional;

public class ConsumoMetodsHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		//String valor = funcion.getNombre();
		
		return funcion.getNombre();
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
		
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
		
	}
	
	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}
}
