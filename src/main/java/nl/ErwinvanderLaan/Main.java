/* Goal of this file: During a lightning storm the user can calculate how far the lightning is away from him,
how fast the lightning moves and when the lightning will reach him. */

package nl.ErwinvanderLaan;

import java.util.ArrayList;
import java.util.Scanner;

class UserInput {
    static String askForInput(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.next();
    }

    public class LightningCalculator {
        public static void main(String[] args)
                throws java.io.IOException {

            int numberOfSeconds, timeBetween;
            ArrayList<Integer> lightningDistFeet = new ArrayList<Integer>();
            lightningDistFeet.add(0);
            ArrayList<Double> LightningDistKm = new ArrayList<Double>();
            LightningDistKm.add(0.0);

            System.out.println("""
                     Welcome to the lightning movement calculator!
                     With it you can calculate:
                     First, the distance lightning is away from you.
                     Then, the speed with which the lightning moves.
                     Finally, if the lightning reaches you and, if so, when it does.
                    """);


        /* letting the user repeatedly input the number of seconds to calculate:
        lightning travel speed and when it reaches the user */
            while (true) {
                System.out.println("""
                        Do you want to know the distances in feet of kilometer?
                        Enter '1' for distance in feet.
                        Enter '2' for distance in kilometer
                        Enter 'q' to quit.
                        """);

                String chosenOption = askForInput("Choose an option");

                // calculating the distance in feet / kilometers the lightning is away from the user
                switch (chosenOption) {


                    case "1":
                        // calculating the distance in feet the lightning is away from the user
                        numberOfSeconds = Integer.parseInt(askForInput("Input the number of seconds " +
                                "between the lightning and the thunder"));
                        int distanceInFeet = (numberOfSeconds * 1125);
                        lightningDistFeet.add(distanceInFeet);
                        System.out.println("The lightning is " + distanceInFeet + " feet away \n");

                        // calculating the distance the lightning has travelled between the last two inputs.
                        timeBetween = Integer.parseInt(askForInput("Input the time in seconds between " +
                                "the two last seen lightning strikes"));
                        int travelDistanceFeet = lightningDistFeet.get(-2) - lightningDistFeet.get(-1);

                        // calculating the lightning speed between two lightning strikes
                        int lightningSpeedFeet = travelDistanceFeet / timeBetween;
                        System.out.println("The lightning speed is: " + lightningSpeedFeet + " feet per second");

                        // calculating if and how fast the lightning will reach the user
                        if (travelDistanceFeet == 0)
                            System.out.println("The lightning has not moved");
                        else if (travelDistanceFeet < 0)
                            System.out.println("The lightning has moved away from you and will not reach you");
                        else if (travelDistanceFeet > 0)
                            System.out.println("The lightning has moved " + travelDistanceFeet + " feet towards you");
                        System.out.println("It will reach you in " + (lightningDistFeet.get(-1) / lightningSpeedFeet)
                                + " seconds \n");

                        break;


                    case "2":
                        // calculating the distance in kilometers the lightning is away from the user.
                        numberOfSeconds = Integer.parseInt(askForInput("Input the number of seconds " +
                                "between the lightning and the thunder"));
                        double distanceInKilometers = (numberOfSeconds * 0.343);
                        LightningDistKm.add(distanceInKilometers);
                        System.out.println("The lightning is " + distanceInKilometers + " kilometers away \n");

                        // calculating the travel distance between the last two inputs.
                        double traveldistanceKm = LightningDistKm.get(-2) - LightningDistKm.get(-1);

                        // calculating the lightning speed in kilometers between two lightning strikes
                        timeBetween = Integer.parseInt(askForInput("Input the time in seconds between " +
                                "the two last seen lightning strikes"));
                        double lightningSpeed = traveldistanceKm / timeBetween;
                        System.out.println("The lightning speed is: " + lightningSpeed + " kilometers per second");

                        // calculating if and how fast the lightning will reach the user
                        if (traveldistanceKm == 0)
                            System.out.println("The lightning has not moved");
                        else if (traveldistanceKm < 0)
                            System.out.println("The lightning has moved away from you and will not reach you");
                        else if (traveldistanceKm > 0)
                            System.out.println("The lightning has moved " + traveldistanceKm + " kilometers towards you");
                        System.out.println("It will reach you in " + (LightningDistKm.get(-1) / lightningSpeed)
                                + " seconds \n");

                        break;

                    // Option to quit the program.
                    case "q":
                        System.out.println("Exiting Lightning calculator. Have a nice day!");
                        return;

                    // default for an invalid input
                    default:
                        System.out.println("Invalid input. Please try again");
                    break;
                }
            }
        }
    }
    }

