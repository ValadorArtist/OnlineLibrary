package spring.mvc.library.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="books")
@Table(name="books")
public class books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Title")
	@NotNull(message="It may not me null")
	@Size(min=1, max=45, message="There is a problem with size")
	private String Title;
	
	@Column(name="Author")
	@NotNull(message="It may not me null")
	@Size(min=1, max=150, message="There is a problem with size")
	private String Author;
	
	@Column(name="Pages")
	@NotNull(message="It may not me null")
	private int Pages;
	
	@Column(name="PublishingHouse")
	@NotNull(message="It may not me null")
	@Size(min=1, max=150, message="It may not be null")
	private String PublishingHouse;
	
	@Column(name="Wypozyczona")
	private String Wypozyczona;
	
	@Column(name="Owner")
	private String Owner;
	
	@Column(name="isActualReading")
	private String isActualReading;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPages() {
		return Pages;
	}

	public void setPages(int pages) {
		Pages = pages;
	}

	public String getPublishingHouse() {
		return PublishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		PublishingHouse = publishingHouse;
	}

	public String getWypozyczona() {
		return Wypozyczona;
	}

	public void setWypozyczona(String wypozyczona) {
		Wypozyczona = wypozyczona;
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

	public String getIsActualReading() {
		return isActualReading;
	}

	public void setIsActualReading(String isActualReading) {
		this.isActualReading = isActualReading;
	}

	@Override
	public String toString() {
		return "books [id=" + id + ", Title=" + Title + ", Author=" + Author + ", Pages=" + Pages + ", PublishingHouse="
				+ PublishingHouse + ", Wypozyczona=" + Wypozyczona + ", Owner=" + Owner + ", isActualReading="
				+ isActualReading + "]";
	}

	
	
	
}
