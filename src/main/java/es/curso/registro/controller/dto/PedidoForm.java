package es.curso.registro.controller.dto;

import java.util.List;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Status;
import es.curso.registro.model.User;

public class PedidoForm {
	
	private int cantidad;
	private double precioFinal;
	private User user;
	private String direccion;
	private String comentario;
	private Status status;
	private List<LineaPedido> listaLineas;
	
	public PedidoForm() {
	}

	public PedidoForm(int cantidad, double precioFinal, User user, Status status, List<LineaPedido> listaLineas) {
		this.cantidad = cantidad;
		this.precioFinal = precioFinal;
		this.user = user;
		this.status = status;
		this.listaLineas = listaLineas;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<LineaPedido> getListaLineas() {
		return listaLineas;
	}

	public void setListaLineas(List<LineaPedido> listaLineas) {
		this.listaLineas = listaLineas;
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
