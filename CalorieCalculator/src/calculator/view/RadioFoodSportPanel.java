package calculator.view;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioFoodSportPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JRadioButton foodBtn = new JRadioButton("FOOD");

	private JRadioButton sportBtn = new JRadioButton("SPORT");

	ButtonGroup foodSportGroup = new ButtonGroup();

	public RadioFoodSportPanel() {

		setButtobsToolTips();

		foodBtn.setBorderPainted(true);
		sportBtn.setBorderPainted(true);

		add(sportBtn);
		add(foodBtn);

		foodSportGroup.add(sportBtn);
		foodSportGroup.add(foodBtn);

	}

	public JRadioButton getFoodBtn() {
		return foodBtn;
	}

	public JRadioButton getSportBtn() {
		return sportBtn;
	}

	public void setButtobsToolTips() {

		sportBtn.setToolTipText("Press to View SPORT Activity Menu");
		foodBtn.setToolTipText("Press to View FOOD Menu");

	}

}
