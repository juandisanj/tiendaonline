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
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idStatus;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pedido> listaPedidos;
	
	public Status() {
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
