
package inbuffer;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class InBufParams extends DataStructure
{

	public double bufferCapacity;

	public InBufParams()
	{

		this.bufferCapacity = 100;

	}

	public InBufParams(double min, double max)
	{

		this.bufferCapacity = min;
	}
}
