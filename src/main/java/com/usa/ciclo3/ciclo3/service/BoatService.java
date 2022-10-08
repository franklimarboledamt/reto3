/**
 * Esta clase debemos convertirla en un servicio, para eso debemos
 * usar una anotación '@Service'
 */
package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Boat;
import com.usa.ciclo3.ciclo3.repository.BoatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 1. Usamos la anotación para convertir la clase en un servicio
 * @author frankdev
 */
@Service
public class BoatService {
    /**
     * 2. Instanciamos la Clase 'BoatRepository' para acceder a los
     * métodos que a su vez se encargan de llamar los métodos del
     * Framework Spring a través de 'BoatCrudRepository'.
     * 
     * Se inicializa la instancia con la anotación '@Autowired'
     */
    @Autowired
    private BoatRepository boatRepository;
    
    /**
     * 3. Como estamos en un módelo cercano a lo que es MVC, el
     * 'BoatService' hace las veces de puente entre el controlador y
     * el 'BoatRepository' cuando se realizan peticiones.
     * 
     * Aqui recibo las peticiones del controlador y aqui es donde
     * debo gestionar la lógica del negocio.
     * 
     * Este doble paso que se realiza es con el objetivo de poder darle
     * manejo a la lógica del noegocio y que necesitaremos en los retos
     * posteriores. Si lo hacemos directamente sobre la 'BoatCrudRepository'
     * posiblemente se nos cerrarian las opciones para hacer el proyecto más
     * flexible.
     */
    public List<Boat> getServiceBarcos() {
        /**
         * 4. Hago uso de la instancia de 'BoatRepository' para
         * acceder a los métodos que hacen las peticiones al
         * 'CrudRepository' que finalmente son los que tienen contaco
         * con la BD y realizan las transacciones.
         */
        return boatRepository.getAllBoats();
    }
    
    /**
     * 5. Método para consultar un solo bote
     */
    public Optional<Boat> getServiceBarco(int id) {
        return boatRepository.getBoat(id);
    }
    
    /**
     * 6. Método para agregar un bote. Cuando me llegue un bote lo voy a
     * guardar, pero si me llega sin 'id', quiere decir que no esta en
     * la BD y guardo el registro, pero si me llega con 'id' voy a validar
     * que ese 'id' no exista y lo guardo, pero si tiene 'id' y existe; no
     * lo voy a guardar y lo retorno por donde vino porque ese ya sería el
     * método de actualizar.
     */
    public Boat saveServiceBarco(Boat boat) {
         // 7. Si vine sin 'id'
         if (boat.getId() == null) {
             // 9. Es el registro que estaba esperando y lo guardo
             return boatRepository.saveBoat(boat);
         } else {
             /**
              * 8. Si viene con 'id', puede ser que existe en la BD o que no,
              * entonces lo buscamos en la BD usando el 'id' y guardamos
              * ese resultado en una instancia de la Clase 'Optional<Boat>',
              * posteriormente validamso si esa instancia esta vacia o no
              */
             Optional<Boat> boatAux = boatRepository.getBoat(boat.getId());
             /**
              * 9. La magia del 'Optional', validamos si está vacio, si es así
              * es porque me llegó con un 'id' pero no existe en la BD,
              * entonces lo guardo.
              */
             if (boatAux.isEmpty()) {
                 // 10. Llamo al guardador
                 return boatRepository.saveBoat(boat);
             } else {
                 /**
                  * 11. Se definitivamente si existe, no hago nada, esta
                  * es función de actualizar un registro. Entonces solo
                  * retorno ese registro pero no lo guardo.
                  */
                 return boat;
             }
         }
    }
    
}
