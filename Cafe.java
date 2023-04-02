
/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /** Constructor for the Cafe class
     * @param name, address, number of Floors
     *  
     */

    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        this.nCoffeeOunces = 500;
        this.nSugarPackets = 500;
        this.nCreams = 500;
        this.nCups = 500;
        System.out.println("You have built a cafe: ☕");


    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if( this.nCoffeeOunces < size){
            System.out.println("out of coffee! restock time:)");
            this.restock(100, 00, 0, 0);

        } 
        if (this.nSugarPackets < nSugarPackets) {
            System.out.println("out of sugar! restock time:)");
            this.restock(00, 100, 0, 0);
         }
        if (this.nCreams < nCreams ){
            System.out.println("out of cream! restock time:)");
            this.restock(00, 00, 100, 0);

        }
        if (this.nCups < 1){
            System.out.println("out of cups! restock time:)");
            this.restock(00, 00, 00, 100);
           
        }

        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;

        System.out.println("here's your coffee!☕");
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nCups;
        this.nCreams += nCreams;
        this.nCups += nCups;
    } 
    
    /** Method that prints out the inventory + details about the cafe
     * @return values of nCoffeeOunces, nSugarPackets, nCreams & nCups
     */
    public String toString(){
        String toReturn = "This is the " + this.name + " Cafe on " + this.address + "\n";
        toReturn += "Here is our inventory: " + "\n";
        toReturn += "Amount of Coffee: "+nCoffeeOunces+" oz. \n";
        toReturn += "Amount of Sugar: "+nSugarPackets+" packets. \n";
        toReturn += "Amount of Cream: "+nCreams+" oz. \n";
        toReturn += "Number of Cups: "+nCups+"  cups. ";

        return toReturn;


    }
    
    public static void main(String[] args) {

        Cafe JuliaChild = new Cafe("Julia Child CC", "Main St.", 3);

        for (int i = 0; i < 15; i++ ){
            JuliaChild.sellCoffee(20, 20, 20);
            System.out.println(JuliaChild);
        }
       System.out.println(JuliaChild);
    }
    
}
