package leib.huffman;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/4/15 20:44
 */
public class HuffmanCode {
    public static void main(String[] args) {
        //传递的原信息
        String msg = "can you can a can as a can canner can a can.";
        //转换成字节数组 内部是ascii形式
        byte [] translateData =msg.getBytes();
        //转换成2进制 和题目无关
        System.out.println("2进制："   + binary(translateData, 2));

        //进行赫夫曼编码
        byte [] translateDataZIP = huffmanZIP(translateData);

        System.out.println(" ");
        System.out.println("压缩前长度："+translateData.length);
        System.out.println("压缩后长度："+translateDataZIP.length);

        //开始解码
        byte[] newBytes = decode(huffCodes,translateDataZIP);

        //验证解码前和解码后的数组
        System.out.println(Arrays.toString(translateData));
        System.out.println(Arrays.toString(newBytes));

        System.out.println(new String(newBytes));
    }

    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);
        // 这里的1代表正数
    }

    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        //讲b->转换成字符串就好了
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<bytes.length;i++) {
            byte b = bytes[i];
            //判断是否是最后一个
            boolean flag=(i==bytes.length-1);
                sb.append(byteToBitStr(!flag,b));
                //sb.append(" ");
        }
        System.out.println("解码"+sb.toString());

        //map键值对转换
        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte ,String> entry :huffCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        //存放byte 以为数组长度是写死的 所以用list
        List<Byte> list = new ArrayList<>();
        for(int i =0;i<sb.length();){
            int count =1;
            boolean flag =true;
            Byte b=null;
            while(flag){
                String key = sb.substring(i,i+count);
                b=map.get(key);
                if(b==null){
                    count++;
                }else{
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte [] b = new byte [list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i]=list.get(i);
        }
        System.out.println("解码后---->"+sb.toString());
        return  b;
    }

    private static String byteToBitStr(boolean flag,byte b) {
        int temp =b;
        if(flag){
            temp|=256;
        }
        String str =   Integer.toBinaryString(temp);
        if(flag){
            //取最后8位
            return str.substring(str.length()-8) ;
        }else{
            return str ;
        }
    }

    /*将字节数组压缩成赫夫曼编码*/
    private static byte[] huffmanZIP(byte[] translateData) {
        //1.统计每个byte出现的次数 并放入每个节点中 每个节点后续放入map kv即字符本身与出现次数
        List<Code> Codes =getCodes(translateData);
        //2.得到赫夫曼树
        Code tree = createNodeTress(Codes);
        //3.得到赫夫曼编码
        Map<Byte,String> huffCodes = getCodesss(tree);
        System.out.println("赫夫曼编码："+huffCodes);
        //4.转为压缩后的字节数组
        byte[] b = zip(translateData,huffCodes);
        return b;
    }

    private static byte[] zip(byte[] translateData, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //把原字节数组 压缩成成二进制字符串
        for(byte b : translateData){
            sb.append(huffCodes.get(b));
        }
        int len;
        //切割为8个bit的字节
        if(sb.length()%8==0){
            //12345678-->1byte
            len =sb.length()/8;
        }else{
            //123456789-->2byte
            len= sb.length()/8+1;
        }
        byte [] byteZIP =new byte [len];
        int index =0;
        for (int i = 0; i <sb.length(); i+=8) {
            String stringByte;
            if(i+8>sb.length()){
                stringByte=sb.substring(i );
            }else{
                stringByte=sb.substring(i,i+8);}
                System.out.print("压缩");
                System.out.print(stringByte);
                System.out.print(" ");
                byte byt = (byte) Integer.parseInt(stringByte,2);
                byteZIP[index] = byt;
                index++;
        }
        //返回字节数组
        return byteZIP;
    }

    /*
    *遍历赫夫曼树  存储临时路径
    *赫夫曼编码表 例：ascii->32=10
    */
    static  StringBuilder sb = new StringBuilder();
    static Map<Byte ,String > huffCodes = new HashMap<>();

    private static Map<Byte, String> getCodesss(Code tree) {
        if(tree==null){
            return  null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);
        return huffCodes;
    }
    private static void getCodes(Code node, String s, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(s);
        if(node.data==null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else{
            //获得赫夫曼路径已经字节码
            huffCodes.put(node.data,sb2.toString());
        }
    }

    /*
    创建赫夫曼树
    */
    private static Code createNodeTress(List<Code> codes) {
        while (codes.size()>1){
            Collections.sort(codes);
            Code left = codes.get(codes.size()-1);
            Code right = codes.get(codes.size()-2);
            Code code =new Code (null,left.weight+right.weight);
            code.left = left;
            code.right = right ;
            codes.remove(left);
            codes.remove(right);
            codes.add(code);
        }
        return codes.get(0);
    }

    /*
    * 将传入的字节数组每个字节以及出现次数 转换成 Code-->节点
    */

    private static List<Code> getCodes(byte[] translateData) {
    //将byte数组转换为Code集合
        List<Code> Codes =new ArrayList<>();
        //统计byte出现的次数 byte为字节 int为出现次数
        Map<Byte,Integer> map = new HashMap<>() ;
        for (Byte b: translateData) {
            //第一个字节进来的时候count肯定是空啦~
            Integer count = map.get(b);
            //所以count计数初始化为1
            if(count ==null){
                map.put(b,1);
            }else{
                //遍历时将第二个及其以上的字符覆盖，计数值+1
                map.put(b,count+1);
            }
        }
        //System.out.println(map);
        for(Map.Entry<Byte,Integer> entry: map.entrySet()){
            //遍历并放入Codes数组 key是值，value是次数
            Codes.add(new Code(entry.getKey(),entry.getValue()));
        }
        return Codes;
    }
}
