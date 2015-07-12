package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testBracketsViaRecSuccess() {
		assertTrue("check for good expression", Main.bracketsViaRec("3+2"));
		assertTrue("check for good expression", Main.bracketsViaRec("4+(97*[89+( )]+{8+6})"));
		
	}
	
	@Test
	public void testBracketsViaRecFailure() {
		
		assertFalse("check for leading open bracket", Main.bracketsViaRec("(3+2"));
		assertFalse("check for leading open bracket", Main.bracketsViaRec("("));
		assertFalse("check for opening close bracket", Main.bracketsViaRec(")"));
		assertFalse("check for opening close bracket", Main.bracketsViaRec(")3+2"));
		assertFalse("check for opening close bracket", Main.bracketsViaRec("+)3+2"));
		assertFalse("check for opening close bracket", Main.bracketsViaRec("78-)+)3+2"));
		assertFalse("check for wrong brackets pair", Main.bracketsViaRec("(3+2]"));
	}

}
