package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional.TxType;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	private static final Logger logg = Logger.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value =TxType.MANDATORY)//mandatory y required tienen el mismo comportamiento
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		logg.info("Transaccion activa repository: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.persist(transferencia);
		throw new RuntimeException();
	}

}
