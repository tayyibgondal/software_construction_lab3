package rules;

/**
 * RulesOf6005 represents the collaboration policy of 6.005 as described by the
 * general information on Stellar.
 */
public class RulesOf6005 {

    /**
     * Judge whether a given piece of code may be used in an assignment (problem
     * set or team project) or not, according to the 6.005 collaboration policy.
     *
     * @param writtenByYourself      true if the code in question was written by
     *                               yourself or, in the case of a team project, your teammates,
     *                               otherwise false.
     * @param availableToOthers      if not writtenByYourself, whether or not the
     *                               code in question is available to all other students in the class.
     *                               Otherwise ignored.
     * @param writtenAsCourseWork    if not writtenByYourself, whether or not the
     *                               code in question was written specifically as part of a solution to
     *                               a 6.005 assignment, in the current or past semesters. Otherwise
     *                               ignored.
     * @param citingYourSource       if not writtenByYourself, whether or not you
     *                               properly cite your source. Otherwise ignored.
     * @param implementationRequired whether the assignment specifically asks
     *                               you to implement the feature in question.
     * @return Whether or not, based on the information provided in the
     * arguments, you are likely to be allowed to use the code in
     * question in your assignment, according to the 6.005 collaboration
     * policy for the current semester.
     */
    public static boolean mayUseCodeInAssignment(boolean writtenByYourself,
                                                 boolean availableToOthers, boolean writtenAsCourseWork,
                                                 boolean citingYourSource, boolean implementationRequired) {

        // Check if the code was written by yourself or your teammates
        if (writtenByYourself) {
            return false; // You can use code you wrote yourself.
        }

        // If not written by yourself, check the collaboration policy
        if (availableToOthers) {
            // Code is available to others
            if (citingYourSource) {
                // Proper citation is provided
                return true;
            } else {
                // No proper citation, you cannot use it
                return false;
            }
        } else {
            // Code is not available to others
            if (writtenAsCourseWork) {
                // It was written as part of a 6.005 assignment
                if (implementationRequired) {
                    // Assignment specifically asks you to implement it
                    return true;
                } else {
                    // Not required to implement, you cannot use it
                    return false;
                }
            } else {
                // Code was not written as course work, you cannot use it
                return false;
            }
        }
    }

    /**
     * Main method of the class.
     *
     * Runs the mayUseCodeInAssignment method.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("You may certainly use code you wrote yourself: " +
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
}
