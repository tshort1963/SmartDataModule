
package signalgen;

import edu.ucsc.cross.jheq.core.model.JumpSet;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.object.NoInput;

public class D implements JumpSet<State, NoInput>
{

	@Override
	public boolean evaluateD(State x, NoInput u, Variables params)
	{

		boolean jump = false;

		return jump;
	}

}
