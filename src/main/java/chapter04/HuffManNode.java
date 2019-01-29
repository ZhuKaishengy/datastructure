package chapter04;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 哈夫曼树节点
 */
@Data
@ToString
@Accessors(chain = true)
public class HuffManNode {

    public int value;
    public HuffManNode lNode;
    public HuffManNode rNode;

    public HuffManNode(int value) {
        this.value = value;
    }
}
