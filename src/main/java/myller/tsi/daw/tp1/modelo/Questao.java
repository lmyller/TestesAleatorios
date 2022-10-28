package myller.tsi.daw.tp1.modelo;

public class Questao {

	private long idQuestao;
	private String tituloQuestao, resposta;
	private Disciplina disciplina;
	private Materia materia;

	public long getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getTituloQuestao() {
		return tituloQuestao;
	}
	public void setTituloQuestao(String tituloQuestao) {
		this.tituloQuestao = tituloQuestao;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
