package leib.binarySortTree;

/**
 * @Author:Leib
 * @Date 2020/4/17 13:33
 */
public class Test {
    public static void main(String[] args) {
        int [] arr = new int []{7,3,10,1,12,5,19};
        BinarySortTree tree = new BinarySortTree();
        for(int i :arr){
            tree.add(new Node(i));
        }
        tree.midShow();
        tree.search(10);
        tree.searchParent(3);
    }
}
