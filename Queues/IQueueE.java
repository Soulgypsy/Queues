/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7qa;

/**
 *
 * @author rla
 * @param <E>
 */
public interface IQueueE<E> {
    /**
     * This method will be used to construct a queue
     */
    public void createQueue();
    /**
     * Use this method to add (enqueue) an item/object onto the queue
     * @param e Generic object
     */
    public void enqueue ( E e );
    /**
     * Use this method to remove (dequeue) an item off/from the queue
     * @return an item/object from the queue
     */
    public E dequeue ();
    /**
     * Use this method to see the item/object on the front of the queue.
     * The item/object is not removed from the queue.
     * @return the item/object at the front of the queue.
     */
    public E peek();
    /**
     * Use this method to determine if the queue is empty
     * i.e. contains no items.
     * @return true or false 
     */
    public boolean isEmpty();
    /**
     * Use this method to determine if the queue is full.
     * i.e. has reached its maximum capacity.
     * @return true or false.
     */
    public boolean isFull();
    
}
