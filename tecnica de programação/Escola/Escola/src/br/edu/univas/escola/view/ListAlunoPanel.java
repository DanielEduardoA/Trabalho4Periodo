package br.edu.univas.escola.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.escola.model.Aluno;


@SuppressWarnings("all")
public class ListAlunoPanel extends JPanel {
	
	private static final long serialVersionUID = 6806359975034010813L;
	
	private JTable table;
	private List<Aluno> alunos;
	
	public ListAlunoPanel(List<Aluno> alunos) {
		this.alunos = alunos;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("Nome");
		columnNames.add("Data Nascimento");
		
		table = new JTable(null, columnNames);
  		table.setFillsViewportHeight(true);
  		updateAlunos(alunos);
		
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(tableScroll, gbc);
		
	}

	public void updateAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for (Aluno aluno : alunos) {
			dtm.addRow(new Object[] {
					aluno.getNome(),
					formatDate(aluno.getDataNascimento())
			});
		} 
	}
	
	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
}