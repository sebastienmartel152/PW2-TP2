package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp3.controller.ReservationController;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.TransportType;

@SuppressWarnings("serial")
public class ReservationBaseInfoView extends JPanel {
	
	private ReservationController reservationController;
	
	// Textes des labels du formulaire
	
	public static final String COTTAGE_TYPE_TEXT = "Type de chalet";
	public static final String NUMBER_OF_PEOPLE_TEXT = "Nombre de personnes";
	public static final String NUMBER_OF_NIGHTS_TEXT = "Nombre de nuits";
	public static final String TRANSPORT_TYPE_TO_TEXT = "Type de transport (allé)";
	public static final String TRANSPORT_TYPE_BACK_TEXT = "Type de transport (retour)";
	public static final String BREAKFAST_OPTION_TEXT = "Option déjeûner/dîner";
	public static final String GASTRONOMIC_SUPPER_OPTION_TEXT = "Option souper gastronomic";
	
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
	
}
