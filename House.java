
// /* This is a stub for the House class */
// import java.util.ArrayList;

// public class House extends Building {


// /** Checks if house has a dining hall 
//      * @return True or False 
//     */
//     private boolean hasDiningRoom;

    
//     private ArrayList<String> residents; 
//   // The <String> tells Java what kind of data we plan to store IN the ArrayList
  
//   public boolean hasDiningRoom(){
//     return this.hasDiningRoom;
//   }
//   public ArrayList<String> residents(){
//     return this.residents;
//   }

//   public int nResidents(){
//     return residents.size();
//   }

// public void moveIn(String name){
//   residents.add(name);


// }
 
// public String moveOut(String name){
//   for (String resident: residents) {
//     if (resident.equals(name)) {
//       return resident;
//     }
//   }
//   residents.remove(name);
//   return null;
// }

// // return the name of the person who moved out

// /** Check if person is on the house's resident list
//  * @param name 
//  * @return True or False - not the list of the names of residents!
//  */

//   public House(boolean DiningRoom, ArrayList<String> residents, String name, String address, int nFloors) {
//     super(name,  address,  nFloors);
//     this.hasDiningRoom = DiningRoom;
//     this.residents = residents;

    

//     System.out.println("You have built a house: 🏠");
//   }

//   public static void main(String[] args) {
//     House Talbot = new House(True, "hannah", "priya", "reilly");
//     System.out.println(Talbot);
//   }

// }

import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
  }

  public String moveOut(String name){
    // check if this.residents contains name
    if (!this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.remove(name);
    System.out.println(name + " has just moved out from " + this.name + "! Go say bye :-(");
    return name;
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    morrow.moveOut("Jordan");
    System.out.println(morrow);
    House king = new House("King", "The Quad", 3, true);
    System.out.println(king);
  }

}