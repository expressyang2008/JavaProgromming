/**
 * @program: JavaProgromming
 * @description: A Example of class
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-20 00:45
 */

public class CollegeStudent {
    /**
     * Create a new Student object with the specified name and ID.
     *
     * @param name The student's name as a String
     * @param id   The student's ID as an int
     */
    public CollegeStudent(String name, int id) {
        studentName = name;
        studentID = id;
    }

    /**
     * Get the name of this student
     *
     * @return The name of this student
     */
    public String getName() {
        return studentName;
    }

    /**
     * Get the ID of this student
     *
     * @return The ID of this student
     */
    public int getID() {
        return studentID;
    }

    /**
     * Sets the number of units earned.
     *
     * @param units The new number of units earned
     */
    public void setUnits(double units) {
        unitsEarned = units;
    }

    public double getUnits() {
        return unitsEarned;
    }

    /**
     * Gets the number of units earned.
     *
     * @return Whether the student has enough units to graduate
     */
    public boolean hasEnoughUnits() {

        return (unitsEarned >= UNIT_TO_GRADUATE);
    }

    /**
     * Increment the number of units earned.
     *
     * @param additionalUnits The additional number of units earned
     */
    public void incrementUnits(double additionalUnits)
    {
        unitsEarned += additionalUnits;
    }

    /**
     * Create a string identifying this studetn.
     *
     * @return The string used to display this student
     */
    public String toString() {
        return studentName + "{#" + studentID + "}";
    }

    /* public constants */
    public static final double UNIT_TO_GRADUATE = 166.0;

    /* private instance variable */
    private String studentName;
    private int studentID;
    private double unitsEarned;
}
