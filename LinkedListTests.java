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

        assertEquals("(A, B, C)", ll.toString());
        assertEquals(3, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; inserts after the head
    public void insertAtHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertAtHead("X");

        assertEquals("(X, A, B, C)", ll.toString());
        assertEquals(4, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; inserts after the head
    public void insertAtHeadEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);

        ll.insertAtHead("X");

        assertEquals("(X)", ll.toString());
        assertEquals(1, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; inserts after the head
    public void insertAfterTestHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertAfter("A", "X");

        assertEquals("(A, X, B, C)", ll.toString());
        assertEquals(4, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; inserts after when inserting after last node
    public void insertAfterTestlast(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertAfter("C", "X");

        assertEquals("(A, B, C, X)", ll.toString());
        assertEquals(4, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; if call insertAfter on empty LinkedList, does nothing
    public void insertAfterTestEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);

        ll.insertAfter("C", "X");

        assertEquals("()", ll.toString());
        assertEquals(0, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; if call insertAfter when item to insert after isnt in list, do nothing
    public void insertAfterTestNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertAfter("D", "X");

        assertEquals("(A, B, C)", ll.toString());
        assertEquals(3, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertBefore;
    public void insertBeforeTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertBefore("C", "X");

        assertEquals("(A, B, X, C)", ll.toString());
        assertEquals(4, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertBefore; insert an element at the head of the list
    public void insertBeforeAtHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertBefore("A", "X");

        assertEquals("(X, A, B, C)", ll.toString());
        assertEquals(4, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertBefore; insert an element at the head of the list
    public void insertBeforeEmpty(){
        String[] items = {};
        LinkedList ll = makeLinkedList(items);

        ll.insertBefore("A", "X");

        assertEquals("()", ll.toString());
        assertEquals(0, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests insertBefore; insert an element at the head of the list. should do nothing
    public void insertBeforeItemNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertBefore("D", "X");

        assertEquals("(A, B, C)", ll.toString());
        assertEquals(3, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests remove;
    public void removeTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.remove("B");

        assertEquals("(A, C)", ll.toString());
        assertEquals(2, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test //Tests remove; tries to remove an item that isnt in the list, should do nothing
    public void removeNotInList(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.remove("B");

        assertEquals("(A, C)", ll.toString());
        assertEquals(2, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test
    public void removeAtHead(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.remove("A");

        assertEquals("(B, C)", ll.toString());
        assertEquals(2, ll.getLength());
        System.out.println(ll.toString());
    }

    @Test
    public void removeAtEnd(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);
        String[] correctItems = {"B", "A"};
        LinkedList correct = makeLinkedList(correctItems);

        ll.remove("C");

        assertEquals(2, ll.getLength());
        assertTrue(ll.equals(correct));
    }

}
