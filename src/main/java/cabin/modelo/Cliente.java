/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabin.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@Entity
@Table(name ="client")
public class Cliente implements Serializable{
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    private String email;
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    private String password;
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    private String name;
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    private Integer age;
     /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties({"client","messages"})
    public List<Mensaje>messages;
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservacion>reservations; 
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public Integer getIdClient() {
        return idClient;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param idClient
 */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public String getEmail() {
        return email;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param email
 */
    public void setEmail(String email) {
        this.email = email;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public String getPassword() {
        return password;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param password
 */
    public void setPassword(String password) {
        this.password = password;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public String getName() {
        return name;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public Integer getAge() {
        return age;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param age
 */
    public void setAge(Integer age) {
        this.age = age;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Mensaje> getMessages() {
        return messages;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param messages
 */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @return 
 */
    public List<Reservacion> getReservations() {
        return reservations;
    }
 /**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param reservations
 */
    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
    
    
    
    
}
