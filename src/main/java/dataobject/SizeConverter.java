package dataobject;

import com.be3short.obj.utilities.ObjectSizeCalculator;

public class SizeConverter
{

	public static double bytesToKb(Object obj)
	{
		double by = 0.0;
		try
		{
			by = ObjectSizeCalculator.sizeOf(obj);
			by = by / 10;
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return by;
	}
}
