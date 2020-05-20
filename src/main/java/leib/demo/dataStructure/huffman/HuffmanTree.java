package leib.demo.dataStructure.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/4/15 19:47
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int  [] arr = new int[]{3,7,8,29,5,11,23,14};
        Node node = createHuffmanTree(arr);
        System.out.println(node);
    }

    private static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        for (int value :arr) {
            list.add(new Node(value));
        }
        while (list.size()>1){
            Collections.sort(list);
            Node left = list.get(list.size()-1);
            Node right = list.get(list.size()-2);
            Node node = new Node(left.value+right.value,left, right);
            list.remove(left);
            list.remove(right);
            list.add(node);
        }
        return null;
    }
}
