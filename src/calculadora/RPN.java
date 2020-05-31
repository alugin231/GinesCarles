package calculadora;

/*
Objetivo: Obtener c�digo refactorizado a partir de otro que no lo est�.
Tarea: Para esta tarea, se refactorizar� un programa mal escrito, sin cambiar la forma en que funciona el programa. Este programa, RPN.java es una calculadora de notaci�n inversa polaca que utiliza una pila.
Reverse Polish notation (RPN) Notaci�n Polaca inversa, por ejemplo
la expresi�n: 4 * 5 - 7 / 2 % 3 nos da 1,5 respetando la prioridad de
los operadores en notaci�n RPN seria: 4 5 * 7 2 / - 3 % (pues no podemos poner los par�ntesis para alterar la prioridad)
Se debe reorganizar este c�digo usando al menos tres de las reglas
vistas en clase.
*/


/**
 * Clase Reverse Polish notation (RPN) Notaci�n Polaca inversa
 * 
 */
public class RPN {
	
	private String commando; //Lineas de comandos a calcular
	private NodoPila arriba; //�ltimo nodo de la pila introducido
	
	/**
	 * Contructor de la clase
	 * @param commando se asigna a la variable {@link #commando}
	 */
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	
	/**
	 * Metodo que a�ade un nuevo nodo a la pila
	 * @param nuevo_dato valor del nodo
	 */
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	
	/**
	 * M�todo recoge el valor del �ltimo nodo y lo quita de la pila
	 * @return dato_arriba valor del �ltimo nodo de la pila
	 */
	public double pullPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	
	/**
	 * M�todo que lee la cadena introducida
	 * @return val resultado de la operacion
	 */
	public double resultado( ) {
		
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
				// convertir a double y a�adir a la pila
				numero = Double.parseDouble(temp);
				pushPila(numero);
			} else {
				calcula(i);
			}
		}
		double val = pullPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	
	/**
	 * M�todo que calcula la operaci�n  y actualiza la pila con el resultado
	 * @param i posici�n de la cadena donde est� el simbolo de la operacion
	 */
	public void calcula(int i) {
		double a, b;
		b = pullPila( );
		a = pullPila( );
		if(commando.charAt(i) == '+') {
			//b = pullPila( );
			//a = pullPila( );
			pushPila(a + b);
		} else if(commando.charAt(i) == '-') {
			//b = pullPila( );
			//a = pullPila( );
			pushPila(a - b);
		} else if(commando.charAt(i) == '*') {
			//b = pullPila( );
			//a = pullPila( );
			pushPila(a * b);
		} else if(commando.charAt(i) == '/') {
			//b = pullPila( );
			//a = pullPila( );
			pushPila(a / b);
		}
		else if(commando.charAt(i) == '^') {
			//b = pullPila( );
			//a = pullPila( );
			pushPila(Math.pow(a, b));
		}
		else if(commando.charAt(i) == '%') {
			//b = pullPila( );
			//a = pullPila( );
			pushPila(a%b);
		} else if(commando.charAt(i) != ' ') {
			throw new IllegalArgumentException( );
		}
	}
	
}
