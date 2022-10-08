/**
 * Clase Boat, debe ser anotada como un entidad
 */
package com.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author frankdev
 */
/**
 * 1. Mi clase sera una entidad. No crearemos tablas en MySQL, solo
 * crearemos la BD, las tablas las creará la la dependencia (jpa) por mi
 * y eso se configura en (application.properties).
 * @author frankdev
 */
@Entity
// 2. Mi clase se comportara como una tabla
@Table(name = "boat")
/**
 * 3. La información que hay en las tablas la voy a representar
 * con instancias de mis clases y para poder pasar mi información
 * por ahi debo usar (implements Serializable), esto me obliga
 * a definir mi llave primaria (@Id) en el siguiente paso
 */
public class Boat implements Serializable {
    // 4. Defino mi (id), se quita el error en el (Boat)
    @Id
    /**
     * 5. Desprenderme un poco del código SQL, para que la
     * creación de las tablas corresponde a la estructura
     * logica que yo use en mis clases. Por esa razón no le voy
     * a decir a mi tabla que sea autoincrementado porque no he
     * creado tablas, voy a definir Clses-Entidad y estas van a
     * construir la BD. Así se creara una clave primaria para
     * cada elemento (id)
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer model;
    private Integer category_id;
    private String name;
    
    /**
     * 6. Generar los Getter ans Setter. En alguna parte de los retos
     * debemos copiar una de nuestras clases en la plataforma para que
     * sea evaluada en buenas practicas.
     * @return 
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
