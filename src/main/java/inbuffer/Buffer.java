package inbuffer;

import dataobject.DataPartition;

public interface Buffer
{

	public DataPartition getContents();

	public double getCapacity();
}
