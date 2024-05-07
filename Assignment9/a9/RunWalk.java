package a9;

import java.util.Date;

/**
 * The RunWalk class represents an exercise of type Run/Walk.
 */
class RunWalk extends Exercise {
    private double distance;

    /**
     * Constructs a new RunWalk exercise with the given parameters.
     * @param name The name of the exercise.
     * @param date The date of the exercise.
     * @param duration The duration of the exercise (in minutes).
     * @param comment Any additional comments about the exercise.
     * @param distance The distance covered during the exercise (in miles).
     */
    public RunWalk(String name, Date date, double duration, String comment, double distance) {
        super(name, date, duration, comment);
        this.distance = distance;
    }
    // Gets the distance covered during the exercise.
    public double getDistance() {
        return distance;
    }
    //Sets the distance covered during the exercise.
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Gets the type of exercise, which is "Run/Walk".
     * @return The type of exercise.
     */
    @Override
    public String getType() {
        return "Run/Walk";
    }

    /**
     * Calculates the calories burned during the exercise.
     * @return The calories burned during the exercise.
     */
    @Override
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }

    /**
     * Generates a custom string containing exercise-specific information. implementing abstract method
     * @return A string with information about the distance covered.
     */
    @Override
    protected String toStringCustomInfo() {
        return String.format("Distance: %.2f miles", distance);
    }
}