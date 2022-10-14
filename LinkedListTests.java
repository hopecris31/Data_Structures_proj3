package proj3;
/**
 * JUnit test class.  Tests the constructors and public methods for the Sequence class.
 */
import org.junit.*;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;


public class LinkedListTests {

    //@Rule // a test will fail if it takes longer than 1/10 of a second to run
    //public Timeout timeout = Timeout.millis(100);


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

        System.out.println(ll.toString());
    }

    @Test //Tests insertAfter; inserts after the head
    public void insertAfterTest(){
        String[] items = {"C", "B", "A"};
        LinkedList ll = makeLinkedList(items);

        ll.insertAfter("A", "X");

        assertEquals("(A, X, B, C)", ll.toString());

        System.out.println(ll.toString());
    }




}
