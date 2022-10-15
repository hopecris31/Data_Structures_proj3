package proj3;

/**
 *  Fill this in.  Really.  And the methods too.
 */
public class LinkedList
{
    private int length;
    private ListNode firstNode;


    public LinkedList()
    {
        length = 0;
        firstNode = null;
    }

    public int getLength()
    {
        return this.length;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }

    public void setFirst(ListNode head){
        this.firstNode = head;
    }

    public void insertAtHead(String data)
    {
    	ListNode newNode = new ListNode(data);
        if (getLength() == 0){
            firstNode = newNode;
        }
        else{
            newNode.next = firstNode;
            firstNode = newNode;
        }
        length++;
    }


    public void insertAfter(String prevData, String data){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = null;

            while(runner != null && !runner.getData().equals(prevData)){
                prev = runner;
                runner = runner.next();
            }
            if(runner != null){
                ListNode newNode = new ListNode(data);
                if(runner.next() == null) { //if at the end of the sequence
                    newNode.next = null;
                }
                else {
                    newNode.next = runner.next;
                }
                runner.next = newNode;
            }
        }
    }

    public void insertBefore(String nextData, String data){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = null;

            while(runner != null && !runner.getData().equals(nextData)){ //while not at the end and not equal to the node to insert before
                prev = runner; //advances in the sequence
                runner = runner.next();
            }
            if(runner != null){
                ListNode newNode = new ListNode(data);
                if(isHead(nextData)) {//if at beginning of list
                    newNode.setNext(this.firstNode);
                    this.firstNode = newNode;

                }
                else {
                    prev.setNext(newNode);
                    newNode.setNext(runner);
                }
            }
        }
    }

    private boolean isHead(String data){
        return this.firstNode.getData().equals(data);
    }

	public String toString(){ 
		String toReturn = "(";
		ListNode runner = firstNode;
		while(runner != null){
			toReturn = toReturn + runner;
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}

}


