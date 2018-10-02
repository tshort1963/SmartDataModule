
package inbuffer;

import java.util.HashMap;

import dataobject.DataPartition;
import edu.ucsc.cross.jheq.core.object.DataStructure;

public class Input extends DataStructure
{

	HashMap<String, Object> input;
	DataPartition delete;

	/**
	 * @return the input
	 */
	public Object getObject()
	{
		return input;
	}

	public Input()
	{

		input = new HashMap<String, Object>();
		delete = new DataPartition();
	}

	public Input(HashMap<String, Object> objs)
	{

		input = objs;
	}

	/**
	 * @return the input
	 */
	public HashMap<String, Object> getInput()
	{
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(HashMap<String, Object> input)
	{
		this.input = input;
	}

}
