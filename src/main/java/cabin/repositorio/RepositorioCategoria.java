/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cabin.interfaces.InterfaceCategoria;
import cabin.modelo.Categoria;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Repository
public class RepositorioCategoria {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @Autowired
    private InterfaceCategoria crud2;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
     public List<Categoria> getAll(){
        return (List<Categoria>) crud2.findAll();       
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param id
     * @return 
 */
    public Optional <Categoria> getCategoria(int id){
        return crud2.findById(id);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param categoria
     * @return 
 */
    public Categoria save(Categoria categoria){
        return crud2.save(categoria);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param categoria
 */
     public void delete(Categoria categoria){
        crud2.delete(categoria);
    }
}
