package calculadora;

/**
 * Clase que representa un nodo de la pila, se contruye a partir de un valor ({@link #dato}) y el objeto anterior de la pila({@link #abajo}) 
 * 
 */
class NodoPila{
	
	public NodoPila abajo; //Siguiente nodo de la pila
	public double dato;	//Valor de la pila
	
	/**
	 * Constructor del nodo de la pila
	 * @param dato valor de la pila, se asigna a {@link #dato}
	 * @param abajo nodo anterior de la pila, se asigna a {@link #abajo}
	 */
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
	
	
}
