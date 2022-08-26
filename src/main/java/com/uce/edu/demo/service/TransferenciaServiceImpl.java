package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW)//si no hay una transaccion, la crea
	public void realizarTransferencia(String numeroctaOrigen, String numeroctaDestino, BigDecimal monto) {//begin
		// TODO Auto-generated method stub
		//1. Restar el monto a la cta origen
		//2. Sumar el monto a la cta destino
		//3. Insertar transferencia
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(numeroctaOrigen);
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		
		ctaOrigen.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
	
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroctaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);
	
		//3. Insertar Transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepository.insertar(trans);
		
		if(monto.compareTo(saldoOrigen)>0) {// el monto es mayor al saldo de que tiene la cuenta, se hace la excepcion
											//RuntimeException por lo que se hace un rollback
											// nunca se hace un commit y por lo tanto no se realiza la transferencia
			throw new RuntimeException();//unchecked
		}
		
		
	}//commit
	

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

}
