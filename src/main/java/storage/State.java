
package storage;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class State extends DataStructure
{

	public StorageState state;

	public double dataSize;
	public double transferData;

	public State()
	{

		state = StorageState.IDLE;
		this.dataSize = 0;
		this.transferData = 0;
	}

}
