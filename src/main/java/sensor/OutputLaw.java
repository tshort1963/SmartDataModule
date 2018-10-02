
package sensor;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.OutputMap;

public class OutputLaw implements OutputMap<State, Input, SensorReading>
{

	@Override
	public SensorReading determineOutput(HybridSystem<State, Input, SensorReading> system)
	{
		if (system.getState().storedData != null)
		{
			if (system.getState().storedData.sensorId != system.toString())
			{
				system.getState().storedData.sensorId = system.toString();
			}
		}
		return system.getState().storedData;
	}

}
