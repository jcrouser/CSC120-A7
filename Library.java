import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors){
      super(name, name, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title){
        if (this.collection.contains(title)){
          throw new RuntimeException ("This title is already in this collection");
        }
        else{
          System.out.println("Adding " + title + ".........");
          this.collection.put(title, true);
          System.out.println("Book added!");
        }
        
    }

    public String removeTitle(String title){
      this.collection.remove(title);
      return title + "has been removed.";
    }

    public void checkOut(String title){
      this.collection.replace(title, true, false);
    }

    public void returnBook(String title){
      this.collection.replace(title, false, true);
    }

    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
      }
        else{
          throw new RuntimeException ("Title not found");
        }
    }

    public boolean isAvailable(String title){
      if (this.collection.containsValue(true)){
        return true;
      }
      else{
        throw new RuntimeException  ("This title is not available");
      }
    }

    public void printCollection(){
      System.out.println("Printing collection...");
      System.out.println(this.collection.keys());
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "7 Neilson Drive", 4);
      neilson.addTitle("Green Eggs and Ham");
      neilson.printCollection();
    }
  
  }