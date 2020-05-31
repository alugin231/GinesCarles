package calculadora;

/*
Objetivo: Obtener código refactorizado a partir de otro que no lo está.
Tarea: Para esta tarea, se refactorizará un programa mal escrito, sin cambiar la forma en que funciona el programa. Este programa, RPN.java es una calculadora de notación inversa polaca que utiliza una pila.
Reverse Polish notation (RPN) Notación Polaca inversa, por ejemplo
la expresión: 4 * 5 - 7 / 2 % 3 nos da 1,5 respetando la prioridad de
los operadores en notación RPN seria: 4 5 * 7 2 / - 3 % (pues no podemos poner los paréntesis para alterar la prioridad)
Se debe reorganizar este código usando al menos tres de las reglas
vistas en clase.
*/


/**
 * Clase que representa un nodo de la pila, se contruye a partir de un valor ({@link #dato}) y el objeto anterior de la pila({@link #abajo}) 
 * 
 */
class NodoPila {
	/**
	 * Constructor del nodo de la pila
	 * @param dato valor de la pila, se asigna a {@link #dato}
	 * @param abajo nodo anterior de la pila, se asigna a {@link #abajo}
	 */
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
	public NodoPila abajo; //Siguiente nodo de la pila
	public double dato;	//Valor de la pila
}

/**
 * Clase Reverse Polish notation (RPN) Notación Polaca inversa
 * 
 */
public class RPN {
	/**
	 * Metodo que añade un nuevo nodo a la pila
	 * @param nuevo_dato valor del nodo
	 */
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	
	/**
	 * Método recogeel valor del último nodo y lo quita de la pila
	 * @return dato_arriba valor del último nodo de la pila
	 */
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	
	/**
	 * Contructor de la clase
	 * @param commando se asigna a la variable {@link #commando}
	 */
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	
	/**
	 * Método que lee la cadena introducida y hace los claculos
	 * @return val resultado de la operacion
	 */
	public double resultado( ) {
	double a, b;
	int j;
	for(int i = 0; i < commando.length( ); i++) {
		// si es un digito
		if(Character.isDigit(commando.charAt(i))) {
			double numero;
			// obtener un string a partir del numero
			String temp = "";
			for(j = 0; (j < 100) && (Character.isDigit(commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
				temp = temp + String.valueOf(commando.charAt(i));
			}
			// convertir a double y añadir a la pila
			numero = Double.parseDouble(temp);
			pushPila(numero);
		} else if(commando.charAt(i) == '+') {
			b = popPila( );
			a = popPila( );
			pushPila(a + b);
		} else if(commando.charAt(i) == '-') {
			b = popPila( );
			a = popPila( );
			pushPila(a - b);
		} else if(commando.charAt(i) == '*') {
			b = popPila( );
			a = popPila( );
			pushPila(a * b);
		} else if(commando.charAt(i) == '/') {
			b = popPila( );
			a = popPila( );
			pushPila(a / b);
		}
		else if(commando.charAt(i) == '^') {
			b = popPila( );
			a = popPila( );
			pushPila(Math.pow(a, b));
		}
		else if(commando.charAt(i) == '%') {
			b = popPila( );
			a = popPila( );
			pushPila(a%b);
		} else if(commando.charAt(i) != ' ') {
			throw new IllegalArgumentException( );
		}
		}
		double val = popPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	private String commando; //Lineas de comandos a calcular
	private NodoPila arriba; //Último nodo de la pila introducido
}
