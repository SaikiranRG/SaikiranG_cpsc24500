package a9;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * The ExerciseWriter class provides utility methods for writing exercises to the screen or a file in tab-delimited format.
 */
public class ExerciseWriter {
	
	 /**
     * Writes a list of exercises to the screen in tab-delimited format.
     * @param exercises The list of exercises to be written.
     */
    public static void writeExercisesToScreen(List<Exercise> exercises) {
        tabulateSummary(exercises);
    }

    /**
     * Writes a list of exercises to a file in tab-delimited format.
     * @param exercises The list of exercises to be written.
     * @param file The file to which the exercises will be written.
     */
    public static void writeExercisesToFile(List<Exercise> exercises, File file) {
        try (FileWriter writer = new FileWriter(file)) {          
        	 String formattedSummary = tabulateSummary(exercises);
             writer.write(formattedSummary); // Write the formatted summary to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a tab-delimited summary of exercises.
     * @param exercises The list of exercises to be summarized.
     * @return A tab-delimited string representing the summary of exercises.
     */
    public static String tabulateSummary(List<Exercise> exercises) {
        StringBuilder tabulatedSummary = new StringBuilder();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
       // Append each exercise
        for (Exercise exercise : exercises) {
        	String formattedDate = dateFormat.format(exercise.getDate());
            tabulatedSummary.append(exercise.getName())
                            .append("\t")
                            .append(exercise.getType())
                            .append("\t")
                            .append(formattedDate)
                            .append("\t")
                            .append(String.format("%.2f",exercise.getCaloriesBurned()))
                            .append("\n");
        }
        
        return tabulatedSummary.toString();
    }
}
