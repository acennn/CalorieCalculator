package calculator.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import calculator.model.Model;
import calculator.view.CheckBoxPanel;
import calculator.view.MainPanel;
import calculator.view.RadioFoodSportPanel;
import calculator.view.RadioPanel;
import calculator.view.View;

public class Controller {

	private View theView;

	private Model theModel;

	private RadioPanel radioPanel;

	private MainPanel mainPanel;

	private CheckBoxPanel checkBoxPanel;

	private RadioFoodSportPanel radioFoodSportPanel;

	private ArrayList<HashMap<String, JCheckBox>> allFoodCheckBoxButtons = new ArrayList<>();
	private ArrayList<HashMap<String, JTextField>> allFoodTextFields = new ArrayList<>();

	ArrayList<ArrayList<ArrayList<String>>> allSelectedTextFieldsSportAndFood = new ArrayList<ArrayList<ArrayList<String>>>();

	private HashMap<String, JCheckBox> dayriProductsCheckBoxButtons = new HashMap<>();
	private HashMap<String, JCheckBox> eggsCheckBoxButtons = new HashMap<>();
	private HashMap<String, JCheckBox> meatsCheckBoxButtons = new HashMap<>();
	private HashMap<String, JCheckBox> fishCheckBoxButtons = new HashMap<>();
	private HashMap<String, JCheckBox> fruitVegetablesListCheckBoxButtons = new HashMap<>();
	private HashMap<String, JCheckBox> beanRiceLentilsListCheckBoxButtons = new HashMap<>();
	private HashMap<String, JCheckBox> drinksListCheckBoxButtons = new HashMap<>();

	private HashMap<String, JCheckBox> sportActivityListCheckBoxButtons = new HashMap<>();

	private HashMap<String, JTextField> dayriProductsTextFields = new HashMap<>();
	private HashMap<String, JTextField> eggsTextFields = new HashMap<>();
	private HashMap<String, JTextField> meatsTextFields = new HashMap<>();
	private HashMap<String, JTextField> fishTextFields = new HashMap<>();
	private HashMap<String, JTextField> fruitVegetablesListTextFields = new HashMap<>();
	private HashMap<String, JTextField> beanRiceLentilsListTextFields = new HashMap<>();
	private HashMap<String, JTextField> drinksListTextFields = new HashMap<>();

	private HashMap<String, JTextField> sportActivityListTextFields = new HashMap<>();

	private JPanel dayriProductsCheckBoxPanel;
	private JPanel eggsCheckBoxPanel;
	private JPanel meatsCheckBoxPanel;
	private JPanel fishCheckBoxPanel;
	private JPanel fruitVegetablesListCheckBoxPanel;
	private JPanel beanRiceLentilsListCheckBoxPanel;
	private JPanel drinksListCheckBoxPanel;

	private JPanel sportActivityListCheckBoxPanel;

	public void start() {
		theView.setVisible(true);
	}

	public Controller(View theView, Model theModel) {

		this.theView = theView;
		this.theModel = theModel;

		this.radioPanel = theView.getRadioPanel();
		this.mainPanel = theView.getMainPanel();
		this.checkBoxPanel = theView.getCheckBoxPanel();
		this.radioFoodSportPanel = theView.getRadioFoodSportPanelPanel();

		this.dayriProductsCheckBoxPanel = checkBoxPanel.getDayriProductsCheckBoxPanel();
		this.eggsCheckBoxPanel = checkBoxPanel.getEggsCheckBoxPanel();
		this.meatsCheckBoxPanel = checkBoxPanel.getMeatsCheckBoxPanel();
		this.fishCheckBoxPanel = checkBoxPanel.getFishCheckBoxPanel();
		this.fruitVegetablesListCheckBoxPanel = checkBoxPanel.getFruitVegetablesListCheckBoxPanel();
		this.beanRiceLentilsListCheckBoxPanel = checkBoxPanel.getBeanRiceLentilsListCheckBoxPanel();
		this.drinksListCheckBoxPanel = checkBoxPanel.getDrinksListCheckBoxPanel();

		this.sportActivityListCheckBoxPanel = checkBoxPanel.getSportActivityListCheckBoxPanel();

		theView.addMainButtonsListener(new ButtonsListener());

		addAllFoodCheckBoxButtonsToList();

		addAllFoodTextFieldsToList();

	}

	class ButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			setTheListenerAndUpdateLists(event, radioPanel.getDayriProductsBtn(), theModel.dayriProductsList,
					theModel.selectedDayriProductsList, dayriProductsCheckBoxPanel, dayriProductsCheckBoxButtons,
					dayriProductsTextFields);

			setTheListenerAndUpdateLists(event, radioPanel.getEggsBtn(), theModel.eggsList, theModel.selectedEggsList,
					eggsCheckBoxPanel, eggsCheckBoxButtons, eggsTextFields);

			setTheListenerAndUpdateLists(event, radioPanel.getMeatsBtn(), theModel.meatsList,
					theModel.selectedMeatsList, meatsCheckBoxPanel, meatsCheckBoxButtons, meatsTextFields);

			setTheListenerAndUpdateLists(event, radioPanel.getFishBtn(), theModel.fishList, theModel.selectedFishList,
					fishCheckBoxPanel, fishCheckBoxButtons, fishTextFields);

			setTheListenerAndUpdateLists(event, radioPanel.getFruitVegetablesBtn(), theModel.fruitVegetablesList,
					theModel.selectedFruitVegetablesList, fruitVegetablesListCheckBoxPanel,
					fruitVegetablesListCheckBoxButtons, fruitVegetablesListTextFields);

			setTheListenerAndUpdateLists(event, radioPanel.getBeanRiceLentilsBtn(), theModel.beanRiceLentilsList,
					theModel.selectedBeanRiceLentilsList, beanRiceLentilsListCheckBoxPanel,
					beanRiceLentilsListCheckBoxButtons, beanRiceLentilsListTextFields);

			setTheListenerAndUpdateLists(event, radioPanel.getDrinksBtn(), theModel.drinksList,
					theModel.selectedDrinksList, drinksListCheckBoxPanel, drinksListCheckBoxButtons,
					drinksListTextFields);

			setTheListenerAndUpdateLists(event, radioFoodSportPanel.getSportBtn(), theModel.sportActivityList,
					theModel.selectedSportActivityList, sportActivityListCheckBoxPanel,
					sportActivityListCheckBoxButtons, sportActivityListTextFields);

			theView.pack();

		}

		public void setTheListenerAndUpdateLists(ActionEvent event, JRadioButton radioButton,
				ArrayList<String> optionsList, ArrayList<String> selectedList, JPanel checkBoxPanel,
				HashMap<String, JCheckBox> chechkBoxButtonsMap, HashMap<String, JTextField> textFieldMap) {

			Object source = event.getSource();

			if (source == radioFoodSportPanel.getSportBtn() && radioButton.isSelected()) {

				radioPanel.setVisible(false);

				radioPanel.clearRadioPanelSelection();

				loadJList(mainPanel.optionsJList, optionsList);

				loadJList(mainPanel.selectedJList, selectedList);

				mainPanel.setVisible(true);

				return;
			}

			if ((source == radioFoodSportPanel.getFoodBtn() && radioFoodSportPanel.getFoodBtn().isSelected())) {

				radioPanel.setVisible(true);

				clearOptionSelectedLists(mainPanel.optionsJList, mainPanel.selectedJList);

				mainPanel.setVisible(true);

				return;
			}

			if ((source == radioButton)
					&& (source != radioFoodSportPanel.getSportBtn() && (source != radioFoodSportPanel.getFoodBtn()))) {

				loadJList(mainPanel.optionsJList, optionsList);

				loadJList(mainPanel.selectedJList, selectedList);

				return;

			}

			if ((source == mainPanel.getAddBtn()) && radioButton.isSelected()) {

				List<String> selectedItemsList = getSelectedItemsFromJlist(mainPanel.optionsJList);

				addUpdateOptionsSourceLists(mainPanel.optionsJList, optionsList, mainPanel.selectedJList, selectedList);

				addCheckBoxTextField(selectedItemsList, chechkBoxButtonsMap, textFieldMap);

				reloadCheckPanel(checkBoxPanel, chechkBoxButtonsMap, textFieldMap);

				theView.getCheckBoxPanel().setVisible(true);
				mainPanel.getRemoveBtn().setVisible(true);

				mainPanel.getSumFoodCaloriesBtn().setVisible(true);

				mainPanel.getSumSportCaloriesBtn().setVisible(true);
				mainPanel.getexportDataBtn().setVisible(true);

				return;
			}
			if ((source == mainPanel.getRemoveBtn()) && radioButton.isSelected()) {

				List<String> selectedItemsList = getSelectedItemsFromJlist(mainPanel.selectedJList);

				removeUpdateOptionsSourceLists(mainPanel.optionsJList, optionsList, mainPanel.selectedJList,
						selectedList);

				removeCheckBoxTextField(selectedItemsList, chechkBoxButtonsMap, textFieldMap);

				reloadCheckPanel(checkBoxPanel, chechkBoxButtonsMap, textFieldMap);

				return;
			}

			if (source == mainPanel.getSumFoodCaloriesBtn() && radioButton.isSelected()) {
				trySumAllFoodFieldsValues(allFoodTextFields);

				return;
			}

			if (source == mainPanel.getSumSportCaloriesBtn() && radioButton.isSelected()) {
				trySumAllSportFieldsValues(sportActivityListTextFields);

				return;
			}

			if (source == mainPanel.getexportDataBtn() && radioButton.isSelected()) {

				allSelectedTextFieldsSportAndFood.clear();

				trySumAllFoodFieldsValues(allFoodTextFields);
				trySumAllSportFieldsValues(sportActivityListTextFields);

				addToListSelectedProductTextFields("SportActivity", "[minutes]", sportActivityListTextFields);
				addToListSelectedProductTextFields("DayriProducts", "[grams]", dayriProductsTextFields);
				addToListSelectedProductTextFields("Eggs", "[grams]", eggsTextFields);
				addToListSelectedProductTextFields("Meats", "[grams]", meatsTextFields);
				addToListSelectedProductTextFields("Fish", "[grams]", fishTextFields);
				addToListSelectedProductTextFields("FruitVegetables", "[grams]", fruitVegetablesListTextFields);
				addToListSelectedProductTextFields("BeanRiceLentils", "[grams]", beanRiceLentilsListTextFields);
				addToListSelectedProductTextFields("Drinks", "[ml]", drinksListTextFields);

				tryExportData(theModel, theView, allSelectedTextFieldsSportAndFood);

				return;
			}

		}

	}

	class UnselectedCheckBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();

			AbstractButton abstractButton = (AbstractButton) source;
			boolean selected = abstractButton.getModel().isSelected();

			String key = event.getActionCommand();

			if (!selected) {
				String command = event.getActionCommand();

				removeUnselectedCheckBox(command, allFoodCheckBoxButtons);

				removeUnselectedSportCheckBox(command, sportActivityListCheckBoxButtons);
				theView.pack();

			}
		}

	}

	private void clearOptionSelectedLists(JList optionsJList, JList selectedJList) {

		optionsJList.setListData(new String[0]);

		selectedJList.setListData(new String[0]);

	}

	private void addAllFoodCheckBoxButtonsToList() {

		allFoodCheckBoxButtons.add(dayriProductsCheckBoxButtons);
		allFoodCheckBoxButtons.add(eggsCheckBoxButtons);
		allFoodCheckBoxButtons.add(meatsCheckBoxButtons);
		allFoodCheckBoxButtons.add(fishCheckBoxButtons);
		allFoodCheckBoxButtons.add(fruitVegetablesListCheckBoxButtons);
		allFoodCheckBoxButtons.add(beanRiceLentilsListCheckBoxButtons);
		allFoodCheckBoxButtons.add(drinksListCheckBoxButtons);

	}

	private void addAllFoodTextFieldsToList() {

		allFoodTextFields.add(dayriProductsTextFields);
		allFoodTextFields.add(eggsTextFields);
		allFoodTextFields.add(meatsTextFields);
		allFoodTextFields.add(fishTextFields);
		allFoodTextFields.add(fruitVegetablesListTextFields);
		allFoodTextFields.add(beanRiceLentilsListTextFields);
		allFoodTextFields.add(drinksListTextFields);

	}

	private void removeUnselectedCheckBox(String command,
			ArrayList<HashMap<String, JCheckBox>> allFoodCheckBoxButtons) {

		for (HashMap<String, JCheckBox> hashMap : allFoodCheckBoxButtons) {

			if (hashMap.containsKey(command)) {

				JPanel parent = (JPanel) hashMap.get(command).getParent();

				if (parent == dayriProductsCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.dayriProductsList,
							theModel.selectedDayriProductsList);

					removeUncheckedCommandFromMapButtonsTextField(command, dayriProductsCheckBoxButtons,
							dayriProductsTextFields);

					reloadCheckPanel(dayriProductsCheckBoxPanel, dayriProductsCheckBoxButtons, dayriProductsTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.dayriProductsList,
							mainPanel.selectedJList, theModel.selectedDayriProductsList,
							radioPanel.getDayriProductsBtn());

					setFoodRadioButons(radioPanel.getDayriProductsBtn());

				}

				if (parent == eggsCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.eggsList, theModel.selectedEggsList);

					removeUncheckedCommandFromMapButtonsTextField(command, eggsCheckBoxButtons, eggsTextFields);

					reloadCheckPanel(eggsCheckBoxPanel, eggsCheckBoxButtons, eggsTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.eggsList, mainPanel.selectedJList,
							theModel.selectedEggsList, radioPanel.getEggsBtn());

					setFoodRadioButons(radioPanel.getEggsBtn());
				}

				if (parent == meatsCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.meatsList,
							theModel.selectedMeatsList);

					removeUncheckedCommandFromMapButtonsTextField(command, meatsCheckBoxButtons, meatsTextFields);

					reloadCheckPanel(meatsCheckBoxPanel, meatsCheckBoxButtons, meatsTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.meatsList, mainPanel.selectedJList,
							theModel.selectedMeatsList, radioPanel.getMeatsBtn());

					setFoodRadioButons(radioPanel.getMeatsBtn());
				}

				if (parent == fishCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.fishList, theModel.selectedFishList);

					removeUncheckedCommandFromMapButtonsTextField(command, fishCheckBoxButtons, fishTextFields);

					reloadCheckPanel(fishCheckBoxPanel, fishCheckBoxButtons, fishTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.fishList, mainPanel.selectedJList,
							theModel.selectedFishList, radioPanel.getFishBtn());

					setFoodRadioButons(radioPanel.getFishBtn());
				}

				if (parent == fruitVegetablesListCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.fruitVegetablesList,
							theModel.selectedFruitVegetablesList);

					removeUncheckedCommandFromMapButtonsTextField(command, fruitVegetablesListCheckBoxButtons,
							fruitVegetablesListTextFields);

					reloadCheckPanel(fruitVegetablesListCheckBoxPanel, fruitVegetablesListCheckBoxButtons,
							fruitVegetablesListTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.fruitVegetablesList,
							mainPanel.selectedJList, theModel.selectedFruitVegetablesList,
							radioPanel.getFruitVegetablesBtn());

					setFoodRadioButons(radioPanel.getFruitVegetablesBtn());
				}

				if (parent == beanRiceLentilsListCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.beanRiceLentilsList,
							theModel.selectedBeanRiceLentilsList);

					removeUncheckedCommandFromMapButtonsTextField(command, beanRiceLentilsListCheckBoxButtons,
							beanRiceLentilsListTextFields);

					reloadCheckPanel(beanRiceLentilsListCheckBoxPanel, beanRiceLentilsListCheckBoxButtons,
							beanRiceLentilsListTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.beanRiceLentilsList,
							mainPanel.selectedJList, theModel.selectedBeanRiceLentilsList,
							radioPanel.getBeanRiceLentilsBtn());

					setFoodRadioButons(radioPanel.getBeanRiceLentilsBtn());
				}

				if (parent == drinksListCheckBoxPanel) {

					reoveUncheckedCommandFromOptionsSourceLists(command, theModel.drinksList,
							theModel.selectedDrinksList);

					removeUncheckedCommandFromMapButtonsTextField(command, drinksListCheckBoxButtons,
							drinksListTextFields);

					reloadCheckPanel(drinksListCheckBoxPanel, drinksListCheckBoxButtons, drinksListTextFields);

					reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.drinksList,
							mainPanel.selectedJList, theModel.selectedDrinksList, radioPanel.getDrinksBtn());

					setFoodRadioButons(radioPanel.getDrinksBtn());
				}

			}
		}

	}

	private void removeUnselectedSportCheckBox(String command, HashMap<String, JCheckBox> allSportCheckBoxButtons) {

		if (allSportCheckBoxButtons.containsKey(command)) {

			JPanel parent = (JPanel) allSportCheckBoxButtons.get(command).getParent();

			if (parent == sportActivityListCheckBoxPanel) {

				reoveUncheckedCommandFromOptionsSourceLists(command, theModel.sportActivityList,
						theModel.selectedSportActivityList);

				removeUncheckedCommandFromMapButtonsTextField(command, sportActivityListCheckBoxButtons,
						sportActivityListTextFields);

				reloadCheckPanel(sportActivityListCheckBoxPanel, sportActivityListCheckBoxButtons,
						sportActivityListTextFields);

				reloadOprionalAndSelectedJLists(mainPanel.optionsJList, theModel.sportActivityList,
						mainPanel.selectedJList, theModel.selectedSportActivityList, radioFoodSportPanel.getSportBtn());

				setSportRadioButons(radioFoodSportPanel.getSportBtn());
			}

		}

	}

	public void addUpdateOptionsSourceLists(JList optionsJList, ArrayList<String> optionsList, JList selectedJList,
			ArrayList<String> selectedList) {

		addSelectedItemsToList(optionsJList, selectedList);

		removeSelectedItemsFromList(optionsJList, optionsList);

		loadJList(optionsJList, optionsList);

		loadJList(selectedJList, selectedList);

		return;

	}

	public void removeUpdateOptionsSourceLists(JList optionsJList, ArrayList<String> optionsList, JList selectedJList,
			ArrayList<String> selectedList) {

		addSelectedItemsToList(selectedJList, optionsList);

		removeSelectedItemsFromList(selectedJList, selectedList);

		loadJList(optionsJList, optionsList);

		loadJList(selectedJList, selectedList);

		return;

	}

	private void addCheckBoxTextField(List<String> selectedItemsList, HashMap<String, JCheckBox> chechkBoxButtonsMap,
			HashMap<String, JTextField> textFieldMap) {

		for (int i = 0; i < selectedItemsList.size(); i++) {

			JCheckBox checkBoxField = createCheckBox(selectedItemsList.get(i));

			checkBoxField.addActionListener(new UnselectedCheckBoxListener());

			JTextField textField = createTextField(selectedItemsList.get(i));

			chechkBoxButtonsMap.put(checkBoxField.getName(), checkBoxField);

			textFieldMap.put(textField.getName(), textField);

		}

	}

	private void removeCheckBoxTextField(List<String> selectedItemsList, HashMap<String, JCheckBox> chechkBoxButtonsMap,
			HashMap<String, JTextField> textFieldMap) {

		for (int i = 0; i < selectedItemsList.size(); i++) {

			chechkBoxButtonsMap.remove(selectedItemsList.get(i));

			textFieldMap.remove(selectedItemsList.get(i));

		}

	}

	private JCheckBox createCheckBox(String checkBoxName) {

		JCheckBox button = new JCheckBox(checkBoxName);

		button.setName(checkBoxName);

		button.setSelected(true);

		return button;

	}

	private JTextField createTextField(String textFieldName) {

		JTextField textField = new JTextField(textFieldName);

		textField.setName(textFieldName);

		textField.setToolTipText("Enter a Whole Number and press SUM to sum all fields.");

		textField.setPreferredSize(new Dimension(30, 20));
		textField.setText("0");

		textField.setVisible(true);

		return textField;

	}

	private void removeUncheckedCommandFromMapButtonsTextField(String command,
			HashMap<String, JCheckBox> chechkBoxButtonsMap, HashMap<String, JTextField> textFieldMap) {

		chechkBoxButtonsMap.remove(command);

		textFieldMap.remove(command);

	}

	private void reloadCheckPanel(JPanel checkBoxPanel, HashMap<String, JCheckBox> chechkBoxButtonsMap,
			HashMap<String, JTextField> textFieldMap) {

		checkBoxPanel.removeAll();
		checkBoxPanel.revalidate();
		checkBoxPanel.validate();
		checkBoxPanel.repaint();

		checkBoxPanel.setVisible(true);

		for (Entry<String, JCheckBox> entry : chechkBoxButtonsMap.entrySet()) {

			JCheckBox checkBoxField = entry.getValue();
			JTextField textField = textFieldMap.get(checkBoxField.getName());

			checkBoxPanel.add(checkBoxField);
			checkBoxPanel.add(textField);

		}

		if (chechkBoxButtonsMap.isEmpty()) {

			checkBoxPanel.setVisible(false);

		}

	}

	private void trySumAllSportFieldsValues(HashMap<String, JTextField> allSportTextFields) {
		try {

			mainPanel.setSumSportCaloriesText(theModel.getSumSportValues(allSportTextFields));

		}

		catch (NumberFormatException e) {

			theView.displayErrorMessageDialog("Incorrect Input. Enter a Whole Number [minutes]. Only digits accepted");
			return;
		}
	}

	private void trySumAllFoodFieldsValues(ArrayList<HashMap<String, JTextField>> allFoodTextFields) {
		try {

			mainPanel.setSumFoodCaloriesText(theModel.getSumFoodValues(allFoodTextFields));
		}

		catch (NumberFormatException e) {

			theView.displayErrorMessageDialog("Incorrect Input. Enter a Whole Number [grams]. Only digits accepted");
			return;
		}
	}

	public void addSelectedItemsToList(JList sourceJList, ArrayList<String> receiverArrayList) {

		List<String> currentSelection = sourceJList.getSelectedValuesList();

		receiverArrayList.addAll(currentSelection);

	}

	public List<String> getSelectedItemsFromJlist(JList sourceJList) {

		List<String> currentSelection = sourceJList.getSelectedValuesList();

		return currentSelection;

	}

	public void reoveUncheckedCommandFromOptionsSourceLists(String command, ArrayList<String> optionsList,
			ArrayList<String> selectedList) {

		optionsList.add(command);
		selectedList.remove(command);

		return;

	}

	public void removeSelectedItemsFromList(JList sourceJList, ArrayList<String> sourceList) {

		List<String> selectedSourceList = sourceJList.getSelectedValuesList();

		sourceList.removeAll(selectedSourceList);

	}

	public void loadJList(JList sourceJList, ArrayList<String> sourceList) {

		String[] stringReceiverList = sourceList.toArray(new String[sourceList.size()]);

		Arrays.sort(stringReceiverList);

		sourceJList.setListData(stringReceiverList);

	}

	public void reloadOprionalAndSelectedJLists(JList optionsJList, ArrayList<String> optionsList, JList selectedJList,
			ArrayList<String> selectedList, JRadioButton radioButton) {

		loadJList(optionsJList, optionsList);

		loadJList(selectedJList, selectedList);

	}

	public void setFoodRadioButons(JRadioButton radioButton) {

		radioButton.setSelected(true);

		radioFoodSportPanel.getFoodBtn().setSelected(true);

		radioPanel.setVisible(true);

		return;
	}

	public void setSportRadioButons(JRadioButton radioButton) {

		radioFoodSportPanel.getSportBtn().setSelected(true);

		radioPanel.setVisible(false);

		radioPanel.clearRadioPanelSelection();

		return;
	}

	public void addToListSelectedProductTextFields(String productTitle, String dimension,
			HashMap<String, JTextField> selectedTextFields) {

		try {

			if (!selectedTextFields.isEmpty()) {

				ArrayList<ArrayList<String>> selectedPdoductsList = new ArrayList<ArrayList<String>>();

				ArrayList<String> firstRowTitles = new ArrayList<String>();

				firstRowTitles.add(productTitle);
				firstRowTitles.add(dimension);
				firstRowTitles.add("Calculated calorie [kcal]");

				selectedPdoductsList.add(firstRowTitles);

				for (JTextField textFieled : selectedTextFields.values()) {

					ArrayList<String> productNameQuantityCalories = new ArrayList<String>();

					int productCalories = theModel.getLastIntegerOfText(textFieled.getName());

					double calculatedCalorie;
					if (selectedTextFields == sportActivityListTextFields) {

						calculatedCalorie = (Double.parseDouble(textFieled.getText()) / 60) * productCalories;
					} else {
						calculatedCalorie = (Double.parseDouble(textFieled.getText()) / 100) * productCalories;

					}
					calculatedCalorie = Math.round(calculatedCalorie);

					productNameQuantityCalories.add(textFieled.getName());

					productNameQuantityCalories.add(textFieled.getText());

					productNameQuantityCalories.add(String.valueOf(calculatedCalorie));

					selectedPdoductsList.add(productNameQuantityCalories);

				}

				allSelectedTextFieldsSportAndFood.add(selectedPdoductsList);

			}

		}

		catch (NumberFormatException e) {

			theView.displayErrorMessageDialog("Only digits accepted as input in the fields");
			return;
		}

	}

	private static void tryExportData(Model theModel, View theView,
			ArrayList<ArrayList<ArrayList<String>>> allSelectedTextFieldsSportAndFood) {
		try {
			theModel.exportData("ExportedCalorieData", allSelectedTextFieldsSportAndFood);

		}

		catch (FileNotFoundException e) {

			theView.displayErrorMessageDialog("The Excel file must to be closed first");
			return;
		}
	}

}
