package in.assignment02.springbootmongodbppa.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class BookLibrary {
	
	@Id
	private String id;
	
	@NotNull(message = "book cannot be null")
	private String book;
	
	@NotNull(message = "Price cannot be null")
	private Float price;

	
	private Date createdAt;
	
	private Date updateAt;

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Object getCompleted() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCompleted(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setUpdatedAt(Date date) {
		// TODO Auto-generated method stub
		
	}

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
