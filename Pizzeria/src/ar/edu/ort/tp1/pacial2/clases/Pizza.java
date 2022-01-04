package ar.edu.ort.tp1.pacial2.clases;

public abstract class Pizza implements Mostrable{

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inválida";
	private static final String MSG_COSTO_INVALIDO = "Costo inválido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inválido";
	//TODO A completar
	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		//TODO A completar
		this.setNombre(nombre);
		this.setPrecioDeCosto(costoDeProduccion);
		this.setPorcentajeGanancia(porcentajeGanancia);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	public float getPrecioDeCosto() {
		return costoDeProduccion;
	}

	private void setPrecioDeCosto(float costoDeProduccion) {
		if(costoDeProduccion<=0) {
			throw new IllegalArgumentException(MSG_COSTO_INVALIDO);
		}
		this.costoDeProduccion = costoDeProduccion;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	private void setPorcentajeGanancia(float porcentajeGanancia) {
		if(porcentajeGanancia<0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}
		this.porcentajeGanancia = porcentajeGanancia;
	}


	public abstract float getPrecioDeVenta();
}
