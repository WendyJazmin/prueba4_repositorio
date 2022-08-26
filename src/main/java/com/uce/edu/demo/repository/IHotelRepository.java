package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	//CRUD
	
	public Hotel buscarHotel(Integer id);//
	
	public int actualizarHotel(String nombre, String direccion);//
	
	public int eliminarHotel(String direccion);//

	public void insertarHotel(Hotel hotel);//
	
	
	//CONSULTAS
	
	//TIPOS DE JOIN
	
	//Inner Join (Join Interno), en la setencia where se puede ponder INNER JOIN o solo JOIN
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	
	public List<Hotel> buscarHotelOuterJoinLeft();

	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion);

	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);

	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);

}
