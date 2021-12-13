/**
 * @program: JavaProgromming
 * @description: This class keeps track of the profiles of all users in the
 * FacePamphlet application.  Note that profile names are case
 * sensitive, so that "ALICE" and "alice" are NOT the same name.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-26 17:49
 */
import java.util.*;
import acm.graphics.GCompound;
public class FaceMomentsDatabase implements FaceMomentsConstants{
    /**
     * Constructor
     * This method takes care of any initialization needed for
     * the database.
     */
    public FaceMomentsDatabase() {
        // You fill this in
        // profileMap = null; // Can't initialize a HashMap to null.
    }


    /**
     * This method adds the given profile to the database.  If the
     * name associated with the profile is the same as an existing
     * name in the database, the existing profile is replaced by
     * the new profile passed in.
     */
    public void addProfile(FaceMomentsProfile profile) {
        // You fill this in
        profileMap.put(profile.getName(), profile);
    }


    /**
     * This method returns the profile associated with the given name
     * in the database.  If there is no profile in the database with
     * the given name, the method returns null.
     */
    public FaceMomentsProfile getProfile(String name) {
        // You fill this in.  Currently always returns null.
        return profileMap.get(name);
    }


    /**
     * This method removes the profile associated with the given name
     * from the database.  It also updates the list of friends of all
     * other profiles in the database to make sure that this name is
     * removed from the list of friends of any other profile.
     *
     * If there is no profile in the database with the given name, then
     * the database is unchanged after calling this method.
     */
    public void deleteProfile(String name) {
        // You fill this in
        profileMap.remove(name);
    }


    /**
     * This method returns true if there is a profile in the database
     * that has the given name.  It returns false otherwise.
     */
    public boolean containsProfile(String name) {
        // You fill this in.  Currently always returns false.
        if (profileMap.get(name) != null) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String, FaceMomentsProfile> getDatabase() {
        return profileMap;
    }

    /* Instance variables */
    private HashMap<String, FaceMomentsProfile> profileMap = new HashMap<String, FaceMomentsProfile>();
}
