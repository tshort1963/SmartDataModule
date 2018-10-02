
package storage;

import edu.ucsc.cross.jheq.core.model.FlowSet;
import edu.ucsc.cross.jheq.core.model.Variables;

public class C implements FlowSet<State, Input>
{

	@Override
	public boolean evaluateC(State x, Input input, Variables params)
	{

		boolean flow = false;
		if (x.transferData >= 0.0)
		{
			flow = true;
		}
		return flow;
	}
}
