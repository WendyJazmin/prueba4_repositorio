package com.uce.edu.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.HotelRepositoryImpl;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	private static final Logger logg = Logger.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private IHotelRepository iHotelRepository;
	

	@Override
	public void insertarHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHotelRepository.insertarHotel(hotel);
	}

	@Override
	public Hotel buscarHotel(Integer id) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotel(id);
	}

	@Override
	public int actualizarHotel(String nombre, String direccion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.actualizarHotel(nombre, direccion);
	}

	@Override
	public int eliminarHotel(String direccion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.eliminarHotel(direccion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinRigth(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		logg.info("Transaccion activa service: "+TransactionSynchronizationManager.isActualTransactionActive());

		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}






	

}
