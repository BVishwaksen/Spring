package com.sunsoft;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	Map<Integer, Book> book = new HashMap<Integer,Book>();
	int index=4;
	public BookController(){
		book.put(1,new Book(1,"Python",1999,"Pearson","Mark Lutz"));
		book.put(2,new Book(2,"Java",2002,"Cengage","Gousling"));
		book.put(3,new Book(3,"Machine Learning",2007,"TMH","Peter Flach"));
	}
	
	@RequestMapping("/display_all")
	public String getBookDetails() {
		String bookString = "";
		for (Map.Entry<Integer, Book> e : book.entrySet()) 
            bookString+=e.getValue().toString()+"\n";
		return bookString;
	}
	
	@RequestMapping(value="/create/{id}/{name}/{year}/{publisher}/{author}", 
			method=RequestMethod.GET)
	public void createBook(@PathVariable int id,@PathVariable String name,
			@PathVariable int year,@PathVariable String publisher,@PathVariable String author) {
		book.put(index, new Book(id,name,year,publisher,author));
		index=index+1;
	}
	
	@RequestMapping(value="/delete/{deleteindex}",method=RequestMethod.GET)
	public void deleteBook(@PathVariable int deleteindex) {
		book.remove(deleteindex);
	}
	
	@RequestMapping(value="/update/{updateindex}/{id}/{name}/{year}/{publisher}/{author}"
			,method=RequestMethod.GET)
	public void updateBook(@PathVariable int updateindex,@PathVariable int id,@PathVariable String name,
			@PathVariable int year,@PathVariable String publisher,@PathVariable String author) {
		book.put(updateindex, new Book(id,name,year,publisher,author));
	}
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		Book singleBook = book.get(id);
		return singleBook.toString();
	}
	
}