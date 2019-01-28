package chapter04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 二叉树
 * @author zhukaishengy
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BinaryTree {

    private TreeNode root;

    public void fontShow() {
        this.root.fontShow();
    }

    public void midShow() {
        this.root.midShow();
    }

    public void forwardShow() {
        this.root.forwardShow();
    }

    public TreeNode fontSearch(int ele) {
        return this.root.fontSearch(ele);
    }

    public TreeNode midSearch(int ele) {
        return this.root.midSearch(ele);
    }

    public TreeNode forwardSearch(int ele) {
        return this.root.forwardSearch(ele);
    }

    public void delSubTree(int ele) {
        if (ele == this.root.getVal()) {
            // del root element
            this.root = null;
        } else {
            this.root.delSubTree(ele);
        }
    }
}
