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

import br.edu.univas.escola.model.Disciplina;


@SuppressWarnings("all")
public class ListDisciplinaPanel extends JPanel {
	
	private static final long serialVersionUID = 6806359975034010813L;
	
	private JTable table;
	private List<Disciplina> disciplinas;
	
	public ListDisciplinaPanel(List<Disciplina> disiciplinas) {
		this.disciplinas = disiciplinas;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("Nome");
		
		table = new JTable(null, columnNames);
  		table.setFillsViewportHeight(true);
  		updateDisciplinas(disciplinas);
		
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

	public void updateDisciplinas(List<Disciplina> disiciplinas) {
		this.disciplinas = disiciplinas;
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for (Disciplina aluno : disiciplinas) {
			dtm.addRow(new Object[] {
					aluno.getNome()
			});
		} 
	}
}