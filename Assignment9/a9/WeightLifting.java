package a9;

import java.util.Date;

/**
 * The WeightLifting class represents an exercise of type Weightlifting.
 */
class WeightLifting extends Exercise {
    private double totalWeight;

    /**
     * Constructs a new WeightLifting exercise with the given parameters.
     * @param name The name of the exercise.
     * @param date The date of the exercise.
     * @param duration The duration of the exercise (in minutes).
     * @param comment Any additional comments about the exercise.
     * @param totalWeight The total weight lifted during the exercise (in pounds).
     */
    public WeightLifting(String name, Date date, double duration, String comment, double totalWeight) {
        super(name, date, duration, comment);
        this.totalWeight = totalWeight;
    }
    //Gets the total weight lifted during the exercise.
    public double getTotalWeight() {
        return totalWeight;
    }
    //Sets the total weight lifted during the exercise.
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    //Gets the type of exercise, which is "Weightlifting"
    @Override
    public String getType() {
        return "Weightlifting";
    }
    
    /**
    * Calculates the calories burned during the exercise.
    * @return The calories burned during the exercise.
    */
    @Override
    public double getCaloriesBurned() {
        return (totalWeight / getDuration()) * 50;
    }

    /**
     * Generates a custom string containing exercise-specific information. abstract method from exercise
     * @return A string with information about the total weight lifted.
     */
    @Override
    protected String toStringCustomInfo() {
        return String.format("Total Weight: %.2f lbs", totalWeight);
    }
}

