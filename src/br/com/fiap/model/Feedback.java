package br.com.fiap.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Feedback {

	protected User remetente;
	protected int id;
	protected Date dataEntrada = new Date(System.currentTimeMillis());
	protected Date dataSaida;
	protected String motivo;
	protected String assunto;
	protected String conteudo;
	protected String status = "Aberto";
	public DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public Feedback() {

	}

	public User getRemetente() {
		return this.remetente;
	}

	public void setRemetente(User remetente) {
		this.remetente = remetente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String toString() {
		return "\n ID: " + getId() + 
				"\n Entrada: " + dateFormat.format(getDataEntrada()) + 
				"\n Saida: " + getDataSaida() + 
				"\n Assunto: " + getAssunto() + 
				"\n Conteudo: " + getConteudo() + 
				"\n Status: " + getStatus();
	}

}
