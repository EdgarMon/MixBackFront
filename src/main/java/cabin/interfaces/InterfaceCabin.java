/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cabin.interfaces;

import org.springframework.data.repository.CrudRepository;
import cabin.modelo.Cabin;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
public interface InterfaceCabin extends CrudRepository<Cabin,Integer> {
    
}
