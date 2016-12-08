package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp3.controller.ReservationController;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.TransportType;
import tp3.view.DTO.DTOBaseInfo;

@SuppressWarnings("serial")
public class ReservationBaseInfoView extends ReservationView implements ActionListener {
	
	private ReservationController reservationController;
	
	// Textes des labels du formulaire
	
	private static final String COTTAGE_TYPE_TEXT = "Type de chalet";
	private static final String NUMBER_OF_PEOPLE_TEXT = "Nombre de personnes";
	private static final String NUMBER_OF_NIGHTS_TEXT = "Nombre de nuits";
	private static final String TRANSPORT_TYPE_TO_TEXT = "Type de transport (allé)";
	private static final String TRANSPORT_TYPE_BACK_TEXT = "Type de transport (retour)";
	private static final String BREAKFAST_OPTION_TEXT = "Option déjeûner/dîner";
	private static final String GASTRONOMIC_SUPPER_OPTION_TEXT = "Option souper gastronomic";

	private static final String COTTAGE_TYPE_SELECTED = "COTTAGE_TYPE_SELECTED";
	
	// Composantes du formulaires
	
	private JComboBox<CottageType> cottageTypeCombo;
	private JComboBox<Integer> numberOfPeopleCombo;
	private JTextField numberOfNightsInput;
	private JComboBox<TransportType> transportTypeToCombo;
	private JComboBox<TransportType> transportTypeBackCombo;
	private JCheckBox breakfastDinnerCheckBox;
	private JCheckBox gastronomicSupperCheckBox;
	
	
	public ReservationBaseInfoView(ReservationController reservationController){
		super();
		
		this.setupFormPanel();
		this.reservationController = reservationController;
	}

	private void setupFormPanel() {
		JPanel formPanel = new JPanel(new GridLayout(0, 2));
		
		JLabel cottageTypeLabel = new JLabel(COTTAGE_TYPE_TEXT);
		JLabel numberOfPeopleLabel = new JLabel(NUMBER_OF_PEOPLE_TEXT);
		JLabel numberOfNightsLabel = new JLabel(NUMBER_OF_NIGHTS_TEXT);
		JLabel transportToLabel = new JLabel(TRANSPORT_TYPE_TO_TEXT);
		JLabel transportFromLabel = new JLabel(TRANSPORT_TYPE_BACK_TEXT);
		JLabel breakfastDinnerOptionLabel = new JLabel(BREAKFAST_OPTION_TEXT);
		JLabel gastronomicSupperOptionLabel = new JLabel(GASTRONOMIC_SUPPER_OPTION_TEXT);
		
		cottageTypeCombo = new JComboBox<CottageType>(CottageType.values());
		numberOfPeopleCombo = new JComboBox<Integer>();
		numberOfNightsInput = new JTextField("1");
		
		transportTypeToCombo = new JComboBox<TransportType>(TransportType.values());
		transportTypeBackCombo = new JComboBox<TransportType>(TransportType.values());
		breakfastDinnerCheckBox = new JCheckBox();
		gastronomicSupperCheckBox = new JCheckBox();
		
		updateNumberOfPeopleCombo((CottageType) this.cottageTypeCombo.getSelectedItem());
		
		cottageTypeCombo.addActionListener(this);
		cottageTypeCombo.setActionCommand(COTTAGE_TYPE_SELECTED);
		
		formPanel.add(cottageTypeLabel);
		formPanel.add(cottageTypeCombo);
		formPanel.add(numberOfPeopleLabel);
		formPanel.add(numberOfPeopleCombo);
		formPanel.add(numberOfNightsLabel);
		formPanel.add(numberOfNightsInput);
		formPanel.add(transportToLabel);
		formPanel.add(transportTypeToCombo);
		formPanel.add(transportFromLabel);
		formPanel.add(transportTypeBackCombo);
		formPanel.add(breakfastDinnerOptionLabel);
		formPanel.add(breakfastDinnerCheckBox);
		formPanel.add(gastronomicSupperOptionLabel);
		formPanel.add(gastronomicSupperCheckBox);
		
		this.add(formPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case COTTAGE_TYPE_SELECTED:
			// Mettre à jour numberOfPeopleCombo selon le type de chalet sélectionné
			CottageType newCottageType = (CottageType) cottageTypeCombo.getSelectedItem();
			updateNumberOfPeopleCombo(newCottageType);
			
			break;
		}
		
	}

	private void updateNumberOfPeopleCombo(CottageType selectedCottageType) {
		int newMax = selectedCottageType.getMaxNumberOfPeople();
		
		this.numberOfPeopleCombo.removeAllItems();
		
		for(int i=1;i<=newMax;i++){
			this.numberOfPeopleCombo.addItem(i);
		}
	}
	
	private boolean validateInputs(){
		boolean inputsAreCorrect = true;
		
		try{
			Integer.parseInt(this.numberOfNightsInput.getText());
		}catch(NumberFormatException e){
			inputsAreCorrect = false;
			JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre!");
		}
		
		return inputsAreCorrect;
	}
	
	public DTOBaseInfo getBaseInfoDTO(){
		CottageType cottageType = (CottageType) this.cottageTypeCombo.getSelectedItem();
		TransportType transportTypeTo = (TransportType) this.transportTypeToCombo.getSelectedItem();
		TransportType transportTypeBack = (TransportType) this.transportTypeBackCombo.getSelectedItem();
		int numberOfPeople = this.numberOfPeopleCombo.getSelectedIndex();
		int numberOfNights = Integer.parseInt(this.numberOfNightsInput.getText());
		boolean breakfastDinnerOption = this.breakfastDinnerCheckBox.isSelected();
		boolean gastronomicSupperOption = this.gastronomicSupperCheckBox.isSelected();
		
		return new DTOBaseInfo(cottageType, numberOfPeople, numberOfNights, 
				transportTypeTo, transportTypeBack, breakfastDinnerOption, gastronomicSupperOption);
	}
	
	@Override
	public void sendInformation(){
		if(validateInputs()){
			this.reservationController.receiveBaseInfo(getBaseInfoDTO());
		}
	}
}
