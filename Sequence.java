package proj3;  // Gradescope needs this.
/**
 *Hope Crisafi
 *CS 151 Project 2
 *Oct 4, 2022
 *
 *A class that represents a sequence ADT. Holds items of the same type.
 *Items in sequence are accessed via a "current" marker, and not by index
 *
 *INVARIANTS:
 * - If there's no current index, current = -1
 * - size = holder.length
 * - -1 < current < size
 * -If size > 0, the contents are stored in holder at indexes 0 to size-1 and the
 *      contents of the indexes >= size are irrelevant
 * - If size = 0, the contents are irrelevant
 * - 0 <= size <= capacity
 *
 */
public class Sequence
{

	private LinkedList holder;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int currentIndex;
    private final int NO_INDEX = -1;

    private final int START = 0;

	
    /**
     * Creates a new sequence with initial capacity 10.
     */
    public Sequence() {
    	this.holder = new LinkedList();
        this.capacity = DEFAULT_CAPACITY;
        this.currentIndex = NO_INDEX;
    }
    

    /**
     * Creates a new sequence.
     * 
     * @param initialCapacity the initial capacity of the sequence.
     */
    public Sequence(int initialCapacity){
        this.holder = new LinkedList();
        this.capacity = initialCapacity;
        this.currentIndex = NO_INDEX;
    }

    public int getCurrentIndex(){
        return this.currentIndex;
    }
    

    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value) {
        this.capacityReached();
        if(this.isEmpty()){
            this.holder.insertAtHead(value);
            this.setCurrentIndex(START);
        }
        else{
            if(!this.isCurrent()){
                this.setCurrentIndex(START);
            }
            this.holder.addAtIndex(this.getCurrentIndex(), value);
        }
    }

    private void capacityReached() {
        if(this.size() == this.getCapacity()){
            this.ensureCapacity((this.getCapacity()*2)+1);
        }
    }

    private void setCurrentIndex(int newIndex) {
        this.currentIndex = newIndex;
    }


    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value) {
        this.capacityReached();
        if(!this.isCurrent()){
            this.setCurrentIndex(this.size());
            this.holder.insertAtEnd(value);
        }
        else{
            this.setCurrentIndex(getCurrentIndex()+1);
            this.holder.insertAfter(value, getCurrent());
        }
    }


    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent() {
        return this.getCurrentIndex() != NO_INDEX;
    }
    
    
    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
        return this.capacity;
    }

    
    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
        if (isCurrent()){
            return this.holder.getDataAtIndex(this.getCurrentIndex()); //is this an appropriate helper method
        }
        else{
            return null;
        }
    }
    
    
    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity) {
        if(this.getCapacity() < minCapacity){
            this.capacity = minCapacity;
        }
    }

    
    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make (just enough) room for
     * all of the elements to be added.
     * 
     * Postcondition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another) {
        if(this.size()+another.size() > this.getCapacity()){
            this.ensureCapacity(this.size()+another.size());
        }
        this.holder.addAll(another.holder);
    }

    
    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     */
    public void advance() {
        if(isCurrent()) {
            if (endOfSequenceReached()) { // if the current index is at the end of the sequence
                this.currentIndex = NO_INDEX;  //is this.getCapacity()-1 the best way to express "at the last index"
            }
            else{
                this.currentIndex +=1;
            }
        }
    }

    private boolean endOfSequenceReached(){
        return this.currentIndex == getLastIndex();
    }

    private int getLastIndex(){
        return this.size()-1;
    }
    
    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     * 
     * Postcondition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */
    public Sequence clone()
    {
        Sequence sequenceCopy = new Sequence(this.getCapacity());
        sequenceCopy.holder = this.holder.clone();
        sequenceCopy.currentIndex = this.getCurrentIndex();

        return sequenceCopy;
    }
   
    
    /**
     * Remove the current element from this sequence.  The following
     * element, if there was one, becomes the current element.  If
     * there was no following element (current was at the end of the
     * sequence), the sequence now has no current element.
     *
     * If there is no current element, does nothing.
     */
    public void removeCurrent() {
        if(this.isCurrent()){
            if(!this.endOfSequenceReached()){
                if(this.getCurrentIndex() == START){
                    this.holder.removeAtHead();
                }
                else{
                    this.holder.removeAtIndex(this.getCurrentIndex());
                }
            }
            else{
                this.setCurrentIndex(NO_INDEX);
                this.holder.removeAtIndex(this.size()-1);
            }
        }
    }

    
    /**
     * @return the number of elements stored in the sequence.
     */
    public int size() {
        return this.holder.getLength();
    }

    
    /**
     * Sets the current element to the start of the sequence.  If the
     * sequence is empty, the sequence has no current element.
     */
    public void start() {
        if(this.isEmpty()){
            this.setCurrentIndex(NO_INDEX);
        }
        else{
            this.setCurrentIndex(START);
        }
    }

    
    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize() {
        if(this.getCapacity() > this.size()){
            this.capacity = this.size();
        }

    }
    
    
    /**
     * Produce a string representation of this sequence.  The current
     * location is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the current element, and the
     * capacity is 5, would print as:
     * 
     *    {A, >B} (capacity = 5)
     * 
     * The string you create should be formatted like the above example,
     * with a comma following each element, no comma following the
     * last element, and all on a single line.  An empty sequence
     * should give back "{}" followed by its capacity.
     * 
     * @return a string representation of this sequence.
     */
    public String toString() {
        String sequenceString = "{";
        if(!this.isEmpty()){
            for(int i = 0; i < this.size(); i++){
                if(i == this.currentIndex) {
                    sequenceString += ">";
                    sequenceString += this.holder.getDataAtIndex(i);
                    if(i+1 != this.size()){
                        sequenceString += ", ";
                    }
                }
                else{
                    sequenceString += this.holder.getDataAtIndex(i);
                    if(i+1 != this.size()){
                        sequenceString += ", ";
                    }
                }
            }
        }
        return sequenceString += "} (capacity = " + this.getCapacity() + ")";
    }
    
    /**
     * Checks whether another sequence is equal to this one.  To be
     * considered equal, the other sequence must have the same size
     * as this sequence, have the same elements, in the same
     * order, and with the same element marked
     * current.  The capacity can differ.
     * 
     * Postcondition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     * 
     * @param other the other Sequence with which to compare
     * @return true iff the other sequence is equal to this one.
     */
    public boolean equals(Sequence other) 
    {
        if (this.getCurrentIndex() != other.getCurrentIndex()){
            return false;
        }
        return this.holder.equals(other.holder);
    }
    
    
    /**
     * 
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty() {
        return this.holder.isEmpty();
    }
    
    
    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear() {
        this.currentIndex = NO_INDEX;
        this.holder.clear();
    }

}