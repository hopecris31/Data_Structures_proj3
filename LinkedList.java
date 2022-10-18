package proj3;

/**
 * LinkedList class: represents a Linked List
 *
 *  INVARIANTS:
 *  -size must always equal the number of nodes in the list
 *  -the last node points to null
 *  -the first node points to the first node in the list
 *      -if length is equal to 0, the first node points to null
 *  -list node next refers to the next node in the list
 */
public class LinkedList
{
    private int length;
    private ListNode firstNode;

    private final int EMPTY = 0;


    public LinkedList()
    {
        length = 0;
        firstNode = null;
    }

    public int getLength() {
        return this.length;
    }

    private ListNode getFirstNode() {
        return this.firstNode;
    }


    public boolean isEmpty(){
        return this.length == 0;
    }

    private void setFirst(ListNode head){
        this.firstNode = head;
    }

    private void setLength(int length){
        this.length = length;
    }

    public void insertAtHead(String data) {
    	ListNode newNode = new ListNode(data);
        if (this.isEmpty()){
            firstNode = newNode;
        }
        else{
            newNode.next = firstNode;
            firstNode = newNode;
        }
        length++;
    }

    public void insertAtEnd(String data){
        if(!this.isEmpty()){
            ListNode last = this.getLastItem();
            ListNode newNode = new ListNode(data);
            last.next = newNode;
            this.length++;
        }
        else{
            this.insertAtHead(data);
        }
    }

    private ListNode getLastItem(){
        if(this.isEmpty()){
            return null;
        }
        ListNode runner = this.firstNode;
        while(runner.getNext() != null){
            runner = runner.next;
        }
        return runner;
    }

    private ListNode getTail(){
        if(this.isEmpty()){
            return null;
        }
        ListNode runner = this.firstNode;
        ListNode prev = null;
        while(runner.next != null) {
            prev = runner;
            runner = runner.next;
        }
        return prev;
    }


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
                    newNode.next = runner.getNext();
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
                    newNode.next = this.getFirstNode();
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
            if(runner == this.getFirstNode()){ //if trying to remove the first node
                this.firstNode = runner.next;
            }
            else{
                prev.setNext(runner.next);
            }
            runner.next = null;  //Is this needed, to set the removed item's pointer to null
            length--;
        }
    }

    private boolean isHead(String data){
        return this.firstNode.getData().equals(data);
    }

    public void clear(){
        this.length = EMPTY;
        this.firstNode = null;
    }

    public boolean contains(String data){
        ListNode runner = this.getFirstNode();
        while(runner != null){
            if(runner.getData().equals(data)){
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    public LinkedList clone(){
        LinkedList cloneList = new LinkedList();
        cloneList.setFirst(this.getFirstNode());
        cloneList.setLength(this.getLength());
        return cloneList;
    }

    public void removeLast(){
        if(!this.isEmpty()){
            this.getTail().setNext(null);
            length--;
        }
    }

    public void removeAtHead(){
        if(!this.isEmpty()){
            this.firstNode = firstNode.getNext();
            length--;
        }
    }

    public void addAll(LinkedList toAdd){
        if(this.isEmpty()){
            this.setFirst(toAdd.firstNode);
        }
        else{
            this.getLastItem().setNext(toAdd.firstNode);
        }
        this.length += toAdd.getLength();
    }

    /**
     * gets the index of the first instance of given data
     * @param data index of data to find
     * @return the index of the data
     */
    public int getIndex(String data){
        if(!isEmpty()){
            ListNode runner = this.getFirstNode();
            int count = 0;
            while(runner != null && !runner.getData().equals(data)){
                runner = runner.next;
                count++;
            }
            if(runner != null){
                return count;
            }
        }
        return -1;
    }

    public String getDataAtIndex(int index){
        if(!isEmpty()){
            ListNode runner = this.getFirstNode();
            int count = 0;
            while(runner != null && count != index){
                runner = runner.next;
                count++;
            }
            if(runner != null){
                return runner.getData();
            }
        }
        return null;
    }

    public void addAtIndex(int index, String toAdd){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = null;
            int currIndex = 0;
            while(runner != null && currIndex != index){
                prev = runner;
                runner = runner.getNext();
                currIndex++;
            }
            if(runner != null){
                ListNode newNode = new ListNode(toAdd);
                if(currIndex == 0){
                    this.firstNode = newNode;
                }
                else{
                    prev.next = newNode;
                }
                newNode.next = runner;
                length++;
            }
        }
    }

    public void removeAtIndex(int index){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = runner.next;
            int currIndex = 0;
            while(runner != null && currIndex != index){
                prev = runner;
                runner = runner.next;
                currIndex++;
            }
            if(runner != null){
                prev.next = runner.getNext();
                length--;
            }
        }
    }


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


