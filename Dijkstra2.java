import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;  //edge class for distance+weight
    public double minDistance = Double.POSITIVE_INFINITY;         //at the beginning initialized to infinity
    public Vertex previous;
    public Vertex(String argName) { name = argName; }           //constructor declaration
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);  //fn to compare distance
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }              //constructor
}

/********Class declaration to compute shortest paths with source initialized to zero******
*******Then its neighbours are polled if queue is not empty and replaced recursively****
******if the destined value is less than source value*******************************/
public class Dijkstra2
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;   //source distance set to zero

	
      // create priority queue
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();

    // insert values in the queue
    vertexQueue.add(source);         //initially the source with 0(minimum) is added to queue

/******enter the queue and poll through all values********/
/******if queue is not empty******************************/
    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;          //final destination to be reached
                double weight = e.weight;     //weight of the edge
                double distanceThroughU = u.minDistance + weight; // distance of source + its weight
        if (distanceThroughU < v.minDistance) { 
            vertexQueue.remove(v);

/*******If source distance weight< adjacent destination******/
/*******replace its value with source weighted value*********/
            v.minDistance = distanceThroughU ;
            v.previous = u;                  //mark its parent
            vertexQueue.add(v);              //add the next least neighbour value to queue
        }
            }
        }
    }

/*********Simple ArrayList to store the names of cities in the shortest path from*****
********source to destination********************************************/
    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
 
//as queue is first in first out the source city will be removed first so collections.reverse is called
 //to display in the order from source to destination//
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        Vertex Charlotte = new Vertex("Charlotte");
        Vertex Asheville = new Vertex("Asheville");
        Vertex Willmington = new Vertex("Willmington");
        Vertex Atlanta = new Vertex("Atlanta");
        Vertex Columbia = new Vertex("Columbia");
        Vertex Knoxville = new Vertex("Knoxville");
        Vertex Chattanooga = new Vertex("Chattanooga");
        Vertex Florence = new Vertex("Florence");
        Vertex Augusta = new Vertex("Augusta");
        Vertex Charleston = new Vertex("Charleston");
        Vertex Savannah = new Vertex("Savannah");
        Vertex Raleigh = new Vertex("Raleigh");
        Vertex Unknown = new Vertex("Unknown");
        Vertex Birmingham = new Vertex("Birmingham");
        Vertex Montgomery = new Vertex("Montgomery");
        Vertex Tifton = new Vertex("Tifton");
        Vertex Mobile = new Vertex("Mobile");
	Vertex Tallahassee = new Vertex("Tallahassee");
	Vertex Jacksonville = new Vertex("Jacksonville");
	Vertex DaytonaBeach = new Vertex("DaytonaBeach");
	Vertex JctIntUS = new Vertex("JctIntUS");
	Vertex Orlando = new Vertex("Orlando");
	Vertex Tampa = new Vertex("Tampa");
	Vertex Cocoa = new Vertex("Cocoa");
	Vertex VeroBeach = new Vertex("VeroBeach");
	Vertex FtMyersa = new Vertex("FtMyersa");
	Vertex Miami = new Vertex("Miami");
	Vertex KeyWest = new Vertex("KeyWest");

        // set the edges and weight
        Charlotte.adjacencies = new Edge[]
        {
        	 new Edge(Asheville, 112),
        	 new Edge(Willmington, 203), 
        	 new Edge(Atlanta, 240),
        	 new Edge(Columbia, 94) 
        };

		Asheville.adjacencies = new Edge[]
		{ 
			new Edge(Charlotte, 112),
			new Edge(Chattanooga, 195),
			new Edge(Atlanta, 205),
			new Edge(Augusta, 172),
			new Edge(Columbia, 159)
		};

		Willmington.adjacencies = new Edge[]
		{
			new Edge(Charlotte, 203),
			new Edge(Florence, 119),
			new Edge(Charleston, 167),
			new Edge(Raleigh, 124)
		};
		
		Atlanta.adjacencies = new Edge[]
		{ 
			new Edge(Charlotte, 240),
			new Edge(Asheville, 205),
			new Edge(Chattanooga, 113),
			new Edge(Birmingham, 150),
			new Edge(Montgomery, 168),
			new Edge(Tifton, 182),
	 		new Edge(Savannah, 255),
			new Edge(Augusta, 150),
			new Edge(Columbia, 214),
			new Edge(Knoxville, 224)
		};

		Columbia.adjacencies = new Edge[]
		{ 
			new Edge(Charlotte, 94),
			new Edge(Asheville, 159),
			new Edge(Atlanta, 214), 
			new Edge(Augusta, 69),
			new Edge(Savannah, 158),
			new Edge(Charleston, 113),
			new Edge(Florence, 80),
			new Edge(Raleigh, 205)
		};

		Knoxville.adjacencies = new Edge[]
		{ 
			new Edge(Atlanta, 224),
			new Edge(Unknown, 178),
			new Edge(Chattanooga, 111)
		};

		Unknown.adjacencies = new Edge[]
		{ 
			new Edge(Knoxville, 178),
			new Edge(Chattanooga, 129),
			new Edge(Birmingham, 194)
		};

		Chattanooga.adjacencies = new Edge[]
		{ 
			new Edge(Asheville, 195),
			new Edge(Atlanta, 113),
			new Edge(Knoxville, 111),
			new Edge(Unknown, 129),
			new Edge(Birmingham, 145)
		};

		Florence.adjacencies = new Edge[]
		{ 
			new Edge(Willmington, 119),
			new Edge(Columbia, 80),
			new Edge(Raleigh, 147),
			new Edge(Savannah, 172)
		};
	
		Augusta.adjacencies = new Edge[]
		{
			new Edge(Asheville, 172),
			new Edge(Atlanta, 150),
			new Edge(Columbia, 69),
			new Edge(Tifton, 222),
			new Edge(Jacksonville, 260),
			new Edge(Savannah, 124),
			new Edge(Charleston, 139)
		};

		Charleston.adjacencies = new Edge[]
		{ 
			new Edge(Willmington, 167),
			new Edge(Columbia, 113),
			new Edge(Augusta, 139),
			new Edge(Savannah, 106)
		};

		Raleigh.adjacencies = new Edge[]
		{
			new Edge(Willmington, 124),
			new Edge(Columbia, 205),
			new Edge(Florence, 147)
		};

		Savannah.adjacencies = new Edge[]
		{
			new Edge(Atlanta, 255), 
			new Edge(Columbia, 158),
			new Edge(Florence, 172),
			new Edge(Augusta, 124),
			new Edge(Charleston, 106),
			new Edge(Montgomery, 354),
			new Edge(Tallahassee, 244),
			new Edge(Jacksonville, 136)
		};

		Birmingham.adjacencies = new Edge[]
		{ 
			new Edge(Atlanta, 150),
			new Edge(Chattanooga, 145),
			new Edge(Unknown, 194),
			new Edge(Mobile, 240),
			new Edge(Montgomery, 91),
        	new Edge(Tifton, 286)
        	};

		Montgomery.adjacencies = new Edge[]
		{
			new Edge(Atlanta, 168), 
			new Edge(Savannah, 354),
			new Edge(Birmingham, 91),
			new Edge(Mobile, 172),
	 		new Edge(Tallahassee, 202),
			new Edge(Tifton, 200)
		};

		Tifton.adjacencies = new Edge[]
		{ 
			new Edge(Atlanta, 182),
			new Edge(Augusta, 222),
			new Edge(Birmingham, 286),
			new Edge(Montgomery, 200),
			new Edge(Tallahassee, 89),
			new Edge(JctIntUS, 185),
			new Edge(Jacksonville, 149)
		};

		Mobile.adjacencies = new Edge[]
		{
			new Edge(Birmingham, 240),
			new Edge(Montgomery, 172),
			new Edge(Tallahassee, 244)
		};
	
		Tallahassee.adjacencies = new Edge[]
		{ 
			new Edge(Savannah, 244),
			new Edge(Montgomery, 202),
			new Edge(Tifton, 89),
			new Edge(Mobile, 244),
			new Edge(Jacksonville, 166),
			new Edge(JctIntUS, 170),
			new Edge(Tampa, 244)
		};
	
		Jacksonville.adjacencies = new Edge[]
		{ 
			new Edge(Augusta, 260),
			new Edge(Savannah, 136),
			new Edge(Tifton, 149),
			new Edge(Tallahassee, 166),
			new Edge(JctIntUS, 105),
			new Edge(DaytonaBeach, 91)
		};
	
		DaytonaBeach.adjacencies = new Edge[]
		{
			new Edge(Jacksonville, 91), 
			new Edge(Cocoa, 66),
			new Edge(Orlando, 54)
		};

		JctIntUS.adjacencies = new Edge[]
		{ 
			new Edge(Tifton, 185),
			new Edge(Tallahassee, 170),
			new Edge(Jacksonville, 105),
			new Edge(Tampa, 94),
			new Edge(Miami, 302),
			new Edge(Orlando, 75)
		};

		Orlando.adjacencies = new Edge[]
		{ 
			new Edge(DaytonaBeach, 54),
			new Edge(JctIntUS, 75),
			new Edge(Tampa, 82),
			new Edge(Cocoa, 44)
		};
		
		Tampa.adjacencies = new Edge[]
		{ 
			new Edge(Tallahassee, 244),
			new Edge(JctIntUS, 94),
			new Edge(Orlando, 82),
			new Edge(VeroBeach, 137),
			new Edge(FtMyersa, 125)
		};

		Cocoa.adjacencies = new Edge[]
		{ 
			new Edge(DaytonaBeach, 66),
			new Edge(Orlando, 44),
			new Edge(VeroBeach, 55)
		};
	
		VeroBeach.adjacencies = new Edge[]
		{ 
			new Edge(Miami, 140),
			new Edge(Tampa, 137),
			new Edge(Cocoa, 55)
		};
	
		FtMyersa.adjacencies = new Edge[]
		{ 
			new Edge(Tampa, 125),
			new Edge(Miami, 143)
		};

		Miami.adjacencies = new Edge[]
		{ 
			new Edge(JctIntUS, 302),
			new Edge(VeroBeach, 140),
			new Edge(FtMyersa, 143),
			new Edge(KeyWest, 151)
		};

		KeyWest.adjacencies = new Edge[]
		{
			new Edge(Miami, 151)
		};
      
	
	Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between 1 to 5" + '\n' +"1" +'\t' +"Charlotte to all cities" +'\n' +"2"+'\t' +"Jacksonville to all cities and so on..");
	int city = sc.nextInt(); 
	/*Distance from CHARLOTTE to all 5 cities*/
	switch(city)

	{
	case 1:
	computePaths(Charlotte); // run Dijkstra
        System.out.println("Distance to " + Jacksonville + " from " + Charlotte + " : " + Jacksonville.minDistance);
        List<Vertex> patha = getShortestPathTo(Jacksonville);
        System.out.println("Path: " + patha + '\n' + '\n');
	
	computePaths(Charlotte); // run Dijkstra
        System.out.println("Distance to " + Tallahassee + " from " + Charlotte + ": " + Tallahassee.minDistance);
        List<Vertex> pathb = getShortestPathTo(Tallahassee);
        System.out.println("Path:" + pathb + '\n' + '\n');

        computePaths(Charlotte); // run Dijkstra
        System.out.println("Distance to " + Orlando + " from " + Charlotte + ": " + Orlando.minDistance);
        List<Vertex> pathc = getShortestPathTo(Orlando);
        System.out.println("Path: " + pathc + '\n' + '\n');

        computePaths(Charlotte); // run Dijkstra
        System.out.println("Distance to " + Tampa + " from " + Charlotte + ": " + Tampa.minDistance);
        List<Vertex> pathd = getShortestPathTo(Tampa);
        System.out.println("Path: " + pathd + '\n' + '\n');

        computePaths(Charlotte); // run Dijkstra
        System.out.println("Distance to " + Miami + " from " + Charlotte + ": " + Miami.minDistance);
        List<Vertex> pathe = getShortestPathTo(Miami);
        System.out.println("Path: " + pathe + '\n' + '\n');
	break;

	/*Distance from JACKSONVILLE to remaining 4 cities*/
	case 2:
	computePaths(Jacksonville); // run Dijkstra
        System.out.println("Distance to " + Tallahassee + " from " + Jacksonville + ": " + Tallahassee.minDistance);
        List<Vertex> pathf = getShortestPathTo(Tallahassee);
        System.out.println("Path:" + pathf + '\n' + '\n');
	
	computePaths(Jacksonville); // run Dijkstra
        System.out.println("Distance to " + Orlando + " from " + Jacksonville + ": " + Orlando.minDistance);
        List<Vertex> pathg = getShortestPathTo(Orlando);
        System.out.println("Path: " + pathg + '\n' + '\n');
	
	computePaths(Jacksonville); // run Dijkstra
        System.out.println("Distance to " + Tampa + " from " + Jacksonville + ": " + Tampa.minDistance);
        List<Vertex> pathh = getShortestPathTo(Tampa);
        System.out.println("Path: " + pathh + '\n' + '\n');
		
	computePaths( Jacksonville); // run Dijkstra
        System.out.println("Distance to " + Miami + " from " + Jacksonville + ": " + Miami.minDistance);
        List<Vertex> pathi = getShortestPathTo(Miami);
        System.out.println("Path: " + pathi + '\n' + '\n');
	break;

	/*Distance from TALLAHASSEE to remaining 3 cities*/
	case 3:
      	computePaths(Tallahassee); // run Dijkstra
        System.out.println("Distance to " + Orlando + " from " + Tallahassee + ": " + Orlando.minDistance);
        List<Vertex> pathj = getShortestPathTo(Orlando);
        System.out.println("Path: " + pathj + '\n' + '\n');
	
	computePaths(Tallahassee); // run Dijkstra
        System.out.println("Distance to " + Tampa + " from " + Tallahassee + ": " + Tampa.minDistance);
        List<Vertex> pathk = getShortestPathTo(Tampa);
        System.out.println("Path: " + pathk + '\n' + '\n');
		
	computePaths(Tallahassee); // run Dijkstra
        System.out.println("Distance to " + Miami + " from " + Tallahassee + ": " + Miami.minDistance);
        List<Vertex> pathl = getShortestPathTo(Miami);
        System.out.println("Path: " + pathl + '\n' + '\n');
	break;
	/*Distance from ORLANDO to remaining 2 cities*/

	case 4:
	computePaths(Orlando); // run Dijkstra
        System.out.println("Distance to " + Tampa + " from " + Orlando  + ": " + Tampa.minDistance);
        List<Vertex> pathm = getShortestPathTo(Tampa);
        System.out.println("Path: " + pathm + '\n' + '\n');
		
	computePaths(Orlando); // run Dijkstra
        System.out.println("Distance to " + Miami + " from " + Orlando + ": " + Miami.minDistance);
        List<Vertex> pathn = getShortestPathTo(Miami);
        System.out.println("Path: " + pathn + '\n' + '\n');
	break;

	/*Distance from TAMPA to remaining 1 city*/
	case 5:
	computePaths(Tampa); // run Dijkstra
        System.out.println("Distance to " + Miami + " from " + Tampa + ": " + Miami.minDistance);
        List<Vertex> patho = getShortestPathTo(Miami);
        System.out.println("Path: " + patho);
	break;

	default:
	System.out.println("Please enter valid case number between 1 to 5");
	break;
	}
}
}

