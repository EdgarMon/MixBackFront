/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cabin.modelo.Mensaje;
import cabin.modelo.Cabin;
import cabin.interfaces.InterfaceCabin;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Repository
public class RepositorioCabin {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
     @Autowired
    private InterfaceCabin crud;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */

    public List<Cabin> getAll(){
        return (List<Cabin>) crud.findAll();       
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param id
     * @return 
 */
    public Optional <Cabin> getCabin(int id){
        return crud.findById(id);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabin
     * @return 
 */
    public Cabin save(Cabin cabin){
        return crud.save(cabin);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabin
 */
      public void delete(Cabin cabin){
        crud.delete(cabin);
    }
    
    
}
