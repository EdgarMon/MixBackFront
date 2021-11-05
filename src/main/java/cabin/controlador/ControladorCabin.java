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
import cabin.modelo.Cabin;
import cabin.servicios.ServiciosCabin;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCabin {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }

    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @Autowired
    private ServiciosCabin servicio;
    @GetMapping("all")
    public List <Cabin> getCabin(){
        return servicio.getAll();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param idCabin
     * @return 
 */
    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int idCabin) {
        return servicio.getCabin(idCabin);
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabin
     * @return 
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return servicio.save(cabin);
    }/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */

    /**
     *
     * @author Edgar Ernesto M.
 por buenas practicas se deja comentado el documento
     * @param cabin
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return servicio.update(cabin);
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabinId
     * @return 
 */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cabinId) {
        return servicio.deleteCabin(cabinId);
    }
    
}
