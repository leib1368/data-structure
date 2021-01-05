package leib.demo.leecode2020.leetcode2009;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/9/24 16:20
 */
public class T0924_1 {
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int [] list = {-9,-5,0,5,5,77,77};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

        T0924_1 t0924 = new T0924_1();
        System.out.println(Arrays.toString(t0924.findMode(treeNode)));
    }

    List<Integer> mList = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);

        for(Map.Entry entry:map.entrySet()) {
            mList.add((int) entry.getValue());
        }
        Collections.sort(mList);
        int count = 1;
        for (int i = mList.size()-1; i >0; i--) {
            if(mList.get(i) != mList.get(i - 1))
                break;
            else count++;
        }

        int[] res = new int[count];
        ArrayList<Integer> key = new ArrayList<>();
        for (int i =  mList.size()-1; i > mList.size()-1-count; i--) {
             key = getKey(map, mList.get(i));
        }
        for (int i = 0; i < count; i++) {

            res[i] = key.get(i);
        }
        return res;
    }
    //根据map的value获取map的key
    public ArrayList<Integer> getKey(Map<Integer,Integer> map, Integer value){
        ArrayList<Integer> list = new ArrayList<>();
        Integer key=0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(value.equals(entry.getValue())){
                key=entry.getKey();
                list.add(key);
            }
        }
        return list;
    }

    public void inOrderTraversal(TreeNode node) {
        //终止条件判断
        if (node == null)
            return;

        inOrderTraversal(node.left);

        if(map.get(node.val)==null){
            map.put(node.val,1);
        }else{
            map.put(node.val,map.get(node.val)+1);
        }

        inOrderTraversal(node.right);
    }
}
