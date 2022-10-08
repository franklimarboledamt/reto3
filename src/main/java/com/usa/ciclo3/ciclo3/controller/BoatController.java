/**
 * Clase que será el controlador, esto se espedifica a través de una anotación
 */
package com.usa.ciclo3.ciclo3.controller;

import com.usa.ciclo3.ciclo3.model.Boat;
import com.usa.ciclo3.ciclo3.service.BoatService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. La convertimos en Controlador usando '@RestController', es este
 * controlador el que va a recibir las peticiones que lleguen desde
 * 'Postman', 'Mi navegador', 'Mi FrontEnd' y desde cualquier cliente.
 * @author frankdev
 */
@RestController
/**
 * 2. Establesco la URL mediante la cual este controlador va a ser
 * alcanzado, 
 */
@RequestMapping("/api/Boat")
/**
 * Impedir que se mueste el error de 'CORS' al realizar peticiones a la URL
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {
    /**
     * 3. Según las peticiones que vayamos a relaizar, podremos
     * configurar URLs hijas que dependeran de ("/api/Boat") según
     * la petición a realizar.
     * 
     * La instancia de 'BoatService' se usa para pasarle las peticiones
     * que recibe el controlador y la inicializamos con '@Autowired'
     */
    @Autowired
    private BoatService boatService;
    
    /**
     * 4. Método que recibe una petición 'GET' para obtener todos los botes,
     * esto lo establezco con la anotación '@GetMapping' y tambien la URL hija
     * que se debe poner despues de la URL base.
     */
    @GetMapping("/all")
    public List<Boat> getControllerBoats() {
        /**
         * 5. Este método me retorna simplemente lo que haga el servicio
         */
        return boatService.getServiceBarcos();
    }
    
    /**
     * 10. Método para consultar un solo bote
     */
    @GetMapping("/{id}")
    /**
     * 11. Lo que el usuario envíe en formato 'JSON' debe ingresar
     * como una variable de la ruta usando '@pathVariable("id")' y debe
     * de ponerle cuidado a la ruta a una variable que se llame id
     */
    public Optional<Boat> getControllerBoat(@PathVariable("id") int id) {
        return boatService.getServiceBarco(id);
    }
    
    /**
     * 6. Método guardar
     */
    @PostMapping("/save")
    /**
     * 9. Debo indicar cual es el estado que debe devolver en la petición
     */
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * 7. Lo que el usuario envíe en formato 'JSON' hay que convertirlo
     * a una instancia de la clase ´Boat' con '@RequestBody'
     */
    public Boat saveControllerBoat(@RequestBody Boat boat) {
        /**
         * 8. Le entrago el trabajo al servicio
         */
        return boatService.saveServiceBarco(boat);
    }
}
