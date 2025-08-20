/*
A stack can be implemented using a linked list, where each element (or node) contains data and a reference to the next node. [15 marks]
Task: Create a Node<T> class that:
- Stores a generic data type (T).
- Has a reference (next) to the next node in the stack.
- Provides a constructor to initialise the data.
*/
//we need a class sig
public class Node<T>{
  //we should have some instance variables
  T data;
  Node<T> next;

  //This is the constructor which allows us to create an instance of the object Node
  //we pass in the data and assign it to our instance variable data and the pointer is
  //set to Null
  public Node(T data){
    this.data = data;
    this.next = null;
  }

  //we should provide a string representation of the Node to be able to
  // see the contents
  @Override
  public String toString(){
    return "Node { data = "+data+", is pointing at : ..."+next.data+"}";
  }

}
