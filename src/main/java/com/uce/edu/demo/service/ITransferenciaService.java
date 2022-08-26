package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizarTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto);

	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto);
}
