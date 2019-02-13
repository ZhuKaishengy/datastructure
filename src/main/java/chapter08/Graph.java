package chapter08;

import chapter02.MyStack;

public class Graph {

    /**
     * 保存顶点信息
     */
    private Vertex[] vertices;

    /**
     * 记录当前索引值
     */
    private int currentIndex = 0;

    /**
     * 使用邻接矩阵描述图中的关系
     */

    private int[][] adjMat;

    public int[][] getAdjMat() {
        return adjMat;
    }

    /**
     * 图的初始化方法定义顶点数
     * @param size
     */
    public Graph(int size) {
        this.vertices = new Vertex[size];
        adjMat = new int[size][size];
        for (int i = 0; i < adjMat.length; i++) {
            adjMat[i][i] = 1;
        }
    }

    /**
     * 添加顶点的方法
     * @param value
     */
    public void addVertex(String value){
        this.vertices[currentIndex] = new Vertex(value);
        this.currentIndex ++;
    }

    /**
     * 添加一条边
     */
    public void addEdge(String val1, String val2){
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(val1)) {
                index1 = i;
            }
            if (vertices[i].getValue().equals(val2)) {
                index2 = i;
            }
        }
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    MyStack myStack = new MyStack();
    /**
     * 深度优先遍历
     */
    public void dfs(){
        // stack head
        int index = 0;
        System.out.println(vertices[index]);
        myStack.push(index);
        while (!myStack.isEmpty()) {
            // push
            for (int i = index + 1; i < vertices.length; i++) {
                if (adjMat[index][i] == 1) {
                    myStack.push(i);
                    index = i;
                }
            }
            // pop
            int pop = myStack.pop();
            index = myStack.peek();

            for (int i = pop + 1; i < vertices.length; i++) {
                if (adjMat[index][i] == 1) {
                    myStack.push(i);
                    index = i;
                }
            }

        }
    }
}
