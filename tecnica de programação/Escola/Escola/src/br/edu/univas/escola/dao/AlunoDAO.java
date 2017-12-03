package br.edu.univas.escola.dao;

import java.util.ArrayList;

import br.edu.univas.escola.model.Aluno;

public class AlunoDAO {

	private static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public void cadastrar(Aluno aluno) {
		alunos.add(aluno);
	}

	public ArrayList<Aluno> listar() {
		return alunos;
	}
	
	
}
