package leib.demo.dataStructure.huffman;

/**
 * @Author:Leib
 * @Date 2020/4/15 20:44
 */
public class Code implements Comparable<Code>{
    //data是字符
    Byte data ;
    //weight是出现次数
    Integer weight;
    Code left ;
    Code right ;


    public Code (Byte data ,Integer weight){
        this.data= data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Code{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Code o) {
        return o.weight.compareTo(weight);
        //倒叙 大到小 调换o.weight和weight可以更换顺序
    }
}
