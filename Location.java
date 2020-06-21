package project04option2summer2018;

/**
 * 
 * @author Brian Albert
 */
public class Location implements Comparable<Location> 
{
	private String description;
        private LinkedBag<Location> neighbors;
        
        /**
         * Constructor
         * @param initDescription value for the description field
         */
        public Location(String initDescription){
            description = initDescription;
            neighbors = new LinkedBag<Location>();
        }
        
        /**
         * getDescription method returns the description of the location
         * @return value in the description field
         */
        public String getDescription(){
            return description;
        }
        
        /**
         * isNeighbor method returns a boolean that indicates whether other
         * location is a neighbor of this location
         * @param otherLocation value to see if it is neighbors with current location
         * @return boolean indicating whether the two locations are neighbors
         */
        public boolean isNeighbor(Location otherLocation){
            if (neighbors.exists(otherLocation))
                return true;
            else
                return false;
        }
        
        /**
         * compareTo method compares this description field to another locations
         * @param otherLocation value of whose description will be compared
         * @return int with result of comparison
         */
        public int compareTo(Location otherLocation){
            if (!(otherLocation instanceof Location))
                throw new ClassCastException("A Location object expected.");
            
            return description.compareToIgnoreCase(otherLocation.getDescription());
        }
        
        /**
         * equals method compares the description for this location to another
         * @param otherLocation is the other location whose description will be compared
         * @return a boolean for whether or not the descriptions are equal
         */
        public boolean equals(Location otherLocation){
            if (!(otherLocation instanceof Location))
                throw new ClassCastException("A Location object expected.");
            
            if (description.equalsIgnoreCase(otherLocation.getDescription()))
                return true;
            else
                return false;
        }
        
        /**
         * addNeighbor method receives a location and adds it to the neighbors
         * linked list
         * @param neighbor value to add to the linked list of neighbors
         */
        public void addNeighbor(Location neighbor){
            neighbors.add(neighbor);
        }
        
        /**
        * toString method used to return a String representing this location
        * @return a string representing the location
        */
        @Override
        public String toString(){
            return description;
        }
        
        /**
         * numNeighbors method returns the length of the neighbors linked list
         * @return length of neighbors linked list
         */
        public int numNeighbors(){
            return neighbors.getSize();
        }
        
        /**
         * neighbors method returns the Lister from the neighbors linked list
         * @return lister from neighbors linked list
         */
        public Lister<Location> neighbors(){
                return neighbors.iterator();
        }
}
