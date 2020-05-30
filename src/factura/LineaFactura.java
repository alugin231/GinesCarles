package factura;

/**
 * Clase que define los productos que hay en la factura mediante objetos compuestos por el identificador ({@link #id_producto}), el nombre ({@link #nombre_producto}), el precio ({@link #precio}), la cantidad ({@link #cantidad}) y un descuento ({@link #descuento})
 * @author Desconocido
 *
 */

public class LineaFactura {
		
	public String id_producto; 		// identificador (codigo) del producto
	public String nombre_producto; 	// nombre del producto
	public float precio; 			//precio por una unidad del producto
	public float cantidad; 			//cantidad de unidades compradas
	public float descuento; 		//descuento de la unidad (no se esta utilizando)
	
	/**
	 * Constructor de la clase
	 * @param idProducto identificador (codigo) del producto, se asigna a  {@link #id_producto}
	 * @param nombreProducto nombre del producto, se asigna a  {@link #nombre_producto}
	 * @param precio precio por una unidad del producto, se asigna a  {@link #precio}
	 * @param cantidad cantidad de unidades compradas, se asigna a  {@link #cantidad}
	 * @param descuento descuento de la unidad (no se esta utilizando), se asigna a  {@link #descuento}
	 * @see factura.Factura
	 */
	public LineaFactura(String idProducto, String nombreProducto, float precio,
			float cantidad, float descuento) {
		super();
		id_producto = idProducto;
		nombre_producto = nombreProducto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}
	
	@Override
	/**
	 * Genera un texto con todos los parámetros del producto
	 */
	public String toString() {
		return "\n\tLineaFactura ["  				 				 
				+ "id_producto=" + id_producto
				+ ", nombre_producto=" + nombre_producto				
				+ ", precio=" + precio
				+ ", cantidad=" + cantidad
				+ ", descuento=" + descuento
				+ "]";
	}
	
	/**
	 * Devuelve el precio total de una linea. El precio de la unidad por la cantidad de productos 
	 * pedidos de esa unidad mes el descuento 
	 * @return total
	 */
	public float getTotal(){
		float total = (this.precio * this.cantidad)*(1-this.descuento/100);
		return total;
	}
}
