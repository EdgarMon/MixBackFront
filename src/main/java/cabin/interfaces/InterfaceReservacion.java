/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cabin.interfaces;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import cabin.modelo.Reservacion;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 * se maneja un alias en la parte del Reservacion AS c group by c.client 
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer> {
    
    public List<Reservacion> findAllByStatus (String status);
    
    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    //select clientid, count(*) as "total" from reservacion group by clientid order by total desc; 
    @Query("SELECT c.client, COUNT(c.client) FROM Reservacion AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();
    
}
