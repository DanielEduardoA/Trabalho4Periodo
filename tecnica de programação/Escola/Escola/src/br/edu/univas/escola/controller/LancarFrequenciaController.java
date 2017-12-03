package br.edu.univas.escola.controller;

import java.awt.Component;

import javax.swing.JOptionPane;

import br.edu.univas.escola.dao.FrequenciaDAO;
import br.edu.univas.escola.listener.LancarFrequenciaButtonListener;
import br.edu.univas.escola.listener.SelecionarAlunoComboBoxListener;
import br.edu.univas.escola.listener.SelecionarDisciplinaComboBoxListener;
import br.edu.univas.escola.listener.SelecionarPresencaCheckBoxListener;
import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.model.Disciplina;
import br.edu.univas.escola.model.Frequencia;
import br.edu.univas.escola.view.LancarFrequenciaPanel;

public class LancarFrequenciaController {

	private Frequencia frequencia;
	private FrequenciaDAO frequenciaDAO;
	
	private LancarFrequenciaPanel lancarFrequenciaPanel;

	
	public LancarFrequenciaController() {
		frequencia = new Frequencia();
		lancarFrequenciaPanel = new LancarFrequenciaPanel();
		frequenciaDAO = new FrequenciaDAO();
	}
	
	public Component getComponent() {
		return lancarFrequenciaPanel;
	}

	public void init() {
		lancarFrequenciaButtonListener();
		selecionarAlunoComboBoxListener();
		selecionarDisciplinaComboBoxListener();
		selecionarPresencaCheckBoxListener();
	}
	
	private void selecionarPresencaCheckBoxListener() {
		lancarFrequenciaPanel.setSelecionarPresencaCheckBoxListener(new SelecionarPresencaCheckBoxListener() {
			
			@Override
			public void selecionar() {
				frequencia.setPesenca(lancarFrequenciaPanel.getPresencaCheckBox().isSelected());
			}
		});
	}

	private void lancarFrequenciaButtonListener() {
		lancarFrequenciaPanel.setListener(new LancarFrequenciaButtonListener() {
			
			@Override
			public void salvar() {
				lancarFrequencia();
				
			}
		});
	}
	
	private void selecionarAlunoComboBoxListener() {
		lancarFrequenciaPanel.setSelecionarAlunoComboBoxListener(new SelecionarAlunoComboBoxListener() {
			
			@Override
			public void selecionar() {
				if (lancarFrequenciaPanel.getAlunoComboBox().getSelectedItem() instanceof Aluno) {
					Aluno aluno = (Aluno) lancarFrequenciaPanel.getAlunoComboBox().getSelectedItem();
					frequencia.setAluno(aluno);
				}
			}
		});
	}
	
	private void selecionarDisciplinaComboBoxListener() {
		lancarFrequenciaPanel.setSelecionarDisciplinaComboBoxListener(new SelecionarDisciplinaComboBoxListener() {
			
			@Override
			public void selecionar() {
				if (lancarFrequenciaPanel.getDisciplinaComboBox().getSelectedItem() instanceof Disciplina) {
					Disciplina disciplina = (Disciplina) lancarFrequenciaPanel.getDisciplinaComboBox().getSelectedItem();
					frequencia.setDisciplina(disciplina);
				}
			}
		});
	}
	
	private void lancarFrequencia() {
		if((frequencia.getAluno() == null)
			|| (frequencia.getDisciplina() == null)) {
			JOptionPane.showMessageDialog(lancarFrequenciaPanel, "Campos obrigatórios não foram preenchidos!",
					"Informação", JOptionPane.WARNING_MESSAGE);
		} else {
				frequencia.setData(lancarFrequenciaPanel.getData());
				if (!frequenciaDAO.listarPorAlunoData(frequencia.getAluno(), frequencia.getData())) {
					frequenciaDAO.cadastrar(frequencia);
					
					JOptionPane.showMessageDialog(lancarFrequenciaPanel, "Frequencia salva com sucesso!",
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
					cleanFields();
				} else {
					JOptionPane.showMessageDialog(lancarFrequenciaPanel, "Frequencia já cadastrada!",
							"Alerta", JOptionPane.WARNING_MESSAGE);
					cleanFields();
				}
				
		}
	}

	private void cleanFields() {
		lancarFrequenciaPanel.getPresencaCheckBox().setSelected(false);
		lancarFrequenciaPanel.getAlunoComboBox().setSelectedIndex(0);
		lancarFrequenciaPanel.getDisciplinaComboBox().setSelectedIndex(0);
	}
	
}
