package ro.ase.cts.Models;

import ro.ase.cts.Exceptions.InvalidDiscountException;
import ro.ase.cts.Exceptions.NotDiscountableException;

public class Book {

	String title;
	String author;
	int nrPages;
	BookGenre genre;
	double price;
	
	
	public Book() {
	}
	public Book(String title, String author, int nrPages, BookGenre genre, double price) {
		super();
		this.title = title;
		this.author = author;
		this.nrPages = nrPages;
		this.genre = genre;
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNrPages() {
		return nrPages;
	}
	public void setNrPages(int nrPages) {
		this.nrPages = nrPages;
	}
	public BookGenre getGenre() {
		return genre;
	}
	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}
	
	
	public void applyDiscount(int percent) throws InvalidDiscountException, NotDiscountableException {
		if(percent<=0||percent>100) {
			throw new InvalidDiscountException("Discount must be between 1% and 100%!");
		}
		if(this.genre.equals(BookGenre.Drama)||this.genre.equals(BookGenre.Romance)) {
			throw new NotDiscountableException("Discounts are not applicable to romance and drama books");
		}
			this.setPrice(price*(100-percent)/100);
			
	}
			
}

