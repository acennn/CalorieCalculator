package calculator.view;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton dayriProductsBtn = new JRadioButton("Dayri Products");
	private JRadioButton eggsBtn = new JRadioButton("Eggs");
	private JRadioButton meatsBtn = new JRadioButton("Meats");
	private JRadioButton fishBtn = new JRadioButton("Fish");
	private JRadioButton fruitVegetablesBtn = new JRadioButton("Fruit Vegetables");
	private JRadioButton BeanRiceLentilsBtn = new JRadioButton("Bean RiceLentils");
	private JRadioButton drinksBtn = new JRadioButton("Drinks");

	static ButtonGroup group = new ButtonGroup();

	public RadioPanel() {

		setButtobsToolTips();

		add(dayriProductsBtn);
		add(eggsBtn);
		add(meatsBtn);
		add(fishBtn);
		add(fruitVegetablesBtn);
		add(BeanRiceLentilsBtn);
		add(drinksBtn);

		group.add(dayriProductsBtn);
		group.add(eggsBtn);
		group.add(meatsBtn);
		group.add(fishBtn);
		group.add(fruitVegetablesBtn);
		group.add(BeanRiceLentilsBtn);
		group.add(drinksBtn);

		this.setVisible(false);

	}

	public JRadioButton getDayriProductsBtn() {
		return dayriProductsBtn;
	}

	public JRadioButton getEggsBtn() {
		return eggsBtn;
	}

	public JRadioButton getMeatsBtn() {
		return meatsBtn;
	}

	public JRadioButton getFishBtn() {
		return fishBtn;
	}

	public JRadioButton getFruitVegetablesBtn() {
		return fruitVegetablesBtn;
	}

	public JRadioButton getBeanRiceLentilsBtn() {
		return BeanRiceLentilsBtn;
	}

	public JRadioButton getDrinksBtn() {
		return drinksBtn;
	}

	public static void clearRadioPanelSelection() {

		group.clearSelection();
	}

	public void setButtobsToolTips() {

		dayriProductsBtn.setToolTipText("Press to View DayriProducts Menu");
		eggsBtn.setToolTipText("Press to View Eggs Menu");
		meatsBtn.setToolTipText("Press to View Meats Menu");
		fishBtn.setToolTipText("Press to View Fish Menu");
		fruitVegetablesBtn.setToolTipText("Press to View Fruit and Vegetables Menu");
		BeanRiceLentilsBtn.setToolTipText("Press to View Bean, Rice and Lentils Menu");
		drinksBtn.setToolTipText("Press to View Drinks Menu");

	}

}
