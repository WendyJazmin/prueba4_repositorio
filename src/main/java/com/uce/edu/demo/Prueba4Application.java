package com.uce.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;



@SpringBootApplication
public class Prueba4Application implements CommandLineRunner{

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private ITransferenciaService iTransferenciService;
	private static Logger logg = Logger.getLogger( Prueba4Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//INNER JOIN
		List<Hotel> hotel1 = this.iHotelService.buscarHotelInnerJoin("individual");
		
		for(Hotel h: hotel1) {
			logg.info("HOTEL INNER: "+h.getNombre()+", Dirección: "+h.getDireccion());
			
		}
		
		logg.info("");
		List<Hotel> hotel4 = this.iHotelService.buscarHotelInnerJoin();//salen 2 hotels
	
		for(Hotel h: hotel4) {
			logg.info("HOTEL INNER: "+h.getNombre()+", Dirección: "+h.getDireccion());
			
		}
		
		//LEFTH JOIN
		logg.info("\n");
		List<Hotel> hotel2 = this.iHotelService.buscarHotelOuterJoinLeft("individual");
		
		for(Hotel h: hotel2) {
			logg.info("HOTEL LEFT JOIN: "+h.getNombre()+", Dirección: "+h.getDireccion());
			
		}
		
		logg.info("\n");
		List<Hotel> hotel5 = this.iHotelService.buscarHotelOuterJoinLeft();
		
		for(Hotel h: hotel5) {
			logg.info("4HOTEL LEFT JOIN: "+h.getNombre()+", Dirección: "+h.getDireccion());
			
		}
		
		//RIGHT JOIN
		logg.info("\nRIGHT JOIN");
				List<Hotel> hotel3 = this.iHotelService.buscarHotelOuterJoinRigth("individual");
				
				for(Hotel h: hotel3) {
					logg.info("HOTEL RIGHT JOIN: "+h.getNombre()+", Dirección: "+h.getDireccion());
					
				}
		
				
		//RELACIONAMIENTO WHERE
				logg.info("\nJOIN WHERE");
				List<Hotel> hotel6 = this.iHotelService.buscarHotelJoinWhere("familiar");
				
				for(Hotel h: hotel6) {
					logg.info("HOTEL join WHERE: "+h.getNombre()+", Dirección: "+h.getDireccion());
					
				}
		
				
				
				logg.info("\nINNER JOIN EAGER/LAZY");
				List<Hotel> hotel7 = this.iHotelService.buscarHotelInnerJoin("individual");
				
				for(Hotel h: hotel7) {
					logg.info("HOTEL INNER, LAZY: "+h.getNombre()+", Dirección: "+h.getDireccion());
					for(Habitacion ha: h.getHabitaciones()) {
						logg.info(ha);
					}
					
				}	
				
				
				//JOIN FETCH
				logg.info("\nJOIN FETCH");
				List<Hotel> hotel8 = this.iHotelService.buscarHotelJoinFetch("individual");
				
				for(Hotel h: hotel8) {
					logg.info("HOTEL JOIN FETCH: "+h.getNombre()+", Dirección: "+h.getDireccion());
					for(Habitacion ha: h.getHabitaciones()) {
						logg.info(ha);
					}
					
				}	
				
				logg.info("\n");
				
				//this.iTransferenciService.realizarTransferencia("123456", "12345678", new BigDecimal(20));//cuenta origen. cuenta destino
	
				this.iTransferenciService.realizarTransferenciaFachada("123456", "12345678", new BigDecimal(20));
	}
		
	

}
