package br.edu.univas.escola.dao;

import java.util.ArrayList;
import java.util.Date;

import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.model.Frequencia;

public class FrequenciaDAO {

private static ArrayList<Frequencia> frequencias = new ArrayList<Frequencia>();
	
	public void cadastrar(Frequencia frequencia) {
		frequencias.add(frequencia);
	}
	
	public ArrayList<Frequencia> listar() {
		return frequencias;
	}
	
	public boolean listarPorAlunoData(Aluno aluno, Date data) {
		boolean existeFrequencia = false;
		for (Frequencia frequencia : frequencias) {
			if (frequencia.getAluno().getId() == aluno.getId() && frequencia.getData().equals(data)) {
				existeFrequencia = true;
			}
		}
		return existeFrequencia;
	}
}
