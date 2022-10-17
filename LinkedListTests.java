package proj3;
/**
 * JUnit test class.  Tests the constructors and public methods for the Sequence class.
 */
import org.junit.*;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;


public class LinkedListTests {

    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);


    /**
     * constructs a linked list with elements from a given array
     * @param items an array of items
     * @return the linked list with the items
     */
    private LinkedList makeLinkedList(String[] items){
        LinkedList ll = new LinkedList();
        for (String item : items) {
            ll.insertAtHead(item);
        }
        return ll;
    }

    @Test //constructs a Linked List object
    public void LinkedListConstructor(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertAtHead; inserts new node so the head becomes the new node
    public void insertAtHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "A", "X"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAtHead("X");

        assertTrue(ll.equals(correct));

    }

    @Test //Tests insertAtHead; inserts a node into an empty Linked List.  New node becomes the head
    public void insertAtHeadEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"X"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAtHead("X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertAfter; inserts new node after the head
    public void insertAfterHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "X", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAfter("A", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertAfter; inserts after the last node. new node now points to null
    public void insertAfterLast(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"X", "C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAfter("C", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertAfter; if call insertAfter on empty LinkedList, does nothing
    public void insertAfterEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAfter("C", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertAfter; if call insertAfter when item to insert after isn't in list, does nothing
    public void insertAfterNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAfter("D", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertBefore; inserts new node before a current node in the list
    public void insertBefore(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "X", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertBefore("C", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertBefore; insert an element before the head of the list.  New node becomes head
    public void insertBeforeAtHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "A", "X"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertBefore("A", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertBefore; tries to insert an element in an empty list.  Does nothing
    public void insertBeforeEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertBefore("A", "X");
        assertTrue(ll.equals(correct));

    }

    @Test //Tests insertBefore; called on a list in which the node to insert before is not in the list. Does nothing
    public void insertBeforeItemNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertBefore("D", "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests remove;
    public void removeTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.remove("B");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests remove; tries to remove an item that isn't in the list, should do nothing
    public void removeNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.remove("X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests remove; tries to remove an item that isn't in the list, should do nothing
    public void removeEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.remove("X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests remove; removes the node at the head. The node after becomes the head
    public void removeAtHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "B"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.remove("A");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests clear; there should be no items in the List and length is 0
    public void clear(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.clear();

        assertEquals(0, ll.getLength());
    }


    @Test
    public void removeLastElement(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.remove("C");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests contains; checks to see if a Linked List contains a specified item
    public void contains(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        assertEquals(true, ll.contains("A"));
    }

    @Test //Tests contains; called on a Linked List that does not contain the item
    public void containsNotInList(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);

        assertEquals(false, ll.contains("A"));
    }

    @Test //Tests insertAtEnd;
    public void insertAtEnd(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"X", "C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAtEnd("X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests insertAtEnd; called on an empty Linked List
    public void insertAtEndEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"X"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.insertAtEnd("X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests clone;
    public void cloneTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        LinkedList correct = ll.clone();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests clone; called on an empty list
    public void cloneTestEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);

        LinkedList correct = ll.clone();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests removeLast;
    public void removeLast(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.removeLast();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests removeLast; called on an empty LinkedList
    public void removeLastEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.removeLast();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests removeLast; tries to remove the last element that has a duplicate in the list
    public void removeLastDuplicateData(){
        String[] items = {"C", "B", "A", "C"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = { "B", "A", "C"};
        LinkedList correct = makeLinkedList(correctItems);


        ll.removeLast();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests removeAtHead;
    public void removeAtHeadTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = { "C", "B"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.removeAtHead();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests removeAtHead; called on an empty LinkedList
    public void removeAtHeadEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.removeAtHead();

        assertTrue(ll.equals(correct));
    }

    @Test //Tests addAll;
    public void addAllTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] otherItems = {"3", "2", "1"};
        LinkedList other = makeLinkedList(otherItems);
        String[] correctItems = {"3", "2", "1", "C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        System.out.println(correct.toString());
        ll.addAll(other);

        assertTrue(ll.equals(correct));
    }

    @Test //Tests addAll; adding another list to an empty list
    public void addAllTestFirstEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] otherItems = {"3", "2", "1"};
        LinkedList other = makeLinkedList(otherItems);
        String[] correctItems = {"3", "2", "1"};
        LinkedList correct = makeLinkedList(correctItems);

        System.out.println(correct.toString());
        ll.addAll(other);

        assertTrue(ll.equals(correct));
    }

    @Test //Tests addAll; adding another empty list to a list with items
    public void addAllTestOtherEmpty(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] otherItems = {};
        LinkedList other = makeLinkedList(otherItems);
        String[] correctItems = {"C", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        System.out.println(correct.toString());
        ll.addAll(other);

        assertTrue(ll.equals(correct));
    }

    @Test //Tests getIndex;
    public void getIndex(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        assertEquals(2, ll.getIndex("C"));
    }

    @Test //Tests getIndex; finds the first element which is at index 0
    public void getIndexFirst(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        assertEquals(0, ll.getIndex("A"));
    }

    @Test //Tests getIndex; called opn an empty Linked List
    public void getIndexEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);

        assertEquals(-1, ll.getIndex("X"));
    }

    @Test //Tests getIndex; called to find the index of an element that is not in the list
    public void getIndexNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        assertEquals(-1, ll.getIndex("X"));
    }

    @Test //Tests addAtIndex; the item is added at specified index, and all following elements have +1 index
    public void addAtIndex(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"C", "X", "B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.addAtIndex(2, "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests addAtIndex; called on empty list
    public void addAtIndexEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.addAtIndex(2, "X");

        assertTrue(ll.equals(correct));
    }

    @Test //Tests addAtIndex; tries to add at an index that is not in the list
    public void addAtIndexNotInList(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {};
        LinkedList correct = makeLinkedList(correctItems);

        ll.addAtIndex(2, "X");

        assertTrue(ll.equals(correct));
    }
}
