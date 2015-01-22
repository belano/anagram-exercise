package com.belano;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for {@link com.belano.PoemLine} class
 */
public class PoemLineTest {

	@Test
	public void shouldReturnTrueWhenLineIsAnagram() {
		PoemLine line1 = new PoemLine("In reliable mockery");
		PoemLine line2 = new PoemLine("Rollick ye bare mien");
		assertTrue("Expected anagram", line1.isAnagramOf(line2));
	}

	@Test
	public void shouldReturnFalseWhenLineIsNotAnagram() {
		PoemLine line1 = new PoemLine("Said the little boy, \"Sometimes I drop my spoon.\"");
		PoemLine line2 = new PoemLine("Said the old man, \"I do that too.\"");
		assertFalse("Unexpected anagram", line1.isAnagramOf(line2));
	}

}
