package leib.demo.leecode2020.leetcode2009;

/**
 * @Author:Leib
 * @Date 2020/9/28 20:22
 */
public class T0930 {
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int [] list = {-9,-5,0,5,9};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

//        T0930 t0930 = new T0930();
//        t0930.replaceSpace("we are") ;

        StringBuffer sb = new StringBuffer();
        for (int i = 120; i < 150; i++) {
            sb.append(i);
            sb.append(",");
        }
        System.out.println(sb);
    }
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
                System.out.println(c);
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;
        TreeNode cur = root;
        while (true){
            if (cur.val>val){
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            }else{
                if (cur.val<val){
                    if (cur.right ==null){
                        cur.right = node ;
                        break;
                    }
                    cur = cur.right;
                }

            }

        }
        return root;
    }
}
