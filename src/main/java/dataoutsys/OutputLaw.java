
package dataoutsys;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.OutputMap;
import inbuffer.DataStorage;

public class OutputLaw implements OutputMap<DataSourceSet, DataStorage, DataSourceSet>
{

	@Override
	public DataSourceSet determineOutput(HybridSystem<DataSourceSet, DataStorage, DataSourceSet> system)
	{
		return system.getState();
	}

}
