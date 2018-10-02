package sensor;

import dataobject.DataSource;
import dataobject.Metadata;
import edu.ucsc.cross.jheq.core.model.Signal;

public class SensorReading implements Metadata, Signal<Object>, DataSource
{

	public Object storedData;
	public String sensorId;
	public long readTime;

	public SensorReading()
	{
		storedData = new Object();
		readTime = System.currentTimeMillis();
	}

	@Override
	public String getCreatorId()
	{
		// TODO Auto-generated method stub
		return sensorId;
	}

	@Override
	public long getCreateDate()
	{
		// TODO Auto-generated method stub
		return readTime;
	}

	@Override
	public Object getValue()
	{
		// TODO Auto-generated method stub
		return storedData;
	}

	@Override
	public String getId()
	{
		// TODO Auto-generated method stub
		return sensorId;
	}

	@Override
	public Object content()
	{
		// TODO Auto-generated method stub
		return storedData;
	}

	@Override
	public Double created()
	{
		// TODO Auto-generated method stub
		return (double) readTime;
	}

}
