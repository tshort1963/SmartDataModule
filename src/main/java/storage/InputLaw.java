
package storage;

import java.util.HashMap;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.InputMap;
import inbuffer.Buffer;

public class InputLaw implements InputMap<Input>
{

	@Override
	public Input determineInput(HybridSystem<?, Input, ?> system)
	{
		Input input = new Input();
		HashMap<String, Buffer> states = new HashMap<String, Buffer>();

		for (Buffer sig : system.getNetworkInputs(Buffer.class))
		{
			states.put(sig.toString(), sig);

		}
		input.setInput(states);
		return input;
	}

}
