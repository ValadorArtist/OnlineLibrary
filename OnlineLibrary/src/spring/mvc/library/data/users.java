package spring.mvc.library.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Id;

@Entity(name="users")
@Table(name="users")
public class users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="login")
	@NotNull(message="It may not be null")
	@Size(min=1,max=35, message="The login has to be bettwen 1 and 35 letters")
	private String login;
	
	@Column(name="password")
	@NotNull(message="It may not be null")
	@Size(min=1,max=35, message="The password has to be bettwen 1 and 35 letters")
	private String password;
	
	@Column(name="email")
	@NotNull(message="It may not be null")
	@Size(min=1,max=35, message="The password has to be bettwen 1 and 35 letters")
	@Email(message="Provide a valid email address")
	private String email;
	
	@Column(name="Access")
	private boolean Access;

	@Column(name="libraryUser")
	private String libraryUser;
	
	public users(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getAccess() {
		return Access;
	}

	public void setAccess(boolean access) {
		Access = access;
	}

	public String getLibraryUser() {
		return libraryUser;
	}

	public void setLibraryUser(String libraryUser) {
		this.libraryUser = libraryUser;
	}

	@Override
	public String toString() {
		return "users [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", Access="
				+ Access + ", libraryUser=" + libraryUser + "]";
	}
	
	
}
