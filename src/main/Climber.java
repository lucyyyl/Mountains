package main;

import java.util.ArrayList;

public class Climber {
    private String climberName;
    private String climberGender;
    private int  climberAge;
    private Mountain highestClimb;
    private double averageHeight;
    ArrayList <Mountain> climbsOverX = new ArrayList<>();
    ArrayList <Mountain> climbs = new ArrayList<>();


    public void addClimb(Mountain mountain){
        climbs.add(mountain);
    }

    public void setClimberName(String newName) {
        climberName = newName;
    }

    public String getClimberName(){
        return climberName;
    }

    public void setClimberAge(int newAge){
        climberAge = newAge;
    }

    public int getClimberAge(){
        return climberAge;
    }

    public void setClimberGender(String newGender){
        climberGender = newGender;
    }

    public Mountain gethighestClimb(){
        for (Mountain climb : climbs){
            int height = 0;
            if (climb.getMountainHeight() > height){
                height = climb.getMountainHeight();
                highestClimb = climb;
            }
        }
        return highestClimb;
    }

    public double getaverageHeight(){
        double height = 0;
        for (Mountain climb : climbs){
            height += climb.getMountainHeight();
        }
        averageHeight = height / climbs.size();
        return averageHeight;
    }

// Dunno if i'm feeding the height in wrong here
    public void getClimbsOverX(double height){
        for (Mountain climb : climbs){
            if (climb.getMountainHeight() > height){
                climbsOverX.add(climb);
            }
        }
    }

//    public void printClimbsOverX(){
//        for (Mountain climb: climbsOverX){
//
//            System.out.println("Mountain name: " + climb.getMountainName() +". Mountain height: " + climb.getMountainHeight() + ".");
//        }
//    }

}
