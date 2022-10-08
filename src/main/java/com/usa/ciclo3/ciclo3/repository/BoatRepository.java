/**
 * Clase que se encarga de usar la interfaz 'CrudRepository' para
 * interactuar con la BD, esta es la que saca pecho usando al
 * (BoatCrudRepository)
 */
package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Boat;
import com.usa.ciclo3.ciclo3.repository.crud.BoatCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 1. Debo decirle que se comporte como un repositorio por medio
 * de una anotación (@) para que me permita hacer transacciones con
 * la BD, bien sea traer (GET) o llevar (POST)
 * @author frankdev
 */
@Repository
public class BoatRepository {
    /**
     * 2. Instancia de (BoatCrudRepository) con la cual realizara las
     * transacciones en la BD. Como no quero preocuparme poe la
     * inicialización de estos objetos, voy a usar la anotación (@). Esta
     * etiqueta '@Autowired' solo la debo usar dentro de componentes de
     * Sping, como '@Repository'.
     */
    @Autowired
    private BoatCrudRepository boatCrudRepository;
    
    /**
     * 3. Este Repositorio saca pecho creando los métodos que interactuan
     * con la BD, pero recordemos que usando a (BoatCrudRepository)
     */
    
    /**
     * 4. Método 'getAll()' que trae todos los Botes de la BD en una lista
     */
    public List<Boat> getAllBoats() {
        /**
         * 5. Empezamos a usar los métodos 'findAll()' propios de la interfaz
         * 'CrudRepository' a través de la instancia creada y anotada con
         * (@Autowired). En este caso el método 'findAll()' nos entrega la
         * información en un formato distinto a lo que es una 'List<>' y como
         * el método 'getAll()' debe retornar una 'List<>', entonces debemos
         * realizar un 'Casteo' al tipo '(List<Boat>)' de aquí en adelante
         * será un lista.
         */
        return (List<Boat>) boatCrudRepository.findAll();
    }
    
    /**
     * 6. Metodo 'getBoat()' que retorna un Bote. Esta Clase 'Optional<>' la
     * usamos para evitar que Java retorne 'null' si no encuentra el
     * registro. Esto pasaba antes de existir 'Optional<>'. Si existe, lo
     * muestra y si no existe no colapsa la cunsulta como si trabajara con
     * retorno de 'null'.
     */
    public Optional<Boat> getBoat(int id) {
        /**
         * 7. Usamos la interfaz creada para interactuar con la BD y le
         * pasamos el id que recibió el método.
         */
        return boatCrudRepository.findById(id);
    }
    
    /**
     * 8. Metodo para hacer actualizaciones o para guardar registros que
     * no existen, 'save'. Recibe un objeto tipo 'Boat'.
     */
    public Boat saveBoat(Boat boat) {
        /**
         * 9. De nuevo usamos la instancia que hace el trabajo 'sucio'
         * o duro con la BD.
         */
        return boatCrudRepository.save(boat);
    }
    
    /**
     * 10. En este punto ya estan definidos los métodos que realizaran las
     * peticiones a la BD. Ahora solo queda utilizarlos y eso lo haremos
     * a través de un 'servicio' que es el que invoca todos estos
     * métodos.
     */
    
    /**
     * 11. Debemos ir a nuestra Clase principal (la que contiene el main()) y
     * le diremos donde encontrar todos los modelos de nuestro proyecto
     * con la anotación '@EntityScan()'
     */
}
