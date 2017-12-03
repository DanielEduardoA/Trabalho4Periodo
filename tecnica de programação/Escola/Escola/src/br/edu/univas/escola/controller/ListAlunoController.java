package br.edu.univas.escola.controller;

import java.awt.Component;
import java.util.ArrayList;

import br.edu.univas.escola.dao.AlunoDAO;
import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.view.ListAlunoPanel;


public class ListAlunoController {

	private ListAlunoPanel listAlunoPanel;
	private AlunoDAO alunoDAO;
	
	public ListAlunoController() {
		alunoDAO = new AlunoDAO();
		ArrayList<Aluno> alunos = alunoDAO.listar();
		listAlunoPanel = new ListAlunoPanel(alunos);
	}
	
	public Component getComponent() {
		ArrayList<Aluno> alunos = alunoDAO.listar();
		listAlunoPanel.updateAlunos(alunos);
		return listAlunoPanel;
	}
}
