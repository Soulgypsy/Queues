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
public class ADTStackE_RA<E> implements IStackE<E>{
    /**
     * Use this private method to check that an integer value
     * is within a set range.
     * @param valueToCheck the value to be checked.
     * @param minValueInclusive the starting value.
     * @param maxValueInclusive the end value.
     * @return true if within the range otherwise return false
     */
    private static boolean inRange(int valueToCheck, int minValueInclusive, int maxValueInclusive) {
        return (valueToCheck >= minValueInclusive && valueToCheck <= maxValueInclusive);
    }
    
    private int numberOfStackElements = 0;
    /**
     * DEFAULTMAXELEMENTS can be considered a "constant" value.
     * i.e. set at compile time and can't be changed.
     */
    private static final int DEFAULTMAXELEMENTS = 25;
    private int MAXELEMENTS;
    private int top = -1;
    private E[] aStack;

    /**
     * Default constructor
     */
    ADTStackE_RA() {
        this.MAXELEMENTS = DEFAULTMAXELEMENTS;
        this.aStack = (E[])new Object[this.MAXELEMENTS];
        this.numberOfStackElements = 0;
        this.top = -1;
    }
    /**
     * Use this version of the constructor to create a specific stack size.
     * If the specified stack size is not in the range 1 to 25 then the
     * stack will be created using the DEFAULTMAXELEMENTS value (25)
     * @param raSize size of the array
     */
    ADTStackE_RA( int raSize ) {
        if ( !inRange( raSize, 1, DEFAULTMAXELEMENTS ) ) {
            System.out.println("Size of array not allowed! Assuming " + DEFAULTMAXELEMENTS );
            raSize = DEFAULTMAXELEMENTS;
        }
        this.MAXELEMENTS = raSize;
        this.aStack = (E[])new Object[this.MAXELEMENTS];
        this.numberOfStackElements = 0;
        this.top = -1;
    }
    @Override
    public void createStack() {
        this.aStack = (E[])new Object[this.MAXELEMENTS];
        this.numberOfStackElements = 0;
        this.top = -1;        
    }

    @Override
    public void push(E e) {
        if ( isFull() ) {
            System.out.println(String.format("Array is full, only %3d elements allowed", this.MAXELEMENTS));
        } else {
            this.top ++;
            this.aStack[this.top] = e;
            this.numberOfStackElements ++;
        }
    }

    @Override
    public E pop() {
        if ( isEmpty() ) {
            throw new NullPointerException("Can't pop stack its Empty!!");
        } else {
            this.numberOfStackElements --;
            E e = this.aStack[this.top];
            this.top --;
            return e;            
        }
    }

    @Override
    public E peek() {
        if ( isEmpty() )
            throw new NullPointerException("Can't peek at top item as the stack is Empty!!");
        else
           return this.aStack[this.top];
    }

    @Override
    public boolean isEmpty() {
        return ( this.getStackSize() == 0 );
    }
    
    @Override
    public boolean isFull() {
        return ( this.numberOfStackElements == this.MAXELEMENTS );
    }
    
    public void displayStack() {
        System.out.println( this.toString() );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder( "\n" );
        int tmp = this.getStackSize() - 1;
        if(isEmpty())
        {
            sb.append("The stack is Empty!!");
        }
        else
        {
            while (tmp > -1) {
                sb.append( this.aStack[ tmp ] + "\n");
                tmp --;
            }
        }
        return sb.toString();
    }
    
    public int getStackSize() {
        return this.numberOfStackElements;
    }

}
