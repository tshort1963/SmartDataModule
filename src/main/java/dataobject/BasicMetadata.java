package dataobject;

public class BasicMetadata implements Metadata
{

	public String sensorId;
	public long readTime;

	public BasicMetadata()
	{
		sensorId = "generic";
		readTime = System.currentTimeMillis();
	}

	public BasicMetadata(String id)
	{
		sensorId = id;
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

}
