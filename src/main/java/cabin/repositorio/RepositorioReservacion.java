/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cabin.interfaces.InterfaceReservacion;
import cabin.modelo.Cliente;
import cabin.modelo.Reservacion;
import cabin.reportes.ContadorClientes;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Repository
public class RepositorioReservacion {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
     @Autowired
    private InterfaceReservacion crud4;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param id
     * @return 
 */
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param reservacion
     * @return 
 */
    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param reservacion
 */
     public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 * 
     * @param status
     * @return 
 */
    public List<Reservacion> getReservationByStatus(String status){
        return crud4.findAllByStatus(status);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param a
     * @param b
     * @return 
 */
   public List<Reservacion> getReservationPeriod(Date a, Date b){
       return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
   } 
   /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 * acá se contaran los clientes por medio de una lista
     * @return 
 */
   public List<ContadorClientes> getTopClients(){
       List<ContadorClientes> res= new ArrayList<>();
       List<Object[]> report = crud4.countTotalReservationByClient();
       for(int i=0;i<report.size();i++){
           res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
       }
       return res;
   }
}
