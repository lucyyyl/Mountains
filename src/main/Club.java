package main;

import java.util.ArrayList;

public class Club {
    ArrayList <Climber> climbers = new ArrayList<>();
    Climber highestAverageClimber;
    Climber highestClimber;
    ArrayList<Mountain> allOverX = new ArrayList<>();


    public void addClimber(Climber climber){
        climbers.add(climber);
    }

    public Climber getHighestAverageClimber(){
        for (Climber climber : climbers){
            double averageHeight = 0;
            if (climber.getaverageHeight() > averageHeight){
                averageHeight = climber.getaverageHeight();
                highestAverageClimber = climber;
            }
        }
        return highestAverageClimber;
    }


    public Climber getHighestClimber(){
        double highestMountain = 0;
        for (Climber climber : climbers){
            if (climber.climbs.size() > 0){
                Mountain highestClimb = climber.gethighestClimb();
                double highestHeight = highestClimb.getMountainHeight();
                if (highestHeight > highestMountain){
                    highestMountain = highestHeight;
                    highestClimber = climber;
                }
            } else {
                continue;
            }

        }
        return highestClimber;
    }

    public ArrayList<Mountain> getAllOverX(double height) {
        for (Climber climber:climbers) {
            climber.getClimbsOverX(height);
            if (climber.climbsOverX.size() > 0) {
                allOverX.addAll(climber.climbsOverX);
            } else {
                continue;
            }
        }
        int i = 1;
        for (Mountain mountain:allOverX){
            System.out.println(i + ") Name: " + mountain.getMountainName() + ". Height: " + mountain.getMountainHeight() + ".");
            i ++;
        }
        return allOverX;
    }

    public void printAllOverX(){
        for (Mountain mountain:allOverX){
            System.out.println("Name: " + mountain.getMountainName() + ". Height: " + mountain.getMountainHeight() + ".");
        }
    }
}
