
package sensor;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.InputMap;

public class InputLaw implements InputMap<Input>
{

	@Override
	public Input determineInput(HybridSystem<?, Input, ?> system)
	{

		HybridSystem states = system.getNetwork().getConnections(system, HybridSystem.class, true).get(0);
		Input input = new Input(states.getValue());
		return input;
	}

}
