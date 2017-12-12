package expedientesx.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import expedientesx.modelo.entidad.Expediente;
import expedientesx.modelo.persistencia.ExpedientesDao;

@Component
public class GestorExpedientesImpl implements GestorExpendientes {
	
	@Autowired
	private ExpedientesDao expedientesDao;

	public void actualizar(Expediente expediente) {
		expedientesDao.guardar(expediente);
		System.out.println("Actualizado Expediente: " + expediente);
	}

	@Secured("ROLE_AGENTE_ESPECIAL,ROLE_DIRECTOR")
	public void clasificar(Expediente expediente) {
		if (!expediente.isClasificado()) {
			expediente.setClasificado(true);
			actualizar(expediente);
			System.out.println("Expediente Clasificado: " + expediente);
		}
	}

	@PreAuthorize("hasRole('ROLE_DIRECTOR') or #expediente.investigador == authentication.name")
	public void desclasificar(Expediente expediente) {
		if (expediente.isClasificado()) {
			expediente.setClasificado(false);
			actualizar(expediente);
			System.out.println("Expediente Desclasificado: " + expediente);
		}
	}

	@PostFilter("(hasRole('ROLE_AGENTE') and not filterObject.clasificado) " +
	        "or (hasAnyRole('ROLE_AGENTE_ESPECIAL','ROLE_DIRECTOR') and not filterObject.informe.contains(principal.username))")
	public List<Expediente> listarTodos() {
		List<Expediente>expedientes=expedientesDao.listar();
		System.out.println("Mostrar "+expedientes.size()+" Expedientes: " + expedientes.toString());
		return expedientes;
	}

	@PostAuthorize("hasRole('ROLE_DIRECTOR') or returnObject.investigador == authentication.name")
	public Expediente mostrar(Long id) {
		Expediente expediente=expedientesDao.buscar(id);
		System.out.println("Mostrar Expediente: " + expediente.toString());
		return expediente;
	}

}
