package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojo.Book;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/bookApi")
public class Mapping {

	@GetMapping("/hello")
		public String check() {
			return "Hello world";
		}
	
	//@RequestMapping(value ="/get" ,method = RequestMethod.GET)
	@GetMapping("/get")
	public Book getBook() {
		Book book = new Book(1, "java", "easy");
		return book;
	}
	
	//@RequestMapping(value ="/create" ,method = RequestMethod.POST)
	@PostMapping("/create")
	//ResponseEntity ->add http status as a response
	public ResponseEntity<Book> createBookDetails(@RequestBody Book createBook) {
		
		/*
		 * in all methods ->sysout la potu irukarathu alla yepadi work aaguthu nu namaku console la theriyanum nu potu iruken
		 */
		System.out.println("created book details :");
		System.out.println(createBook.getId());
		System.out.println(createBook.getBook());
		System.out.println(createBook.getDescription());
		
		return new ResponseEntity<>(createBook,HttpStatus.CREATED);
	}
	
	//@RequestMapping(value ="/update/{id}" ,method = RequestMethod.PUT)
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBookDetails(@PathVariable int id,
													@RequestBody Book updateBook){
		
		System.out.println("updated book id: "+id);
		System.out.println(updateBook.getBook());
		System.out.println(updateBook.getDescription());
		updateBook.setId(id);
		return ResponseEntity.ok(updateBook);
	}
	
	//@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBookDetails(@PathVariable int id){
		
		System.out.println("Deleted book id: "+id);
		return ResponseEntity.ok("book deleted sucessfully");
	}
	
	//pathvariable
		@RequestMapping("/books/{id}/{name}/{description}")
		public ResponseEntity<Book> pathVaribaleDemo(@PathVariable  int id,
													@PathVariable("name") String bookName,
													@PathVariable("description") String bookDescription){
			System.out.println(id);
			Book book=new Book();
			book.setId(id);
			book.setBook(bookName);
			book.setDescription(bookDescription);
			
			return ResponseEntity.ok(book);
		}
		
		
		//requestParameter
				@RequestMapping("/books/query")
				public ResponseEntity<Book> requestParamDemo(@RequestParam(name="id")  int id,
															@RequestParam(name="tittle") String bookName){
					System.out.println(id);
					System.out.println(bookName);
					
					Book book=new Book();
					book.setId(id);
					book.setBook(bookName);
					
					return ResponseEntity.ok(book);
				}
	
}

