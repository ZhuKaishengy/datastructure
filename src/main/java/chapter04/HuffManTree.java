package chapter04;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 创建一个哈夫曼树
 */
@Data
@ToString
@Accessors(chain = true)
public class HuffManTree {

    public HuffManNode root;

    public HuffManTree build(int[] arr){
        // 创建哈夫曼数集合
        List<HuffManNode> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new HuffManNode(i));
        }
        while (list.size() > 1) {
            // 排序
            list.sort(Comparator.comparingInt(HuffManNode::getValue));
            // 使用新节点代替老节点
            HuffManNode huffManNode1 = list.get(0);
            HuffManNode huffManNode2 = list.get(1);
            HuffManNode tmp = new HuffManNode(huffManNode1.getValue() + huffManNode2.getValue());
            tmp.setLNode(huffManNode1).setRNode(huffManNode2);
            list.remove(huffManNode1);
            list.remove(huffManNode2);
            list.add(tmp);
        }

        return new HuffManTree().setRoot(list.get(0));
    }


    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 29, 5, 11, 23, 14};
        HuffManTree huffManTree = new HuffManTree();
        HuffManTree huffManTree2 = huffManTree.build(arr);
        System.out.println(huffManTree2);
    }
}
