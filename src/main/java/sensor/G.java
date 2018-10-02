
package sensor;

import edu.ucsc.cross.jheq.core.model.JumpMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.variable.RandomVariable;

public class G implements JumpMap<State, Input>
{

	@Override
	public void evaluateG(State x, State x_plus, Input u, Variables vars)
	{

		// get parameters
		CollectionParams parameters = vars.get(CollectionParams.class);
		x_plus.nextTransmission = tauReset(x, parameters);
		x_plus.storedData = x.create(u.getObject(), System.currentTimeMillis());
		SensorVal out = vars.get(SensorVal.class);
		out.load(x_plus.storedData.storedData);
	}

	/**
	 * Timer reset mapping
	 * 
	 * @param x
	 *            current state
	 * @param parameters
	 *            timer parameters
	 * @return timer value (updated if necesssary)
	 */
	public double tauReset(State x, CollectionParams parameters)
	{

		double resetValue = x.nextTransmission;

		resetValue = RandomVariable.generate(parameters.minSampleInterval, parameters.maxSampleInterval);

		return resetValue;
	}

}