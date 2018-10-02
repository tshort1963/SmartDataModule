
package signalgen;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class State extends DataStructure
{

	public double translate;
	public double xVal;
	public double yVal;

	public State()
	{
		translate = 0.0;
		xVal = 0.0;
		yVal = 1.0;
		this.getProperties().setStoreTrajectory(true);
	}

	public State(Double x, Double y, Double trans)
	{
		translate = trans;
		this.xVal = x;
		this.yVal = y;
		this.getProperties().setStoreTrajectory(true);
	}

}
