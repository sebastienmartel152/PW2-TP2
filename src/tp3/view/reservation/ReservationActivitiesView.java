package tp3.view.reservation;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp3.controller.ReservationController;
import tp3.view.DTO.DTOActivities;

@SuppressWarnings("serial")
public class ReservationActivitiesView extends ReservationView {
	
	private final String MAIN_LABEL_TEXT = "Voici les activités offertes en option:";
	
	private final String FLY_FISHING_ACTIVITY_TEXT = "Pêche à la mouche";
	private final String BLACK_BEAR_ACTIVITY_TEXT = "Observation de l'ours noir";
	private final String WOLF_OBSERVATION_ACTIVITY_TEXT = "Observation des loups";
	
	private JCheckBox flyFishingActivityCheckbox;
	private JCheckBox blackBearActivityCheckbox;
	private JCheckBox wolfObservationActivityCheckbox;
	
	private ReservationController reservationController;
	
	public ReservationActivitiesView(ReservationController reservationController){
		super();
		this.reservationController = reservationController;
		
		this.setupFormPanel();
	}
	
	private void setupFormPanel(){
		JLabel mainLabel = new JLabel(MAIN_LABEL_TEXT);
		this.add(mainLabel, BorderLayout.NORTH);
		
		JPanel formPanel = new JPanel(new GridLayout(0,2));
		
		flyFishingActivityCheckbox = new JCheckBox();
		blackBearActivityCheckbox = new JCheckBox();
		wolfObservationActivityCheckbox = new JCheckBox();
		
		JLabel flyFishingActivityLabel = new JLabel(FLY_FISHING_ACTIVITY_TEXT);
		JLabel blackBearActivityLabel = new JLabel(BLACK_BEAR_ACTIVITY_TEXT);
		JLabel wolfObservationActivityLabel = new JLabel(WOLF_OBSERVATION_ACTIVITY_TEXT);
		
		formPanel.add(flyFishingActivityLabel);
		formPanel.add(flyFishingActivityCheckbox);
		formPanel.add(blackBearActivityLabel);
		formPanel.add(blackBearActivityCheckbox);
		formPanel.add(wolfObservationActivityLabel);
		formPanel.add(wolfObservationActivityCheckbox);
	
		this.add(formPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void sendInformation() {
		DTOActivities = new DTOActivities(this.flyFishingActivityCheckbox.isSelected(),
				this.blackBearActivityCheckbox.isSelected(), this.wolfObservationActivityCheckbox.isSelected());
		
	}

}
