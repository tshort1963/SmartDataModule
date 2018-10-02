
package signalgen;

import edu.ucsc.cross.jheq.core.model.FlowSet;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.object.NoInput;

public class C implements FlowSet<State, NoInput>
{

	@Override
	public boolean evaluateC(State x, NoInput input, Variables params)
	{

		boolean flow = true;
		return flow;
	}
}
