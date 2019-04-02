package es.curso.registro.filterModel;

import es.curso.registro.model.Status;
import es.curso.registro.model.User;

public class PedidoForm {
	
	private double precioFinal;
	private User user;
	private Status status;
	
	public PedidoForm() {
	}

	public PedidoForm(double precioFinal, User user, Status status) {
		this.precioFinal = precioFinal;
		this.user = user;
		this.status = status;
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
	
}
