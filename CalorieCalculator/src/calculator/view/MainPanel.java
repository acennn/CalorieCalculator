package calculator.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panelAddRemoveButtons = new JPanel();

	private JPanel panelSumExportButtons = new JPanel();

	private JButton addBtn = new JButton("Add-->");

	private JButton removeBtn = new JButton("<--Remove");

	public JList<String> optionsJList = new JList<String>();

	public JList<String> selectedJList = new JList<String>();

	public JScrollPane optionsJScrollPane = new JScrollPane(optionsJList);

	public JScrollPane selectedJScrollPane = new JScrollPane(selectedJList);

	private JButton sumFoodCaloriesBtn = new JButton("SUM Food");

	private JButton sumSportCaloriesBtn = new JButton("SUM Sport");

	private JButton exportDataBtn = new JButton("Export Data Excel");

	public MainPanel() {

		setAddRemoveButtonsPosition(panelAddRemoveButtons, addBtn, removeBtn);

		setSumExportButtonsPosition(panelSumExportButtons, sumSportCaloriesBtn, sumFoodCaloriesBtn, exportDataBtn);

		setButtobsToolTips();

		this.add(optionsJScrollPane);

		this.add(panelAddRemoveButtons);

		this.add(selectedJScrollPane);

		this.add(panelSumExportButtons);

		setButtonsVisibility();

		this.setVisible(false);

	}

	public void setButtonsVisibility() {

		getSumFoodCaloriesBtn().setVisible(false);

		getSumSportCaloriesBtn().setVisible(false);

		getAddBtn().setVisible(true);

		getRemoveBtn().setVisible(false);

		getexportDataBtn().setVisible(false);

	}

	public void setAddRemoveButtonsPosition(JPanel panel, JButton button1, JButton button2) {

		GridBagConstraints gbc = new GridBagConstraints();

		panel.setLayout(new GridBagLayout());

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(10, 2, 10, 2);

		gbc.gridy = 1;

		panel.add(button1, gbc);

		gbc.gridy = 2;

		panel.add(button2, gbc);

		return;

	}

	public void setSumExportButtonsPosition(JPanel panel, JButton button1, JButton button2, JButton button3) {

		GridBagConstraints gbc = new GridBagConstraints();

		panel.setLayout(new GridBagLayout());

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(10, 2, 10, 2);

		gbc.gridy = 1;

		panel.add(button1, gbc);

		gbc.gridy = 2;

		panel.add(button2, gbc);

		gbc.gridy = 3;
		panel.add(button3, gbc);

		return;

	}

	public void setButtobsToolTips() {

		addBtn.setToolTipText("Press to Add to selected list");
		removeBtn.setToolTipText("Press to Remove from selected list");
		sumFoodCaloriesBtn.setToolTipText("Press to Sum all FOOD calories");

		sumSportCaloriesBtn.setToolTipText("Press to Sum all SPORT calories");

		exportDataBtn.setToolTipText("Press to EXPORT selected data.");

		optionsJScrollPane.setToolTipText("Select one or more products and press Add to add to selected list");

		selectedJScrollPane.setToolTipText("Select one or more products and press Remove to remove of selected list");

	}

	public JButton getexportDataBtn() {
		return exportDataBtn;
	}

	public void setSumFoodCaloriesBtn(JButton sumFoodCaloriesBtn) {
		this.sumFoodCaloriesBtn = sumFoodCaloriesBtn;
	}

	public void setSumSportCaloriesBtn(JButton sumSportCaloriesBtn) {
		this.sumSportCaloriesBtn = sumSportCaloriesBtn;
	}

	public JPanel getPanelSumExportButtons() {
		return panelSumExportButtons;
	}

	public JButton getSumFoodCaloriesBtn() {
		return sumFoodCaloriesBtn;
	}

	public JButton getSumSportCaloriesBtn() {
		return sumSportCaloriesBtn;
	}

	public void setSumSportCaloriesText(Double sum) {
		this.sumSportCaloriesBtn.setText("SUM = " + sum + " [kcal]");
	}

	public void setSumFoodCaloriesText(Double sum) {
		this.sumFoodCaloriesBtn.setText("SUM = " + sum + " [kcal]");
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public JButton getRemoveBtn() {
		return removeBtn;
	}
}
