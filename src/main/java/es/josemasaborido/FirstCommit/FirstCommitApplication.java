package es.josemasaborido.FirstCommit;

import es.josemasaborido.FirstCommit.entities.*;
import es.josemasaborido.FirstCommit.enums.Presencialidad;
import es.josemasaborido.FirstCommit.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FirstCommitApplication {

	public static void main(String[] args) {
		//ARRANCAMOS LA APLICACION
		ApplicationContext context = SpringApplication.run(FirstCommitApplication.class, args);


		//DEFINIMOS LOS SERVICIOS PARA CREAR LOS DATOS INICIALES EN LA BASE DE DATOS
		AlumnoService alumnoService = context.getBean(AlumnoService.class);
		UsuarioService usuarioService = context.getBean(UsuarioService.class);
		CertificacionService certificacionService = context.getBean(CertificacionService.class);
		CiudadService ciudadService = context.getBean(CiudadService.class);
		PaisService paisService = context.getBean(PaisService.class);


		//Creamos los paises
		Pais spain = new Pais("España");
		Pais francia = new Pais("Francia");
		Pais portugal = new Pais("Portugal");

		//Guardamos los paises en la base de datos
		paisService.save(spain);
		paisService.save(francia);
		paisService.save(portugal);

		//Creamos las ciudades y le asignamos el pais

		Ciudad cadiz = new Ciudad("Cadiz");

		Ciudad madrid = new Ciudad("Madrid");

		Ciudad barcelona = new Ciudad("Barcelona");


		Ciudad paris = new Ciudad("Paris");


		Ciudad lisboa = new Ciudad("Lisboa");

		//Guardamos las ciudades

		ciudadService.save(cadiz);
		ciudadService.save(madrid);
		ciudadService.save(barcelona);
		ciudadService.save(paris);
		ciudadService.save(lisboa);

		cadiz.setPais(spain);
		madrid.setPais(spain);
		barcelona.setPais(spain);
		paris.setPais(francia);
		lisboa.setPais(portugal);

		ciudadService.update(cadiz);
		ciudadService.update(madrid);
		ciudadService.update(barcelona);
		ciudadService.update(paris);
		ciudadService.update(lisboa);


		//Creamos las certificaciones

		Certificacion java = new Certificacion("JAVA");
		Certificacion htmlCss = new Certificacion("HTMLS+CSS");
		Certificacion react = new Certificacion("REACT");
		Certificacion spring = new Certificacion("SPRING");


		//Creamos los usuarios

		Usuario usuario1 = new Usuario("josema", "123456", "josema@hotmail.com");

		//Guardamos el usuario
		usuarioService.save(usuario1);

		//Creamos los alumnos

		Alumno alumno1 = new Alumno("Josema", "Saborido Noriega",
				"j.saborido@gmail.com", "678555555", Presencialidad.REMOTO, false, null,
				null, usuario1);
		alumno1.setCiudad(cadiz);


		Alumno alumno2 = new Alumno("Ana", "Romero", "a.romero@gmail.com",
				"655225458", Presencialidad.HIBRIDO, true, null, null, usuario1);
		alumno2.setCiudad(madrid);


		Alumno alumno3 = new Alumno("Piere", "Devenú", "p.devenu@gmail.com",
				"477455845", Presencialidad.PRESENCIAL, true, null, null, usuario1);
		alumno3.setCiudad(paris);

		//Guardamos los alumnos
		alumnoService.save(alumno1);
		alumnoService.save(alumno2);
		alumnoService.save(alumno3);

		//Guardamos las certificaciones
		certificacionService.save(java);
		certificacionService.save(htmlCss);
		certificacionService.save(react);
		certificacionService.save(spring);

		java.getAlumnosCertificados().add(alumno1);
		certificacionService.update(java);


	}

}
