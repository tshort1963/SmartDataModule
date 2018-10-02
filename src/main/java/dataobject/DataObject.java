package dataobject;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class DataObject<T> extends DataStructure implements Metadata
{

	T object;

	/**
	 * @return the object
	 */
	public T getObject()
	{
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(T object)
	{
		this.object = object;
	}

	Metadata meta;

	public DataObject(T obj, Metadata meta)
	{
		object = obj;
		this.meta = meta;

	}

	public DataObject(T obj, String creator)
	{
		object = obj;
		this.meta = new BasicMetadata(creator);
	}

	@Override
	public String getCreatorId()
	{
		// TODO Auto-generated method stub
		return meta.getCreatorId();
	}

	@Override
	public long getCreateDate()
	{
		// TODO Auto-generated method stub
		return meta.getCreateDate();
	}
}
