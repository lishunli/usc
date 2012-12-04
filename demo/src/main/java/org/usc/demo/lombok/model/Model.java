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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Data
@SuppressWarnings("unused")
public class Model {
    private int age;
    private String name;
    private long money;
}
