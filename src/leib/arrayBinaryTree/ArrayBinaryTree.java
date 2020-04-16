package leib.arrayBinaryTree;

/**
 * @Author:Leib
 * @Date 2020/4/15 13:14
 */
public class ArrayBinaryTree {
    int [] data ;
    public ArrayBinaryTree(int[] data) {
        this.data = data ;
    }

    public void frontShow(int i) {
        if(data==null||data.length==0){
            return;
        }
        System.out.println(data[i]);
        if(i*2+1<data.length){
            frontShow(2*i+1);
        }
        if(i*2+2<data.length){
            frontShow(2*i+2);
        }
    }

    public void frontShow() {
        frontShow(0);
    }
}
