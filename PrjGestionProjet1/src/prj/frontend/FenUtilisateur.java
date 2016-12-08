package prj.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.DAOException;
import prj.backend.exception.FacadeException;
import prj.backend.util.AppFunction;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FenUtilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField txtMembrePret;
	private JTextField txtIdLivrePret;
	private JTextField txtPret;
	private JTextField txtCatCategorie;
	private JTextField txtIdCategorie;
	private JTextField txtIdLivre;
	private JTextField txtTitreLivre;
	private JTextField txtAuteurLivre;
	private JTextField txtEditLivre;
	private JTextField txtLangue;
	private JTextField txtPlace;
	private JTextField txtDateParution;
	private JTextField txtIdMembre;
	private JTextField txtPrenomMembre;
	private JTextField txtNomMembre;
	private JTextField txtAdresseMembre;
	private JTextField txtLimite;
	private JTextField txtCourriel;
	private JTextField txtTel;
	private JTextField txtCode;
	private static AppFunction app = new AppFunction();

	/**
	 * Create the frame.
	 */
	public FenUtilisateur() {
		setResizable(false);
		try {
			app.loadDatabase();
		} catch (DAOException e3) {
			JOptionPane.showMessageDialog(null, e3.getMessage());
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 383);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					app.saveDatabase();
				} catch (DAOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				System.exit(0);
			}
		});
		mnOptions.add(mntmQuitter);
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
		
		txtIdMembre = new JTextField();
		txtIdMembre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				MembreDTO membreDTO = new MembreDTO();
				try {
					membreDTO = app.getMembreFacade().read(txtIdMembre.getText());
					txtNomMembre.setText(membreDTO.getNom());
					txtPrenomMembre.setText(membreDTO.getPrenom());
					txtCourriel.setText(membreDTO.getCourriel());
					txtAdresseMembre.setText(membreDTO.getAdresse());
					txtTel.setText(membreDTO.getTelephone());
					txtCode.setText(membreDTO.getCodePostal());
					txtLimite.setText(membreDTO.getLimitePret());
				} catch (FacadeException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		txtIdMembre.setColumns(10);
		txtIdMembre.setBounds(98, 11, 86, 20);
		MembrePanel.add(txtIdMembre);
		
		JLabel lblIdMembre = new JLabel("Id :");
		lblIdMembre.setBounds(10, 14, 78, 14);
		MembrePanel.add(lblIdMembre);
		
		JLabel lblPrenomMembre = new JLabel("Pr\u00E9nom  :");
		lblPrenomMembre.setBounds(10, 48, 78, 14);
		MembrePanel.add(lblPrenomMembre);
		
		txtPrenomMembre = new JTextField();
		txtPrenomMembre.setColumns(10);
		txtPrenomMembre.setBounds(98, 45, 86, 20);
		MembrePanel.add(txtPrenomMembre);
		
		txtNomMembre = new JTextField();
		txtNomMembre.setColumns(10);
		txtNomMembre.setBounds(98, 76, 86, 20);
		MembrePanel.add(txtNomMembre);
		
		JLabel lblNomMembre = new JLabel("Nom :");
		lblNomMembre.setBounds(10, 79, 78, 14);
		MembrePanel.add(lblNomMembre);
		
		JLabel lblAdresseMembre = new JLabel("Adresse :");
		lblAdresseMembre.setBounds(10, 110, 78, 14);
		MembrePanel.add(lblAdresseMembre);
		
		txtAdresseMembre = new JTextField();
		txtAdresseMembre.setColumns(10);
		txtAdresseMembre.setBounds(98, 107, 86, 20);
		MembrePanel.add(txtAdresseMembre);
		
		txtLimite = new JTextField();
		txtLimite.setColumns(10);
		txtLimite.setBounds(351, 107, 86, 20);
		MembrePanel.add(txtLimite);
		
		txtCourriel = new JTextField();
		txtCourriel.setColumns(10);
		txtCourriel.setBounds(351, 76, 86, 20);
		MembrePanel.add(txtCourriel);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(351, 45, 86, 20);
		MembrePanel.add(txtTel);
		
		txtCode = new JTextField();
		txtCode.setColumns(10);
		txtCode.setBounds(351, 11, 86, 20);
		MembrePanel.add(txtCode);
		
		JLabel lblCode = new JLabel("Code postal :");
		lblCode.setBounds(277, 14, 64, 14);
		MembrePanel.add(lblCode);
		
		JLabel lblTelephoneMembre = new JLabel("Telephone :");
		lblTelephoneMembre.setBounds(284, 48, 57, 14);
		MembrePanel.add(lblTelephoneMembre);
		
		JLabel lblCourriel = new JLabel("Courriel :");
		lblCourriel.setBounds(297, 79, 44, 14);
		MembrePanel.add(lblCourriel);
		
		JLabel lblLimiteDePret = new JLabel("Limite de pret :");
		lblLimiteDePret.setBounds(269, 110, 72, 14);
		MembrePanel.add(lblLimiteDePret);
		
		JButton btnInscrire = new JButton("Inscrire");
		btnInscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembreDTO membreDTO = new MembreDTO();
				membreDTO.setAdresse(txtAdresseMembre.getText());
				membreDTO.setPrenom(txtPrenomMembre.getText());
				membreDTO.setNom(txtNomMembre.getText());
				membreDTO.setCourriel(txtCourriel.getText());
				membreDTO.setCodePostal(txtCode.getText());
				membreDTO.setTelephone(txtTel.getText());
				membreDTO.setLimitePret(txtLimite.getText());
				try {
					app.getMembreFacade().inscrire(membreDTO);
					txtNomMembre.setText("");
					txtPrenomMembre.setText("");
					txtCourriel.setText("");
					txtAdresseMembre.setText("");
					txtTel.setText("");
					txtCode.setText("");
					txtLimite.setText("");
					JOptionPane.showMessageDialog(null, "Inscription réussie");
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());					
				}
			}
		});
		btnInscrire.setBounds(10, 188, 72, 23);
		MembrePanel.add(btnInscrire);
		
		JButton btnDesinscrire = new JButton("D\u00E9sinscrire");
		btnDesinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembreDTO membreDTO = new MembreDTO();
				membreDTO.setId(txtIdMembre.getText());
				try {
					app.getMembreFacade().desinscrire(membreDTO);
					JOptionPane.showMessageDialog(null, "Désinscription réussie");
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());	
				}
			}
		});
		btnDesinscrire.setBounds(112, 188, 89, 23);
		MembrePanel.add(btnDesinscrire);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembreDTO membreDTO = new MembreDTO();
				membreDTO.setIdMembre(txtIdMembre.getText());
				membreDTO.setAdresse(txtAdresseMembre.getText());
				membreDTO.setPrenom(txtPrenomMembre.getText());
				membreDTO.setNom(txtNomMembre.getText());
				membreDTO.setCourriel(txtCourriel.getText());
				membreDTO.setCodePostal(txtCode.getText());
				membreDTO.setTelephone(txtTel.getText());
				membreDTO.setLimitePret(txtLimite.getText());
				try {
					app.getMembreFacade().modifier(membreDTO);
					txtNomMembre.setText("");
					txtPrenomMembre.setText("");
					txtCourriel.setText("");
					txtAdresseMembre.setText("");
					txtTel.setText("");
					txtCode.setText("");
					txtLimite.setText("");
					JOptionPane.showMessageDialog(null, "Modification réussie");
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());					
				}
			}
		});
		btnModifier.setBounds(227, 188, 89, 23);
		MembrePanel.add(btnModifier);
		
		JButton btnListerTous = new JButton("Lister tous");
		btnListerTous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "ID\tNom\tPrénom\tAdresse\t\tCode Postal\tCourriel\t\tTelephone\tLimite de prêt";
				for(MembreDTO membreDTO : app.getMembreFacade().getAll()){
					msg += "\n"+membreDTO.getIdMembre()+"\t"+membreDTO.getNom()
					+"\t"+membreDTO.getPrenom()+"\t"+membreDTO.getAdresse()+"\t\t"
					+membreDTO.getCodePostal()+"\t"+membreDTO.getCourriel()+"\t\t"
					+membreDTO.getTelephone()+"\t"+membreDTO.getLimitePret();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnListerTous.setBounds(348, 188, 89, 23);
		MembrePanel.add(btnListerTous);
		
		JPanel LivrePanel = new JPanel();
		tabbedPane.addTab("Livre", null, LivrePanel, null);
		LivrePanel.setLayout(null);
		
		JComboBox<CategorieDTO> cBoxCat = new JComboBox<CategorieDTO>();
		cBoxCat.setBounds(121, 107, 86, 20);
		for(CategorieDTO categorieDTO: app.getCategorieFacade().getAll()){
			cBoxCat.addItem(categorieDTO);
		}
		LivrePanel.add(cBoxCat);
		
		txtIdLivre = new JTextField();
		txtIdLivre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				LivreDTO livreDTO = new LivreDTO();
				try {
					livreDTO = app.getLivreFacade().read(txtIdLivre.getText());
					txtTitreLivre.setText(livreDTO.getTitre());
					txtAuteurLivre.setText(livreDTO.getAuteur());
					txtLangue.setText(livreDTO.getLangue());
					txtDateParution.setText(livreDTO.getDateParution().toString());
					txtPlace.setText(livreDTO.getEmplacement());
					txtEditLivre.setText(livreDTO.getEditeur());
					cBoxCat.setSelectedItem(livreDTO.getCategorieDTO());
				} catch (FacadeException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		txtIdLivre.setColumns(10);
		txtIdLivre.setBounds(121, 11, 86, 20);
		LivrePanel.add(txtIdLivre);
		
		txtTitreLivre = new JTextField();
		txtTitreLivre.setColumns(10);
		txtTitreLivre.setBounds(121, 45, 86, 20);
		LivrePanel.add(txtTitreLivre);
		
		txtAuteurLivre = new JTextField();
		txtAuteurLivre.setColumns(10);
		txtAuteurLivre.setBounds(121, 76, 86, 20);
		LivrePanel.add(txtAuteurLivre);
		
		txtEditLivre = new JTextField();
		txtEditLivre.setColumns(10);
		txtEditLivre.setBounds(374, 11, 86, 20);
		LivrePanel.add(txtEditLivre);
		
		txtLangue = new JTextField();
		txtLangue.setColumns(10);
		txtLangue.setBounds(374, 45, 86, 20);
		LivrePanel.add(txtLangue);
		
		txtPlace = new JTextField();
		txtPlace.setColumns(10);
		txtPlace.setBounds(374, 76, 86, 20);
		LivrePanel.add(txtPlace);
		
		txtDateParution = new JTextField();
		txtDateParution.setColumns(10);
		txtDateParution.setBounds(374, 107, 86, 20);
		LivrePanel.add(txtDateParution);
		
		JLabel lblCatLivre = new JLabel("Cat\u00E9gorie :");
		lblCatLivre.setBounds(33, 110, 78, 14);
		LivrePanel.add(lblCatLivre);
		
		JLabel lblAuteurLivre = new JLabel("Auteur :");
		lblAuteurLivre.setBounds(33, 79, 78, 14);
		LivrePanel.add(lblAuteurLivre);
		
		JLabel lblTitreLivre = new JLabel("Titre  :");
		lblTitreLivre.setBounds(33, 48, 78, 14);
		LivrePanel.add(lblTitreLivre);
		
		JLabel lblIdLivre = new JLabel("Id :");
		lblIdLivre.setBounds(33, 14, 78, 14);
		LivrePanel.add(lblIdLivre);
		
		JLabel lblDateDeParution = new JLabel("Date de parution :");
		lblDateDeParution.setBounds(261, 110, 103, 14);
		LivrePanel.add(lblDateDeParution);
		
		JLabel lblPlace = new JLabel("Emplacement :");
		lblPlace.setBounds(286, 79, 78, 14);
		LivrePanel.add(lblPlace);
		
		JLabel lblLangue = new JLabel("Langue :");
		lblLangue.setBounds(286, 48, 78, 14);
		LivrePanel.add(lblLangue);
		
		JLabel lblEditLivre = new JLabel("\u00C9diteur :");
		lblEditLivre.setBounds(286, 14, 78, 14);
		LivrePanel.add(lblEditLivre);
		
		JRadioButton rbTitreLivre = new JRadioButton("");
		rbTitreLivre.setBounds(2, 44, 109, 23);
		rbTitreLivre.setActionCommand("rbTitreLivre");
		LivrePanel.add(rbTitreLivre);
		
		JRadioButton rbAuteur = new JRadioButton("");
		rbAuteur.setBounds(2, 75, 109, 23);
		rbAuteur.setActionCommand("rbAuteur");
		LivrePanel.add(rbAuteur);
		
		JRadioButton rbCatLivre = new JRadioButton("");
		rbCatLivre.setBounds(2, 106, 109, 23);
		rbCatLivre.setActionCommand("rbCatLivre");
		LivrePanel.add(rbCatLivre);
		
		JRadioButton rbEdit = new JRadioButton("");
		rbEdit.setBounds(238, 8, 109, 23);
		rbEdit.setActionCommand("rbEdit");
		LivrePanel.add(rbEdit);
		
		JRadioButton rbLangue = new JRadioButton("");
		rbLangue.setBounds(238, 42, 109, 23);
		rbLangue.setActionCommand("rbLangue");
		LivrePanel.add(rbLangue);
		
		JRadioButton rbPlace = new JRadioButton("");
		rbPlace.setBounds(238, 76, 109, 23);
		rbPlace.setActionCommand("rbPlace");
		LivrePanel.add(rbPlace);
		
		JRadioButton rbDate = new JRadioButton("");
		rbDate.setBounds(238, 107, 109, 23);
		rbDate.setActionCommand("rbDate");
		LivrePanel.add(rbDate);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbDate);
		btnGroup.add(rbEdit);
		btnGroup.add(rbPlace);
		btnGroup.add(rbLangue);
		btnGroup.add(rbCatLivre);
		btnGroup.add(rbAuteur);
		btnGroup.add(rbTitreLivre);
		
		
		
		JButton btnAjouterLivre = new JButton("Ajouter");
		btnAjouterLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivreDTO livreDTO = new LivreDTO();
				livreDTO.setTitre(txtTitreLivre.getText());
				livreDTO.setAuteur(txtAuteurLivre.getText());
				livreDTO.setEditeur(txtEditLivre.getText());
				livreDTO.setLangue(txtLangue.getText());
				livreDTO.setCategorieDTO((CategorieDTO) cBoxCat.getSelectedItem());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String str = txtDateParution.getText();
			    Date parsedDate;
				try {
					parsedDate = dateFormat.parse(str);
					Timestamp ts = new java.sql.Timestamp(parsedDate.getTime());
					livreDTO.setDateParution(ts);
				} catch (ParseException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			    livreDTO.setEmplacement(txtPlace.getText());
				try {
					app.getLivreFacade().acquerir(livreDTO);
					txtNomMembre.setText("");
					txtPrenomMembre.setText("");
					txtCourriel.setText("");
					txtAdresseMembre.setText("");
					txtTel.setText("");
					txtCode.setText("");
					txtLimite.setText("");
					JOptionPane.showMessageDialog(null, "Ajout réussie");
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());					
				}
			}
		});
		btnAjouterLivre.setBounds(33, 202, 89, 23);
		LivrePanel.add(btnAjouterLivre);
		
		JButton btnSupprimerLivre = new JButton("Supprimer");
		btnSupprimerLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					LivreDTO livreDTO = new LivreDTO();
					livreDTO.setId(txtIdLivre.getText());
					try {
						app.getLivreFacade().vendre(livreDTO);
						JOptionPane.showMessageDialog(null, "Suppression réussie");
					} catch (FacadeException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());	
					}
				}
			});
		btnSupprimerLivre.setBounds(139, 202, 89, 23);
		LivrePanel.add(btnSupprimerLivre);
		
		JButton btnListerToutLivre = new JButton("Lister tout");
		btnListerToutLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "ID\tTitre\tAuteur\tCategorie\tÉditeur\tLangue\tEmplacement\tDate de parution";
				for(LivreDTO livreDTO : app.getLivreFacade().getAll()){
					msg += "\n"+livreDTO.getIdLivre()+"\t"+livreDTO.getTitre()
					+"\t"+livreDTO.getAuteur()+"\t"+livreDTO.getCategorieDTO().getNomCategorie()+"\t"
					+livreDTO.getEditeur()+"\t"+livreDTO.getLangue()+"\t"
					+livreDTO.getEmplacement()+"\t"+livreDTO.getDateParution();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnListerToutLivre.setBounds(238, 202, 89, 23);
		LivrePanel.add(btnListerToutLivre);
		
		JButton btnListerChampLivre = new JButton("Lister champ");
		btnListerChampLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivreDTO livreDTO = new LivreDTO();
				livreDTO.setIdLivre(txtIdLivre.getText());
				livreDTO.setTitre(txtTitreLivre.getText());
				livreDTO.setAuteur(txtAuteurLivre.getText());
				livreDTO.setEditeur(txtEditLivre.getText());
				livreDTO.setLangue(txtLangue.getText());
				livreDTO.setCategorieDTO((CategorieDTO) cBoxCat.getSelectedItem());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String str = txtDateParution.getText();
			    Date parsedDate;
				try {
					parsedDate = dateFormat.parse(str);
					Timestamp ts = new java.sql.Timestamp(parsedDate.getTime());
					livreDTO.setDateParution(ts);
				} catch (ParseException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			    livreDTO.setEmplacement(txtPlace.getText());
				
			    String msg = "ID\tTitre\tAuteur\tCategorie\tÉditeur\tLangue\tEmplacement\tDate de parution";
				for(LivreDTO unlivreDTO : app.getLivreFacade().findByForm(livreDTO)){
					msg += "\n"+unlivreDTO.getIdLivre()+"\t"+unlivreDTO.getTitre()
					+"\t"+unlivreDTO.getAuteur()+"\t"+unlivreDTO.getCategorieDTO().getNomCategorie()+"\t"
					+unlivreDTO.getEditeur()+"\t"+unlivreDTO.getLangue()+"\t"
					+unlivreDTO.getEmplacement()+"\t"+unlivreDTO.getDateParution();
				}
				JOptionPane.showMessageDialog(null, msg);				
				
			}
		});
		btnListerChampLivre.setBounds(348, 202, 100, 23);
		LivrePanel.add(btnListerChampLivre);
		
		JButton btnSuppCatLivre = new JButton("Supprimer selon la categorie");
		btnSuppCatLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					app.getLivreFacade().deleteAllInCategorie((CategorieDTO)cBoxCat.getSelectedItem());
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Suppression réussie");
			}
		});
		btnSuppCatLivre.setBounds(149, 242, 173, 23);
		LivrePanel.add(btnSuppCatLivre);
		
		JButton btnListerSelection = new JButton("Lister Selection");
		btnListerSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<LivreDTO> search= new ArrayList<LivreDTO>();
				String msg = "ID\tTitre\tAuteur\tCategorie\tÉditeur\tLangue\tEmplacement\tDate de parution";
				switch (btnGroup.getSelection().getActionCommand()) {
	            case "rbTitreLivre":  search = app.getLivreFacade().findByTitre(txtTitreLivre.getText());
	                     break;
	            case "rbAuteur":  search = app.getLivreFacade().findByAuteur(txtAuteurLivre.getText());
	                     break;
	            case "rbCatLivre":  search = app.getLivreFacade().findByCategorie((CategorieDTO)cBoxCat.getSelectedItem());
	                     break;
	            case "rbEdit":  search = app.getLivreFacade().findByEditeur(txtEditLivre.getText());
	                     break;
	            case "rbLangue":  search = app.getLivreFacade().findByLangue(txtLangue.getText());
	                     break;
	            case "rbPlace":  search = app.getLivreFacade().findByEmplacement(txtPlace.getText());
	                     break;
	            case "rbDate":  String str = txtDateParution.getText();
	            				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            				Date parsedDate;
	            				try {
	            					parsedDate = dateFormat.parse(str);
	            					Timestamp ts = new java.sql.Timestamp(parsedDate.getTime());
	            					search = app.getLivreFacade().findByDateParution(ts);
	            				} catch (ParseException e2) {
	            					JOptionPane.showMessageDialog(null, e2.getMessage());
	            				}
	            		 break;
	        }
				for(LivreDTO livreDTO : search){
					msg += "\n"+livreDTO.getIdLivre()+"\t"+livreDTO.getTitre()
					+"\t"+livreDTO.getAuteur()+"\t"+livreDTO.getCategorieDTO().getNomCategorie()+"\t"
					+livreDTO.getEditeur()+"\t"+livreDTO.getLangue()+"\t"
					+livreDTO.getEmplacement()+"\t"+livreDTO.getDateParution();
				}
				JOptionPane.showMessageDialog(null, msg);	
			}
		});
		btnListerSelection.setBounds(22, 242, 117, 23);
		LivrePanel.add(btnListerSelection);
		
		
		
		JPanel CategoriePanel = new JPanel();
		tabbedPane.addTab("Categorie", null, CategoriePanel, null);
		CategoriePanel.setLayout(null);
		
		JLabel lblCatCategorie = new JLabel("Cat\u00E9gorie :");
		lblCatCategorie.setBounds(128, 47, 78, 14);
		CategoriePanel.add(lblCatCategorie);
		
		txtCatCategorie = new JTextField();
		txtCatCategorie.setBounds(229, 44, 86, 20);
		CategoriePanel.add(txtCatCategorie);
		txtCatCategorie.setColumns(10);
		
		JButton btnAjouterCat = new JButton("Ajouter");
		btnAjouterCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategorieDTO catDTO = new CategorieDTO();
				catDTO.setNomCategorie(txtCatCategorie.getText());
				try {
					app.getCategorieFacade().ajouter(catDTO);
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Ajout réussie");
			}
		});
		btnAjouterCat.setBounds(64, 135, 89, 23);
		CategoriePanel.add(btnAjouterCat);
		
		JButton btnSupprimerCat = new JButton("Supprimer");
		btnSupprimerCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategorieDTO catDTO = new CategorieDTO();
				catDTO.setIdCategorie(txtIdCategorie.getText());
				try {
					app.getCategorieFacade().supprimer(catDTO);
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Suppression réussie");
			}
		});
		btnSupprimerCat.setBounds(181, 135, 89, 23);
		CategoriePanel.add(btnSupprimerCat);
		
		JButton btnListerCategorie = new JButton("Lister");
		btnListerCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String msg= "ID\tCatégorie";
				for(CategorieDTO catDTO : app.getCategorieFacade().getAll()){
					msg += "\n"+catDTO.getIdCategorie()+"\t"+catDTO.getNomCategorie();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnListerCategorie.setBounds(304, 135, 89, 23);
		CategoriePanel.add(btnListerCategorie);
		
		JLabel lblWarningCategorie = new JLabel("");
		lblWarningCategorie.setBounds(39, 260, 397, 14);
		CategoriePanel.add(lblWarningCategorie);
		
		JLabel lblIdCategorie = new JLabel("Num de categorie :");
		lblIdCategorie.setBounds(100, 72, 106, 14);
		CategoriePanel.add(lblIdCategorie);
		
		txtIdCategorie = new JTextField();
		txtIdCategorie.setColumns(10);
		txtIdCategorie.setBounds(229, 69, 86, 20);
		CategoriePanel.add(txtIdCategorie);
		
		JPanel PretPanel = new JPanel();
		tabbedPane.addTab("Prêt", null, PretPanel, null);
		PretPanel.setLayout(null);
		
		JLabel lblNumroDeMembre = new JLabel("Num\u00E9ro de membre : ");
		lblNumroDeMembre.setBounds(54, 11, 111, 25);
		PretPanel.add(lblNumroDeMembre);
		
		txtMembrePret = new JTextField();
		txtMembrePret.setBounds(228, 13, 86, 20);
		PretPanel.add(txtMembrePret);
		txtMembrePret.setColumns(10);
		
		JLabel lblIdLivrePret = new JLabel("Num\u00E9ro de livre :");
		lblIdLivrePret.setBounds(73, 33, 92, 25);
		PretPanel.add(lblIdLivrePret);
		
		txtIdLivrePret = new JTextField();
		txtIdLivrePret.setBounds(228, 35, 86, 20);
		PretPanel.add(txtIdLivrePret);
		txtIdLivrePret.setColumns(10);
		
		JLabel lblWarningPret = new JLabel("");
		lblWarningPret.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningPret.setBounds(54, 181, 304, 14);
		PretPanel.add(lblWarningPret);
		
		JButton btnPret = new JButton("Pr\u00EAter");
		btnPret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretDTO pretDTO = new PretDTO();
				try {
					pretDTO.setLivreDTO(app.getLivreFacade().read(txtIdLivrePret.getText()));
					pretDTO.setMembreDTO(app.getMembreFacade().read(txtMembrePret.getText()));
					app.getPretFacade().creer(pretDTO);
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Prêt réussi");
				
			}
		});
		btnPret.setBounds(10, 131, 89, 23);
		PretPanel.add(btnPret);
		
		JButton btnRetour = new JButton("Retourner");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretDTO pretDTO = new PretDTO();
				try {
					pretDTO.setIdPret(txtPret.getText());
					app.getPretFacade().retourner(pretDTO);
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Retour réussie");
			}
		});
		btnRetour.setBounds(109, 131, 89, 23);
		PretPanel.add(btnRetour);
		
		JButton btnListePret = new JButton("Lister");
		btnListePret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg= "ID de Pret\tTitre de Livre\tPrénom et Nom de Membre";
				for(PretDTO pretDTO : app.getPretFacade().getAll()){
					try {
						msg += "\n"+pretDTO.getIdPret()+"\t"+pretDTO.getLivreDTO().getTitre()
							  +"\t"+pretDTO.getMembreDTO().getPrenom()+" "+pretDTO.getMembreDTO().getNom()
							  +"\t"+ app.getPretFacade().calculerFraisRetard(pretDTO)+ " $";
					} catch (FacadeException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnListePret.setBounds(208, 131, 89, 23);
		PretPanel.add(btnListePret);
		
		JButton btnPayer = new JButton("Payer");
		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretDTO pretDTO = new PretDTO();
				try {
					pretDTO.setIdPret(txtPret.getText());
					app.getPretFacade().payer(pretDTO);
				} catch (FacadeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Paiement réussi");
			}
		});
		btnPayer.setBounds(307, 131, 89, 23);
		PretPanel.add(btnPayer);
		
		JLabel lblNumroDePret = new JLabel("Num\u00E9ro de pr\u00EAt :");
		lblNumroDePret.setBounds(74, 60, 91, 14);
		PretPanel.add(lblNumroDePret);
		
		txtPret = new JTextField();
		txtPret.setColumns(10);
		txtPret.setBounds(228, 57, 86, 20);
		PretPanel.add(txtPret);
		this.setVisible(true);
	}
}
