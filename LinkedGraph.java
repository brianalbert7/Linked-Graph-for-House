package project04option2summer2018;

/**
 * 
 * @author Brian Albert
 */
public class LinkedGraph 
{
	private LinkedBag<Location> vertexList;
        
        /**
         * No-arg constructor
         */
        public LinkedGraph(){
            vertexList = new LinkedBag<Location>();
        }
        
        /**
         * addVertex method adds a new location to known graph
         * @param newVertex value to be added to the graph
         */
        public void addVertex(Location newVertex){
            vertexList.add(newVertex);
        }
        
        /**
         * size method returns the size of the vertex list
         * @return the number of elements held in the vertex list
         */
        public int size(){
            return vertexList.getSize();
        }
        
        /**
         * addEdge method receives 2 locations and if the source and 
         * destination are in the known list of vertices, the second location 
         * is added as a neighbor to the first Location passed
         * @param source starting location
         * @param destination location to add
         */
        public void addEdge(Location source, Location destination){
            if (vertexList.exists(source) &&  vertexList.exists(destination))
                source.addNeighbor(destination);
        }
        
        /**
         * isEdge method receives 2 Locations and if the source and 
         * destination are in the known list of vertices, the second Location 
         * is checked to see if it is a neighbor of the first Location
         * @param source location you are at
         * @param destination location to see if it is a neighbor of source
         * @return true if destination is a neighbor of source, false if not
         */
        public boolean isEdge(Location source, Location destination){
            if (vertexList.exists(source) &&  vertexList.exists(destination)){
                if (source.isNeighbor(destination))
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        
        /**
         * neighbors method returns a Lister of Location which are the 
         * neighbors of the Location passed
         * @param vertex value whose neighbors user wants to see
         * @return lister of location of neighbors
         */
        public Lister<Location> neighbors(Location vertex){
            return vertex.neighbors();
        }
}
