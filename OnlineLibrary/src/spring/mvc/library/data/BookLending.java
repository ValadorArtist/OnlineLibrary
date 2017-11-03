package spring.mvc.library.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="booklending")
@Table(name="booklending")
public class BookLending {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="BookName")
	@Size(min=1, max=150, message="There is a problem with size")
	private String BookName;
	
	@Column(name="Owner")
	@Size(min=1, max=45, message="There is a problem with size")
	private String Owner;
	
	@Column(name="LoanToWho")
	@NotNull()
	@Size(min=1, max=45)
	private String LoanToWho;
	
	@Column(name="StartDate")
	@NotNull(message="It may not me null")
	private Date StartDate;
	
	@Column(name="EndDate")
	@NotNull(message="It may not me null")
	private Date EndDate;
	
	public BookLending(){
		
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getBookName() {
		return BookName;
	}


	public void setBookName(String bookName) {
		BookName = bookName;
	}


	public String getOwner() {
		return Owner;
	}


	public void setOwner(String owner) {
		Owner = owner;
	}


	public String getLoanToWho() {
		return LoanToWho;
	}


	public void setLoanToWho(String loanToWho) {
		LoanToWho = loanToWho;
	}


	public Date getStartDate() {
		return StartDate;
	}


	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}


	public Date getEndDate() {
		return EndDate;
	}


	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	@Override
	public String toString() {
		return "BookLending [Id=" + Id + ", BookName=" + BookName + ", Owner=" + Owner + ", LoanToWho=" + LoanToWho
				+ ", StartDate=" + StartDate + ", EndDate=" + EndDate + "]";
	}
	
	
}
