
package dataoutsys;

import edu.ucsc.cross.jheq.core.model.JumpSet;
import edu.ucsc.cross.jheq.core.model.Variables;
import inbuffer.DataStorage;

public class D implements JumpSet<DataSourceSet, DataStorage>
{

	@Override
	public boolean evaluateD(DataSourceSet x, DataStorage u, Variables params)
	{

		boolean jump = false;
		// System.out.println(u.getStored().getLastUpdate());
		if (x.lastDataUpdate + params.get(DataOutParams.class).minCheckInterval < u.getStored().getLastUpdate()
		&& u.getStored().getStoredData().size() > 0)
		{
			// System.out.println(u.getStored().getLastUpdate());

			jump = true;
		}
		return jump;
	}

}
