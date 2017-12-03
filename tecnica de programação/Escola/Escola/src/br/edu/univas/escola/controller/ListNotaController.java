package br.edu.univas.escola.controller;

import java.awt.Component;
import java.util.ArrayList;

import br.edu.univas.escola.dao.NotaDAO;
import br.edu.univas.escola.model.Nota;
import br.edu.univas.escola.view.ListNotaPanel;


public class ListNotaController {

	private ListNotaPanel listNotaPanel;
	private NotaDAO notaDAO;
	
	public ListNotaController() {
		notaDAO = new NotaDAO();
		ArrayList<Nota> notas = notaDAO.listar();
		listNotaPanel = new ListNotaPanel(notas);
	}
	
	public Component getComponent() {
		ArrayList<Nota> notas = notaDAO.listar();
		listNotaPanel.updateNotas(notas);
		return listNotaPanel;
	}
}
