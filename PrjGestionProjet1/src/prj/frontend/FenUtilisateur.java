package prj.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FenUtilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField txtMembre;
	private JTextField txtLivre;
	private JTextField txtPret;
	private JTextField txtCategorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenUtilisateur frame = new FenUtilisateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenUtilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 475, 325);
		contentPane.add(tabbedPane);
		
		JPanel MembrePanel = new JPanel();
		tabbedPane.addTab("Membre", null, MembrePanel, null);
		MembrePanel.setLayout(null);
		
		JPanel LivrePanel = new JPanel();
		tabbedPane.addTab("Livre", null, LivrePanel, null);
		LivrePanel.setLayout(null);
		
		JPanel CategoriePanel = new JPanel();
		tabbedPane.addTab("Categorie", null, CategoriePanel, null);
		CategoriePanel.setLayout(null);
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie :");
		lblCategorie.setBounds(128, 47, 78, 14);
		CategoriePanel.add(lblCategorie);
		
		txtCategorie = new JTextField();
		txtCategorie.setBounds(229, 44, 86, 20);
		CategoriePanel.add(txtCategorie);
		txtCategorie.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(64, 135, 89, 23);
		CategoriePanel.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(181, 135, 89, 23);
		CategoriePanel.add(btnSupprimer);
		
		JButton btnListerCategorie = new JButton("Lister");
		btnListerCategorie.setBounds(304, 135, 89, 23);
		CategoriePanel.add(btnListerCategorie);
		
		JLabel lblWarningCategorie = new JLabel("");
		lblWarningCategorie.setBounds(39, 260, 397, 14);
		CategoriePanel.add(lblWarningCategorie);
		
		JPanel PretPanel = new JPanel();
		tabbedPane.addTab("Prêt", null, PretPanel, null);
		PretPanel.setLayout(null);
		
		JLabel lblNumroDeMembre = new JLabel("Num\u00E9ro de membre : ");
		lblNumroDeMembre.setBounds(54, 11, 111, 25);
		PretPanel.add(lblNumroDeMembre);
		
		txtMembre = new JTextField();
		txtMembre.setBounds(228, 13, 86, 20);
		PretPanel.add(txtMembre);
		txtMembre.setColumns(10);
		
		JLabel lblNumroDeLivre = new JLabel("Num\u00E9ro de livre :");
		lblNumroDeLivre.setBounds(73, 33, 92, 25);
		PretPanel.add(lblNumroDeLivre);
		
		txtLivre = new JTextField();
		txtLivre.setBounds(228, 35, 86, 20);
		PretPanel.add(txtLivre);
		txtLivre.setColumns(10);
		
		JLabel lblWarningPret = new JLabel("");
		lblWarningPret.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningPret.setBounds(54, 181, 304, 14);
		PretPanel.add(lblWarningPret);
		
		JButton btnPret = new JButton("Pr\u00EAter");
		btnPret.setBounds(10, 131, 89, 23);
		PretPanel.add(btnPret);
		
		JButton btnRetour = new JButton("Retourner");
		btnRetour.setBounds(109, 131, 89, 23);
		PretPanel.add(btnRetour);
		
		JButton btnListePret = new JButton("Lister");
		btnListePret.setBounds(208, 131, 89, 23);
		PretPanel.add(btnListePret);
		
		JButton btnPayer = new JButton("Payer");
		btnPayer.setBounds(307, 131, 89, 23);
		PretPanel.add(btnPayer);
		
		JLabel lblNumroDePrt = new JLabel("Num\u00E9ro de pr\u00EAt :");
		lblNumroDePrt.setBounds(74, 60, 91, 14);
		PretPanel.add(lblNumroDePrt);
		
		txtPret = new JTextField();
		txtPret.setColumns(10);
		txtPret.setBounds(228, 57, 86, 20);
		PretPanel.add(txtPret);
	}
}
