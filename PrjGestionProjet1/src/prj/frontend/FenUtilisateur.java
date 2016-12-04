package prj.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenUtilisateur extends JFrame{
	
	/**
	 * Create the frame.
	 */
	JDesktopPane desktop;
	public FenUtilisateur() {
		super("Gestion des employés");
		setSize(600,400);
		initComponents();
		desktop = new JDesktopPane();
		add(desktop);
		setVisible(true);
	}



	private void initComponents() {
		// TODO Auto-generated method stub
		JMenuBar mBar;
		JMenu mOption;
		JMenuItem mEmprunt;
		JMenuItem mRetour;
		JMenuItem mInscrire;
		JMenuItem mQuitter;
		
		mBar = new JMenuBar();
		mOption = new JMenu("Options");
		mEmprunt = new JMenuItem("Emprunter");
		mEmprunt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FenEmprunt emprunt = new FenEmprunt();
				desktop.add(emprunt);
				desktop.setSelectedFrame(emprunt);
			}
		});
		mRetour = new JMenuItem("Retourner");
		mRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FenRetour retour = new FenRetour();
				desktop.add(retour);
				desktop.setSelectedFrame(retour);
			}
		});
		mInscrire = new JMenuItem("Inscription");
		mInscrire.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FenInscription inscrire = new FenInscription();
				desktop.add(inscrire);
				desktop.setSelectedFrame(inscrire);
			}
		});
		mQuitter = new JMenuItem("Quitter");
		mQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//Ajout des options de menu
		mOption.add(mEmprunt);
		mOption.add(mRetour);
		mOption.add(mInscrire);
		mOption.add(mQuitter);
		//Ajout menu Personnel dans la barre de menus
		mBar.add(mOption);
		//Ajout barre de menu a la fenetre
		setJMenuBar(mBar);
	}

}
