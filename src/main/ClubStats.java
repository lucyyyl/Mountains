package main;

import java.util.Scanner;

public class ClubStats {

        public static Climber lucy = new Climber();
        public static Club club = new Club();
        public static boolean exit = false;

    public static void main(String[] args) {

        lucy.setClimberName("Lucy");
        lucy.setClimberAge(22);
        lucy.setClimberGender("Female");

        club.addClimber(lucy);


        for (int i = 0; i < 10; i++ ){
            Mountain mountain = new Mountain();
            mountain.setMountainName("mountain"+i);
            mountain.setMountainHeight(98 + i);
            lucy.addClimb(mountain);
        }

        Scanner user_input = new Scanner(System.in);


        System.out.println("Welcome to the Misty Mountains club!");
        System.out.println("What would you like to do today?");

        while (!exit) {

            System.out.println("1. Add new climber info.");
            System.out.println("2. Add a new mountain to your record.");
            System.out.println("3. See Club statistics.");
            System.out.println("4. Exit.");

            String choice = user_input.next();


            switch (choice) {

                case "1":
                    newClimber();
                    System.out.println("What would you like to do next?");
                    break;
                case "2":
                    newMountain();
                    System.out.println("What would you like to do next?");
                    break;
                case "3":
                    clubStatistics();
                    System.out.println("What would you like to do next?");
                    break;
                case "4":
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Sorry your choice wasn't recognised - please choose again.");
            }
        }

    }

    public static void newClimber(){
        Scanner user_input = new Scanner(System.in);
        Climber climber = new Climber();
        System.out.println("Name:");
        climber.setClimberName(user_input.next().trim());
        System.out.println("Age:");
        climber.setClimberAge(user_input.nextInt());
        System.out.println("Gender:");
        climber.setClimberGender(user_input.next().trim());
        System.out.println(climber.getClimberName());
        club.addClimber(climber);
        System.out.println(club.climbers.size());
    }

    public static void newMountain(){
        Scanner user_input = new Scanner(System.in);
        System.out.println("Name of mountain:");
        Mountain mountain = new Mountain();
        mountain.setMountainName(user_input.next().trim());
        System.out.println("Height of mountain (meters):");
        mountain.setMountainHeight(user_input.nextInt());
        lucy.addClimb(mountain);
    }

    public static void clubStatistics(){

        boolean mainMenu = false;

        while (!mainMenu) {
            System.out.println("What statistics would you like to see:");
            System.out.println("1. Highest Climber");
            System.out.println("2. Highest Average Climber");
            System.out.println("3. All climbs over a threshold");
            System.out.println("4. Back to main menu");

            Scanner user_input = new Scanner(System.in);
            String selection = user_input.next();

            switch (selection){
                case "1":
                    highestClimber();
                    break;
                case "2":
                    highestAvgClimber();
                    break;
                case "3":
                    overX();
                    break;
                case "4":
                    mainMenu = true;
                    break;
                default:
                    System.out.println("Sorry your choice wasn't recognised - please choose again.");
            }

        }
    }

    public static void highestClimber(){
        club.getHighestClimber();
        System.out.println("The climber with the highest climb is: " + club.highestClimber.getClimberName() + ". Their highest climb is: " + club.highestClimber.gethighestClimb().getMountainHeight() + " metres." );
    }

    public static void highestAvgClimber(){
        club.getHighestAverageClimber();
        System.out.println("The climber with the highest average climbs is: " + club.highestAverageClimber.getClimberName() + ". Their average climb height is: " + club.highestAverageClimber.getaverageHeight() + " metres." );
    }

    public static void overX(){
        club.getAllOverX();
        System.out.println("All the climbs recorded over X meters: ");
        club.printAllOverX();
    }


}
