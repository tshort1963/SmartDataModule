package dataobject;

import java.util.HashMap;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class DataPartition extends DataStructure
{

	private HashMap<String, DataObject<?>> storedData;
	private double lastUpdate;

	public DataPartition()
	{
		lastUpdate = (0.0);
		storedData = new HashMap<String, DataObject<?>>();
	}

	public HashMap<String, DataObject<?>> getStoredData()
	{
		return storedData;
	}

	public void setStoredData(HashMap<String, DataObject<?>> storedData)
	{
		this.storedData = storedData;
	}

	public boolean containsPath(String path)
	{
		return storedData.containsKey(path);
	}

	public boolean remove(String path)
	{
		boolean removed = false;
		if (containsPath(path))
		{
			storedData.remove(path);
			removed = true;
		}
		refreshUpdate();
		return removed;
	}

	public boolean add(DataPartition p)
	{
		boolean added = true;
		for (String key : p.storedData.keySet())
		{
			DataObject<?> data = p.get(key);
			storedData.put(key, data);
		}
		refreshUpdate();
		return added;
	}

	public boolean add(String path, Object obj, String creator)
	{
		DataObject<Object> data = null;
		boolean added = false;
		try
		{
			Metadata md = (Metadata) obj;
			data = new DataObject<Object>(obj, md);
		} catch (Exception e)
		{
			data = new DataObject<Object>(obj, creator);

		}
		storedData.put(path, data);
		added = true;
		refreshUpdate();
		return added;
	}

	public boolean add(String path, DataObject<?> obj)
	{
		boolean added = false;

		storedData.put(path, obj);
		added = true;
		refreshUpdate();
		return added;
	}

	public DataObject<?> get(String path)
	{
		DataObject<?> obj = null;
		if (containsPath(path))
		{
			obj = storedData.get(path);
		}
		refreshUpdate();
		return obj;
	}

	public <T> void refreshUpdate()
	{
		lastUpdate = System.currentTimeMillis();
	}

	// public static void main(String args[])
	// {
	// DataPartition h = new DataPartition();
	// h.refreshUpdate();
	// System.out.println(h.lastUpdate);
	// }

	public double getSizeInBytes()
	{
		double size = 0.0;

		size += SizeConverter.bytesToKb(storedData);

		return size;
	}

	public double getLastUpdate()
	{
		return lastUpdate;
	}

}
