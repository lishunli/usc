package org.usc.demo.fastjson;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Entity {
    private String id;
    private int age;
    private Long score;
    private Date birthDay;
    private List<String> names;
    private Map<String, String> cahce;

    private SubEntity subEntity;

    public Entity() {
    }

    public Entity(String id, int age, Long score, Date birthDay, List<String> names, Map<String, String> cahce) {
        super();
        this.id = id;
        this.age = age;
        this.birthDay = birthDay;
        this.score = score;
        this.names = names;
        this.cahce = cahce;
    }

    public Entity(String id, int age, Long score, Date birthDay, List<String> names, Map<String, String> cahce, SubEntity subEntity) {
        this.id = id;
        this.age = age;
        this.score = score;
        this.birthDay = birthDay;
        this.names = names;
        this.cahce = cahce;
        this.subEntity = subEntity;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public SubEntity getSubEntity() {
        return subEntity;
    }

    public void setSubEntity(SubEntity subEntity) {
        this.subEntity = subEntity;
    }

}
