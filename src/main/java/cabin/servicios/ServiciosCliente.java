/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cabin.modelo.Cliente;
import cabin.repositorio.RepositorioCliente;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Service
public class ServiciosCliente {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
        @Autowired
    private RepositorioCliente metodosCrud;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param clientId
     * @return 
 */
    public Optional<Cliente> getCliente(int clientId){
        return metodosCrud.getCliente(clientId);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param client
     * @return 
 */
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> evt=metodosCrud.getCliente(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param client
     * @return 
 */
     public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param clientId
     * @return 
 */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getCliente(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
