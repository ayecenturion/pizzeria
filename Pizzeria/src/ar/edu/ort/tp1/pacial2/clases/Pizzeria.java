package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Pizzeria implements Mostrable{

	private static final String MSG_PIZZA_TOPPINGS_NULO = "No se pudo fabricar Pizza o Topping nulo.";
	private static final String MSG_TOPPINGS = "Error de parámetros incorporando toppings";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	// TODO A completar
	
	private String nombre;
	private ListaPizzasPorPr listaPizzasPorPr;
	private int[][] toppingPorTipoPizza;
	private Cola<String> registroErrores;

	public Pizzeria(String nombre) {
		// TODO A completar
		this.nombre = nombre;
		this.listaPizzasPorPr = new ListaPizzasPorPr();
		this.toppingPorTipoPizza = new int[TipoPizza.values().length][Topping.values().length];
		this.registroErrores = new ColaNodos<>();
		
	}

	// TODO A completar
	public void incorporarTopping(TipoPizza tipoPizza, Topping topping, int cantidad) {
		
		int cantInicial = 0;
		int posPizza = tipoPizza.ordinal();
		int posTopping = topping.ordinal();
		
		this.toppingPorTipoPizza[posPizza][posTopping] = cantInicial + cantidad;
		
	}

	public void ingresarPedido(Pizza p, Topping topping) throws IllegalArgumentException {
		// TODO A completar
		if(p == null || topping == null) {
			this.registroErrores.add(MSG_PIZZA_TOPPINGS_NULO);
			throw new IllegalArgumentException(MSG_PIZZA_TOPPINGS_NULO);
		}else {
			if(agregarPizza(p, topping) == null) {
				throw new IllegalArgumentException("No se pudo fabricar " + p.getNombre() + " por falta de topping " + topping.getNombre());
			}
		}
		
	
	}

	private Pizza agregarPizza(Pizza p, Topping topping) {
		Pizza pizza = null;
		int cant = 0;
		
		if (p instanceof Tradicional) {
			cant = verificarStockTopping(TipoPizza.TRADICIONAL,topping);
		} else if (p instanceof Especial) {
			cant = verificarStockTopping(TipoPizza.ESPECIAL,topping);
			
		} else {
			cant = verificarStockTopping(TipoPizza.RECTANGULAR,topping);
		}
		
		if(cant > 0) {
			this.listaPizzasPorPr.add(p);
			pizza = p;
		}
		
		return pizza;
		
	}

	private int verificarStockTopping(TipoPizza tipo, Topping topping) {
		
		int posPizza = tipo.ordinal();
		int posTopping = topping.ordinal();
		int cant = 0;
		
		if(this.toppingPorTipoPizza[posPizza][posTopping] >= 1) {
			cant = this.toppingPorTipoPizza[posPizza][posTopping];
			this.toppingPorTipoPizza[posPizza][posTopping]--;
		}
		
		return cant;
		
	}

	@Override
	public void mostrar() {
		System.out.println("Pizzeria: " + this.nombre);
		int[] cantidadPizzas = obtenerCantidad();
		System.out.printf(MSG_CANTIDADES, cantidadPizzas[0], cantidadPizzas[1], cantidadPizzas[2]);
		float precio= 0;
		for (Pizza p : this.listaPizzasPorPr) {
			precio += p.getPrecioDeVenta();
		}
		System.out.printf(MSG_TOTALES,precio);
		System.out.println("--------------------------------------");
		mostrarListaPorPrecio();
		
	}

	private void mostrarListaPorPrecio() {
		
		for (Pizza p : this.listaPizzasPorPr) {
			p.mostrar();
		}
		
	}

	private int[] obtenerCantidad() {
		int[] cantTipo = new int[TipoPizza.values().length];
		int cantT=0, cantE=0, cantR=0;
		
		for (Pizza p : this.listaPizzasPorPr) {
			if (p instanceof Tradicional) {
				cantTipo[0] = cantT++;
			} else if (p instanceof Especial) {
				cantTipo[1] = cantE++;
				
			} else {
				cantTipo[2] = cantR++;
			}
		}
		
		return cantTipo;
	}

	public int vendidasConPrecioEntre(int i, int j) {
		int cant = 0;
		
		for (Pizza pizza : listaPizzasPorPr) {
			float pr = pizza.getPrecioDeVenta();
			if(pr>i && pr<=j) {
				cant ++;
				//System.out.println(pizza.toString());
			}
		}
		
		return cant;
	}

	// TODO A completar
}
