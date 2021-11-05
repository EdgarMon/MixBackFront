//Categoria, Mensaje, Reservacion, Cliente , Ortesis
//1.Modelo o Entidad
//2.Interface
//3.Repositorio
//4.Servicios
//5.Controlador o Web



package cabin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"cabin.modelo"})
public class Appmain {
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
     * @param args
 */
	public static void main(String[] args) {
		SpringApplication.run(Appmain.class, args);
	}

}
