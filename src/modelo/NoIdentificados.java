package modelo;

import java.time.temporal.ChronoUnit;

public class NoIdentificados extends Detenidos {

	private String apodo;
	private String descripcion;
	private String descripcionFisica;
	


	@Override
	
	public long tiempoCautiverio() { 
		if(getCentrosEnLosQueEstuvo().size() != 0)
		{
			long tiempo_en_cautiverio =  ChronoUnit.DAYS.between(fechaApertura(), fechaCierre() ); 
			return tiempo_en_cautiverio;
		}
		else{
			return 0;
		}
	}
	
	@Override
	public boolean sobrevivio() {
		return false;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcionFisica() {
		return descripcionFisica;
	}

	public void setDescripcionFisica(String descripcionFisica) {
		this.descripcionFisica = descripcionFisica;
	}
}
