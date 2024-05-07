package a9;

import java.util.Date;

/**
 * The RockClimbing class represents an exercise of type Rock Climbing.
 */
class RockClimbing extends Exercise {
    private double wallHeight;
    private int repetitions;

    /**
     * Constructs a new RockClimbing exercise with the given parameters.
     * @param name The name of the exercise.
     * @param date The date of the exercise.
     * @param duration The duration of the exercise (in minutes).
     * @param comment Any additional comments about the exercise.
     * @param wallHeight The height of the climbing wall (in feet).
     * @param repetitions The number of repetitions performed.
     */
    public RockClimbing(String name, Date date, double duration, String comment, double wallHeight, int repetitions) {
        super(name, date, duration, comment);
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }
    //Gets the height of the climbing wall.
    public double getWallHeight() {
        return wallHeight;
    }
    //Sets the height of the climbing wall.
    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }
    //Gets the number of repetitions performed.
    public int getRepetitions() {
        return repetitions;
    }
    // Sets the number of repetitions performed.
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    //Gets the type of exercise, which is "Rock Climbing".
    @Override
    public String getType() {
        return "Rock Climbing";
    }

    /**
     * Calculates the calories burned during the exercise.
     * @return The calories burned during the exercise.
     */
    @Override
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / getDuration()) * 100;
    }

    /**
     * Generates a custom string containing exercise-specific information. abstract method from exercise
     * @return A string with information about the climbing wall height and repetitions.
     */
    @Override
    protected String toStringCustomInfo() {
        return String.format("WHeight: %.2f ft, Rep: %d", wallHeight, repetitions);
    }
}