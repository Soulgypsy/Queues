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
public interface IStackE<E> {
    /**
     * This method will be used to construct a stack
     */
    public void createStack();
    /**
     * Use this method to add (push) an item/object onto the stack
     * @param e Generic object
     */
    public void push ( E e );
    /**
     * Use this method to remove (pop) an item off/from the stack
     * @return an item/object from the stack
     */
    public E pop ();
    /**
     * Use this method to see the item/object on the top of the stack.
     * The item/object is not removed from the stack.
     * @return the item/object at the top of the stack.
     */
    public E peek();
    /**
     * Use this method to determine if the stack is empty
     * i.e. contains no items.
     * @return true or false 
     */
    public boolean isEmpty();
    /**
     * Use this method to determine if the stack is full.
     * i.e. has reached its maximum capacity.
     * @return true or false.
     */
    public boolean isFull();

}
