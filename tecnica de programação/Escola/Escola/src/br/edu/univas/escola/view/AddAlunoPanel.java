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
import br.edu.univas.escola.listener.SelecionarUfComboBoxListener;

@SuppressWarnings("all")
public class AddAlunoPanel extends JPanel {

	private static final long serialVersionUID = 4253440926691625229L;
	
	private CadastrarAlunoButtonListener listener;
	private SelecionarUfComboBoxListener selecionarUfComboBoxListener;
	private MascaraFormatter mascaraFormatter;
	
	String[] ufString = { "Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MT", "MS", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
	
	private JTextField nomeTextField;
	private JFormattedTextField  cpfTextField;
	private JFormattedTextField dataNascimentoTextField;
	private JTextField nomePaiTextField;
	private JTextField nomeMaeTextField;
	private JFormattedTextField cepTextField;
	private JTextField bairroTextField;
	private JTextField ruaTextField;
	private JTextField cidadeTextField;
	private JTextField numeroTextField;
	private JTextField  rgTextField;
	private JComboBox ufComboBox;
	
	
	public AddAlunoPanel() {
		mascaraFormatter = new MascaraFormatter();
		addComponent();
	}
	
	private void addComponent() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nomeLabel = new JLabel();
		nomeLabel.setText("Nome:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(15, 15, 10, 15);
		this.add(nomeLabel, gbc);
		
		nomeTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(nomeTextField, gbc);
		
		JLabel nomePaiLabel = new JLabel();
		nomePaiLabel.setText("Nome Pai:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(nomePaiLabel, gbc);
		
		nomePaiTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(nomePaiTextField, gbc);
		
		JLabel nomeMaeLabel = new JLabel();
		nomeMaeLabel.setText("Nome Mãe:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(nomeMaeLabel, gbc);
		
		nomeMaeTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(nomeMaeTextField, gbc);
		
		JLabel dataNascimentoLabel = new JLabel();
		dataNascimentoLabel.setText("Data Nascimento:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(dataNascimentoLabel, gbc);
		
		dataNascimentoTextField = new JFormattedTextField(mascaraFormatter.mascara("##/##/####"));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(dataNascimentoTextField, gbc);
		
		JLabel ruaLabel = new JLabel();
		ruaLabel.setText("Rua:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(ruaLabel, gbc);
		
		ruaTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(ruaTextField, gbc);
		
		JLabel bairroLabel = new JLabel();
		bairroLabel.setText("Bairro:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(bairroLabel, gbc);
		
		bairroTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 1.0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(bairroTextField, gbc);
		
		JLabel numeroLabel = new JLabel();
		numeroLabel.setText("Número:");
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(numeroLabel, gbc);
		
		numeroTextField = new JTextField();
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.weightx = 1.0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(numeroTextField, gbc);
		
		JLabel cidadeLabel = new JLabel();
		cidadeLabel.setText("Cidade:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(cidadeLabel, gbc);
		
		cidadeTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(cidadeTextField, gbc);
		
		JLabel cepLabel = new JLabel();
		cepLabel.setText("CEP:");
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(cepLabel, gbc);
		
		cepTextField = new JFormattedTextField(mascaraFormatter.mascara("#####-###"));
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(cepTextField, gbc);
		
		JLabel ufLabel = new JLabel();
		ufLabel.setText("UF:");
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(ufLabel, gbc);
		
		ufComboBox = new JComboBox(ufString);
		gbc.gridx = 3;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(ufComboBox, gbc);
		
		ufComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionarUfComboBoxListener selecionarUf = (SelecionarUfComboBoxListener) selecionarUfComboBoxListener;
				selecionarUf.selecionar();
			}
		});
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF:");
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(cpfLabel, gbc);
		
		cpfTextField = new JFormattedTextField(mascaraFormatter.mascara("###.###.###-##"));
		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.weightx = 1.0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(cpfTextField, gbc);
		
		JLabel rgLabel = new JLabel();
		rgLabel.setText("RG:");
		gbc.gridx = 2;
		gbc.gridy = 11;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(rgLabel, gbc);
		
		rgTextField = new JTextField();
		gbc.gridx = 3;
		gbc.gridy = 11;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(rgTextField, gbc);
		
		JButton addButton = new JButton();
		addButton.setText("Salvar");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarAlunoButtonListener cadastrarAluno = (CadastrarAlunoButtonListener) listener;
				cadastrarAluno.salvar();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 12;
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

	public JTextField getCpfTextField() {
		return cpfTextField;
	}

	public JTextField getDataNascimentoTextField() {
		return dataNascimentoTextField;
	}

	public JTextField getNomePaiTextField() {
		return nomePaiTextField;
	}

	public JTextField getNomeMaeTextField() {
		return nomeMaeTextField;
	}

	public JTextField getCepTextField() {
		return cepTextField;
	}

	public JTextField getBairroTextField() {
		return bairroTextField;
	}

	public JTextField getRuaTextField() {
		return ruaTextField;
	}

	public JTextField getCidadeTextField() {
		return cidadeTextField;
	}

	public JTextField  getNumeroTextField() {
		return numeroTextField;
	}

	public JTextField getRgTextField() {
		return rgTextField;
	}

	public void setNomeTextField(JFormattedTextField  nomeTextField) {
		this.nomeTextField = nomeTextField;
	}

	public void setCpfTextField(JFormattedTextField  cpfTextField) {
		this.cpfTextField = cpfTextField;
	}

	public void setListener(CadastrarAlunoButtonListener cadastrarAlunoButtonListener) {
		listener = cadastrarAlunoButtonListener;
	}

	public void setSelecionarUfComboBoxListener(SelecionarUfComboBoxListener selecionarUfComboBoxListener) {
		this.selecionarUfComboBoxListener = selecionarUfComboBoxListener;
	}

	public JComboBox getUfComboBox() {
		return ufComboBox;
	}
	
}
