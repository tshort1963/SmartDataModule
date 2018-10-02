
package dataoutsys;

import edu.ucsc.cross.jheq.core.model.HybridSystem;
import edu.ucsc.cross.jheq.core.model.InputMap;
import inbuffer.DataStorage;

public class InputLaw implements InputMap<DataStorage>
{

	@Override
	public DataStorage determineInput(HybridSystem<?, DataStorage, ?> system)
	{
		DataStorage st = null;
		for (DataStorage sig : system.getNetworkInputs(DataStorage.class))
		{

			st = sig;

		}
		return st;
	}

}
