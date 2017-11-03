package spring.mvc.library.classes;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;
import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Url {

	@NotNull(message="It may not be null")
	@URL(message="Something is wrong with content")
	private String url;
	
	public Url(){
		
	}
	
	
	public String getTitle(){
		String title = null;
		
		try{
			Document doc = Jsoup.connect(this.url).get();
			
			Elements element = doc.select("title");
			
			for (Element elem : element) {
				title = elem.ownText();	
			}
			
			String[] parts = title.split("Książka");
			
			title = parts[0];
			System.out.println(title+"\n");
		}catch(IOException ex){
			Logger.getLogger(Url.class.getName()).log(null, ex);
		}
		
		return title;
	}
	
	
	public String getAutor(){
		String autor = null;
		
		try{
			Document doc = Jsoup.connect(this.url).get();
			
			Elements element = doc.select("title");
			
			for (Element elem : element) {
				autor = elem.ownText();	
			}
			
			String[] parts = autor.split("Książka");
			autor = parts[1];
			String[] AutorParts = autor.split(" - ");
			autor = AutorParts[1];
			System.out.println(autor+"\n");
			
		}catch(IOException ex){
			Logger.getLogger(Url.class.getName()).log(null, ex);
		}
		
		return autor;
	}
	
	
	public int getPages(){
		int Pages = 0;
		String Page=null;
		
		try{
			Document doc = Jsoup.connect(this.url).get();
			
			Elements element = doc.select("dd");
			for (Element elem : element) {
				if(elem.hasClass("select_druk select_ebook select_bundle")){
					Page = elem.ownText();
				}
			}
			Pages = Integer.parseInt(Page);
			System.out.println(Page+"\n");
			
		}catch(IOException ex){
			Logger.getLogger(Url.class.getName()).log(null, ex);
		}
		
		return Pages;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
