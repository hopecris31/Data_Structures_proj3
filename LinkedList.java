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

    public void insertAtHead(String data)
    {
    	ListNode newnode = new ListNode(data);
        if (getLength() == 0){
            firstNode=newnode;
        }
        else{
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }


    public void insertAfter(String prevData, String data){
        ListNode runner = this.firstNode;
        ListNode prev = null;

        while(runner != null && !runner.getData().equals(prevData)){
            prev = runner;
            runner = runner.next();
        }
        if(runner.next().equals(null)){ //if toInsert is at the end of the list
            ListNode newNode = new ListNode(data);
            runner.next = newNode;
            newNode.next = null;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = runner.next;
        runner.next = newNode;

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


