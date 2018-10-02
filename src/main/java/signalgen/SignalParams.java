
package signalgen;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class SignalParams extends DataStructure
{

	public double amplitude;

	public double period;

	public SignalType type;

	public SignalParams()
	{

		this.amplitude = .1;
		this.period = 1.0;
		type = SignalType.SIN;
	}

	public SignalParams(double min, double max, SignalType type)
	{

		this.amplitude = min;
		this.period = max;
		this.type = type;
	}
}
