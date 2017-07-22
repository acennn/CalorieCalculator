package calculator.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Model {

	private String[] sportActivity = { "Аеробика (бавно темпо)  237", "Аеробика (нормално темпо) 60min 309",
			"Аеробика (интензивно темпо) 60min 381", "Бадминтон 60min 392", "Баскетбол 60min 448", "Билярд 60min 108",
			"Бокс 60min 348", "Боулинг 60min 168", "Бягане 60min 660", "Волейбол 60min 392",
			"Волейбол (плажен) 60min 456", "Гмуркане 60min 671", "Голф 60min 252", "Дарц 60min 140",
			"Джогинг 60min 864", "Джудо 60min 560", "Езда 60min 228", "Изкачване на стълби 60min 720", "Йога 60min 385",
			"Карате 60min 349", "Колоездене (15 км/ ч) 60min 380", "Лов 60min 280", "Пилатес 60min 390",
			"Плуване 60min 475", "Плуване (бързо темпо) 60min 660", "Пързаляне с ролери 60min 480",
			"Разходка (1,5 км/ ч) 60min 120", "Риболов 60min 140", "Скачане с въже 60min 900",
			"Ски – спускане 60min 480", "Стрелба 60min 168", "Тае Бо 60min 800", "Танци (интензивно темпо) 60min 381",
			"Тенис 60min 600", "Фитнес - жени, (тежка тренировка) 60min 920", "Футбол 60min 371", "Хандбал 60min 671",
			"Ходене (нормално темпо) 60min 126", "Ходене (бързо темпо) 60min 350" };

	private String[] dayriProducts = { "Извара (кашкавал) 100g 145", "Извара (сирене) 100g 79", "Камамбер 100g 300",
			"Катък 100g 138", "Кашкавал 100g 330", "Кисело мляко 0.5% 100g 37", "Кисело мляко 2% 100g 42",
			"Кисело мляко 3.6% 100g 60", "Кисело мляко 6.5% 100g 90", "Кисело мляко, цедено 100g 150",
			"Маскарпоне 100g 406", "Моцарела 100g 300", "Пармезан 100g 452", "Прясно мляко (овче) 100g 95",
			"Прясно мляко 0.1% 100g 32", "Прясно мляко 1.5% 100g 47", "Прясно мляко 3% 100g 60", "Сирене, бри 100g 319",
			"Сирене, козе 100g 364", "Сирене, краве 100g 300", "Сирене, крема 100g 297", "Сирене, рикота 100g 174",
			"Сирене, синьо 100g 353", "Сирене, фета 100g 250", "Сирене, чедар 100g 412", "Сирене, швейцарско 100g 350",
			"Сметана 20% 100g 200", "Сметана 30 % 100g 300", "Сметана, течна 100g 309" };

	private String[] eggs = { "Белтък от кокоши яйца 100g 49", "Бъркани яйца 100g 119", "Варени кокоши яйца 100g 160",
			"Варени на рохко кокоши яйца 100g 159", "Варени яйца 100g 168", "Жълтък от кокоши яйца 100g 314",
			"Пъдпъдъчени яйца 100g 180", "Сух белтък 100g 375", "Сух жълтък 100g 613", "Цели кокоши яйца 100g 139",
			"Яйчен прах 100g 542" };

	private String[] meats = { "Агнешки бут 100g 266", "Агнешки врат 100g 315", "Агнешки котлет 100g 386",
			"Агнешко/гърди 100g 380", "Агнешко/каре 100g 377", "Бекон 100g 414", "Език, телешки 100g 224",
			"Заешко 100g 124", "Луканка 100g 460", "Пилешки дробчета 100g 119", "Пилешки сърца 100g 153",
			"Пилешко месо/бутче 100g 119", "Пилешко месо/гърди 100g 110", "Пуешко/бут 100g 114",
			"Пуешко/гърди 100g 103", "Свинска кайма 100g 263", "Свински бут 100g 269", "Свински дроб 100g 134",
			"Свинско каре 100g 329", "Сланина 100g 900", "Телешка кайма 100g 332", "Телешки дроб 100g 135",
			"Телешки стек 100g 124", "Телешко филе 100g 109", "Шкембе 100g 85", "Шунка 100g 93" };

	public String[] fish = { "Аншоа консерва 100g 280", "Пъстърва 100g 117", "Риба тон във вода 100g 91",
			"Сардини в олио 100g 217", "Скариди 100g 107", "Скариди 100g 106", "Скумрия 100g 223", "Сьомга 100g 182",
			"Треска 100g 76", "Черни миди 100g 48" };

	private String[] fruitVegetables = { "Авокадо 100g 190", "Ананас 100g 41", "Аспержи 100g 25", "Бамя 100g 31",
			"Банан 100g 95", "Броколи 100g 33", "Брюкселско зеле 100g 42", "Грах 100g 69", "Грейпфрут 100g 20",
			"Гродзе 100g 60", "Гъби 100g 13.5", "Гъби консерва 100g 80", "Диня 100g 31", "Домат 100g 17",
			"Замразени зеленчуци 100g 42", "Зеле 100g 26", "Зелен боб 100g 31", "Кайсии 100g 31", "Каперси 100g 28",
			"Карфиол 100g 34", "Касис 100g 28", "Киви 100g 49", "Краставица 100g 10", "Круши 100g 40",
			"Кумкуат 100g 60", "Къпини 100g 56", "Лимони 100g 19", "Лук пресен 100g 23", "Лук стар 100g 36",
			"Малини 100g 25", "Манго 100g 57", "Мандарини 100g 35", "Маруля 100g 14", "Моркови 100g 41",
			"Нахут 100g 89", "Нектарини 100g 40", "Патладжан 100g 24", "Портокали 100g 37", "Праз 100g 22",
			"Праскови 100g 33", "Пресни картофи 100g 75", "Пъпеш 100g 28", "Репички 100g 16", "Рукола 100g 26",
			"Сини сливи 100g 35", "Сладки картофи 100g 84", "Спанак 100g 7", "Стари картофи 100g 136",
			"Стафиди 100g 272", "Сушени смокини 100g 227", "Тиква 100g 26", "Тиквичка 100g 20", "Фурми 100g 227",
			"Царевица 100g 88", "Череши 100g 48", "Чушки 100g 20", "Ябълки 100g 42", "Ягоди 100g 27" };

	private String[] BeanRiceLentils = { "Зрял боб 100g 113", "Кафяв ориз 100g 362", "Леща 100g 105" };

	private String[] drinks = { "Бейлис 100 ml  240", "Бира 100 ml  34", "Бира, светла 100 ml  30",
			"Вино, бяло 100 ml  65", "Вино, десертно 100 ml  90", "Вино, розе 100 ml  62", "Вино, червено 100 ml  70",
			"Водка 100 ml  231", "Джин 100 ml  231", "Мартини 100 ml  175", "Перно 100 ml  140", "Ром 100 ml  231",
			"Тиа Мария 100 ml  155", "Уиски 100 ml  250", "Шампанско 100 ml  126" };

	public ArrayList<String> sportActivityList = new ArrayList<String>(Arrays.asList(sportActivity));

	public ArrayList<String> dayriProductsList = new ArrayList<String>(Arrays.asList(dayriProducts));
	public ArrayList<String> eggsList = new ArrayList<String>(Arrays.asList(eggs));
	public ArrayList<String> meatsList = new ArrayList<String>(Arrays.asList(meats));
	public ArrayList<String> fishList = new ArrayList<String>(Arrays.asList(fish));
	public ArrayList<String> fruitVegetablesList = new ArrayList<String>(Arrays.asList(fruitVegetables));
	public ArrayList<String> beanRiceLentilsList = new ArrayList<String>(Arrays.asList(BeanRiceLentils));
	public ArrayList<String> drinksList = new ArrayList<String>(Arrays.asList(drinks));

	public ArrayList<String> selectedSportActivityList = new ArrayList<String>();

	public ArrayList<String> selectedDayriProductsList = new ArrayList<String>();
	public ArrayList<String> selectedEggsList = new ArrayList<String>();
	public ArrayList<String> selectedMeatsList = new ArrayList<String>();
	public ArrayList<String> selectedFishList = new ArrayList<String>();
	public ArrayList<String> selectedFruitVegetablesList = new ArrayList<String>();
	public ArrayList<String> selectedBeanRiceLentilsList = new ArrayList<String>();
	public ArrayList<String> selectedDrinksList = new ArrayList<String>();

	public Double getSumFoodValues(ArrayList<HashMap<String, JTextField>> allFoodTextFields)
			throws NumberFormatException {

		double sumAllFoodCalories = 0;

		for (HashMap<String, JTextField> hashMap : allFoodTextFields) {

			for (JTextField textFieled : hashMap.values()) {

				int productCalories = getLastIntegerOfText(textFieled.getName());

				double productQuantity = Double.parseDouble(textFieled.getText());

				sumAllFoodCalories += (productQuantity / 100) * productCalories;

			}

		}

		sumAllFoodCalories = Math.round(sumAllFoodCalories);
		return sumAllFoodCalories;

	}

	public Double getSumSportValues(HashMap<String, JTextField> allSportTextFields) throws NumberFormatException {

		double sumAllSportCalories = 0.0;

		for (JTextField textFieled : allSportTextFields.values()) {

			int productCalories = getLastIntegerOfText(textFieled.getName());

			sumAllSportCalories += (Double.parseDouble(textFieled.getText()) / 60) * productCalories;

		}

		sumAllSportCalories = Math.round(sumAllSportCalories);

		return sumAllSportCalories;
	}

	public static Integer getLastIntegerOfText(String text) {
		int i = text.length();
		while (i > 0 && Character.isDigit(text.charAt(i - 1))) {
			i--;
		}
		return new Integer(text.substring(i));
	}

	public static void exportData(String fileName,
			ArrayList<ArrayList<ArrayList<String>>> allSelectedTextFieldsSportAndFood) throws FileNotFoundException {

		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		Workbook workbook = new HSSFWorkbook();

		FileOutputStream fileOut = new FileOutputStream(fileName + currentDate + ".xls");

		try {

			for (int i = 0; i < allSelectedTextFieldsSportAndFood.size(); i++) {

				String titleProducts = allSelectedTextFieldsSportAndFood.get(i).get(0).get(0);

				Sheet sheet = workbook.createSheet(titleProducts);

				double sum = 0;

				for (int j = 0; j < allSelectedTextFieldsSportAndFood.get(i).size(); j++) {

					HSSFRow row = (HSSFRow) sheet.createRow(j);

					HSSFCell[] cell = new HSSFCell[allSelectedTextFieldsSportAndFood.get(i).get(j).size() + 3];

					for (int k = 0; k < allSelectedTextFieldsSportAndFood.get(i).get(j).size(); k++) {

						int lastRow = allSelectedTextFieldsSportAndFood.get(i).size();
						int lastCell = allSelectedTextFieldsSportAndFood.get(i).get(j).size();

						cell[k] = row.createCell(k);

						if (k > 0 && k < lastCell && j > 0) {

							double temp = Double.parseDouble(allSelectedTextFieldsSportAndFood.get(i).get(j).get(k));
							cell[k].setCellValue(temp);

						} else {
							cell[k].setCellValue(allSelectedTextFieldsSportAndFood.get(i).get(j).get(k));

						}

						if ((k == lastCell - 1) && j > 0) {
							sum += (Double.parseDouble(allSelectedTextFieldsSportAndFood.get(i).get(j).get(k)));

						}

						if ((j == lastRow - 1) && (k == lastCell - 1)) {
							HSSFRow rowSum = (HSSFRow) sheet.createRow(j + 1);
							cell[k + 1] = rowSum.createCell(k + 1);
							cell[k + 1].setCellValue("Sum =");
							cell[k + 2] = rowSum.createCell(k + 2);
							cell[k + 2].setCellValue(sum);
							cell[k + 3] = rowSum.createCell(k + 3);
							cell[k + 3].setCellValue("[kcal]");

						}

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
			} catch (Exception e) {
			}
		}

		return;
	}

}