package ro.ase.cts;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		try {
			assertEquals("firstsecond", Function.concatenateStrings("first","second"));
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSQL() {
		try {
			String s=Function.concatenateStrings("first","SELECT something");
			fail("Should not pass!");
		} catch (EmptyStringsException | SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSQL2() {
		try {
			String s=Function.concatenateStrings("SELECT something","second");
			fail("Should not pass!");
		} catch (EmptyStringsException | SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSpecialCharacter() {
		try {
			assertEquals("\"second", Function.concatenateStrings("\"","second"));
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSpace() {
		try {
			assertEquals(" second", Function.concatenateStrings(" ","second"));
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEmpty() {
		try {
			String s=Function.concatenateStrings("","");
			fail("Should not pass!");
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testOneEmpty() {
		try {
			String s=Function.concatenateStrings("","notEmpty");

			fail("Should not pass!");
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testOneEmpty2() {
		try {
			String s=Function.concatenateStrings("notEmpty","");
			fail("Should not pass!");
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testNull() {
		try {
			String s=Function.concatenateStrings("notEmpty",null);
			fail("Should not pass!");
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testNull2() {
		try {
			String s=Function.concatenateStrings(null,"notEmpty");
			fail("Should not pass!");
		} catch (EmptyStringsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
