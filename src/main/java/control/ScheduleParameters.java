package control;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class ScheduleParameters extends DataStructure
{

	public double minSizeToTransfer;

	public ScheduleParameters()
	{
		this.minSizeToTransfer = 0.0;
	}
}
