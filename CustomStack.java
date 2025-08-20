/*
  Using the Node<T> class, implement a CustomStack<T> class that behaves like a stack (LIFO - Last In,
  First Out).
  Task: Implement the following methods in CustomStack<T>:
  - void push(T data): Adds a new element to the top of the stack.
  - T pop(): Removes and returns the top element.
  - T peek(): Returns the top element without removing it.
  - boolean isEmpty(): Checks if the stack is empty.
*/

//create the class sig
public class CustomStack<T>{
  //we know in our stack we simply need to keep reference of the Top Node

  private Node<T> top;

  //we need to have a constructor for our custom stack
  public CustomStack(){
    this.top = null;
  }

  /*
    We need to be able to create the push method. This should take some new
    data and push it on top of the CustomStack
  */
  public void push(T data){
    //create the Node and then add it to the top of the stack
    Node<T> newNode = new Node<>(data);
    //we then need to add it into the stack to make sure that the stack operates like a stack
    newNode.next = top;
    top = newNode;
  }

  /*
    The next method is called pop. This method should return the data from the stack and 
    remove the node from the stack.
  */

  public T pop(){
    //we need to make sure that there is something in the stack before we try and remove it
    if(isEmpty()){
      throw new IllegalStateException("The stack is empty");
    }
    //if we want to remove the data from the stack we should create a variable of type T
    T data = top.data;
    top = top.next;
    return data;
  }

  /*
    we need to have a peek method that returns the data without remove it from the stack...
  */
  public T peek(){
    //we need to make sure that there is something in the stack before we try and remove it
    if(isEmpty()){
      throw new IllegalStateException("The stack is empty");
    }
    //this time we simply want to return the data from the top element
    //we don't want to be able to change the reference of the Top node...
    return top.data;
  }

  //we need to have a method that is able to check if the Stack is empty
  public boolean isEmpty(){
    return top == null;
  }

}
