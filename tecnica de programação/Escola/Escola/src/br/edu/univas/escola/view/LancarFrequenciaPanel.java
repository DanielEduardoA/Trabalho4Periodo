package br.edu.univas.escola.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.escola.dao.AlunoDAO;
import br.edu.univas.escola.dao.DisciplinaDAO;
import br.edu.univas.escola.listener.CadastrarAlunoButtonListener;
import br.edu.univas.escola.listener.LancarFrequenciaButtonListener;
import br.edu.univas.escola.listener.SelecionarAlunoComboBoxListener;
import br.edu.univas.escola.listener.SelecionarDisciplinaComboBoxListener;
import br.edu.univas.escola.listener.SelecionarPresencaCheckBoxListener;
import br.edu.univas.escola.listener.SelecionarUfComboBoxListener;
import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.model.Disciplina;

@SuppressWarnings("all")
public class LancarFrequenciaPanel extends JPanel {

	private static final long serialVersionUID = 4253440926691625229L;
	
	private AlunoDAO alunoDAO;
	private DisciplinaDAO disciplinaDAO;
	private LancarFrequenciaButtonListener listener;
	private SelecionarPresencaCheckBoxListener selecionarPresencaCheckBoxListener;
	private MascaraFormatter mascaraFormatter;
	private JFormattedTextField dataTextField;
	private JComboBox alunoComboBox;
	private JComboBox disciplinaComboBox;
	private JCheckBox presencaCheckBox;
	private SelecionarAlunoComboBoxListener selecionarAlunoComboBoxListener;
	private SelecionarDisciplinaComboBoxListener selecionarDisciplinaComboBoxListener;
	private Date data;
	private DefaultComboBoxModel modelAluno;
	private DefaultComboBoxModel modelDisciplina;
	
	
	public LancarFrequenciaPanel() {
		mascaraFormatter = new MascaraFormatter();
		alunoDAO = new AlunoDAO();
		disciplinaDAO = new DisciplinaDAO();
		addAlunoComboBox();
		addDisciplinaComboBox();
		addComponent();
		preencherComponent();
	}
	
	private void preencherComponent() {
		data = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dataTextField.setText(dateFormat.format(data));
		addAlunoComboBox();
		addDisciplinaComboBox();
	}
	
	private void addAlunoComboBox() {
		Vector comboBoxItems=new Vector();
		comboBoxItems.add("Selecione");
		for (Aluno aluno : alunoDAO.listar()) {
			comboBoxItems.add(aluno);
		}
		 modelAluno = new DefaultComboBoxModel(comboBoxItems);
	}
	
	private void addDisciplinaComboBox() {
		Vector comboBoxItems=new Vector();
		comboBoxItems.add("Selecione");
		for (Disciplina disciplina : disciplinaDAO.listar()) {
			comboBoxItems.add(disciplina);
		}
		
	    modelDisciplina = new DefaultComboBoxModel(comboBoxItems);
	}
	
	private void addComponent() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel dataLabel = new JLabel();
		dataLabel.setText("Data:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(15, 15, 10, 15);
		this.add(dataLabel, gbc);
		
		dataTextField = new JFormattedTextField(mascaraFormatter.mascara("##/##/####"));
		dataTextField.setEnabled(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(dataTextField, gbc);
		
		JLabel alunoLabel = new JLabel();
		alunoLabel.setText("Aluno:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(alunoLabel, gbc);
		
		alunoComboBox = new JComboBox(modelAluno);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(alunoComboBox, gbc);
		
		alunoComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionarAlunoComboBoxListener selecionarAluno = (SelecionarAlunoComboBoxListener) selecionarAlunoComboBoxListener;
				selecionarAluno.selecionar();
			}
		});
		
		JLabel disciplinaLabel = new JLabel();
		disciplinaLabel.setText("Disciplina:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(disciplinaLabel, gbc);
		
		disciplinaComboBox = new JComboBox(modelDisciplina);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(disciplinaComboBox, gbc);
		
		disciplinaComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionarDisciplinaComboBoxListener selecionarDisciplina = (SelecionarDisciplinaComboBoxListener) selecionarDisciplinaComboBoxListener;
				selecionarDisciplina.selecionar();
			}
		});
		
		JLabel presencaLabel = new JLabel();
		presencaLabel.setText("Presente:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(presencaLabel, gbc);
		
		presencaCheckBox = new JCheckBox();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(presencaCheckBox, gbc);
		
		presencaCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionarPresencaCheckBoxListener selecionarFrequencia = (SelecionarPresencaCheckBoxListener) selecionarPresencaCheckBoxListener;
				selecionarFrequencia.selecionar();
			}
		});
		
		JButton addButton = new JButton();
		addButton.setText("Salvar");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LancarFrequenciaButtonListener lancarFrequencia = (LancarFrequenciaButtonListener) listener;
				lancarFrequencia.salvar();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(addButton, gbc);
		
		
	}

	public AlunoDAO getAlunoDAO() {
		return alunoDAO;
	}

	public void setAlunoDAO(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public DisciplinaDAO getDisciplinaDAO() {
		return disciplinaDAO;
	}

	public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

	public LancarFrequenciaButtonListener getListener() {
		return listener;
	}

	public void setListener(LancarFrequenciaButtonListener listener) {
		this.listener = listener;
	}

	public SelecionarPresencaCheckBoxListener getSelecionarPresencaCheckBoxListener() {
		return selecionarPresencaCheckBoxListener;
	}

	public void setSelecionarPresencaCheckBoxListener(
			SelecionarPresencaCheckBoxListener selecionarPresencaCheckBoxListener) {
		this.selecionarPresencaCheckBoxListener = selecionarPresencaCheckBoxListener;
	}

	public MascaraFormatter getMascaraFormatter() {
		return mascaraFormatter;
	}

	public void setMascaraFormatter(MascaraFormatter mascaraFormatter) {
		this.mascaraFormatter = mascaraFormatter;
	}

	public JFormattedTextField getDataTextField() {
		return dataTextField;
	}

	public void setDataTextField(JFormattedTextField dataTextField) {
		this.dataTextField = dataTextField;
	}

	public JComboBox getAlunoComboBox() {
		return alunoComboBox;
	}

	public void setAlunoComboBox(JComboBox alunoComboBox) {
		this.alunoComboBox = alunoComboBox;
	}

	public JComboBox getDisciplinaComboBox() {
		return disciplinaComboBox;
	}

	public void setDisciplinaComboBox(JComboBox disciplinaComboBox) {
		this.disciplinaComboBox = disciplinaComboBox;
	}

	public JCheckBox getPresencaCheckBox() {
		return presencaCheckBox;
	}

	public void setPresencaCheckBox(JCheckBox presencaCheckBox) {
		this.presencaCheckBox = presencaCheckBox;
	}

	public SelecionarAlunoComboBoxListener getSelecionarAlunoComboBoxListener() {
		return selecionarAlunoComboBoxListener;
	}

	public void setSelecionarAlunoComboBoxListener(SelecionarAlunoComboBoxListener selecionarAlunoComboBoxListener) {
		this.selecionarAlunoComboBoxListener = selecionarAlunoComboBoxListener;
	}

	public SelecionarDisciplinaComboBoxListener getSelecionarDisciplinaComboBoxListener() {
		return selecionarDisciplinaComboBoxListener;
	}

	public void setSelecionarDisciplinaComboBoxListener(
			SelecionarDisciplinaComboBoxListener selecionarDisciplinaComboBoxListener) {
		this.selecionarDisciplinaComboBoxListener = selecionarDisciplinaComboBoxListener;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
