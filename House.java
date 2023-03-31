import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
/**
     * 
     * Constructor for initializing the values of how much coffee, cream, sugar, and cups
     * 
     * @param name string of the name of the building being created
     * @param address string of the address of the building being created
     * @param nFloors integer for the number of floors the building will have
     * @param hasDiningRoom boolean value for whether or not the house has a dining room
     */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    // System.out.println("You have built a house: 🏠");
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }
  /**
   * 
   * @return the boolean value of if the house has a dining room
   */
  public boolean hadDiningRoom(){
    return hasDiningRoom;
  }
/**
 * 
 * @return integer of how many residents reside in this house
 */
  public int nResidents(){
    return this.residents.size();
  }
/**
 * Used to add a new student into the desired house
 * @param r string containing the name of the student being added to the house
 */
  public void moveIn(String r){
    this.residents.add(r);
  }
/**
 * 
 * @param r string containing the name of the student being removed
 * @return a string confirming the student and the removal of the student
 */
  public String moveOut(String r){
    if (this.residents.contains(r)){
      this.residents.remove(r);
    }
    return "Removing " + r + " from this house.";
  }
/**
 * 
 * @param r string of the name of the student
 * @return boolean value on if the student resides in that house
 */
  public boolean isResident(String r){
    return this.residents.contains(r);
  }
  // public String toString(){
  //   String description = super.toString();
  //   description += "There are currently " + this.residents.size() + " residents in this house.";
  //   description += "This house";
  //   // if (this.hasDiningRoom){

    // }
  // }
  

  public static void main(String[] args) {
    House chapin = new House("Chapin", "3 Chapin Way", 4, true);
    chapin.moveIn("Jamie");
    System.out.println(chapin);
    chapin.residents.contains("Jamie");
  }

}