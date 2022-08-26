package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.support.TransactionSynchronizationManager;


import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional //con esta anotacion en la clase todos los metodos son  por defecto transacciones
			  // de tipo REQUIERED
public class HotelRepositoryImpl implements IHotelRepository {

	private static final Logger logg = Logger.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel buscarHotel(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public int actualizarHotel(String nombre, String direccion) {
		// TODO Auto-generated method stub
		// UPDATE Hotel SET hote_nombre='Hotel Atacames' WHERE hote_direccion='Amanta'
		Query myQueryv4 = this.entityManager
				.createQuery("UPDATE Hotel h SET h.nombre=:datoNombre WHERE h.direccion =:datoDireccion");
		myQueryv4.setParameter("datoNombre", nombre);
		myQueryv4.setParameter("datoDireccion", direccion);
		return myQueryv4.executeUpdate();
	}

	@Override
	public int eliminarHotel(String direccion) {
		// TODO Auto-generated method stub
		// DELETE FROM Hotel WHERE hote_direccion='Shirys'
		Query myQueryV5 = this.entityManager.createQuery("DELETE FROM Hotel h WHERE h.direccion =: direccion");
		myQueryV5.setParameter("direccion", direccion);
		return myQueryV5.executeUpdate();
	}
	

	//tipos de join
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//createQuery("JPQL",Hotel.class);
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("select h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		List<Hotel>hoteles = myQuery.getResultList();
		for(Hotel h : hoteles) {
			h.getHabitaciones().size();
		}
		
		return hoteles;
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("select h FROM Hotel h JOIN h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("select h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("select h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("select h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();	
	}

	//RELACIONAMIENTO   WHERE
	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//	SELECT * FROM hotel ho, habitacion ha where ho.hote_id = ha.habi_id_hotel;
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo = :tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();	
	}

	
	
	//JOIN FETCH
	@Override
	//@Transactional(value=TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//createQuery("JPQL",Hotel.class);
		logg.info("Transaccion activa repository: "+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("select h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
				
		return myQuery.getResultList();	
	}

	
	

	
}
