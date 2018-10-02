
package signalgen;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.OutputMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.object.NoInput;

public class OutputLaw implements OutputMap<State, NoInput, Double>
{

	@Override
	public Double determineOutput(HybridSystem<State, NoInput, Double> system)
	{
		SignalParams parameters = (new Variables(system.getParameters().toArray())).get(SignalParams.class);
		double value = 0.0;
		State state = system.getState();
		switch (parameters.type)
		{
		case SIN:
		{
			value = parameters.amplitude * Math.sin(Math.atan2(state.yVal, state.xVal));
			break;
		}
		case COS:
		{
			value = parameters.amplitude * Math.cos((state.xVal / parameters.period) * Math.PI * 2);
			break;
		}
		default:
		{
			value = parameters.amplitude;
		}
		}

		return value;
	}

}
