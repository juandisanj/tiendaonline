package es.curso.registro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pedido")
	private int idPedido;
	
	@Column(name="precio_final")
	private double precioFinal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy="pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LineaPedido> listaLineas;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pedido", nullable = false)
	private Status status;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="comentario")
	private String comentario;

	public Pedido() {
	}

	public Pedido(double precioFinal, User user, List<LineaPedido> listaLineas, Status status, String direccion,
			String comentario) {
		this.precioFinal = precioFinal;
		this.user = user;
		this.listaLineas = listaLineas;
		this.status = status;
		this.direccion = direccion;
		this.comentario = comentario;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LineaPedido> getListaLineas() {
		return listaLineas;
	}

	public void setListaLineas(List<LineaPedido> listaLineas) {
		this.listaLineas = listaLineas;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
