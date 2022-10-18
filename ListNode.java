package proj3;


/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object. 
 *
 *INVARINAT:
 * -each node contains data and a reference to the next node in a list
 */
public class ListNode
{
    public String data;
    public ListNode next;

    public ListNode(String new_data)
    {
        this.data = new_data;
        this.next = null;
    }

    public String getData(){
        return this.data;
    }

    public void setData(String data){
        this.data = data;
    }

    public void setNext(ListNode nextNode){
        this.next = nextNode;
    }

    public String toString(){
    	return this.data;
    }

    public ListNode getNext() {
        return this.next;
    }
}
