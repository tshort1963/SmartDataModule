
package inbuffer;

import dataobject.DataPartition;
import edu.ucsc.cross.jheq.core.object.DataStructure;

public class State extends DataStructure implements Buffer
{

	public DataPartition storedData;

	public double dataSize;
	public double sensorReading;

	public State()
	{
		this.storedData = new DataPartition();
		this.dataSize = 0;
		this.sensorReading = 0.0;
	}

	@Override
	public DataPartition getContents()
	{
		// TODO Auto-generated method stub
		return storedData;
	}

	@Override
	public double getCapacity()
	{
		double cap = storedData.getStoredData().keySet().size();

		return cap;
	}

}
