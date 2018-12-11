package com.lansrod.test1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.lansrod.test1.entity.validation.CreateLanguageValidation;
import com.lansrod.test1.entity.validation.UpdateLanguageValidation;

@Entity
public class Language extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 175180367828839446L;

	@NotBlank(message = "The label is mandatory", groups = { CreateLanguageValidation.class,
			UpdateLanguageValidation.class })
	@Size(min = 6, message = "The label must have a minimum of 6 caracters", groups = { CreateLanguageValidation.class,
			UpdateLanguageValidation.class })
	private String label;

	@OneToMany(targetEntity = Developer.class, mappedBy = "language", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Developer> developers;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Language [label=" + label + "]";
	}

}
