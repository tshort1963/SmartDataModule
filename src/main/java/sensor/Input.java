
package sensor;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class Input extends DataStructure
{

	Object input;

	/**
	 * @return the input
	 */
	public Object getObject()
	{
		return input;
	}

	public Input()
	{

		input = null;
	}

	public Input(Object obj)
	{

		input = obj;
	}

}
