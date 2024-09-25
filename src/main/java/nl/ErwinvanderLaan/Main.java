/* Goal of this file: During a lightning storm the user can calculate how far the lightning is away from him,
how fast the lightning moves and when the lightning will reach him. */

package nl.ErwinvanderLaan;

import java.util.ArrayList;
import java.util.Scanner;


class LightningCalculator {

  public static void main(String[] args)
      throws java.io.IOException {

    int numberOfSeconds, timeBetween;

    // Adding a list to store the calculated distances in feet
    ArrayList<Integer> arrLightningDistFeet = new ArrayList<Integer>();
    arrLightningDistFeet.add(0);

    // Adding a list to store the calculated distances in kilometers
    ArrayList<Double> arrLightningDistKm = new ArrayList<Double>();
    arrLightningDistKm.add(0.0);

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
            if (arrLightningDistFeet.get(0) == 0){
              arrLightningDistFeet.set(0, distanceInFeet);
          }
          arrLightningDistFeet.add(1,distanceInFeet);
          System.out.println("The lightning is " + distanceInFeet + " feet away \n");

          // calculating the distance the lightning has travelled between the last two inputs.
          timeBetween = Integer.parseInt(askForInput("Input the time in seconds between " +
              "the two last seen lightning strikes. Or '0' if it's the first lightning"));
          int travelDistanceFeet = arrLightningDistFeet.get(1) - arrLightningDistFeet.get(0);

          // calculating the lightning speed between two lightning strikes
          if (timeBetween == 0){
            break;
          }
          int lightningSpeedFeet = travelDistanceFeet / timeBetween;
          System.out.println("The lightning speed is: " + lightningSpeedFeet + " feet per second");

          // calculating if and how fast the lightning will reach the user
          if (travelDistanceFeet == 0) {
            System.out.println("The lightning has not moved \n");
          } else if (travelDistanceFeet > 0) {
            System.out.println("The lightning has moved away from you and will not reach you \n");
          } else if (travelDistanceFeet < 0) {
            System.out.println(
                "The lightning has moved " + travelDistanceFeet + " feet towards you");
            System.out.println(
                "It will reach you in " + (arrLightningDistFeet.get(1) / lightningSpeedFeet)
                    + " seconds \n");
          }

          break;

        case "2":
          // calculating the distance in kilometers the lightning is away from the user.
          numberOfSeconds = Integer.parseInt(askForInput("Input the number of seconds " +
              "between the lightning and the thunder"));
          double distanceInKm = (numberOfSeconds * 0.343);
          if (arrLightningDistKm.get(0) == 0.0){
            arrLightningDistKm.set(0, distanceInKm);
          }
          arrLightningDistKm.add(1, distanceInKm);
          System.out.println("The lightning is " + distanceInKm + " feet away \n");

          // calculating the travel distance between the last two inputs.
          double traveldistanceKm = arrLightningDistKm.get(1) - arrLightningDistKm.get(0);
          timeBetween = Integer.parseInt(askForInput("Input the time in seconds between " +
              "the two last seen lightning strikes"));

          // calculating the lightning speed between two lightning strikes
          if (timeBetween == 0) {
            break;
          }
          double lightningSpeed = traveldistanceKm / timeBetween;
          System.out.println(
              "The lightning speed is: " + lightningSpeed + " kilometers per second");

          // calculating if and how fast the lightning will reach the user
          if (traveldistanceKm == 0) {
            System.out.println("The lightning has not moved");
          } else if (traveldistanceKm > 0) {
            System.out.println("The lightning has moved away from you and will not reach you");
          } else if (traveldistanceKm < 0) {
            System.out.println(
                "The lightning has moved " + traveldistanceKm + " kilometers towards you");
            System.out.println("It will reach you in " + (arrLightningDistKm.get(1) / lightningSpeed)
                + " seconds \n");
          }

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

  static String askForInput(String question) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(question);
    return scanner.next();
  }

}

