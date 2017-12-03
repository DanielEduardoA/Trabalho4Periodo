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

import br.edu.univas.escola.model.Frequencia;

@SuppressWarnings("all")
public class ListFrequenciaPanel extends JPanel {
	
	private static final long serialVersionUID = 6806359975034010813L;
	
	private JTable table;
	private List<Frequencia> frequencias;
	
	public ListFrequenciaPanel(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("Aluno");
		columnNames.add("Disciplina");
		columnNames.add("Data");
		columnNames.add("Presença");
		
		table = new JTable(null, columnNames);
  		table.setFillsViewportHeight(true);
  		updateFrequencias(frequencias);
		
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

	public void updateFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for (Frequencia frequencia : frequencias) {
			dtm.addRow(new Object[] {
					frequencia.getAluno().getNome(),
					frequencia.getDisciplina().getNome(),
					formatDate(frequencia.getData()),
					formatPresenca(frequencia.isPesenca())
			});
		} 
	}
	private String formatPresenca(boolean presenca) {
		String presencaString;
		if (presenca) {
			presencaString = "Sim";
		}else {
			presencaString = "Não";
		}
		return presencaString;
	}
	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
}