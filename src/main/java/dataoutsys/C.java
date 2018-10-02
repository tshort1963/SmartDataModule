
package dataoutsys;

import edu.ucsc.cross.jheq.core.model.FlowSet;
import edu.ucsc.cross.jheq.core.model.Variables;
import inbuffer.DataStorage;

public class C implements FlowSet<DataSourceSet, DataStorage>
{

	@Override
	public boolean evaluateC(DataSourceSet x, DataStorage input, Variables params)
	{

		boolean flow = true;
		return flow;
	}
}
