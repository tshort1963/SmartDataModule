package storage;

import dataobject.DataPartition;
import edu.ucsc.cross.jheq.core.object.DataStructure;

public class Queue extends DataStructure
{

	public DataPartition storedData;
	public QueueState state;
	public StorageState direction;

	public Queue()
	{
		state = QueueState.PENDING;
		direction = StorageState.READING;
		storedData = new DataPartition();
		this.getProperties().setStoreTrajectory(true);
	}

	public void loadQueue(DataPartition... partitions)
	{
		for (DataPartition partition : partitions)
		{
			this.storedData.add(partition);
		}
	}

	/**
	 * @return the storedData
	 */
	public DataPartition getStoredData()
	{
		return storedData;
	}

	/**
	 * @param storedData
	 *            the storedData to set
	 */
	public void setStoredData(DataPartition storedData)
	{
		this.storedData = storedData;
	}

	/**
	 * @return the state
	 */
	public QueueState getState()
	{
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(QueueState state)
	{
		this.state = state;
	}

	/**
	 * @return the direction
	 */
	public StorageState getDirection()
	{
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(StorageState direction)
	{
		this.direction = direction;
	}

}
