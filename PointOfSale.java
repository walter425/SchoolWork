package essentials;

import java.util.Scanner;
/**
 *  This program simulates an inventory tracking and point-of-sale machine.
 * @author walter acevedo
 */
public class PointOfSale {

static final double LOCAL_TAX = 0.01;
static final double STATE_TAX = 0.06;
static int mumInventory = 10;
static int pumpkinInventory = 10;
static int scarecrowInventory = 10;
static int cornstalkInventory = 10;
static final double MUM_PRICE = 8.00;
static final double PUMPKIN_PRICE = 5.00;
static final double SCARECROW_PRICE = 5.00;
static final double CORNSTALK_PRICE = 6.00;
static double subTotal = 0.00;
static double returnedLocalTax = 0.00;
static double returnedStateTax = 0.00;
static int articleID = 0;
static int quantityOrdered = 0;
static char repeat = 'Y';
static String input;

    public static void main(String[] args) {
	// while .toUpperCase(repeat) line and Scanner taken from Gaddis, Tony. 2016. Starting Out with Java.
	// 6th Edition.
    	while (Character.toUpperCase(repeat) == 'Y') {
                subTotal = 0.00;
                System.out.println("");
		System.out.println("Welcome to the Farm Shop!");
                System.out.println("");
		printInventory();
		do {
			getArticleID();
			getArticleQuantity();
			// switch syntax taken from Gaddis, Tony. 2016. Starting Out with Java.
			// 6th Edition. page 154.
			switch (articleID) {
                            case 0:
                                break;
                            case 1:
				if (mumInventory > 0 && quantityOrdered <= 
                                        mumInventory) {
					addToSubtotal();
					decreaseInventory();
				} else {
					System.out.println("There are not "
                                                + "enough mums in inventory.");
					System.out.println("You can purchase "
                                                + "up to " + mumInventory + 
                                                " mums.");
				}; //end if...else
				break;
                            case 2:
				if (pumpkinInventory > 0 && quantityOrdered 
                                        <= pumpkinInventory) {
					addToSubtotal();
					decreaseInventory();
				} else {
					System.out.println("There are not "
                                                + "enough pumpkins in "
                                                + "inventory.");
					System.out.println("You can purchase "
                                                + "up to " + pumpkinInventory + 
                                                " pumpkins.");
				}; //end if...else
				break;
                            case 3:
				if (scarecrowInventory > 0 && quantityOrdered 
                                        <= scarecrowInventory) {
					addToSubtotal();
					decreaseInventory();
				} else {
					System.out.println("There are not "
                                                + "enough scarecrows in "
                                                + "inventory.");
					System.out.println("You can purchase "
                                                + "up to " + scarecrowInventory
                                                + " scarecrows.");
				}; //end if...else
				break;
                            case 4:
				if (cornstalkInventory > 0 && quantityOrdered 
                                        <= cornstalkInventory) {
					addToSubtotal();
					decreaseInventory();
				} else {
					System.out.println("There are not "
                                                + "enough cornstalks in "
                                                + "inventory.");
					System.out.println("You can purchase "
                                                + "up to " + cornstalkInventory
                                                + " cornstalks.");
				}; //end if...else
				break;
                            default:
				System.out.println("Invalid article ID.");
				break;
			} // end switch

		} while (articleID != 0);   // end do… while
		returnedLocalTax = calculateLocalTax(subTotal);
		returnedStateTax = calculateStateTax(subTotal);
		displayTotalSale();
		askToContinue();
	} // end while
    } // close main()

// Horizontal tab example taken from Gaddis, Tony. 2016. Starting Out with Java.
// 6th Edition. page 37.

    public static void printInventory() {
	System.out.println("Article ID\t" + "Descrip\t\t" + "Price\t" + 
                "Amount Available");
	System.out.println("1\t\t" + "Mum\t\t" + MUM_PRICE +"\t" +
                mumInventory);
	System.out.println("2\t\t" + "Pumpkin\t\t" + PUMPKIN_PRICE +"\t" +
                pumpkinInventory);
	System.out.println("3\t\t" + "Scarecrow\t" + SCARECROW_PRICE +"\t" + 
                scarecrowInventory);
	System.out.println("4\t\t" + "Cornstalk\t" + CORNSTALK_PRICE +"\t" + 
                cornstalkInventory);
        System.out.println("");
    } // close printinventory()

    public static void getArticleID() {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter the article ID (0 to end): ");
	articleID = keyboard.nextInt();
    }  // close getArticleID()

    public static void getArticleQuantity() {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter quantity ordered: ");
	quantityOrdered = keyboard.nextInt();
    }  // close getArticleQuantity()

    public static void addToSubtotal() {
	switch(articleID) {
	case 1:
		subTotal += (MUM_PRICE * quantityOrdered);
		break;
	case 2:
		subTotal += (PUMPKIN_PRICE * quantityOrdered);
		break;
	case 3:
		subTotal += (SCARECROW_PRICE * quantityOrdered);
		break;
	case 4:
		subTotal += (CORNSTALK_PRICE * quantityOrdered);
		break;
	default:
		break;
	} // end switch
    }  // close addToSubtotal()

    public static void decreaseInventory() {
	switch(articleID) {
	case 1:
		mumInventory -= quantityOrdered;
		break;
	case 2:
		pumpkinInventory -= quantityOrdered;
		break;
	case 3:
		scarecrowInventory -= quantityOrdered;
		break;
	case 4:
		cornstalkInventory -= quantityOrdered;
		break;
	default:
		break;
	} // end switch

    }  // close decreaseInventory() 

    public static double calculateLocalTax(double subTotal) {
	double localTax = subTotal * LOCAL_TAX;
	return localTax;
    } // close calculateLocalTax()

    public static double calculateStateTax(double subTotal) {
	double stateTax = subTotal * STATE_TAX;
	return stateTax;
    } // close calculateStateTax()

    public static void displayTotalSale() {
        System.out.println("");
	System.out.println("Subtotal: \t\t$" + subTotal);
	System.out.println("Local Tax (" + LOCAL_TAX * 100 + "%): \t$" + 
                returnedLocalTax);
	System.out.println("State Tax (" + STATE_TAX * 100 + "%): \t$" + 
                returnedStateTax);
	System.out.println("Total Sale: \t\t$"+ (subTotal + returnedLocalTax + 
                returnedStateTax + "\n"));
    } // close displayTotalSale()

    public static void askToContinue() {
        Scanner keyboard = new Scanner(System.in);
	System.out.println("Do you want to repeat with another sale? (Y/N) ");
	input = keyboard.nextLine();
	repeat = input.charAt(0);
    } // close askToContinue()

} // close class PointOfSale
  
