package br.edu.univas.escola.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.escola.listener.CadastrarAlunoButtonListener;
import br.edu.univas.escola.listener.CadastrarDisciplinaButtonListener;
import br.edu.univas.escola.listener.SelecionarUfComboBoxListener;

@SuppressWarnings("all")
public class AddDisciplinaPanel extends JPanel {

	private static final long serialVersionUID = 4253440926691625229L;
	
	private CadastrarDisciplinaButtonListener listener;
	
	private JTextField nomeTextField;
	
	public AddDisciplinaPanel() {
		addComponent();
	}
	
	private void addComponent() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nomeLabel = new JLabel();
		nomeLabel.setText("Nome:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(15, 15, 10, 15);
		this.add(nomeLabel, gbc);
		
		nomeTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(nomeTextField, gbc);
		
		JButton addButton = new JButton();
		addButton.setText("Salvar");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarDisciplinaButtonListener cadastrarDisciplina = (CadastrarDisciplinaButtonListener) listener;
				cadastrarDisciplina.salvar();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(addButton, gbc);
	}
	
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public void setListener(CadastrarDisciplinaButtonListener listener) {
		this.listener = listener;
	}
}
