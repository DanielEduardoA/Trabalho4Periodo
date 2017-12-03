package br.edu.univas.escola.controller;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import br.edu.univas.escola.dao.AlunoDAO;
import br.edu.univas.escola.listener.CadastrarAlunoButtonListener;
import br.edu.univas.escola.listener.SelecionarUfComboBoxListener;
import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.view.AddAlunoPanel;

public class AddAlunoController {

	private Aluno aluno;
	private AlunoDAO alunoDAO;
	
	private AddAlunoPanel addAlunoPanel;
	
	private SimpleDateFormat dataFormatter;
	
	public AddAlunoController() {
		aluno = new Aluno();
		addAlunoPanel = new AddAlunoPanel();
		alunoDAO = new AlunoDAO();
		dataFormatter = new SimpleDateFormat("dd/MM/yyyy");
		dataFormatter.setLenient(false);
	}
	
	public Component getComponent() {
		return addAlunoPanel;
	}

	public void init() {
		cadastrarAlunoButtonListener();
		selecionarUfButtonListener();
	}
	
	private void cadastrarAlunoButtonListener() {
		addAlunoPanel.setListener(new CadastrarAlunoButtonListener() {
			
			@Override
			public void salvar() {
				addAluno();
				
			}
		});
	}
	
	private void selecionarUfButtonListener() {
		addAlunoPanel.setSelecionarUfComboBoxListener(new SelecionarUfComboBoxListener() {
			
			@Override
			public void selecionar() {
				String uf = (String) addAlunoPanel.getUfComboBox().getSelectedItem();
				if (!uf.equals("Selecione")) {
					aluno.setUf(uf);
				}
			}
		});
	}
	
	private void addAluno() {
		if(addAlunoPanel.getNomeTextField().getText().isEmpty()
			|| addAlunoPanel.getNomeMaeTextField().getText().isEmpty() 
			|| addAlunoPanel.getNomePaiTextField().getText().isEmpty()
			|| addAlunoPanel.getRuaTextField().getText().isEmpty()
			|| addAlunoPanel.getBairroTextField().getText().isEmpty()
			|| addAlunoPanel.getCidadeTextField().getText().isEmpty()
			|| addAlunoPanel.getNumeroTextField().getText().isEmpty()
			|| addAlunoPanel.getCepTextField().getText().isEmpty()
			|| (aluno.getUf() == null)) {
			JOptionPane.showMessageDialog(addAlunoPanel, "Campos obrigatórios não foram preenchidos!",
					"Informação", JOptionPane.WARNING_MESSAGE);
		} else {
			Date dataNascimento;
			try {
				String dataNascimentoString = addAlunoPanel.getDataNascimentoTextField().getText();
				dataNascimento = dataFormatter.parse(dataNascimentoString);
				aluno.setNomePai(addAlunoPanel.getNomePaiTextField().getText());
				aluno.setNome(addAlunoPanel.getNomeTextField().getText());
				aluno.setNomeMae(addAlunoPanel.getNomeMaeTextField().getText());
				aluno.setDataNascimento(dataNascimento);
				aluno.setRua(addAlunoPanel.getRuaTextField().getText());
				aluno.setBairro(addAlunoPanel.getBairroTextField().getText());
				aluno.setNumero(addAlunoPanel.getNumeroTextField().getText());
				aluno.setCidade(addAlunoPanel.getCidadeTextField().getText());
				aluno.setCep(addAlunoPanel.getCepTextField().getText());
				aluno.setCpf(addAlunoPanel.getCpfTextField().getText());
				aluno.setRg(addAlunoPanel.getRgTextField().getText());
				alunoDAO.cadastrar(aluno);
				
				JOptionPane.showMessageDialog(addAlunoPanel, "Aluno salvo com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				cleanFields();
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(addAlunoPanel, "Data Inválida!",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void cleanFields() {
		addAlunoPanel.getCpfTextField().setText(null);
		addAlunoPanel.getNomeMaeTextField().setText(null);
		addAlunoPanel.getNomePaiTextField().setText(null);
		addAlunoPanel.getNomeTextField().setText(null);
		addAlunoPanel.getRgTextField().setText(null);
		addAlunoPanel.getBairroTextField().setText(null);
		addAlunoPanel.getRuaTextField().setText(null);
		addAlunoPanel.getCepTextField().setText(null);
		addAlunoPanel.getCidadeTextField().setText(null);
		addAlunoPanel.getNumeroTextField().setText(null);
		addAlunoPanel.getUfComboBox().setSelectedIndex(0);
		addAlunoPanel.getDataNascimentoTextField().setText(null);
	}
	
}
