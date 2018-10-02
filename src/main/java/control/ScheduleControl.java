package control;

import edu.ucsc.cross.jheq.core.control.HybridController;
import edu.ucsc.cross.jheq.core.model.Variables;
import edu.ucsc.cross.jheq.core.object.DataStructure;
import inbuffer.Buffer;
import storage.Input;
import storage.Queue;
import storage.QueueState;
import storage.State;
import storage.Storage;

public class ScheduleControl extends DataStructure implements HybridController<State, Input, Queue>
{

	public Queue currentQueue;

	public ScheduleControl()
	{
		this.getProperties().setStoreTrajectory(true);
	}

	public static double pendingData(Input u)
	{
		double size = 0.0;
		for (Buffer buf : u.getInput().values())
		{
			try
			{
				size += buf.getContents().getSizeInBytes();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return size;
	}

	@Override
	public Queue uC(State x, Input arg1, Variables arg2)
	{
		// TODO Auto-generated method stub
		return currentQueue;
	}

	@Override
	public Queue uD(State x, Input u, Variables v)
	{
		boolean resolved = false;
		resolved = evaluateNewQueue(x, u, v);
		if (!resolved)
		{
			evaluateCurrentQueue(x, u, v);
		}
		return currentQueue;
	}

	public boolean evaluateNewQueue(State x, Input u, Variables arg2)
	{
		boolean resolved = false;
		if (currentQueue == null)
		{

			if (pendingData(u) >= params(arg2).minSizeToTransfer)
			{
				Queue currentQueue = new Queue();
				for (Buffer buf : u.getInput().values())
				{
					currentQueue.loadQueue(buf.getContents());
				}
				if (currentQueue.storedData.getStoredData().size() <= 0.0)
				{
					currentQueue = null;
				} else
				{
					this.currentQueue = currentQueue;
				}
				resolved = true;
			}

		}
		return resolved;
	}

	public void evaluateCurrentQueue(State x, Input u, Variables arg2)
	{
		if (currentQueue != null)
		{
			if (x.transferData <= 0.0)
			{
				if (currentQueue.getState().equals(QueueState.IN_PROGRESS))
				{
					completeTransfer(x, u, arg2);
				} else if (currentQueue.getState().equals(QueueState.PROCESSED))
				{
					currentQueue = null;
				}
			}

		}
	}

	public void completeTransfer(State x, Input u, Variables arg2)
	{
		switch (currentQueue.getDirection())
		{
		case READING:
		{
			storage(arg2).getStoredData().add(currentQueue.getStoredData());
			currentQueue.setState(QueueState.FINISHED);
		}
		}
	}

	public Storage storage(Variables var)
	{
		return var.get(Storage.class);
	}

	public ScheduleParameters params(Variables var)
	{
		return var.get(ScheduleParameters.class);
	}
}
