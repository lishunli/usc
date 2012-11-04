package org.usc.demo.fastjson;

import java.util.List;
import java.util.Map;

public class Entity {
	private String id;
	private int age;
	private Long score;
	private List<String> names;
	private Map<String, String> cahce;

	public Entity() {
		super();
	}

	public Entity(String id, int age, Long score, List<String> names, Map<String, String> cahce) {
		super();
		this.id = id;
		this.age = age;
		this.score = score;
		this.names = names;
		this.cahce = cahce;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Map<String, String> getCahce() {
		return cahce;
	}

	public void setCahce(Map<String, String> cahce) {
		this.cahce = cahce;
	}

}
