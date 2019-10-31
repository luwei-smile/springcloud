package com.app.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "persion")
public class Persion {

	private String PersionName;
	private Integer age;

	private Map<String, Object> Value;
	private List<Object> Book;

	private Dog dog;

	public String getPersionName() {
		return PersionName;
	}

	public void setPersionName(String persionName) {
		PersionName = persionName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Map<String, Object> getValue() {
		return Value;
	}

	public void setValue(Map<String, Object> value) {
		Value = value;
	}

	public List<Object> getBook() {
		return Book;
	}

	public void setBook(List<Object> book) {
		Book = book;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Persion [PersionName=" + PersionName + ", age=" + age + ", Value=" + Value + ", Book=" + Book + ", dog="
				+ dog + "]";
	}


}
