import java.util.Hashtable;
import java.util.Scanner;

public class Library extends Building{
  private Hashtable<String, Integer> collection; //int stores the num of copies of book in our collection

  // class constructor
  public Library(String name, String address, int nFloors){
    super(name, address, nFloors);
    this.collection = new Hashtable<> ();
  }

  // getter for hashtable of library's collection
  public Hashtable<String, Integer> getCollection(){
    return this.collection;
  }

  // returns true if the title appears as a key in the Libary's collection, false otherwise
  public boolean containsTitle(String title){
    if (collection.containsKey(title)){
      return true;
    }
    else{
      return false;
    }
  }

  // returns true if the title is currently available, false otherwise
  public boolean isAvailable(String title){
    if (collection.get(title) > 0){
      return true;
    }
    else{
      return false;
    }
  }

  // add a book to the collection
  public void addTitle(String title){
    // if title exists, ask user is they still wish to add book.
    if (this.containsTitle(title)){
      System.out.println("There is currently a copy of " + title + " in this library. Do you still wish to add this book? (Yes/No)");
      
      Scanner sc = new Scanner(System.in); // initialize a scanner for user input
      String userInput = sc.nextLine(); // catch the user input

      // if user says yes, increase num of copies of book by 1
      if (userInput.equalsIgnoreCase("Yes")){
        collection.replace(title, collection.get(title), collection.get(title) + 1);
        System.out.println("A new copy of " + title + " has been successfully added to " + this.getName() + "'s collection");
      }
      
      // if user enters no, don't add book
      else if (userInput.equalsIgnoreCase("No")){
        System.out.println("We will not add a new copy of this book to our collection at this time");
      }

      // if user enters an invalid option, throw an exception
      else{
        sc.close(); // if we throw an exception, close the scanner here
        throw new RuntimeException("You have entered an invalid option. You must enter either yes or no");
      }
      sc.close(); // if no exception, close the scanner here
    }

    // otherwise, simply add title
    else{
      collection.put(title, 1);
      System.out.println(title + " has been successfully added to " + this.getName() + "'s collection");
    }
  }

  public String removeTitle(String title){
    // if title is in collection, ask the user if they wish to remove all copies of the book
    if (this.containsTitle(title)){
      System.out.println("There are currently " + collection.get(title) + " copies of " + title + " in " + this.getName() + "'s collection. Do you wish to remove all copies? (Yes/No)");
      
      Scanner sc = new Scanner(System.in);
      String userInput = sc.nextLine();

      // if user wishes to remove all copies
      if (userInput.equalsIgnoreCase("Yes")){
        collection.remove(title);
      }

      // if not, how many copies does the user wish to remove?
      else if (userInput.equalsIgnoreCase("No")){
        System.out.println("How many copies of this book do you wish to remove?");
        Integer numOfCopies = sc.nextInt();

        // try to accept an int. Else, throw an exception
        try{
          // if input is an integer and user input > available number of copies, throw an exception
          if (numOfCopies > collection.get(title)){
            sc.close();
            throw new RuntimeException("You cannot remove more copies of this book than is available");
          }

          // else, remove the number of copies stated by the user
          else{
            collection.replace(title, collection.get(title), collection.get(title) - numOfCopies);
            System.out.println("You have removed " + numOfCopies + " copies of " + title + "from " + this.getName() + "'s collection. There are " + collection.get(title) + " copies left.");
          }
        } catch(NumberFormatException e){
          System.out.println("You have entered an invalid input. Please, enter an integer.");
        }
      }
      sc.close();
    }
    // if title is not in collection, throw an exception
    else{
      throw new RuntimeException("The book you're trying to remove is not in "  + this.getName() + "'s collection");
    }
    return title;
  }

  // check out a book
  public void checkOut(String title){
    // if title is in exception, reduce num of copies in library by 1
    if (this.isAvailable(title)){
      collection.replace(title, collection.get(title), collection.get(title) - 1);
      System.out.println("You have successfully checked out " + title + " from " + this.getName());

    }
    // if title is not in collection, throw an exception
    else{
      throw new RuntimeException(this.getName() + "does not have a copy of " + title);
    }
    }

  
  // return a book
  public void returnBook(String title){
    // if title is in collection, increase num of copies in library by 1
    if (this.containsTitle(title)){
      collection.replace(title, collection.get(title), collection.get(title) + 1);
      System.out.println("You have successfully retured " + title + " to " + this.getName());
    }
    // if title is not in collection, throw an exception
    else{
      throw new RuntimeException(title + " was never in " + this.getName() + "'s collection. You could not havee borrowed it from here.");
    }
  }

  // prints out the entire collection and number of copies available for each book in an easy-to-read way 
  public void printCollection(){
    System.out.println("\n" + this.getName().toUpperCase() + "'s BOOK COLLECTION"); // print a header for list
    collection.forEach((key, value)-> System.out.println("Copies currently available: " + value + "\t \t Title: " + key ));
    }



  public static void main(String[] args) {
    Library neilsonLibrary = new Library("Neilson library", "10 Chapin Lawn", 3);
    System.out.println(neilsonLibrary);
    neilsonLibrary.addTitle("Purple Hibiscus by Adichie");
    // neilsonLibrary.addTitle("Purple Hibiscus by Adichie");
    neilsonLibrary.addTitle("Mockingbird by Lee");
    // neilsonLibrary.addTitle("Mockingbird by Lee");
    // neilsonLibrary.addTitle("Mockingbird by Lee");
    // neilsonLibrary.removeTitle("Chi by Emma");
    neilsonLibrary.checkOut("Mockingbird by Lee");
    neilsonLibrary.printCollection();
  }
}

// OH questions
// AddTitle doesn't work too well if I try to add two or more books twice at once
// The scanner doesn't seem to like it if I have to input something more than once. It messes up for removeTitle too if I already used user input for addTitle
// How do I let the printCollection print num of Copies currently available and total num of Copies in collection
// Could store a pair of nums: total, current. Int array of size two
// Make two branches on git

// TO DO
// Fix the way scanner works in addTitle and removeTitle
// Add Javadoc headers

// NOTES TO ME
// Hastables are java's version of python dictionaries
// How do I let the printCollection print num of Copies currently available and total num of Copies in collection