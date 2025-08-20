/*
    A browser keeps track of visited pages using two stacks:
    - Back Stack: Stores previously visited pages.
    - Forward Stack: Stores pages that were navigated back from. Task: Create a BrowserNavigation class that:
    - Uses two CustomStack<String> objects (backStack and forwardStack).
    - Keeps track of the currentPage.
    - Implements methods:
    - visitPage(String url): Navigates to a new page.
    - goBack(): Moves back to the previous page.
    - goForward(): Moves forward if available.
    - Override toString() to provide a visual representation of stacks.

    provide a real world example of how a stack can be used to help with browser navigation
*/

//we need our class sig
public class BrowserNavigation{
  // we need two stacks, one for forward and one for back navigation and also we should keep track
  // of the current URL
  private CustomStack<String> backStack;
  private CustomStack<String> forwardStack;
  private String currentPage;

  //we would like to expose / create a constructor
  public BrowserNavigation(){
    backStack = new CustomStack<>();
    forwardStack = new CustomStack<>();
    currentPage = "Home";
  }

/*
  we need to be able to visit a new page...
  - visitPage(String url): Navigates to a new page.
*/

    public void visitPage(String url){
      // we we are currently on a url we need to preserve this in the backstack...
      if(currentPage != null){
        backStack.push(currentPage);
      }
      //change the current page to the new URL
      currentPage = url;
      //flush out the forwardStack...
      forwardStack = new CustomStack<>();
    }

/*
      we need to be able to go back to a previous page
      - goBack(): Moves back to the previous page.
*/
  public void goBack(){
    if(backStack.isEmpty()){
      System.out.println("There are no pages available in the history");
      return;
    }
    forwardStack.push(currentPage);
    currentPage = backStack.pop();
  }

  /*

    we also need to be able to navigate forward
    - goForward(): Moves forward if available.
 */
  public void goForward(){
    if(forwardStack.isEmpty()){
      System.out.println("There are no pages available to navigate to");
      return;
    }
    backStack.push(currentPage);
    currentPage = forwardStack.pop();
  }

  we should be able to print out the contents

  @Override
  public String toString(){
    return "=== Browser Navigation State ==\n" +
            "Back Stack: "+stackToString(backStack)+"\n" +
            "Current Page: "+currentPage+"\n" +
            "Forward Stack: "+stackToString(forwardStack)+"\n";
  }


  //The stack to String method should be able to take in a stack and pring out
  // a string representation of the stack elements

  private String stackToString(CustomStack<String> stack){
    //we would like to be able to iterate over the custom stack and create a
    //string representation of the elements
    CustomStack<String> temp = new CustomStack<>()
    StringBuilder sb = new StringBuilder("[");

    //we would like to print the object from bottom to top, so we should reverse the order
    while(!stack.isEmpty()){
      String item = stack.pop();
      temp.push(item);
    }

    //create the string representation for the output
    while(!temp.isEmpty()){
      //pop the item and create the string....
      String item = temp.pop();
      sb.append(item);
      if(!temp.isEmpty()) sb.append(", ");
      stack.push(item);
    }
    sb.append("]");
    return sb.toString();
  }

  //create a main method to be able to visualise the navigation
  public static void main(String [] args){
    //we need to create an instance of the Browser navigation class
    BrowserNavigation browser = new BrowserNavigation();

    browser.visitPage("https://www.ncirl.ie");
    browser.visitPage("https://www.google.ie");

    System.out.println(browser);

    browser.goBack();
    System.out.println(browser);

    browser.goForward();
    System.out.println(browser);
  }
}
