
public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * 
     * Constructor for initializing the values of how much coffee, cream, sugar, and cups
     * 
     * @param name string of the name of the building being created
     * @param address string of the address of the building being created
     * @param nFloors integer for the number of floors the building will have
     * 
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        nCoffeeOunces = 500;
        nSugarPackets = 200;
        nCreams = 200;
        nCups = 1000;
    }
/**
 * method that reduces the amount of coffee, cream, and sugar to represent selling a cup of coffee
 * 
 * @param size number of ounces for the cup of coffee being sold
 * @param nSugarPackets number of sugar packets used in the coffee
 * @param nCreams number of creams being used
 * 
 */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        System.out.println("Buying a coffee......");
        this.nCoffeeOunces = nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        System.out.printf("There is " + nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " packets of sugar, and " + this.nCreams + " creams left.");
    }

    /**
     * 
     * @param nCoffeeOunces amount of coffee being added back to the stock
     * @param nSugarPackets amount of sugar being added
     * @param nCreams amount of creams being added
     * @param nCups amount of cups being added
     */
    // private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){

    // }
    public static void main(String[] args) {
        Cafe centralcafe = new Cafe("Campus Cafe", "1 Chapin Way", 1);
        centralcafe.sellCoffee(12, 3, 4);

    }
    
}
