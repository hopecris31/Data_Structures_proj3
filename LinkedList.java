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
            ListNode newNode = new ListNode(data);
            if(runner.next() == null) {
                newNode.next = null;
            }
            else {
                newNode.next = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void insertBefore(String prevData, String data){

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


