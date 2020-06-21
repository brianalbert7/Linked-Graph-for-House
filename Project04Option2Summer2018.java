package project04option2summer2018;

import java.util.Scanner;

/**
 *
 * @author Brian Albert
 */
public class Project04Option2Summer2018 
{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int userChoice;
        Scanner input = new Scanner(System.in);
        
        //Creating the graph
        HouseGraph myHouse = new HouseGraph();
        Location found;
        found = myHouse.getHomeLocation();
        
        userChoice = -1;
        do
        {
            // display the current vertex
            System.out.println("\nYou are currently in room " + found.getDescription());

            // who are our neighbors?
            System.out.println("neighbors of " + found.getDescription() + " are:");
            
            Lister<Location> neighborsList = myHouse.neighbors(found);
            int n = 1;
            while (neighborsList.hasNext())
            {
                Location displayNeighbors = neighborsList.next();
                System.out.print(n + "-" + displayNeighbors.getDescription());
                if (neighborsList.hasNext())
                {
                    System.out.print( ", ");
                    n++;
                }
            }
            
            //Ask for user choice
            System.out.print("\n\nWhere would you like to go? (-1 to exit): ");
            userChoice = input.nextInt();

            // if their choice is -1 then exit
            if (userChoice == -1)
                System.out.println("\nGood bye!");
            else if (userChoice < 1 || userChoice > n)
                System.out.println("\noops!  not a neighbor");
            else
            {
                neighborsList = myHouse.neighbors(found);
                n = 1;
                while (neighborsList.hasNext())
                {
                    Location newLocation = neighborsList.next();
                    if (userChoice == n)
                      found = newLocation;
                    n++;
                }
            }

            
        } while (userChoice != -1);
    }
}
