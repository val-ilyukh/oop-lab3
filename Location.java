/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    public boolean equals(Location a) {
    	if (this.xCoord == a.xCoord && this.yCoord == a.yCoord) {
    		return true;
    	}
    	else return false;
    }
    public int hashCode() {
    	int res;
    	int i = 1;
    	while (i < yCoord) {
    		i *= 10;
    	}
    	res = (xCoord + 1) * i *10 + (yCoord + 1);
    	
    	return res;
    }
}