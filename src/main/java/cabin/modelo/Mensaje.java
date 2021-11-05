/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Entity
@Table(name = "message")
public class Mensaje implements Serializable {
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
      /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    private String messageText;
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cabin cabin;
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public Integer getIdMessage() {
        return idMessage;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param idMessage
 */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public String getMessageText() {
        return messageText;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param messageText
 */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public Cabin getCabin() {
        return cabin;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param cabin
 */
    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public Cliente getClient() {
        return client;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param client
 */
    public void setClient(Cliente client) {
        this.client = client;
    }
    
    
}
