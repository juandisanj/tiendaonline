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
@Table(name="lineapedido")
public class LineaPedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLineaPedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pedido", nullable = false)
	private Pedido pedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="linea_pedido", nullable = false)
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_linea")
	private double precioLinea;

	public LineaPedido() {
	}

	public LineaPedido(Pedido pedido, Producto producto, int cantidad, double precioLinea) {
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioLinea = precioLinea;
	}
	
	public int getIdLineaPedido() {
		return idLineaPedido;
	}

	public void setIdLineaPedido(int idLineaPedido) {
		this.idLineaPedido = idLineaPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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

	public double getPrecioLinea() {
		return precioLinea;
	}

	public void setPrecioLinea(double precioLinea) {
		this.precioLinea = precioLinea;
	}

}
