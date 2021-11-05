/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import cabin.modelo.Reservacion;
import cabin.reportes.ContadorClientes;
import cabin.reportes.StatusReservas;
import cabin.servicios.ServiciosReservacion;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorReservacion {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
     @Autowired
    private ServiciosReservacion servicio;
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 *Mapping es para poder seleccionar un deto especifico
     * @return 
 */
    @GetMapping("/all")
    public List<Reservacion> getReservations(){
        return servicio.getAll();
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param reservationId
     * @return 
 */
    @GetMapping("/{id}")
    public Optional<Reservacion> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */

    /**
     *
     * @author Edgar Ernesto M.
 por buenas practicas se deja comentado el documento
     * @param reservation
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservation) {
        return servicio.save(reservation);
    }/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */

    /**
     *
     * @author Edgar Ernesto M.
 por buenas practicas se deja comentado el documento
     * @param reservacion
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservacion) {
        return servicio.update(reservacion);
    }/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */

    /**
     *
     * @author Edgar Ernesto M.
 por buenas practicas se deja comentado el documento
     * @param reservationId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    @GetMapping("/report-status")
    public StatusReservas getReservationsStatusReport(){
        return servicio.getReservationsStatusReport();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 * reportes de datos de las fechas de reservas
     * @param dateOne
     * @param dateTwo
     * @return 
 */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
    return servicio.getReservationPeriod(dateOne, dateTwo);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    @GetMapping("/report-clients")
    public List<ContadorClientes> getReservationsReportsClient(){
        return servicio.getTopClients();
    }
}
