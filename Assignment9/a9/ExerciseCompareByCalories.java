package a9;

import java.util.Comparator;

/**
 * The ExerciseCompareByCalories class compares exercises based on their calories burned.
 */
class ExerciseCompareByCalories implements Comparator<Exercise> {
	
	/**
     * Compares two exercises based on their calories burned.
     * @param e1 The first exercise.
     * @param e2 The second exercise.
     * @return An integer as the first exercise's calories burned
     *         is less than, equal to or greater than the second exercise's calories burned.
     */
    @Override
    public int compare(Exercise e1, Exercise e2) {
        return Double.compare(e1.getCaloriesBurned(), e2.getCaloriesBurned());
    }
}