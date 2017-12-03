package br.edu.univas.escola.controller;

import java.awt.Component;

import javax.swing.JOptionPane;

import br.edu.univas.escola.dao.DisciplinaDAO;
import br.edu.univas.escola.listener.CadastrarDisciplinaButtonListener;
import br.edu.univas.escola.model.Disciplina;
import br.edu.univas.escola.view.AddDisciplinaPanel;

public class AddDisciplinaController {

	private Disciplina disciplina;
	private DisciplinaDAO disciplinaDAO;
	
	private AddDisciplinaPanel addDisciplinaPanel;
	
	public AddDisciplinaController() {
		disciplina = new Disciplina();
		addDisciplinaPanel = new AddDisciplinaPanel();
		disciplinaDAO = new DisciplinaDAO();
	}
	
	public Component getComponent() {
		return addDisciplinaPanel;
	}

	public void init() {
		cadastrarDisciplinaButtonListener();
	}
	
	private void cadastrarDisciplinaButtonListener() {
		addDisciplinaPanel.setListener(new CadastrarDisciplinaButtonListener() {
			@Override
			public void salvar() {
				addDisciplina();	
			}
		});
	}
	
	private void addDisciplina() {
		if(addDisciplinaPanel.getNomeTextField().getText().isEmpty()) {
			JOptionPane.showMessageDialog(addDisciplinaPanel, "Campos obrigatórios não foram preenchidos!",
					"Informação", JOptionPane.WARNING_MESSAGE);
		} else {
			disciplina.setNome(addDisciplinaPanel.getNomeTextField().getText());
			disciplinaDAO.cadastrar(disciplina);
				
			JOptionPane.showMessageDialog(addDisciplinaPanel, "Disciplina salva com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			cleanFields();
		}
	}

	private void cleanFields() {
		addDisciplinaPanel.getNomeTextField().setText(null);
	}	
}
