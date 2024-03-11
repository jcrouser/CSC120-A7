public class Cafe extends Building {
private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
private int nSugarPackets; // The number of sugar packets remaining in inventory
private int nCreams; // The number of "splashes" of cream remaining in inventory
private int nCups; // The number of cups remaining in inventory

    // Class constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); 
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    // check if cafe has enough supplies to sell order
    private boolean canSell(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams){
            return true;
        }
        else{
            return false;
        }
    }

    // restock cafe supplies
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.canSell(size, nSugarPackets, nCreams)){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
        else{
            this.restock(size*5, nSugarPackets*5, nCreams*5, 5);
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }
    
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 50, 100, 100, 100);
        compassCafe.sellCoffee(12, 2, 3);
    }
    
}

// OH questions
// Since all the attributes are private, can I simply change them within the methods as I have done here?
// Why is nCups saying that it is never used locally, although I used it multiple time?
