/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cabin.modelo.Mensaje;
import cabin.repositorio.RepositorioMensaje;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Service
public class ServiciosMensaje {
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
        @Autowired
    private RepositorioMensaje metodosCrud;
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param messageId
     * @return 
 */
    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param message
     * @return 
 */
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> evt= metodosCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param message
     * @return 
 */
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param messageId
     * @return 
 */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
