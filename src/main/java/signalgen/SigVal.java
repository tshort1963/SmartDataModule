package signalgen;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class SigVal extends DataStructure
{

	public double value;

	public SigVal()
	{
		value = 0.0;
		this.getProperties().setName("Signal");
		this.getProperties().setStoreTrajectory(false);

	}
}
