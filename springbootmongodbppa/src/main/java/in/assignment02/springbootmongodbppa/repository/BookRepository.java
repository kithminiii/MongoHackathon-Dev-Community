package in.assignment02.springbootmongodbppa.repository;


import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import in.assignment02.springbootmongodbppa.model.*;


@Repository
public interface BookRepository extends MongoRepository<BookLibrary, String> {
 
	@Query("{'book': ?0}")
	Optional<BookLibrary> findByBook(String book);
}
