package es.curso.registro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name="id_usuario")
	private Integer idUsuario;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="descripcion")
	private String descripcion;
	
	@Column (name="marca")
	private String marca;
	
	@Column (name="precio")
	private Double precio;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="producto")
	private List<LineaPedido> lineaPedido;
	
	public Producto() {
		
	}

	public Producto(String nombre, String descripcion, String marca, Double precio, 
			List<LineaPedido> lineaPedido) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.lineaPedido = lineaPedido;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	public void setLineaPedido(List<LineaPedido> lineaPedido) {
		this.lineaPedido = lineaPedido;
	}
}
