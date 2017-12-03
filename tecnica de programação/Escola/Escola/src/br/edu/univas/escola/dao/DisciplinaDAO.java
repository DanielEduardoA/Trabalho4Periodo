package br.edu.univas.escola.dao;

import java.util.ArrayList;

import br.edu.univas.escola.model.Disciplina;

public class DisciplinaDAO {

	private static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public void cadastrar(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	public ArrayList<Disciplina> listar() {
		return disciplinas;
	}
}
