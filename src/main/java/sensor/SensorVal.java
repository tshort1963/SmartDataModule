
package sensor;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class SensorVal extends DataStructure
{

	public double DataSensorReading;

	public SensorVal()
	{

		DataSensorReading = 0.0;
		this.getProperties().setStoreTrajectory(true);
		this.getProperties().setSimulated(false);
		this.getProperties().setName("SensorRead");

	}

	public void load(Object obj)
	{
		try
		{
			double val = (double) obj;
			this.DataSensorReading = val;
		} catch (Exception notDouble)
		{

		}
	}

}
