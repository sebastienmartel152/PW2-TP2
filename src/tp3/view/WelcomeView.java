package tp3.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tp3.controller.WelcomeController;
import tp3.util.image.ImageUtil;


@SuppressWarnings("serial")
public class WelcomeView extends JFrame implements ActionListener {
	
	private static final String FONT_VALUE = "Arial";

	private WelcomeController welcomeController;
	
	private static final String VIEW_TITLE = "Bienvenue à la pourvoirie";
	private static final String WELCOME_MESSAGE = "Bienvenue à la pourvoirie des Lacs-à-Basiles!";
	private static final String TEXT_BUTTON_ADMIN = "Administration...";	
	private static final String TEXT_BUTTON_RESERVE = "Réserver un chalet...";
	
	private static final String WELCOME_PICTURE = "../resource/pourvoirie.jpg";
	
	private static final String ACTION_ADMIN = "ADMIN";
	private static final String ACTION_RESERVE = "RESERVE";

	private static final Point DEFAULT_LOCATION = new Point(200, 30);
	private static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
	
	public WelcomeView(WelcomeController welcomeController){
		super();
		this.welcomeController = welcomeController;
		
		this.initialize();
		this.setUpComponents();
		
	}
	
	private void initialize(){
		this.setTitle(WelcomeView.VIEW_TITLE);
		this.setLocation(WelcomeView.DEFAULT_LOCATION);
		this.setSize(WelcomeView.DEFAULT_SIZE);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setUpComponents(){
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel);
		
		welcomePanel.setLayout(new BorderLayout());   // Strategy pattern
		
		JLabel welcomePicture = new JLabel(ImageUtil.getImageIcon(this, WelcomeView.WELCOME_PICTURE));		
		welcomePanel.add(welcomePicture);
		
		JLabel welcomeMessage = new JLabel(WelcomeView.WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomeMessage.setFont(new Font(FONT_VALUE, Font.PLAIN, 20));
		
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);	
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton adminButton = new JButton(TEXT_BUTTON_ADMIN);
		adminButton.addActionListener(this);
		adminButton.setActionCommand(ACTION_ADMIN);
		actionPanel.add(adminButton);
		
		JButton reserveButton = new JButton(TEXT_BUTTON_RESERVE);
		reserveButton.addActionListener(this);
		reserveButton.setActionCommand(ACTION_RESERVE);
		actionPanel.add(reserveButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case ACTION_ADMIN:
			this.welcomeController.showAdminView();
			break;
		case ACTION_RESERVE:
			this.welcomeController.showReservationView();
			break;
		}
		
	}	
	
}
