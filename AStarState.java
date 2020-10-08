import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }
    public HashMap<Integer, Waypoint> openWaypoints = new HashMap<>();
    public HashMap<Integer, Waypoint> closedWaypoints = new HashMap<>();
    
    
    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        float min = 1000000;
        int currentkey = 0;
        for (int key: openWaypoints.keySet()) {
        	if (openWaypoints.get(key).getPreviousCost() < min) {
        		min = openWaypoints.get(key).getPreviousCost();
        		currentkey = key;
        		
        	}
        }
        if (currentkey == 0) {
        	return null;
        }
        else return openWaypoints.get(currentkey);
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
//    	Boolean currflag = false;
    	int currloc = newWP.loc.hashCode();
    	for (int key: openWaypoints.keySet()) {
        	if (key == currloc) {
//        		currflag = true;
        		if (Float.compare(newWP.getPreviousCost(), openWaypoints.get(key).getPreviousCost()) < 0 ) {
        			openWaypoints.put(currloc, newWP);
        			return true;
        		}
        		else return false;
        	}
        }
    	openWaypoints.put(currloc, newWP);
		return true;        
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
    	return openWaypoints.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
    	Waypoint currwp = openWaypoints.get(loc.hashCode());
    	openWaypoints.remove(loc.hashCode());
    	closedWaypoints.put(loc.hashCode(), currwp);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
    	for (int key: closedWaypoints.keySet()) {
        	if (key == loc.hashCode()) {
        		return true;
        	}
        }
        return false;
    }
}
