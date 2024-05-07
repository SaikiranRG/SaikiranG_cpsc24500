package a9;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * An abstract class representing an exercise.
 * It provides common attributes and methods for all types of exercises.
 */
public abstract class Exercise implements Comparable<Exercise> {
	private String name;
	private Date date;
	private double duration;
	private String comment;
	/// Date format for parsing and formatting date strings
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
    * Gets the name of the exercise.
    * @return The name of the exercise.
    */
	public String getName() {
		return name;
	}
	
	/**
     * Sets the name of the exercise.
     * @param name The name to set.
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Sets the name of the exercise.
     * @param name The name to set.
     */
	public Date getDate() {
		return date;
	}
	/**
     * Sets the date of the exercise.
     * @param date The date to set.
     */
	public void setDate(Date date) {
		this.date = date;
	}
	
	 //* sets date to current date
	public void setDate() {
		this.date = new Date(); // current date
	}
	
	/**
     * Sets the date of the exercise from a string formatted as "MM/dd/yyyy".
     * If the provided string is invalid, sets the date to the current date.
     * @param date The date string to parse and set.
     */
	public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
	
	 /**
     * Gets the duration of the exercise.
     * @return The duration of the exercise.
     */
	public double getDuration() {
		return duration;
	}
	
	/**
     * Sets the duration of the exercise.
     * If the duration is negative, sets it to 0.
     * @param duration The duration to set.
     */
	public void setDuration(double duration) {
		if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}
	
	 /**
     * Gets the comment for the exercise.
     * @return The comment for the exercise.
     */
	public String getComment() {
		return comment;
	}
	
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	 /**
     * Sets the comment for the exercise.
     * @param comment The comment to set.
     */
	
	/**
     * Default constructor for Exercise.
     * Sets default values for name, date, duration, and comment.
     */
	public Exercise() {
		name = "Exercise";
		setDate();
		setDuration(0);
		setComment("Unknown exercise");
	}
	
	/**
     * Parameterized constructor for Exercise.
     * Initializes Exercise with provided values for name, date, duration, and comment.
     * @param name     The name of the exercise.
     * @param date     The date of the exercise.
     * @param duration The duration of the exercise.
     * @param comment  The comment for the exercise.
     */
	public Exercise(String name, Date date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
//	public Exercise(String name, String date, double duration, String comment) {
//		setName(name);
//		setDate(date);
//		setDuration(duration);
//		setComment(comment);
//	}
	
	 /**
     * Returns the date of the exercise as a formatted string ("MM/dd/yyyy").
     * @return The date of the exercise as a formatted string.
     */
	protected String getDateAsString() {
		return df.format(date);
	}
	
	/**
	 * generates tab-delimited String containing exercise-specific data 
	 * @return tab-delimited String of exercise-specific info
	 */
	protected abstract String toStringCustomInfo();
	
	// Abstract methods to be implemented by subclasses
	public abstract String getType();
	public abstract double getCaloriesBurned();
	
	/**
     * Returns a string representation of the exercise, including its type, name, date, duration, custom info, calories burned, and comment.
     * @return A string representation of the exercise.
     */
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s", name,getType(),getDateAsString(),duration,toStringCustomInfo(),getCaloriesBurned(),comment);
	}
	
	/**
     * Compares this exercise with another exercise based on their dates.
     * @param other The other exercise to compare.
     * @return A negative integer, zero, or a positive integer as this exercise is before, at the same time, or after the other exercise.
     */
	@Override
	public int compareTo(Exercise other) {
		return this.date.compareTo(other.getDate());
		//return -1;
	}
	/**
     * Returns a summary string of the exercise, including its type, name, date, and calories burned.
     * @return A summary string of the exercise.
     */
	public String toSummaryString() {
		return String.format("%-20s%-25s%-15s%10.2f",getType(),name,getDateAsString(),getCaloriesBurned());
	}
}