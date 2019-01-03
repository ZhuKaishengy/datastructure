package chapter01;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class Person {

    private String id;
    private String name;
    private String desc;
}
