import javax.swing.*;
import java.util.*;

public class FindPrice {

	public static void main(String[] args) {
		
		// Creates two array lists with preset item numbers and associated prices
		ArrayList<Integer> validValues = new ArrayList<>(Arrays.asList(101,208,201,213,266, 304,311,409,411,412));
		ArrayList<Double> prices = new ArrayList<>(Arrays.asList(0.29,1.23,3.50,0.69,6.79, 3.19,0.99,0.89,1.26,8.00));
		
		
		String strItem;
		int yn;
		int cont;
		int itemOrdered;
		double itemPrice = 0.0;
		boolean isValidItem = false;
		String newValue;
		String newPrice;
		
		// Welcome message, asks user if they would like to find a price, saves answer to var cont
		cont = JOptionPane.showConfirmDialog(null, "Welcome to the PriceFinder! Would you like to look up a price?");
		
		// While cont is YES, loop repeats, so that the user may look up prices of multiple items
		while (cont == JOptionPane.YES_OPTION) {
			
			// Prompts user for item # in order to look up associated price
			strItem = JOptionPane.showInputDialog(null,"Enter the item number you want to order");
			// Converts user input to Integer, to match ArrayList type
			itemOrdered = Integer.parseInt(strItem);

			// For loop that iterates through ArrayList validValues to check whether or not user has entered a valid item number
			for (int x = 0; x < validValues.size(); x++) {
				
				// If item number is valid, then isValidItem is true and itemPrice is set to the price stored at the same index in ArrayList prices
				if(itemOrdered == validValues.get(x)) {
                 
					isValidItem  = true;
					itemPrice = prices.get(x);
				}
			}

			// If isValid is true, program returns itemPrice
			if(isValidItem) {
				JOptionPane.showMessageDialog(null ," The price for item " + itemOrdered + " is $" + itemPrice);
			}
			
			/* If isValid is false, program informs user that the entered item number was invalid, and asks whether or not they would like to
			add the item to the list */
			else {
				yn = JOptionPane.showConfirmDialog(null,"Sorry - invalid item entered. Would you like to add this item to the list?");
				
				/* If user selects "YES," program prompts user to re enter new item number, saving it to var newValue.
				Then program prompts user to entered associated price, saving it to var newPrice */
				if (yn == JOptionPane.YES_OPTION) {
					newValue = JOptionPane.showInputDialog(null, "Please re enter item number");
					newPrice = JOptionPane.showInputDialog(null, "Please enter item price");
				
					// Initialize vars y and z, casting newValue and newPrice as Integer and Double respectively
					int y = Integer.parseInt(newValue);
					double z = Double.parseDouble(newPrice);
				
					// Adds new item number and new price to ArrayLists validValues and prices respectively
					validValues.add(y);
					prices.add(z);					
				}
				
			}
			// Asks the user whether they would like to look up the price of a new item, stores response in var cont. If YES, then the loop is repeated.
			cont = JOptionPane.showConfirmDialog(null, "Would you like to look up another price?");
		}
	}
}