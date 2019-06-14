package Agencia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Viagem {
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long  id;
	
	@OneToOne
    @JoinColumn(name = "local_de_id")
	private Local localDe;
	
	@OneToOne
    @JoinColumn(name = "local_para_id")
	private Local localPara;
	
	//Temporal(TemporalType.DATE)
	private java.util.Date dataSaida;
	
	//Temporal(TemporalType.DATE)
	private java.util.Date dataVolta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Local getLocalDe() {
		return localDe;
	}

	public void setLocalDe(Local localDe) {
		this.localDe = localDe;
	}

	public Local getLocalPara() {
		return localPara;
	}

	public void setLocalPara(Local localPara) {
		this.localPara = localPara;
	}

	public java.util.Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(java.util.Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public java.util.Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(java.util.Date dataVolta) {
		this.dataVolta = dataVolta;
	}
	
	public String viagemFormatada() {
		long dias = daysBetween(dataVolta, dataSaida);
		return Long.toString(id) + "," + localDe.getDescricao() + "," + localPara.getDescricao() + "," + Double.toString(dias * localPara.getPrecoPorDia());
	}
	
	private static long daysBetween(java.util.Date one, java.util.Date two) {
        long difference =  (one.getTime()-two.getTime())/86400000;
        return Math.abs(difference);
    }
}
