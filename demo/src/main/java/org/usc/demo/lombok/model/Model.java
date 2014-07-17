package org.usc.demo.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Shunli
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
// @Data
public class Model {
    private int age;
    private String name;
    private long money;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getMoney() {
        return money;
    }
    public void setMoney(long money) {
        this.money = money;
    }

}
