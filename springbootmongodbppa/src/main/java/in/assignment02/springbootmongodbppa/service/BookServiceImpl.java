package in.assignment02.springbootmongodbppa.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.assignment02.springbootmongodbppa.exception.BookCollectionException;
import in.assignment02.springbootmongodbppa.model.BookLibrary;
import in.assignment02.springbootmongodbppa.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public void creaateBook(BookLibrary book)throws ConstraintViolationException, BookCollectionException {
		Optional<BookLibrary> bookOptional = bookRepo.findByBook(book.getBook());
		if(bookOptional.isPresent()) {
			throw new BookCollectionException(BookCollectionException.BookAlreadyExists());
		}else {
			book.setCreatedAt(new Date(System.currentTimeMillis()));
			bookRepo.save(book);
		}
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
