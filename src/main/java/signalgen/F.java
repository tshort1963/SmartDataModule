
package signalgen;

import edu.ucsc.cross.jheq.core.model.FlowMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.object.NoInput;

public class F implements FlowMap<State, NoInput>
{

	@Override
	public void evaluateF(State x, State x_dot, NoInput u, Variables vars)
	{
		SignalParams parameters = vars.get(SignalParams.class);
		x_dot.translate = parameters.period * (2 * Math.PI);
		x_dot.xVal = x.yVal;// * (2 * Math.PI);
		x_dot.yVal = -x.xVal;

	}
}