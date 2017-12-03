package br.edu.univas.escola.dao;

import java.util.ArrayList;

import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.model.Nota;

public class NotaDAO {
private static ArrayList<Nota> notas = new ArrayList<Nota>();
	
	public void cadastrar(Nota nota) {
		notas.add(nota);
	}
	
	public ArrayList<Nota> listar() {
		return notas;
	}
	
	public boolean listarPorAlunoBimestre(Aluno aluno, int bimestre, int ano) {
		boolean existeNota = false;
		for (Nota nota : notas) {
			if (nota.getAluno().getId() == aluno.getId() && nota.getBimestre() == bimestre && nota.getAno() == ano) {
				existeNota = true;
			}
		}
		return existeNota;
	}
}
