package leib.loopNode;

/**
 * @Author:Leib
 * @Date 2020/4/14 15:50
 */
public class DoubleNode {
    DoubleNode pre = this ;
    DoubleNode next = this ;
    int data ;

    public DoubleNode(int data) {
        this. data = data;
    }

    public  void after (DoubleNode doubleNode){
        DoubleNode nextNext = next;
        this.next = doubleNode;
        doubleNode.pre = this;

        doubleNode.next = nextNext;
        nextNext.pre =doubleNode;
    }

    public  DoubleNode next (){
        return this.next;
    }

    public  DoubleNode pre (){
        return this.pre;
    }
}
