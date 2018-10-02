
package signalgen;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class Output extends DataStructure
{

	double value;

	public Output()
	{

		value = 0.0;
	}

	public Output(double value)
	{

		this.value = value;
	}

	/**
	 * @return the value
	 */
	public double getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value)
	{
		this.value = value;
	}

}
