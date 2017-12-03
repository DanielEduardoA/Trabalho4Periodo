package br.edu.univas.escola.model;

import java.util.Date;

public class Frequencia {
	private Date data;
	private boolean pesenca;
	private Aluno aluno;
	private Disciplina disciplina;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isPesenca() {
		return pesenca;
	}
	public void setPesenca(boolean pesenca) {
		this.pesenca = pesenca;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
