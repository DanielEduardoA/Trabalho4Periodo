package br.edu.univas.escola.controller;

import java.awt.Component;

import javax.swing.JOptionPane;

import br.edu.univas.escola.dao.NotaDAO;
import br.edu.univas.escola.listener.LancarNotaButtonListener;
import br.edu.univas.escola.listener.SelecionarAlunoComboBoxListener;
import br.edu.univas.escola.listener.SelecionarDisciplinaComboBoxListener;
import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.model.Disciplina;
import br.edu.univas.escola.model.Nota;
import br.edu.univas.escola.view.LancarNotaPanel;

public class LancarNotaController {

	private Nota nota;
	private NotaDAO notaDAO;
	
	private LancarNotaPanel lancarNotaPanel;

	
	public LancarNotaController() {
		nota = new Nota();
		lancarNotaPanel = new LancarNotaPanel();
		notaDAO = new NotaDAO();
	}
	
	public Component getComponent() {
		return lancarNotaPanel;
	}

	public void init() {
		lancarNotaButtonListener();
		selecionarAlunoComboBoxListener();
		selecionarDisciplinaComboBoxListener();
	}
	
	private void lancarNotaButtonListener() {
		lancarNotaPanel.setListener(new LancarNotaButtonListener() {
			
			@Override
			public void salvar() {
				lancarNota();
			}
		});	
	}
	
	private void selecionarAlunoComboBoxListener() {
		lancarNotaPanel.setSelecionarAlunoComboBoxListener(new SelecionarAlunoComboBoxListener() {
			
			@Override
			public void selecionar() {
				if (lancarNotaPanel.getAlunoComboBox().getSelectedItem() instanceof Aluno) {
					Aluno aluno = (Aluno) lancarNotaPanel.getAlunoComboBox().getSelectedItem();
					nota.setAluno(aluno);
				}
			}
		});
	}
	
	private void selecionarDisciplinaComboBoxListener() {
		lancarNotaPanel.setSelecionarDisciplinaComboBoxListener(new SelecionarDisciplinaComboBoxListener() {
			
			@Override
			public void selecionar() {
				if (lancarNotaPanel.getDisciplinaComboBox().getSelectedItem() instanceof Disciplina) {
					Disciplina disciplina = (Disciplina) lancarNotaPanel.getDisciplinaComboBox().getSelectedItem();
					nota.setDisciplina(disciplina);
				}
			}
		});
	}
	
	private void lancarNota() {
		if(lancarNotaPanel.getNotaTextField().getText().isEmpty()
			|| lancarNotaPanel.getBimestreTextField().getText().isEmpty() 
			|| (nota.getAluno() == null)
			|| (nota.getDisciplina() == null)) {
			JOptionPane.showMessageDialog(lancarNotaPanel, "Campos obrigatórios não foram preenchidos!",
					"Informação", JOptionPane.WARNING_MESSAGE);
		} else {
			boolean erro = false;
			Integer bimestre = 0;
			Integer notaBimestre = 0;
			try {
				notaBimestre  = Integer.parseInt(lancarNotaPanel.getNotaTextField().getText());			
			} catch (NumberFormatException e) {
				erro = true;
				JOptionPane.showMessageDialog(lancarNotaPanel, "Nota inválida!",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				bimestre  = Integer.parseInt(lancarNotaPanel.getBimestreTextField().getText());
			} catch (NumberFormatException e) {
				erro = true;
				JOptionPane.showMessageDialog(lancarNotaPanel, "Bimestre inválido!",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
				if (!erro) {
					if (bimestre<1 && bimestre>4) {
						erro = true;
						JOptionPane.showMessageDialog(lancarNotaPanel, "Bimestre inválido!",
								"Erro", JOptionPane.ERROR_MESSAGE);	
					}
					if (notaBimestre<0 && notaBimestre>100) {
						erro = true;
						JOptionPane.showMessageDialog(lancarNotaPanel, "Nota inválida!",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
					if(!erro) {
						
						nota.setAno(lancarNotaPanel.getAno());
						nota.setBimestre(Integer.parseInt(lancarNotaPanel.getBimestreTextField().getText()));
						nota.setNota(Integer.parseInt(lancarNotaPanel.getNotaTextField().getText()));
						if (!notaDAO.listarPorAlunoBimestre(nota.getAluno(), nota.getBimestre(), nota.getAno())) {
							notaDAO.cadastrar(nota);
							JOptionPane.showMessageDialog(lancarNotaPanel, "Nota salva com sucesso!",
									"Sucesso", JOptionPane.INFORMATION_MESSAGE);
							cleanFields();
						} else {
							JOptionPane.showMessageDialog(lancarNotaPanel, "Nota já cadastrada!",
									"Alerta", JOptionPane.WARNING_MESSAGE);
							cleanFields();
						}
					}
				}
		}
	}

	private void cleanFields() {
		lancarNotaPanel.getBimestreTextField().setText(null);
		lancarNotaPanel.getNotaTextField().setText(null);
		lancarNotaPanel.getAlunoComboBox().setSelectedIndex(0);
		lancarNotaPanel.getDisciplinaComboBox().setSelectedIndex(0);
	}
	
}
