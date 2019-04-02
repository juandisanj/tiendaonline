package es.curso.registro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lineapedidos")
public class LineaPedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_lineapedido")
	private int idLineaPedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_linea")
	private Double precioLinea;

	public LineaPedido() {
	}

	public LineaPedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioLinea = getImporteLinea();
	}
	
	public int getIdLineaPedido() {
		return idLineaPedido;
	}

	public void setIdLineaPedido(int idLineaPedido) {
		this.idLineaPedido = idLineaPedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioLinea() {
		return precioLinea;
	}

	public void setPrecioLinea(double precioLinea) {
		this.precioLinea = precioLinea;
	}
	
	public Double getImporteLinea() {
		
		this.precioLinea = cantidad * producto.getPrecio();
		return precioLinea;
	}

}
