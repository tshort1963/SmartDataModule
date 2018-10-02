
package sensor;

import edu.ucsc.cross.jheq.core.model.JumpSet;
import edu.ucsc.cross.jheq.core.model.Variables;

public class D implements JumpSet<State, Input>
{

	@Override
	public boolean evaluateD(State x, Input u, Variables params)
	{

		boolean jump = false;

		if (x.nextTransmission <= 0.0)
		{
			jump = true;
		}

		return jump;
	}

}
