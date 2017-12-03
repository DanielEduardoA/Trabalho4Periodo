package br.edu.univas.escola.controller;

import br.edu.univas.escola.listener.ListenerTopMenus;
import br.edu.univas.escola.view.MainView;

public class MainController {

	private MainView mainView;
	
	public MainController() {
		mainView = new MainView();
	}
	
	public void initApplication() {
		mainView.setListener(new ListenerTopMenus() {
			
			@Override
			public void listarNota() {
				showListNotaPanel();
			}
			
			@Override
			public void listarFrequencia() {
				showListFrequenciaPanel();
			}
			
			@Override
			public void listarDisciplina() {
				showListDisciplinaPanel();
			}
			
			@Override
			public void listarAluno() {
				showListAlunoPanel();
			}
			
			@Override
			public void lancarNota() {
				showAddNotaPanel();
			}
			
			@Override
			public void lancarFrequencia() {
				showAddFrequenciaPanel();
			}
			
			@Override
			public void cadastrarDisciplina() {
				showAddDisciplinaPanel();
			}
			
			@Override
			public void cadastrarAluno() {
				showAddAlunoPanel();
			}
		});
		mainView.setVisible(true);
	}
	
	private void showListAlunoPanel() {
		ListAlunoController listAlunoController = new ListAlunoController();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(listAlunoController.getComponent());
		mainView.revalidate();
	}
	private void showListDisciplinaPanel() {
		ListDisciplinaController listDisciplinaController = new ListDisciplinaController();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(listDisciplinaController.getComponent());
		mainView.revalidate();
	}
	private void showListFrequenciaPanel() {
		ListFrequenciaController listFrequenciaController = new ListFrequenciaController();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(listFrequenciaController.getComponent());
		mainView.revalidate();
	}
	private void showListNotaPanel() {
		ListNotaController listNotaController = new ListNotaController();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(listNotaController.getComponent());
		mainView.revalidate();
	}
	
	private void showAddAlunoPanel() {
		AddAlunoController addAlunoController = new AddAlunoController();
		addAlunoController.init();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(addAlunoController.getComponent());
		mainView.revalidate();
	}
	
	private void showAddDisciplinaPanel() {
		AddDisciplinaController addDisciplinaController = new AddDisciplinaController();
		addDisciplinaController.init();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(addDisciplinaController.getComponent());
		mainView.revalidate();
	}
	
	private void showAddNotaPanel() {
		LancarNotaController addNotaController = new LancarNotaController();
		addNotaController.init();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(addNotaController.getComponent());
		mainView.revalidate();
	}
	
	private void showAddFrequenciaPanel() {
		LancarFrequenciaController addFrequenciaController = new LancarFrequenciaController();
		addFrequenciaController.init();
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(addFrequenciaController.getComponent());
		mainView.revalidate();
	}

}
