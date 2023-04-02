import java.util.Hashtable;

/* This is a stub for the Library class */


public class Library extends Building {

  private Hashtable<String, Boolean> collection;


  /** Library contructor
   * @param name, address, nFloors
   */

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
    }
  
    /** Accessor for number of books in the collection just in case */
  public int nBooks() {
    return this.collection.size();
  }

  /** this method that adds title to hashtable collection
   * @param title
   * throws an exception if the book is already there
   */

  public void addTitle(String title){
    // check if this.collection already contains the book
    if (this.collection.contains(title)) {
      //   if so: throw and exception
      throw new RuntimeException(title + " is already part of the collection in " + this.name);
    }
    // if we're good to go, add from collection
    this.collection.put(title, true);
    System.out.println("We added " + title + " to the collection of " + this.name + "! Yay! :-)");
    

  }

   /** this method that removes title to hashtable collection
   * @param title
   * @return the title if we removed it
   * throws an exception if the book is not there
   */
  public String removeTitle(String title){
    // check if this.collection already contains the book
    if (!this.collection.containsKey(title)) {
      //   if so: throw and exception
      throw new RuntimeException(title + " is not part of the collection in " + this.name);
    }
    // if we're good to go, remove from collection
    this.collection.remove(title);
    System.out.println("We removed " + title + " to the collection of " + this.name);
    return(title);

  } // return the title that we removed
  

   /** this method that assigns key to title to false
   * @param title
   * throws an exception if the book is not already there
   */
  public void checkOut(String title){
     // check if this.collection already contains the book
     if (!this.collection.containsKey(title)) {
      //   if so: throw and exception
      throw new RuntimeException(title + " is not part of the collection in " + this.name);
    }
   this.collection.put(title, false);


  }


  /** this method that changes key of title to true
   * @param title
   * throws an exception if the book is not already there
   */
  public void returnBook(String title){
    // check if this.collection already contains the book
    if (!this.collection.containsKey(title)) {
      //   if so: throw and exception
      throw new RuntimeException(title + " is not part of the collection in " + this.name);
    }
    this.collection.replace(title, true);
  }
    
  public boolean containsTitle(String title){ 
    // returns true if the title appears as a key in the Libary's collection, false otherwise
    return this.collection.containsKey(title);
  
    }
  
  public boolean isAvailable(String title){
    // returns true if the title is currently available, false otherwise

    return (this.collection.get(title));
    }

  public void printCollection(){
     // prints out the entire collection in an easy-to-read way (including checkout status)
     System.out.println(collection);
  } 

  /** Method that prints the info & collection of the library
   * @return books and their status in the library's collection
  */

  public String toString(){
    String toReturn = "You are currently in the " + this.name + " Library" + "located on " + this.address + "\n";
    toReturn += "Here are the current books in the collection and their check-out status: \n";
    toReturn +=  "Note: True is checked-in. False is checked-out. \n ";
    toReturn += "+this.printCollection()+";
    return toReturn;


  }


    public static void main(String[] args) {
     Library hillyer = new Library("hillyer", "green st.", 3);
     hillyer.addTitle("ur mom");
     hillyer.addTitle("milk & honey");
     hillyer.addTitle("communist manifesto");
     hillyer.addTitle("bts jimin doll");
     hillyer.checkOut("ur mom");
     hillyer.containsTitle("milk & honey pt 2");

     // checking the status of a book 
     System.out.println("communism is " + hillyer.isAvailable("communist manifesto"));

     // checking in a book that isn't in the collection

     hillyer.returnBook("the jewish & japanese: cooking & how to raise wolves");
     hillyer.removeTitle("bts jimin doll");
    System.out.println(hillyer);

     
    }
  
  }