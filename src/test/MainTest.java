package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testBracketsViaRecSuccess() {
		assertEquals("check for good expression", Main.bracketsViaRec("3+2"), true );
		
	}
	
	@Test
	public void testBracketsViaRecFailure() {
		
		assertEquals("check for leading open bracket", Main.bracketsViaRec("(3+2"), false );
		assertEquals("check for leading open bracket", Main.bracketsViaRec("("), false );
		assertEquals("check for opening close bracket", Main.bracketsViaRec(")"), false );
		assertEquals("check for opening close bracket", Main.bracketsViaRec(")3+2"), false );
		assertEquals("check for opening close bracket", Main.bracketsViaRec("+)3+2"), false );
		assertEquals("check for opening close bracket", Main.bracketsViaRec("78-)+)3+2"), false );
		assertEquals("check for wrong brackets pair", Main.bracketsViaRec("(3+2]"), false );
		
	}

}
