package ro.ase.cts.Tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.Exceptions.InvalidDiscountException;
import ro.ase.cts.Exceptions.NotDiscountableException;
import ro.ase.cts.Models.Book;
import ro.ase.cts.Models.BookGenre;

public class Tests {

	Book dummyBook;
	@Before
	public void setUp() {
		this.dummyBook=new Book("TestBook","Tester",300,BookGenre.SF,60);
	}
	
	@SuppressWarnings("deprecation")
	//Existence, Ordering and Reference tests are not applicable 
	@Test
	public void testDiscount() {//RIGHT && Cross-Check
		try {
			dummyBook.applyDiscount(10);
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(54.0,dummyBook.getPrice(),0.1);
		
	}
	
	@Test
	public void testNegativeAndLowLimit() {//Boundary
		try{
		dummyBook.applyDiscount(-10);
		fail();
		}catch(InvalidDiscountException e) {
		System.out.println(e.getMessage());
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpperLimit() {//Boundary
		try {
			dummyBook.applyDiscount(101);
			fail();
		} catch (InvalidDiscountException e) {
			e.getMessage();
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testInverseCalculation() { //Inverse
		try {
			double initial = dummyBook.getPrice();
			dummyBook.applyDiscount(50);
			assertEquals(initial, dummyBook.getPrice()*2,0.001);
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testErrors() {//E 
		try {
			dummyBook.setGenre(BookGenre.Drama);
			dummyBook.applyDiscount(50);
			fail();
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testErrors2() {//E 
		try {
			dummyBook.setGenre(BookGenre.Romance);
			dummyBook.applyDiscount(50);
			fail();
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test(timeout=20)//Performance
	
	public void testTime() {
		try {
			dummyBook.applyDiscount(50);
			
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDiscountableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
