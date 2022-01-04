package ar.edu.ort.tp1.pacial2.clases;

public class Rectangular extends Pizza{

	private long largo;
	private long ancho;
	private AdicionalQueso adicionalQueso;
	private static int PR_PORCION = 45;
	
	public Rectangular(String nombre, float costoDeProduccion, float porcentajeGanancia, long largo, long ancho, AdicionalQueso adicionalQueso) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.largo = largo;
		this.ancho = ancho;
		this.adicionalQueso = adicionalQueso;
		
	}

	@Override
	public void mostrar() {
		int cantPorciones = (int) (this.largo * this.ancho);
		System.out.println("Rectangular - " + super.getNombre() + " - Precio de Venta $ " + this.getPrecioDeVenta() + cantPorciones + " porciones " + this.adicionalQueso);
		
	}
	
	@Override
	public float getPrecioDeVenta() {
		float prVenta = 0;
		long cantPorciones = (this.largo * this.ancho);
		prVenta = (super.getPrecioDeCosto() + ((cantPorciones * PR_PORCION) * this.adicionalQueso.getMultiplicadorQueso()));
		return prVenta;
	}

	
	

}
