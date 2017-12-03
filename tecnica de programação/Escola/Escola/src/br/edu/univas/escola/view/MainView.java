package br.edu.univas.escola.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.edu.univas.escola.listener.ListenerTopMenus;


public class MainView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel centerPanel;
	private ListenerTopMenus listener;
	
	public MainView() {
		this.setTitle("Gerenciador Escolar");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800, 600));
		addComponents();
	}
	
	public void addComponents() {
		this.getContentPane().setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.LIGHT_GRAY);
		createMenus(northPanel);
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	private void createMenus(JPanel panel) {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuAluno = new JMenu("Aluno");
		menuBar.add(menuAluno);
		
		JMenuItem menuItemCadsatrar = new JMenuItem("Cadastrar");
		menuAluno.add(menuItemCadsatrar);
		menuItemCadsatrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.cadastrarAluno();
			}
		});
		
		JMenuItem menuItemListar = new JMenuItem("Listar");
		menuAluno.add(menuItemListar);
		menuItemListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.listarAluno();
			}
		});
		
		JMenu menuDisciplina = new JMenu("Disciplina");
		menuBar.add(menuDisciplina);
		
		JMenuItem menuItemCadastrarDisciplina = new JMenuItem("Cadastrar");
		menuDisciplina.add(menuItemCadastrarDisciplina);
		menuItemCadastrarDisciplina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.cadastrarDisciplina();
			}
		});
		
		JMenuItem menuItemListarDisciplina = new JMenuItem("Listar");
		menuDisciplina.add(menuItemListarDisciplina);
		menuItemListarDisciplina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.listarDisciplina();
			}
		});
		
		JMenu menuNota = new JMenu("Nota");
		menuBar.add(menuNota);
		
		JMenuItem menuItemCadastrarNota = new JMenuItem("Cadastrar");
		menuNota.add(menuItemCadastrarNota);
		menuItemCadastrarNota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.lancarNota();
			}
		});
		
		JMenuItem menuItemListarNota = new JMenuItem("Listar");
		menuNota.add(menuItemListarNota);
		menuItemListarNota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.listarNota();
			}
		});
		
		
		JMenu menuFrequencia = new JMenu("Frequencia");
		menuBar.add(menuFrequencia);
		
		JMenuItem menuItemCadastrarFrequencia = new JMenuItem("Cadastrar");
		menuFrequencia.add(menuItemCadastrarFrequencia);
		menuItemCadastrarFrequencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.lancarFrequencia();
			}
		});
		
		JMenuItem menuItemListarFrequencia = new JMenuItem("Listar");
		menuFrequencia.add(menuItemListarFrequencia);
		menuItemListarFrequencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.listarFrequencia();
			}
		});
		
		
		panel.add(menuBar);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public ListenerTopMenus getListener() {
		return listener;
	}

	public void setListener(ListenerTopMenus listener) {
		this.listener = listener;
	}
}






