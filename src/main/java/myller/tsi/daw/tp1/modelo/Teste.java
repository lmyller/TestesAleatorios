package myller.tsi.daw.tp1.modelo;

import java.util.Calendar;

public class Teste {
	private long idTeste;
	private int qtdeQuestoes, numeroAcerto;
	private String resposta;
	private Calendar dataTeste;
	private Usuario usuario;
	private Materia materia;
	
	public long getIdTeste() {
		return idTeste;
	}
	public void setIdTeste(long idTeste) {
		this.idTeste = idTeste;
	}
	public int getQtdeQuestoes() {
		return qtdeQuestoes;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public void setQtdeQuestoes(int qtdeQuestoes) {
		this.qtdeQuestoes = qtdeQuestoes;
	}
	public int getNumeroAcerto() {
		return numeroAcerto;
	}
	public void setNumeroAcerto(int numeroAcerto) {
		this.numeroAcerto = numeroAcerto;
	}
	public Calendar getDataTeste() {
		return dataTeste;
	}
	public void setDataTeste(Calendar dataTeste) {
		this.dataTeste = dataTeste;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
