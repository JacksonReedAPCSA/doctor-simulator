import java.util.Scanner;
import java.util.ArrayList;
/**
 * A NOT SO ACCURATE DOCTOR SIMULATOR, TRY TO KEEP YOUR PATIENT ALIVE
 * @author Damian, Andrei
 * 
 * SUGGESTIONS FOR EXTENSIONS: 
 *  Change choiceEQ ifs nest using case switch to make it neater
 *  Add an enum class to represents the items and action choices for the player, currently represented by int
 *  Make the option to have multiple patients to manage at the same time (add another Patient type and dialogues)
 *  Expand Events.java and make other random events (ex: heart attack)
 *  Have another aspect for Patient.java (ex: pain level)
 *  More graphics for data representation or more (use window.java)
 *  Modify the graphics so it looks prettier
 *  Patient subclass
 * 
 *  PLEASE IGNORE EXTENSIONS Draw.java, DrawListener.java, StdDraw.java, and window.java. 
 */

/**
 * MAIN RUNNER FOR THE GAME PLAYED IN TERMINAL. EVERY CLASS AND FUNCTIONS ARE CONNECTED HERE.
 *@author Damian
 */
public class DoctorSimulator {
    public static void main(String[] args) {

        //INITIALIZE PATIENT, SCANNER, INGREDIENTS
        Patient patient = new Patient();
        Scanner scan = new Scanner(System.in);
        boolean isDead = false;
        boolean isEvent = true;
        //MORE INGREDIENTS CAN BE ADDED
        Ingredient mint = new Ingredient(1, -5, 0);
        Ingredient chilli = new Ingredient(2, 8, 0);
        Ingredient coffee = new Ingredient(3, 12, 1);
        Ingredient chocolate = new Ingredient(4, -15, 1);
        ArrayList<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        ingredientsList.add(mint);
        ingredientsList.add(chilli);
        ingredientsList.add(coffee);
        ingredientsList.add(chocolate);
        

        System.out.println("Welcome Doctor! Here is your patient, their name is...");
        System.out.println("Enter name: . . .");
        String name = scan.nextLine();
        patient.setName(name);

        System.out.println("Set game difficulty: . . .\n0 - easy\n1 - hard");
        int difficulty = -1;
        while (difficulty != 0 && difficulty != 1) {
            difficulty = scan.nextInt();
            if (difficulty != 0 && difficulty != 1) {
                System.out.println("Invalid input, please enter 0 (easy) or 1 (hard)");
            }
        }
        Events events = new Events(difficulty);

        System.out.println("\n" + name
                + " is ready to be treated. They need to be between, 34 - 44 celcius and 40 - 160 bpm, inclusive to be alive. You can start with using the equipments or the medicine.");

        /**MAIN WHILE LOOP OF GAME DIALOGUES AND PLAYER INTERACTIONS
         *
         */
        while (!isDead) {
            System.out.println("isDead " + isDead);
            isEvent = events.getEvent();
            int turnLeft = 6;
            boolean isCritical = false;
            
            //ONLY WHEN isEvent IS TRUE
            while (isEvent) {
                System.out.println("EMERGENCY! Get " + name
                        + " between 36 - 38 celcius and 80 - 100 bpm in " + turnLeft
                        + " turns. Stabilize them or game over.");
                System.out.println("What would you like to do?");
                System.out.println("1 - Use Equipments");
                System.out.println("2 - Use Medicine");
                System.out.println("3 - Help Page");
                int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println(
                            "\n1 - Thermometer\n2 - Heart rate monitor\n3 - Blanket\n4 - Defibrillators\n5 - Ice pack\n6 - Flute");
                    int choiceEq = scan.nextInt();
                    String equipToString = new String();
                    switch (choiceEq) {
                      case 1:  equipToString = "" + patient.getTemp() + " celcius";
                                               break;
                      case 2:  equipToString = "" + patient.getBpm() + " beats per minute";
                                               break;
                      case 3:  equipToString = "Used a blanket, " + name + " gets warmer";
                                               patient.addTemp();
                                               break;
                      case 4:  equipToString = "Used a defibrillators, " + name + " gets their heart pumping";
                                               patient.addBpm();
                                               break;
                      case 5:  equipToString = "Used an ice pack, " + name + " gets colder";
                                               patient.decTemp();
                                               break;
                      case 6:  equipToString = "Played with the flute, " + name + " hearts gets calmer";
                                               patient.decBpm();
                                               break;
                    }
                    System.out.println(equipToString);
                    // if safe false, continue event
                    isCritical = patient.checkCondition(36, 38, 80, 100);

                    events.triggerCondition();
                    if (turnLeft == 0 && isCritical) {
                        isDead = true;
                        break;
                    } else {
                        turnLeft -= 1;
                    }
                    if (turnLeft > 0 && !isCritical) {
                        isEvent = false;
                        System.out.println("Condition Stabilized, continue as normal.");
                    }
                }

                if (choice == 2) {
                    System.out.println("\nCombine 3 ingredients, make different effects:");
                    System.out.println("Ingredients list: \n0 - Mint\n1- Chilli\n2 - Coffee\n3 - Chocolate");
                    int ing1 = scan.nextInt();
                    int ing2 = scan.nextInt();
                    int ing3 = scan.nextInt();
                    Medicine medicine = new Medicine(ingredientsList.get(ing1), ingredientsList.get(ing2),
                            ingredientsList.get(ing3));
                    medicine.setPotencies();
                    System.out.println(medicine);
                    turnLeft--;
                }
                isDead = patient.checkCondition(34, 44, 40, 160);
                
            }
            if (isDead) {
                break;
            }

            /**WHILE isEvent IS FALSE
             */
            System.out.println("What would you like to do?");
            System.out.println("1 - Use Equipments");
            System.out.println("2 - Use Medicine");
            System.out.println("3 - Help Page");
            int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println(
                            "\n1 - Thermometer\n2 - Heart rate monitor\n3 - Blanket\n4 - Defibrillators\n5 - Ice pack\n6 - Flute");
                    int choiceEq = scan.nextInt();
                    String equipToString = new String();
                    switch (choiceEq) {
                      case 1:  equipToString = "" + patient.getTemp() + " celcius";
                                               break;
                      case 2:  equipToString = "" + patient.getBpm() + " beats per minute";
                                               break;
                      case 3:  equipToString = "Used a blanket, " + name + " gets warmer";
                                               patient.addTemp();
                                               break;
                      case 4:  equipToString = "Used a defibrillators, " + name + " gets their heart pumping";
                                               patient.addBpm();
                                               break;
                      case 5:  equipToString = "Used an ice pack, " + name + " gets colder";
                                               patient.decTemp();
                                               break;
                      case 6:  equipToString = "Played with the flute, " + name + " hearts gets calmer";
                                               patient.decBpm();
                                               break;
                    }
                    System.out.println(equipToString);
                    events.triggerCondition();
                    isEvent = events.getEvent();
                 }

            if (choice == 2) {
                System.out.println("\nCombine 3 ingredients, make different effects:");
                System.out.println("Ingredients list: \n0 - Mint\n1- Chilli\n2 - Coffee\n3 - Chocolate");
                int ing1 = scan.nextInt();
                int ing2 = scan.nextInt();
                int ing3 = scan.nextInt();
                Medicine medicine = new Medicine(ingredientsList.get(ing1), ingredientsList.get(ing2),
                        ingredientsList.get(ing3));
                medicine.setPotencies();
                patient.addTempMed(medicine.getTempPotency());
                patient.addBpmMed(medicine.getBpmPotency());
                System.out.println(medicine);
            }
            isDead = patient.checkCondition(34, 44, 40, 160);
            
            if (choice == 3) {
              System.out.println("You've reached the help page!");
              System.out.println("Your goal is to keep your patient in the correct temperature and Bpm range.");
              System.out.println("You can check the patient's temperature and Bpm by using the Thermometer and the Heart Rate Sensor in the equipment page.");
              System.out.println("Once you have seen your patients statistics you can use other equipment to move the patient into the correct range.");
              System.out.println("Blanket - Increases Temperature.");
              System.out.println("Defibrillators - Increases Bpm.");
              System.out.println("Ice Pack - Decreases Temperature.");
              System.out.println("Flute - Decreases Bpm.");
              System.out.println("You may also create medicine to help your patient.");
              System.out.println("To create medicine you must select 3 different ingredients to create your remedy(you may pick the same ingredient multiple times).");
              System.out.println("Mint - Dec Temperature.");
              System.out.println("Chili - Inc Temperature.");
              System.out.println("Coffee - Inc Bpm.");
              System.out.println("Chocolate - Dec Bpm.");
            }
        }

        //WHEN isDead = true
        System.out.println(
                "\nGAME OVER!\nTEMP GRAPH = " + patient.tempArray() + "\nBPM GRAPH = " + patient.bpmArray());
        //DATA GRAPH
        Grapher tempGraph = new Grapher(patient.tempGraph(), 0);
        Grapher bpmGraph = new Grapher(patient.bpmGraph(), 1);
        tempGraph.drawGraph();
        bpmGraph.drawGraph();
    }
    
    //public String equipmentSwitcher(
}