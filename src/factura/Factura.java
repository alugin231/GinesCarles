package factura;

import java.util.Arrays;

/**
 * Clase que se encarga de generar un objeto Factura mediante el identigicador del cliente ({@link #id_cliente}), el nombre del cliente({@link #nombre_cliente}) y una lista de objetos ({@link #lineas})
 * @author Propietario
 *
 */

public class Factura {
	
	public String id_cliente;		// Identificador (codigo) del cliente
	public String nombre_cliente;	// Nombre del cliente
	
	public LineaFactura lineas[];	// lista de productos comprados	
	
	/**
	 * Constructor de la clase factura
	 * @param idCliente Identificador (codigo) del cliente, se asigna a  {@link #id_cliente}
	 * @param nombreCliente Nombre del cliente, se asigna a {@link #nombre_cliente}
	 * @param lineas lista de objetos de la clase {@link factura.LineaFactura}, se asigna a	{@link #lineas}
	 * @see factura.LineaFactura
	 */
	public Factura(String idCliente, String nombreCliente, LineaFactura[] lineas) {
		super();
		id_cliente = idCliente;
		nombre_cliente = nombreCliente;
		this.lineas = lineas;
	}

	/**
	 * Devuelve el precio total de la Factura, calculado a partir del precio de cada linea
	 * @return precio  
	 * @see factura.LineaFactura#getTotal
	 */
	public float getTotal(){
		float precio = 0;
		for (int i = 0; i < this.lineas.length; i++ ){
			precio += this.lineas[i].getTotal();
		}
		return precio;
	}
	
	@Override
	/**
	 * Genera un texto con todos los parámetros de la factura y el precio total
	 * @see #getTotal
	 */
	public String toString() {
		return "Factura [" 
		+ "id_cliente=" + id_cliente 		 
		+ ", nombre_cliente=" + nombre_cliente 
		+ ", \n\tlineas=" + Arrays.toString(lineas)
		+ "\n\n\tgetTotal()=" + getTotal()
		+ "]";
	}

/**
 * Genera 4 objetos de la clase LineaFactura y crea un objeto de la clase Factura con ellos
 * @param args parametro sin uso
 * @see factura.LineaFactura
 * @see factura.Factura
 */
	public static void main(String[] args){
		
		// Crear una factura
		LineaFactura[] lineas = new LineaFactura[]{
				new LineaFactura("P100", "Leche",	0.85f, 	6, 	10 ),
				new LineaFactura("P200", "Pan",		0.60f, 	1, 	20 ),
				new LineaFactura("P150", "Tomate",	0.85f, 	2, 	10 ),
				new LineaFactura("P600", "Cafe",	1.2f, 	1, 	10 )
			};														
		Factura factura1 = new Factura( "C100",  "Antonio Garcia", lineas);
		
		// Escribir la factura
		System.out.println( factura1 );				
	}	
}
