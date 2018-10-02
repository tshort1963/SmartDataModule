
package storage;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class StorageParams extends DataStructure
{

	public double writeSpeed;

	public double minTransferSize;

	public StorageParams()
	{
		this.minTransferSize = 5;
		this.writeSpeed = 100;

	}

	public StorageParams(double min, double max)
	{

		this.writeSpeed = min;
	}
}
