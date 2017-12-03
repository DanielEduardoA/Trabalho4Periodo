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
import java.util.List;
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
import br.edu.univas.escola.listener.LancarNotaButtonListener;
import br.edu.univas.escola.listener.SelecionarAlunoComboBoxListener;
import br.edu.univas.escola.listener.SelecionarDisciplinaComboBoxListener;
import br.edu.univas.escola.listener.SelecionarPresencaCheckBoxListener;
import br.edu.univas.escola.listener.SelecionarUfComboBoxListener;
import br.edu.univas.escola.model.Aluno;
import br.edu.univas.escola.model.Disciplina;

@SuppressWarnings("all")
public class LancarNotaPanel extends JPanel {

	private static final long serialVersionUID = 4253440926691625229L;
	
	private AlunoDAO alunoDAO;
	private DisciplinaDAO disciplinaDAO;
	private LancarNotaButtonListener listener;
	private JComboBox alunoComboBox;
	private JComboBox disciplinaComboBox;
	private JTextField anoTextField;
	private JTextField bimestreTextField;
	private JTextField notaTextField;
	private SelecionarAlunoComboBoxListener selecionarAlunoComboBoxListener;
	private SelecionarDisciplinaComboBoxListener selecionarDisciplinaComboBoxListener;
	private Integer ano;
	private MascaraFormatter mascaraFormatter;
	private DefaultComboBoxModel modelAluno;
	private DefaultComboBoxModel modelDisciplina;
	
	
	public LancarNotaPanel() {
		mascaraFormatter = new MascaraFormatter();
		alunoDAO = new AlunoDAO();
		disciplinaDAO = new DisciplinaDAO();
		addAlunoComboBox();
		addDisciplinaComboBox();
		addComponent();
		preencherComponent();
	}
	
	private void preencherComponent() {
		anoTextField.setEnabled(false);
		Calendar calendar = Calendar.getInstance();
		ano = new Integer(calendar.get(Calendar.YEAR));
		anoTextField.setText(ano.toString());
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
		Vector comboBoxItems=new Vector<Disciplina>();
		comboBoxItems.add("Selecione");
		List<Disciplina> disciplinas = disciplinaDAO.listar();
		for (Disciplina disciplina : disciplinas) {
			comboBoxItems.add(disciplina);
		}
		
	    modelDisciplina = new DefaultComboBoxModel(comboBoxItems);
	}
	
	private void addComponent() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel alunoLabel = new JLabel();
		alunoLabel.setText("Aluno:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(alunoLabel, gbc);
		
		this.alunoComboBox = new JComboBox(modelAluno);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.alunoComboBox, gbc);
		
		this.alunoComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionarAlunoComboBoxListener selecionarAluno = (SelecionarAlunoComboBoxListener) selecionarAlunoComboBoxListener;
				selecionarAluno.selecionar();
			}
		});
		
		JLabel disciplinaLabel = new JLabel();
		disciplinaLabel.setText("Disciplina:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(disciplinaLabel, gbc);
		
		this.disciplinaComboBox = new JComboBox(modelDisciplina);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.disciplinaComboBox, gbc);
		
		this.disciplinaComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionarDisciplinaComboBoxListener selecionarDisciplina = (SelecionarDisciplinaComboBoxListener) selecionarDisciplinaComboBoxListener;
				selecionarDisciplina.selecionar();
			}
		});
		
		JLabel anoLabel = new JLabel();
		anoLabel.setText("Ano:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(anoLabel, gbc);
		
		anoTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(anoTextField, gbc);
		
		
		JLabel bimestreLabel = new JLabel();
		bimestreLabel.setText("Bimestre:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(bimestreLabel, gbc);
		
		bimestreTextField = new JTextField(1);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(bimestreTextField, gbc);
		
		JLabel notaLabel = new JLabel();
		notaLabel.setText("Nota:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(notaLabel, gbc);
		
		notaTextField = new JTextField(3);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(notaTextField, gbc);
		
		JButton addButton = new JButton();
		addButton.setText("Salvar");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LancarNotaButtonListener lancarNota = (LancarNotaButtonListener) listener;
				lancarNota.salvar();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 5;
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

	public LancarNotaButtonListener getListener() {
		return listener;
	}

	public void setListener(LancarNotaButtonListener listener) {
		this.listener = listener;
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

	public JTextField getAnoTextField() {
		return anoTextField;
	}

	public void setAnoTextField(JTextField anoTextField) {
		this.anoTextField = anoTextField;
	}

	public JTextField getBimestreTextField() {
		return bimestreTextField;
	}

	public void setBimestreTextField(JTextField bimestreTextField) {
		this.bimestreTextField = bimestreTextField;
	}

	public JTextField getNotaTextField() {
		return notaTextField;
	}

	public void setNotaTextField(JTextField notaTextField) {
		this.notaTextField = notaTextField;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
