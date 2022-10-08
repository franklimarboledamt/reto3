/**
 * 1. Interface que heredara de otra interfaz.
 */
package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Boat;
import org.springframework.data.repository.CrudRepository;

/**
 *  2. Heredará de una interfaz propia de Spring, en el operador diamante
 * debo de referenciar la Tabla sobre la cual trabajará y el tipo de dato
 * de la clave primaria (Integer) definida en ese modelo Boat.
 * @author frankdev
 */
public interface BoatCrudRepository extends CrudRepository<Boat, Integer> {
    
}
