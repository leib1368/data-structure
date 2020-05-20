package leib.demo.dataStructure.loopNode;

/**
 * @Author:Leib
 * @Date 2020/4/14 14:39
 */
public class LoopNode {
    int data ;
    LoopNode next ;
    //= this  加上就变成循环链表了

    public LoopNode(int data){
        this.data= data;
    }

    public void after(LoopNode node ){
        LoopNode nextNext = next;
        this.next  = node ;
        node.next = nextNext;
    }

/*    public  void show (){
        LoopNode curr = this;
        while (true){
            System.out.println(curr.data);
            curr = curr.next;
            if (curr.next==null){
                break;
            }
        }
    }*/

    public void remove (){
        LoopNode nextNext = next.next;
        this.next = nextNext;
    }

    public LoopNode getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }
}
