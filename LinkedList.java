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

    public void insertAtEnd(String data){
        if(this.getLength() != 0){
            ListNode runner = this.firstNode;
            ListNode prev = null;

        }
        //if not empty
            //runner = head
            //prev = null
            //iterate to the end of the list
            //while not at the end:
            //prev = runner
            //runner = runner.next
            //when at the end of the list(when runner == null):
            //runner.setNext = toInsert
            //tInsert.setNext = null
        //if empty:
            //insert atHead
    }

    public ListNode getLastItem(){
        if(this.isEmpty()){
            return null;
        }
        ListNode runner = this.firstNode;
        ListNode prev = null;
        while(runner.getNext() != null){
            prev = runner;
            runner = runner.next;
        }
        return runner;
    }

    //make private helper that gets the last element
    //use insert after on the last element
    //if empty...


    public void insertAfter(String prevData, String data){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;

            while(runner != null && !runner.getData().equals(prevData)){
                runner = runner.getNext();
            }
            if(runner != null){
                ListNode newNode = new ListNode(data);
                if(runner.getNext() == null) { //if at the end of the sequence
                    newNode.next = null;
                }
                else {
                    newNode.next = runner.next;
                }
                runner.next = newNode;
                length++;
            }
        }
    }

    public void insertBefore(String nextData, String data){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = null;

            while(runner != null && !runner.getData().equals(nextData)){ //while not at the end and not equal to the node to insert before
                prev = runner;
                runner = runner.getNext();
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
                length++;
            }
        }
    }

    /**
     * removes the given String from the Linked List.  If there are duplicates, removes the first instance.
     * @param toRemove the String to remove
     */
    public void remove(String toRemove){
        ListNode runner = this.firstNode;
        ListNode prev = null;

        while(runner != null && !runner.getData().equals(toRemove)) {
            prev = runner;
            runner = runner.getNext();
        }
        if(runner != null){
            if(runner == this.firstNode){ //if trying to remove the first node
                setFirst(runner.next);
            }
            else{
                prev.setNext(runner.next);
            }
            runner.setNext(null);  //Is this needed, to set the removed item's pointer to null
            length--;
        }
    }

    private boolean isHead(String data){
        return this.firstNode.getData().equals(data);
    }

    public void clear(){
        this.length = 0;
        this.setFirst(null);
    }

    public boolean contains(String data){
        ListNode runner = this.firstNode;
        while(runner != null){
            if(runner.getData().equals(data)){
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    //public LinkedList clone(){
    //    LinkedList cloneList = new LinkedList();
    //    cloneList.setFirst(this.firstNode);

    //    ListNode runner = this.firstNode;
    //    ListNode prev = null;
    //    while(runner != null){
    //        cloneList.insertAtEnd();
    //    }
    //}

    public boolean equals(LinkedList other) {
        if(this.getLength() != other.getLength()) {
            return false;
        }
        ListNode thisRunner = this.firstNode;
        ListNode otherRunner = other.firstNode;
        while(thisRunner != null && otherRunner != null){ //if not at the end of the list
            if(!thisRunner.getData().equals(otherRunner.getData())){
                return false;
            }
            thisRunner = thisRunner.next;
            otherRunner = otherRunner.next;
        }
        return thisRunner == null && otherRunner == null;
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


