package br.com.campanha.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campanha")
public class Campanha implements java.io.Serializable  {
	
	private static final long serialVersionUID = 4910225916550731446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nomecampanha", length = 50)
	private String nomecampanha;

	@Column(name = "idtimecoracao")
	private String idtimecoracao;

	@Column(name = "datavigencia", length = 20)
	private String datavigencia;
	
	
	public Campanha() {
	}

	public Campanha(Long id) {
		this.id = id;
	}
	
	public Campanha(Long id, String nomecampanha, String idtimecoracao, String datavigencia) {
		this.id = id;
		this.nomecampanha = nomecampanha;
		this.idtimecoracao = idtimecoracao;
		this.datavigencia = datavigencia;
	}

	public Campanha(String nomecampanha, String idtimecoracao, String datavigencia) {
		this.nomecampanha = nomecampanha;
		this.idtimecoracao = idtimecoracao;
		this.datavigencia = datavigencia;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecampanha() {
		return nomecampanha;
	}

	public void setNomecampanha(String nomecampanha) {
		this.nomecampanha = nomecampanha;
	}

	public String getIdtimecoracao() {
		return idtimecoracao;
	}

	public void setIdtimecoracao(String idtimecoracao) {
		this.idtimecoracao = idtimecoracao;
	}

	public String getDatavigencia() {
		return datavigencia;
	}

	public void setDatavigencia(String datavigencia) {
		this.datavigencia = datavigencia;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append(this.id).append(", NomeCampanha: ").append(this.nomecampanha).append(", IdTimeCoracao: ")
				.append(this.idtimecoracao).append(", DataVigencia: ").append(this.datavigencia);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		Campanha toCompare = (Campanha) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
