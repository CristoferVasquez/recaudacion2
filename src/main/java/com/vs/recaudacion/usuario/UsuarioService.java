package com.vs.recaudacion.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDAO;

	public void agregarUsuario(Usuario user) {
		
		
		usuarioDAO.save(user);
		
		
	}

	public boolean validarRut(Usuario user) {

		// validar rut
		String[] stringRut = user.getRut().split("-");
		String rut = stringRut[0];
		String dv = stringRut[1];

		try {
			Integer rutInt = Integer.parseInt(rut);
		} catch (Exception e) {
			return false;
		}

		Integer rutInt = Integer.parseInt(rut);
		Integer dvInt = Integer.parseInt(dv);

		int factor = 2, suma = 0;
		for (int i = rut.length() - 1; i >= 0; i--) {

			int multiplicacion;
			multiplicacion = factor * (int) dvInt;

			factor++;
			if (factor > 7) {
				factor = 2;
			}

			suma = suma + (int) multiplicacion;

		}

		int resto = suma % 11;
		String dvCalculado = "";

		if (resto >= 2 && resto <= 10) {
			dvCalculado = "" + (11 - resto);
		} else {
			if (resto == 0) {
				dvCalculado = "0";
			} else {
				dvCalculado = "K";
			}

		}
		if (dv.equals(dvCalculado)) {
			return true;
		} else {
			return false;
		}

	}

	
	
	
}
