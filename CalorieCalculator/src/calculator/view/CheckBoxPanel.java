package calculator.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CheckBoxPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private JPanel dayriProductsCheckBoxPanel = new JPanel();
	private JPanel eggsCheckBoxPanel = new JPanel();
	private JPanel meatsCheckBoxPanel = new JPanel();
	private JPanel fishCheckBoxPanel = new JPanel();
	private JPanel fruitVegetablesListCheckBoxPanel = new JPanel();
	private JPanel beanRiceLentilsListCheckBoxPanel = new JPanel();
	private JPanel drinksListCheckBoxPanel = new JPanel();

	private JPanel sportActivityListCheckBoxPanel = new JPanel();

	GridBagConstraints gbc = new GridBagConstraints();

	
	public CheckBoxPanel() {

		setLayout(new GridBagLayout());

		setLayoutTitledBorder("Sport [minutes]", sportActivityListCheckBoxPanel);

		setLayoutTitledBorder("Dayri Products [grams]", dayriProductsCheckBoxPanel);
		setLayoutTitledBorder("Eggs [grams]", eggsCheckBoxPanel);
		setLayoutTitledBorder("Meats [grams]", meatsCheckBoxPanel);
		setLayoutTitledBorder("Fish [grams]", fishCheckBoxPanel);
		setLayoutTitledBorder("Fruit Vegetables [grams]", fruitVegetablesListCheckBoxPanel);
		setLayoutTitledBorder("Bean Rice Lentils [grams]", beanRiceLentilsListCheckBoxPanel);
		setLayoutTitledBorder("Drinks [ml]", drinksListCheckBoxPanel);

		setPanelsSpacing();

		add(sportActivityListCheckBoxPanel, gbc);

		add(dayriProductsCheckBoxPanel, gbc);
		add(eggsCheckBoxPanel, gbc);
		add(meatsCheckBoxPanel, gbc);
		newRow();
		add(fishCheckBoxPanel, gbc);
		add(fruitVegetablesListCheckBoxPanel, gbc);
		add(beanRiceLentilsListCheckBoxPanel, gbc);
		add(drinksListCheckBoxPanel, gbc);

		setPanelsVisibility();

		this.setVisible(false);

	}

	public void setPanelsVisibility() {

		sportActivityListCheckBoxPanel.setVisible(false);

		dayriProductsCheckBoxPanel.setVisible(false);
		eggsCheckBoxPanel.setVisible(false);
		meatsCheckBoxPanel.setVisible(false);
		fishCheckBoxPanel.setVisible(false);
		fruitVegetablesListCheckBoxPanel.setVisible(false);
		beanRiceLentilsListCheckBoxPanel.setVisible(false);
		drinksListCheckBoxPanel.setVisible(false);

	}

	public JPanel getDayriProductsCheckBoxPanel() {
		return dayriProductsCheckBoxPanel;
	}

	public JPanel getEggsCheckBoxPanel() {
		return eggsCheckBoxPanel;
	}

	public JPanel getMeatsCheckBoxPanel() {
		return meatsCheckBoxPanel;
	}

	public JPanel getFishCheckBoxPanel() {
		return fishCheckBoxPanel;
	}

	public JPanel getFruitVegetablesListCheckBoxPanel() {
		return fruitVegetablesListCheckBoxPanel;
	}

	public JPanel getBeanRiceLentilsListCheckBoxPanel() {
		return beanRiceLentilsListCheckBoxPanel;
	}

	public JPanel getDrinksListCheckBoxPanel() {
		return drinksListCheckBoxPanel;
	}

	public JPanel getSportActivityListCheckBoxPanel() {
		return sportActivityListCheckBoxPanel;
	}

	public void newRow() {

		gbc.gridy += 1;

		return;
	}

	public void setPanelsSpacing() {
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(2, 2, 2, 2);

		gbc.gridy = 1;

		return;
	}

	public void setLayoutTitledBorder(String title, JPanel checkBoxPanel) {

		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), title);
		titledBorder.setTitleJustification(TitledBorder.CENTER);

		checkBoxPanel.setBorder(titledBorder);

		return;

	}

	public void addCheckBoxListener(ActionListener event, JPanel checkBoxPanel, JCheckBox checkBoxField,
			JTextField textField) {

		checkBoxField.addActionListener(event);
		textField.addActionListener(event);

	}

}
