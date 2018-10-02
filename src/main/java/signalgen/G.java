
package signalgen;

import edu.ucsc.cross.jheq.core.model.JumpMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.object.NoInput;

public class G implements JumpMap<State, NoInput>
{

	@Override
	public void evaluateG(State x, State x_plus, NoInput u, Variables vars)
	{
		x_plus = x;

	}

}