package proj3;

/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object. 
 *
 * This is the only class where I'll let you use public instance variables.
 * 
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

    public void setData(String new_data){
        this.data = new_data;
    }

    public void setNext(ListNode nextNode){
        this.next = nextNode;
    }

    
    public String toString(){
    	return this.data;
    }

    public ListNode next() {
        return this.next;
    }
}
