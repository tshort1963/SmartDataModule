
package storage;

import java.util.HashMap;

import edu.ucsc.cross.jheq.core.object.DataStructure;
import inbuffer.Buffer;

public class Input extends DataStructure
{

	HashMap<String, Buffer> input;

	/**
	 * @return the input
	 */
	public Object getObject()
	{
		return input;
	}

	public Input()
	{

		input = new HashMap<String, Buffer>();
	}

	/**
	 * @return the input
	 */
	public HashMap<String, Buffer> getInput()
	{
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(HashMap<String, Buffer> input)
	{
		this.input = input;
	}
}
