package in.assignment02.springbootmongodbppa.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import in.assignment02.springbootmongodbppa.model.BookLibrary;
import in.assignment02.springbootmongodbppa.repository.BookRepository;




public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<?>getAllBooks(){
		List <BookLibrary> books = bookRepo.findAll();
		if (books.size() > 0 ) {
			return new ResponseEntity<List<BookLibrary>>(books, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No books available", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> createBook(@RequestBody BookLibrary book){
		try {
			bookService.createBook(book);
			return new ResponseEntity<BookLibrary>(book, HttpStatus.OK);
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);			
		}
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getSingleBook(@PathVariable("id") String id){
		Optional <BookLibrary>bookOptional = bookRepo.findById(id);
		if(bookOptional.isPresent()) {
			return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Book not found with id" +id, HttpStatus.NOT_FOUND);
	}
		
	}
	
	
    @PutMapping("/books/{id}")
    public ResponsiveEntity<?>updateById(@PathVariable("id") String id,@RequestBody BookLibrary book){
		Optional<BookLibrary>bookOptional = bookRepo.findById(id);
		if(bookOptional.isPresent()) {
			BookLibrary bookToSave = bookOptional.get();
			bookToSave.setCompleted(book.getCompleted() != null? book.getCompleted():bookToSave.getCompleted());
			bookToSave.setBook(book.getBook()!= null? book.getBook() : bookToSave.getBook());
			bookToSave.setDescription(book.getDescription()!= null? book.getDescription() :bookToSave.getDescription());
			bookToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
			bookRepo.save(bookToSave);
			
			return new ResponseEntity<>(bookToSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Book not found with id"+id, HttpStatus.NOT_FOUND);
		}
    }
	
    @DeleteMapping("books/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){
    	try {
    		bookRepo.deleteById(id);
    		return new ResponseEntity<>("Successfully deleted with id " +id, HttpStatus.OK);
    	}catch(Exception e) {
   		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    	}
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













