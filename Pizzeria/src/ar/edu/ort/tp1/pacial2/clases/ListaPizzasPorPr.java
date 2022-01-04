package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaPizzasPorPr extends ListaOrdenadaNodos<Float, Pizza>{

	@Override
	public int compare(Pizza dato1, Pizza dato2) {
		
		return (int) (dato1.getPrecioDeVenta() - dato2.getPrecioDeVenta());
	}

	@Override
	public int compareByKey(Float clave, Pizza elemento) {
		// TODO Auto-generated method stub
		return (int) (clave - elemento.getPrecioDeVenta());
	}

}
