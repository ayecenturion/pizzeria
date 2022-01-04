package ar.edu.ort.tp1.pacial2.clases;

public class Tradicional extends Pizza{

	private TipoDeMasa tipoMasa;
	
	public Tradicional(String nombre, float costoDeProduccion, float porcentajeGanancia, TipoDeMasa tipoMasa) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.tipoMasa = tipoMasa;
		
	}

	
	
	@Override
	public void mostrar() {
		System.out.println("Tradicional - " + super.getNombre() + " - Precio de Venta $ " + this.getPrecioDeVenta() +" - "+ this.tipoMasa);
		
	}

	public TipoDeMasa getTipoMasa() {
		return tipoMasa;
	}

	@Override
	public float getPrecioDeVenta() {
		float prVenta = 0;
		prVenta = super.getPrecioDeCosto() * this.tipoMasa.getPorcentaje();
		return prVenta;
	}




	
	

}
