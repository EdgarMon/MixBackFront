/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cabin.modelo.Cabin;
import cabin.repositorio.RepositorioCabin;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Service
public class ServiciosCabin {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
     @Autowired
    private RepositorioCabin metodosCrud;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Cabin> getAll(){
        return metodosCrud.getAll();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param idCabin
     * @return 
 */
    public Optional<Cabin> getCabin(int idCabin){
        return metodosCrud.getCabin(idCabin);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabin
     * @return 
 */
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return metodosCrud.save(cabin);
        }else{
            Optional<Cabin> evt=metodosCrud.getCabin(cabin.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cabin);
            }else{
                return cabin;
            }
        }
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabin
     * @return 
 */
    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e=metodosCrud.getCabin(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabinId
     * @return 
 */
    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
