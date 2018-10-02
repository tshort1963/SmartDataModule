
package dataoutsys;

import dataout.DataSourceAccess;
import edu.ucsc.cross.jheq.core.model.FlowMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import inbuffer.DataStorage;

public class F implements FlowMap<DataSourceSet, DataStorage>
{

	@Override
	public void evaluateF(DataSourceSet x, DataSourceSet x_dot, DataStorage DataStorage, Variables vars)
	{
		for (DataSourceAccess val : x_dot.outputs)
		{
			val.age = 1.0;
		}

	}

}