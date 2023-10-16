package adapterPattern;

import java.util.Scanner;

public class SmartElectronicApp {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        // get device.
        Laptop laptop = new Laptop();
        Refrigerator refrigerator = new Refrigerator();
        SmartphoneCharger charger = new SmartphoneCharger();

        System.out.println("Welcome to Plugging Devices into Power Outlets!\n");

        while (true) {
            System.out.println("Electronic Devices Available:");
            System.out.println("1.) Laptop");
            System.out.println("2.) Refrigerator");
            System.out.println("3.) Smartphone Charger");

            // to choose user what electronic device she/he wants to plug in.
            System.out.print("\nSelect a device you want to plug in: ");
            Integer userChoice = userInput.nextInt();
            System.out.println();
            userInput.nextLine();

            switch (userChoice) {
                case 1: // for laptop.
                    PowerOutlet laptopOutlet = new LaptopAdapter(laptop);
                    laptopOutlet.plugIn();
                    break;

                case 2: // for refrigerator.
                    PowerOutlet refrigeratorOutlet = new RefrigeratorAdapter(refrigerator);
                    refrigeratorOutlet.plugIn();
                    break;

                case 3: // for smartphone charger.
                    PowerOutlet smartphoneChargerOutlet = new SmartphoneAdapter(charger);
                    smartphoneChargerOutlet.plugIn();
                    break;

                default: // for user input invalid choice.
                    System.out.println("Invalid device! Please try again.");
                    break;

            }

            // to prompt user if she/he want to continue the program.
            System.out.print("\n\nDo you want to plug in another electronic device? (Y/N): ");
            String userChoiceB = userInput.nextLine();
            System.out.println();
            if (!userChoiceB.toLowerCase().equals("y")) {
                System.out.println("Program Terminated!");
                System.out.println("Programmed by: Ronan D. Soriano | 3 BSCS - 1");
                break;
            }
        }
        userInput.close();
    }
}
