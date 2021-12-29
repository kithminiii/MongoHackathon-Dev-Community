package in.assignment02.springbootmongodbppa.service;

import javax.validation.ConstraintViolationException;

import in.assignment02.springbootmongodbppa.exception.BookCollectionException;
import in.assignment02.springbootmongodbppa.model.BookLibrary;

public interface BookService {

	public void creaateBook(BookLibrary book) throws ConstraintViolationException, BookCollectionException;
}
