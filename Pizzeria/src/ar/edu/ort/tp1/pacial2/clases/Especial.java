package ar.edu.ort.tp1.pacial2.clases;

public class Especial extends Pizza{
	
	private TamanioDePizza tamanioDePizza;
	private int cantidadFainas;
	private static int PR_FAINA = 70;

	public Especial(String nombre, float costoDeProduccion, float porcentajeGanancia, int cantidadFainas, TamanioDePizza tamanioDePizza) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.tamanioDePizza = tamanioDePizza;
		this.cantidadFainas = cantidadFainas;
	}

	@Override
	public void mostrar() {
		System.out.println("Especial - " + super.getNombre() + " - Precio de venta $ " + this.getPrecioDeVenta() + " - " + this.cantidadFainas + " fainas - " + this.tamanioDePizza );
		
	}
	

	@Override
	public float getPrecioDeVenta() {
		float prVenta = 0;
		prVenta = (super.getPrecioDeCosto() * this.tamanioDePizza.getPorcentaje()) + (this.cantidadFainas * PR_FAINA);
		return prVenta;
	}

}
