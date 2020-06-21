package project04option2summer2018;
/**
 * your LinkedBag from Lab 5 / Project 2
 * @author Brian Albert
*/


public class LinkedBag<E extends Comparable<E>>
{
    private Node<E> head;
    private Node<E> tail;
    private int numElements;

    /**
     * No-arg constructor
     */
    public LinkedBag() {
        head = null;
        tail = null;
        numElements = 0;
    }

    /**
     * getSize method returns the number of elements
     *
     * @return The value in the numElements field
     */
    public int getSize() {
        return numElements;
    }

    /**
     * appendList method adds an element after the tail
     *
     * @param newElement The E object to be added
     */
    public void appendList(E newElement) {
        if (tail == null) {
            head = new Node<E>(newElement, null);
            tail = head;
        } else {
            tail.setNext(new Node<E>(newElement, null));
            tail = tail.getNext();
        }
        numElements++;
    }

    /**
     * prependList method adds an element before the head
     *
     * @param newElement The E object to be added
     */
    public void prependList(E newElement) {
        head = new Node<E>(newElement, head);
        numElements++;
    }
    
    /**
     * add method adds the elements in order
     * @param newElement value to be added to the list
     */
    public void add(E newElement) {
        Node<E> previous = null;
        Node<E> cursor = head;
        boolean found = false;
                
        if (cursor == null){
            head = new Node<E>(newElement, head);
            tail = head;
            found = true;
        }
        
        while (found != true) {
            if (newElement.compareTo(cursor.getData()) > 0) {
                if (cursor == tail){
                    tail.setNext(new Node<E>(newElement,null));
                    tail = tail.getNext();
                    found = true;
                }
                previous = cursor;
                cursor = cursor.getNext();
            }
            else
            {
                if (cursor == head){
                    head = new Node<E>(newElement,head);
                }
                else if (cursor == tail){
                    tail.setNext(new Node<E>(newElement,null));
                    tail = tail.getNext();
                }
                else{
                    previous.setNext(new Node<E>(newElement,cursor));
                }
                found = true;
            }
        }
        numElements++;
    }

    /**
     * exists boolean checks if a string exists in the data
     *
     * @param target is the target value checked for existence
     * @return That the value has been found
     */
    public boolean exists(E target) {
        boolean found = false;
        Node<E> cursor = head;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                cursor = cursor.getNext();
            }
        }
        return found;
    }

    /**
     * countOccurences method looks for a String in the data
     *
     * @param target The String to be found in the data
     * @return an int with the number of times target is found in the data
     */
    public int countOccurences(E target) {
        int numOccur = 0;
        Node<E> cursor = head;

        while (cursor != null) {
            if (cursor.getData().equals(target)) {
                numOccur++;
            } else {
                cursor = cursor.getNext();
            }
        }
        return numOccur;
    }

    /**
     * remove method looks for the 1st occurrence of a String and removes it
     *
     * @param target The String to be removed
     * @return a boolean to indicate if the target was removed
     */
    public boolean remove(E target) {
        Node<E> cursor = head, previous = null;
        boolean found = false;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                previous = cursor;
                cursor = cursor.getNext();
            }
        }
        if (found && cursor != null) {
            if (previous == null) {
                head = head.getNext();
            } else {
                previous.setNext(cursor.getNext());
            }

            if (tail == cursor) {
                tail = previous;
            }
            numElements--;
        }
        return found;
    }

    /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new Lister<E>
     *
     * @return a Lister<E> using a copy of the linked list
     */
    public Lister<E> iterator() {
        // declare variables
        Node headOfListToReturn; // beginning of new "copied" list
        Node cursorOfListToCopy; // active node of list to copy
        Node lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) {
            // create the head of the new list
            headOfListToReturn = new Node(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getNext();
            // if we have a node...
            while (cursorOfListToCopy != null) {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setNext(new Node(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getNext();
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getNext();
            }
        }

        return new Lister(headOfListToReturn);
    }
}
