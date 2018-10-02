package storage;

import dataobject.DataPartition;
import edu.ucsc.cross.jheq.core.object.DataStructure;
import inbuffer.DataStorage;

public class Storage extends DataStructure implements DataStorage
{

	private DataPartition storedData;

	public Storage()
	{

		this.setStoredData(new DataPartition());
		this.getProperties().setStoreTrajectory(true);

	}

	public DataPartition getStoredData()
	{
		return storedData;
	}

	public void setStoredData(DataPartition storedData)
	{
		this.storedData = storedData;
	}

	@Override
	public DataPartition getStored()
	{
		storedData.refreshUpdate();
		return getStoredData();
	}

}
