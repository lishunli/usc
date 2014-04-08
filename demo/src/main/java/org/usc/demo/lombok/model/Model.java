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
}
