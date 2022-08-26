package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.Prueba4Application;

public class MainInterfacesFuncionales {
	
	private static Logger logg = Logger.getLogger( MainInterfacesFuncionales.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//METODOS HIGH ORDER
		ConsumoMetodsHighOrder metodos = new ConsumoMetodsHighOrder();
		
		
		//SUPPLIER
		//clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		logg.info("Supplier clase: "+supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		logg.info("Supplier clase: "+supplierTE.getNombre());
		
		//lambdas
		IPersonaSupplier<String> supplierLambda =() ->"Edison2";
		logg.info("Supplier lambda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE =() ->"Daniel TE";
		logg.info("Supplier lambda: "+supplierLambdaTE.getNombre());
		
		//Metodos high order
		String valorHO = metodos.consumirSupplier(() ->"Metodo High Order en Supplier");
		logg.info(valorHO);
		
		
		
		//CONSUMER
		//clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		//lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//metodos high order
		metodos.consumirConsumer(valor -> System.out.println(valor), 2);
		
		
		
		//PREDICATE
		//clases
		//lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.length()>0;
		logg.info("Predicate Lambda: "+predicateLambda.evaluar("Jeff"));
		
		//Metodos high order
		boolean respuesta = metodos.consumirPredicate(cadena -> cadena.length()>0, "Prince");
		logg.info("High Order predicate: "+respuesta);
		
		
		//FUNCTION
		logg.info("\nFUNCTION");
		//clases
		//lambdas
						//devuelve, recibe
		String nombre = "Jeff";
		IPersonaFunction<Integer,String> functionLambda = cadena -> cadena.length();
		logg.info("Function Lambda: el nombre "+nombre+" tiene una longitud de "+functionLambda.aplicar(nombre));
		
		
		//Metodos High Order
		String valorFinal= metodos.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno;
		}, 1);
		logg.info("High Order Function: "+valorFinal);
		
		
		//UNARY OPERATOR (subdivisión de function)
		logg.info("\nUnary Operator");
		//clases
		//lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena -> nombre+" "+cadena;
		logg.info("Unary Operator lambda: "+unaryLambda.apply("Satur"));
	
		
		//METODOS HIGH ORDER
		logg.info("\n");
		
		
		
	}

}
