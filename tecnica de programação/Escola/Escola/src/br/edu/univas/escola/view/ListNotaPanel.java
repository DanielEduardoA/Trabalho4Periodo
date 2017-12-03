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

import br.edu.univas.escola.model.Nota;

@SuppressWarnings("all")
public class ListNotaPanel extends JPanel {
	
	private static final long serialVersionUID = 6806359975034010813L;
	
	private JTable table;
	private List<Nota> notas;
	
	public ListNotaPanel(List<Nota> notas) {
		this.notas = notas;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("Aluno");
		columnNames.add("Disciplina");
		columnNames.add("Bimestre");
		columnNames.add("Ano");
		columnNames.add("Nota");
		
		table = new JTable(null, columnNames);
  		table.setFillsViewportHeight(true);
  		updateNotas(notas);
		
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

	public void updateNotas(List<Nota> notas) {
		this.notas = notas;
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for (Nota nota : notas) {
			dtm.addRow(new Object[] {
					nota.getAluno().getNome(),
					nota.getDisciplina().getNome(),
					nota.getBimestre(),
					nota.getAno(),
					nota.getNota()
			});
		} 
	}
	
	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
}