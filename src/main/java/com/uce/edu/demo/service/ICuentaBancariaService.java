package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria buscarPorNumero(String numeroCta);


}
