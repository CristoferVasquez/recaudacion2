package com.vs.recaudacion.archivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vs.recaudacion.usuario.Usuario;
import com.vs.recaudacion.usuario.UsuarioDAO;



@RestController
@RequestMapping("v2/Archivos")
public class ArchivoRest {
	
	@Autowired
	private ArchivoDAO archivoDAO; 
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	//usar builder para generar la ruta y poder extraer la ruta igualmente
	//MyDate OneToOne para agregar fechas
	//Manejo de exceptions
	
	/*@GetMapping("list")
	Archivo getAll() {
		
	}*/
	
	@PutMapping("/user/{userId}")
	Archivo subirArchivo( @PathVariable Integer userId) {
		Usuario user = usuarioDAO.findById(userId).get();
		Archivo file = new Archivo();
		
		file.setCodFile("x1x2x3");
		file.setNombreDocumento("doc1");
		file.setUrl("LocalStore");
		file.setUsuario(user);
		
		//File docu crear txt con file, determinar nombre = al de la bd;
		
		return archivoDAO.save(file);
	}


}
