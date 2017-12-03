package br.edu.univas.escola.controller;

import java.awt.Component;
import java.util.ArrayList;

import br.edu.univas.escola.dao.FrequenciaDAO;
import br.edu.univas.escola.model.Frequencia;
import br.edu.univas.escola.view.ListFrequenciaPanel;


public class ListFrequenciaController {

	private ListFrequenciaPanel listFrequenciaPanel;
	private FrequenciaDAO frequenciaDAO;
	
	public ListFrequenciaController() {
		frequenciaDAO = new FrequenciaDAO();
		ArrayList<Frequencia> frequencias = frequenciaDAO.listar();
		listFrequenciaPanel = new ListFrequenciaPanel(frequencias);
	}
	
	public Component getComponent() {
		ArrayList<Frequencia> frequencias = frequenciaDAO.listar();
		listFrequenciaPanel.updateFrequencias(frequencias);
		return listFrequenciaPanel;
	}
}
