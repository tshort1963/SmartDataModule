
package sensor;

import edu.ucsc.cross.jheq.core.object.DataStructure;
import inbuffer.DataObject;

public class State extends DataStructure
{

	public SensorReading storedData;

	public double nextTransmission;

	public State()
	{

		this.storedData = new SensorReading();
		this.nextTransmission = 0;
	}

	public State(DataObject tau_0, double timer_0)
	{
		this.storedData = new SensorReading();

		this.storedData.storedData = tau_0;
		this.nextTransmission = timer_0;
	}

	public SensorReading create(Object obj, long time)
	{
		SensorReading sr = new SensorReading();
		sr.readTime = time;
		sr.storedData = obj;
		sr.sensorId = this.toString();
		return sr;
	}

}
