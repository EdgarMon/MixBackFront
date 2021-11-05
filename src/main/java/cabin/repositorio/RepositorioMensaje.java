/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cabin.interfaces.InterfaceMensaje;
import cabin.modelo.Mensaje;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Repository
public class RepositorioMensaje {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @Autowired
    private InterfaceMensaje crud3;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud3.findAll();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param id
     * @return 
 */
    public Optional<Mensaje> getMessage(int id){
        return crud3.findById(id);
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param message
     * @return 
 */
    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param mensaje
 */
     public void delete(Mensaje mensaje){
        crud3.delete(mensaje);
    }
}
