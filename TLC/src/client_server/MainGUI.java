package client_server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel sfondo;
	private JTextField ip_txt;
	private JTextField myname;
	private JButton contatta_btn;
	private JList<Contatto> contatti_list;
	private JScrollPane scrollPane;
	private Vector<Contatto> vettoreContatti;

	public MainGUI(JList<Contatto> contatti) {
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setFont(new Font("Agency FB", Font.PLAIN, 18));
		new Welcome();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sfondo = new SfondoMain();
		sfondo.setBackground(Color.WHITE);
		setContentPane(sfondo);
		setTitle("TLC Kali Chat v. 0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 650, 750);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/Marco/workspace/TLC/src/kali.png"));

		sfondo.setBorder(new EmptyBorder(50, 50, 50, 50));
		sfondo.setLayout(null);
		
		ip_txt = new JTextField();
		ip_txt.setBounds(125, 166, 375, 31);
		sfondo.add(ip_txt);
		ip_txt.setColumns(10);
		ip_txt.setToolTipText("Inserisci l'indirizzo IP da contattare");
		
		JLabel lblNewLabel = new JLabel("IP  :");
		lblNewLabel.setFont(new Font("Computerfont", Font.PLAIN, 26));
		lblNewLabel.setBounds(41, 171, 56, 16);
		sfondo.add(lblNewLabel);
		
		contatta_btn = new JButton("CONTATTA");
		contatta_btn.setBackground(Color.BLACK);
		contatta_btn.setFont(new Font("Arial Black", Font.BOLD, 10));
		contatta_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contatta_btn.setBounds(512, 170, 108, 25);
		sfondo.add(contatta_btn);
		
		myname = new JTextField();
		myname.setToolTipText("Scegli il tuo nome");
		myname.setBounds(125, 116, 375, 31);
		sfondo.add(myname);
		myname.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Computerfont", Font.PLAIN, 26));
		lblNome.setBounds(22, 114, 116, 30);
		sfondo.add(lblNome);
		
		scrollPane = new JScrollPane();
		scrollPane.setName("");
		scrollPane.setFont(new Font("Arial Narrow", Font.ITALIC, 16));
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(12, 299, 608, 391);
		sfondo.add(scrollPane);
		
		this.contatti_list = contatti;
		scrollPane.setViewportView(contatti_list);
		
		JLabel lblContatti = new JLabel("Contatti Disponibili ");
		lblContatti.setFont(new Font("Computerfont", Font.PLAIN, 30));
		lblContatti.setBounds(12, 210, 234, 110);
		sfondo.add(lblContatti);
		
		JLabel lblWelcome = new JLabel("\tWelcome! ");
		lblWelcome.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 27));
		lblWelcome.setBounds(268, 13, 116, 31);
		sfondo.add(lblWelcome);
		
		JLabel lblInserisciIlTuo = new JLabel("Inserisci il tuo nome nella relativa casella e un indirizzo IP fra quelli disponibili");
		lblInserisciIlTuo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
		lblInserisciIlTuo.setBounds(12, 48, 608, 31);
		sfondo.add(lblInserisciIlTuo);
		
		JLabel lblFraQuelliDisponibili = new JLabel("per avviare una chat.");
		lblFraQuelliDisponibili.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
		lblFraQuelliDisponibili.setBounds(12, 76, 608, 25);
		sfondo.add(lblFraQuelliDisponibili);
		
		setVisible(true);
	}
	public void setVettoreContatti(Vector<Contatto> vettore){
		this.vettoreContatti=vettore;
	}
	public JButton getContattaBtn(){
		return contatta_btn;
	}
	public JTextField getIP(){
		return ip_txt;
	}
	public String getMyName(){
		return myname.getText();
	}
	public void setIP(String ip) {
		ip_txt.setText(ip);
		
	} 
}
