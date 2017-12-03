package br.edu.univas.escola.controller;

import java.awt.Component;
import java.util.ArrayList;

import br.edu.univas.escola.dao.DisciplinaDAO;
import br.edu.univas.escola.model.Disciplina;
import br.edu.univas.escola.view.ListDisciplinaPanel;


public class ListDisciplinaController {

	private ListDisciplinaPanel listDisciplinaPanel;
	private DisciplinaDAO disicplinaDAO;
	
	public ListDisciplinaController() {
		disicplinaDAO = new DisciplinaDAO();
		ArrayList<Disciplina> disciplinas = disicplinaDAO.listar();
		listDisciplinaPanel = new ListDisciplinaPanel(disciplinas);
	}
	
	public Component getComponent() {
		ArrayList<Disciplina> disciplinas = disicplinaDAO.listar();
		listDisciplinaPanel.updateDisciplinas(disciplinas);
		return listDisciplinaPanel;
	}
}
