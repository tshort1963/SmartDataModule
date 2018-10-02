package dataobject;

public class DataPath
{

	public String path;

	public DataPath(String path)
	{
		this.path = path;
	}

	public DataPath(DataObject<?> path)
	{
		this.path = path.toString();
	}
}
