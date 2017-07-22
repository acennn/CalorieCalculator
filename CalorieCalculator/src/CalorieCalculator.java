import calculator.controller.Controller;
import calculator.model.Model;
import calculator.view.View;

public class CalorieCalculator {

	public static void main(String[] args) {

		View theView = new View();
		Model theModel = new Model();

		Controller theController = new Controller(theView, theModel);

		theController.start();

	}

}
