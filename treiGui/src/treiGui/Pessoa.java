package treiGui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

	private Integer id;
	private String primeiroNome;
	private String sobreNome;
	private String nomeCompleto;
	private Date dataCriacao = new Date();
		
	
	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPrimeiroNome() {
		return this.primeiroNome;
	}
	
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	public String getSobreNome() {
		return this.sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
		
	public void setNomeCompleto(String primeiroNome, String sobreNome) {
		this.nomeCompleto = primeiroNome + " " + sobreNome;
	}

	public String getNomeCompleto() {
		return this.nomeCompleto;
	}
	
	public String getDateAsString() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    return dateFormat.format(this.dataCriacao);
	}
}
