package calculator.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	public JPanel conteinerPanel = new JPanel();
	private MainPanel mainPanel = new MainPanel();
	private RadioPanel radioPanel = new RadioPanel();
	private CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
	private RadioFoodSportPanel radioFoodSportPanel = new RadioFoodSportPanel();

	private GridBagConstraints gbc = new GridBagConstraints();

	private Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();

	
	public View() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);

		conteinerPanel.setLayout(new GridBagLayout());

		setSpacing();

		radioPanel.setBorder(raisedbevel);

		mainPanel.setBorder(loweredetched);

		checkBoxPanel.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		getContentPane().add(conteinerPanel);

		conteinerPanel.add(radioFoodSportPanel);

		newRow();

		conteinerPanel.add(radioPanel, gbc);

		newRow();

		conteinerPanel.add(mainPanel, gbc);

		newRow();

		conteinerPanel.add(checkBoxPanel, gbc);

	}

	public void newRow() {

		gbc.gridy += 1;

		return;
	}

	public void setSpacing() {
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(2, 2, 2, 2);

		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridwidth = 2;

		gbc.gridy = 1;

		return;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public RadioPanel getRadioPanel() {
		return radioPanel;
	}

	public CheckBoxPanel getCheckBoxPanel() {
		return checkBoxPanel;
	}

	public RadioFoodSportPanel getRadioFoodSportPanelPanel() {
		return radioFoodSportPanel;
	}

	public void addMainButtonsListener(ActionListener event) {

		mainPanel.getAddBtn().addActionListener(event);
		mainPanel.getRemoveBtn().addActionListener(event);
		mainPanel.getSumFoodCaloriesBtn().addActionListener(event);
		mainPanel.getSumSportCaloriesBtn().addActionListener(event);
		
		
		mainPanel.getexportDataBtn().addActionListener(event);

		radioPanel.getDayriProductsBtn().addActionListener(event);
		radioPanel.getEggsBtn().addActionListener(event);
		radioPanel.getMeatsBtn().addActionListener(event);
		radioPanel.getFishBtn().addActionListener(event);
		radioPanel.getFruitVegetablesBtn().addActionListener(event);
		radioPanel.getBeanRiceLentilsBtn().addActionListener(event);
		radioPanel.getDrinksBtn().addActionListener(event);

		radioFoodSportPanel.getFoodBtn().addActionListener(event);
		radioFoodSportPanel.getSportBtn().addActionListener(event);

	}

	public void displayErrorMessageDialog(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}