/* Goal of this file: During a lightning storm the user can calculate how far the lightning is away from him,
how fast the lightning moves and when the lightning will reach him. */

package nl.ErwinvanderLaan;

public class Main {
    public static void main(String[] args)
    throws java.io.IOException {
        char ch, distance, ignore ;
        int numberOfSeconds, timeBetween;
        int arrayDistancesInFeet[];
        arrayDistancesInFeet = new int [2];
        double arrayDistancesinKm [];
        arrayDistancesinKm = new double [2];


        System.out.println("Welcome to the lightning movement calculator");
        System.out.println("With it you can calculate: ");
        System.out.println("  The distance lightning is away from you. ");
        System.out.println("  The speed with which the lightning moves");
        System.out.println("  The time it takes the lightning to reach you");
        System.out.println("To do so you'll have to input the number of seconds between: ");
        System.out.println("  when you saw the lightning");
        System.out.println("  when you heard the thunder");

        /* letting the user repeatedly input the number of seconds to calculate:
        lightning travel speed and when it reaches the user */
        for ( ; ;) {
            // letting the user input the number of seconds between lightning seen and thunder heard.
            do {
                System.out.print("Input the number of seconds (or type 'q' to quit): ");
                ch = (char) System.in.read();
                numberOfSeconds = ch - '0';

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (ch < 1 & ch != 'q');

            if ( ch == 'q') break;

            // letting the user choose between distance in feet or distance in kilometers
            do {
                System.out.println("Press 1 for distance in feet");
                System.out.print("Press 2 for distance in kilometers (or type 'q' to quit) ");
                distance = (char) System.in.read ( );

                do {
                    ignore = (char) System.in.read ( );
                }while (ignore != '\n') ;
            }while (distance < '1' | distance > '2' & distance != 'q' );

            if (distance == 'q' ) break;

            // calculating the distance in feet / kilometers the lightning is away from the user
            switch(distance){
                // calculating the distance in feet the lightning is away from the user
                case '1':
                    int distanceInFeet = (numberOfSeconds * 1125) ;
                    System.out.println("The lightning is " + distanceInFeet + " feet away \n");
                    arrayDistancesInFeet [1] = distanceInFeet;
                    break ;

                // calculating the distance in kilometers the lightning is away from the user
                case '2':
                    double distanceInKilometers = (numberOfSeconds * 0.343) ;
                    System.out.println("The lightning is " + distanceInKilometers + " kilometers away \n");
                    arrayDistancesinKm [1] = distanceInKilometers;
                    break;
            }

            // letting the user type the time between two lightning strikes
            do {
                System.out.print("Input the time in seconds between two lightning strikes (or type 'q' to quit): ");
                ch = (char) System.in.read();
                timeBetween = ch - '0';

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (ch < 1 & ch != 'q');

            if ( ch == 'q') break;

            // calculating the travel distance between two lightning strikes
            double traveldistance = arrayDistancesinKm [1] - arrayDistancesinKm [0] ;


            // calculating the lightning speed between two lightning strikes
            double lightningSpeed = traveldistance / timeBetween ;
            System.out.println("The lightning speed is:" + lightningSpeed);

            // calculating if and how fast the lightning will reach the user
            if (traveldistance == 0)
                System.out.println("The lightning has not moved");
            else if (traveldistance < 0)
                System.out.println("The lightning has moved away from you and will not reach you");
            else if (traveldistance > 0)
                System.out.println("The lightning has moved" + traveldistance + "kilometers towards you");
                System.out.println("It will reach you in "+ (arrayDistancesinKm [1] / lightningSpeed ) + "seconds");

            arrayDistancesinKm [0] = arrayDistancesinKm [1];

        }
    }
}