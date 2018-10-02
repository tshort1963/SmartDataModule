
package inbuffer;

import java.util.ArrayList;
import java.util.HashMap;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class Output extends DataStructure
{

	HashMap<String, ArrayList<Object>> toWrite;

	public Output()
	{

		toWrite = new HashMap<String, ArrayList<Object>>();
	}

	/**
	 * @return the toWrite
	 */

	public HashMap<String, ArrayList<Object>> getToWrite()
	{
		return toWrite;
	}

	/**
	 * @param toWrite
	 *            the toWrite to set
	 */
	public void setToWrite(HashMap<String, ArrayList<Object>> toWrite)
	{
		this.toWrite = toWrite;
	}
}