
package inbuffer;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.OutputMap;

public class OutputLaw implements OutputMap<State, Input, Buffer>
{

	@Override
	public Buffer determineOutput(HybridSystem<State, Input, Buffer> system)
	{

		return system.getState();
	}

}
