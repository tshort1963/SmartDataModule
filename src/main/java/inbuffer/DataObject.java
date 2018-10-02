package inbuffer;

import com.be3short.obj.utilities.ObjectSizeCalculator;

public class DataObject
{

	public Object object;
	public double size;

	public DataObject()
	{
		object = null;
		size = 0.0;
	}

	public DataObject(Object obj)
	{
		object = obj;
		size = 0.0;
		try
		{
			size = ObjectSizeCalculator.sizeOf(obj);
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
