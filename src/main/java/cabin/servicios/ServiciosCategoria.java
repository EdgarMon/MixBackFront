/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cabin.modelo.Categoria;
import cabin.repositorio.RepositorioCategoria;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */

@Service
public class ServiciosCategoria {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @Autowired
    private RepositorioCategoria metodosCrud;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param idCategoria
     * @return 
 */
    public Optional<Categoria> getCategoria(int idCategoria){
        return metodosCrud.getCategoria(idCategoria);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param categoria
     * @return 
 */
    public Categoria save(Categoria categoria){
        if(categoria.getId()==null){
            return metodosCrud.save(categoria);
        }else{
            Optional<Categoria> evt=metodosCrud.getCategoria(categoria.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param categoria
     * @return 
 */
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param categoriaId
     * @return 
 */
    public boolean deleteCategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
