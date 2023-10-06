/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class RulesOf6005Test {

    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        
        // Additional test cases:
        
        // Test 1: Code is not self-written, publicly available, and cited.
        // It should return true because the code is publicly available and cited.
        assertTrue("Expected true: publicly available and cited code",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
        
        // Test 2: Code is not self-written, not publicly available, and not required for implementation.
        // It should return false because the code is not publicly available and not required for implementation.
        assertFalse("Expected false: not publicly available and not required for implementation",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, false, false));
    }
}
