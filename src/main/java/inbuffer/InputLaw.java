
package inbuffer;

import java.util.HashMap;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.InputMap;
import sensor.SensorReading;

public class InputLaw implements InputMap<Input>
{

	@Override
	public Input determineInput(HybridSystem<?, Input, ?> system)
	{
		Input input = new Input();
		HashMap<String, Object> states = new HashMap<String, Object>();
		Object ignore = "";
		for (DataStorage sig : system.getNetworkInputs(DataStorage.class))
		{

			input.delete = sig.getStored();
			ignore = sig;
			break;

		}
		for (SensorReading sig : system.getNetworkInputs(SensorReading.class))
		{
			if (!sig.equals(ignore))
			{

				states.put(sig.toString(), sig);
			}
		}
		input.setInput(states);
		return input;
	}

}
