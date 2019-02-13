package chapter08;

import chapter02.MyStack;
import org.junit.Test;

public class GraphTest {

    @Test
    public void test(){

        Graph graph = new Graph(3);
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        int[][] adjMat = graph.getAdjMat();
        for (int[] ints : adjMat) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        graph.dfs();
    }

    @Test
    public void test1(){

        MyStack myStack = new MyStack();
        myStack.push(100);
        myStack.push(99);
        myStack.push(98);
        int pop = myStack.pop();
        System.out.println(pop); // 98
        int peek = myStack.peek();
        System.out.println(peek); //99
    }

}