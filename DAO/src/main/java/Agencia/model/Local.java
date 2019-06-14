package Agencia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Local {
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long  id;
	private String descricao;
	private double precoPorDia;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoPorDia() {
		return precoPorDia;
	}
	public void setPrecoPorDia(double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}
}
