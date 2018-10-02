
package storage;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.OutputMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import inbuffer.DataStorage;

public class OutputLaw implements OutputMap<State, Input, DataStorage>
{

	public static Storage storage(Variables var)
	{
		return var.get(Storage.class);
	}

	@Override
	public DataStorage determineOutput(HybridSystem<State, Input, DataStorage> system)
	{
		// if (system.getState().getStored().getStoredData().size() > 0)
		// {
		return storage(system.getVariables());

		// } else
		// {
		// return null;
		// }
	}

}
