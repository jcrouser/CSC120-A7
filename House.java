import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;

  // Class constructor
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors); // the super contructor must take in all the required parameters as defined int the parent class
    this.residents = new ArrayList<> ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator; 
  }

  // getter for hasDining
  public boolean getHasDining(){
    return this.hasDiningRoom;
  }

  // getter for hasElevator
  public boolean getHasElevator(){
    return this.hasElevator;
  }

  // get the number of residents in house
  public int nResidents(){
    int n = residents.size();
    return n;
  }

  // to String
  public String toString(){
    String desc = super.toString();
    if (this.hasDiningRoom){
      desc += " It has a dining room.";
    }

    if (this.hasElevator){
      desc += " It has an elevator.";
    }
    return desc;
  }

  // are you a resident?
  public boolean isResident(String person){
    if (this.residents.contains(person)){
      return true;
    }
    else{
      return false; 
    }
  }

  // move in
  public void moveIn(String name){
    // not a resident? Sure move in!
    if (!isResident(name)){
      this.residents.add(name);
      System.out.println(name + " has successfully moved into " + this.getName());
    }
    // already a resident? Can't move in twice ):
    else{
      throw new RuntimeException(name + " is already a resident in " + this.getName());
    }
  }

  // move out
  public String moveOut(String name){
    // a resident? Sad to see you leave  ):
    if (isResident(name)){
      this.residents.remove(name);
      System.out.println(name + " has successfully moved out of " + this.getName() + ". We're sad to see you leave ):");
      return name;
    }
    // not a resident? Can't move out 
    else{
      throw new RuntimeException(name + " can't move out as " + name + " is not a resident in " + this.getName());
    }
  }


  public static void main(String[] args) {
    House morrisHouse = new House("Morris House", "101 Green Street", 4, false, false);
    System.out.println(morrisHouse);
    System.out.println(morrisHouse.getHasDining());
    System.out.println(morrisHouse.getHasElevator());
    morrisHouse.moveIn("Chioma");
    morrisHouse.moveOut("Chioma");
    morrisHouse.moveIn("Sabina");
    morrisHouse.moveIn("Olohi");
    System.out.println(morrisHouse.nResidents());
  }

}
// OH questions: 
// why should hasDiningRoom or nResidents be private? You don't want other to be able to change it

// TO DO
// Javadoc headers


// NOTE TO ME:
// Idea of hw: what should be handled by the parent class, and what should be handled by the individual classes
// remember to add accessors for the required values(diningroom, nresidents)
// for security reasons, we will never print out the entire list of house residents