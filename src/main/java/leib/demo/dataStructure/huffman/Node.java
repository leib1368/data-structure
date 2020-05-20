package leib.demo.dataStructure.huffman;

/**
 * @Author:Leib
 * @Date 2020/4/15 19:47
 */
public class Node implements Comparable<Node>{
    Integer value ;
    Node left;
    Node right ;



    public  Node(Integer value){
        this.value = value;
    }

    public Node(Integer value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right=right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        return value.compareTo(node.value);
    }

}
