package com.lansrod.test1.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.lansrod.test1.entity.validation.CreateDeveloperValidation;
import com.lansrod.test1.entity.validation.UpdateDeveloperValidation;

@Entity
public class Developer extends AbstractEntity {

	private static final long serialVersionUID = -887070118458783475L;

	@NotBlank(message = "The name is mandatory", groups = { CreateDeveloperValidation.class,
			UpdateDeveloperValidation.class })
	private String name;

	@NotBlank(message = "The name is mandatory", groups = { CreateDeveloperValidation.class,
			UpdateDeveloperValidation.class })
	private String lastname;

	@NotBlank(message = "The email is mandatory", groups = { CreateDeveloperValidation.class,
			UpdateDeveloperValidation.class })
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "The email is invalid", groups = {
			CreateDeveloperValidation.class, UpdateDeveloperValidation.class })
	private String email;

	@NotBlank(message = "The password is mandatory", groups = { CreateDeveloperValidation.class })
	@Size(min = 6, message = "The password must have a minimum of 6 caracters", groups = {
			CreateDeveloperValidation.class })
	private String password;

	@ManyToOne(targetEntity = Language.class, fetch = FetchType.EAGER, optional = true)
	private Language language;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", lastname=" + lastname + ", email=" + email + ", password=" + password
				+ ", language=" + language + "]";
	}

}
