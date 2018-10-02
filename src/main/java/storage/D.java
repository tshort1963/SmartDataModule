
package storage;

import control.ScheduleControl;
import edu.ucsc.cross.jheq.core.model.JumpSet;
import edu.ucsc.cross.jheq.core.model.Variables;

public class D implements JumpSet<State, Input>
{

	public Storage storage(Variables var)
	{
		return var.get(Storage.class);
	}

	public ScheduleControl scheduler(Variables var)
	{
		return var.get(ScheduleControl.class);
	}

	@Override
	public boolean evaluateD(State x, Input u, Variables var)
	{
		Queue q = scheduler(var).uD(x, u, var);
		if (q != null)
		{
			switch (q.getState())
			{
			case PENDING:
			{
				if (x.transferData <= 0.0)
				{
					return true;
				}
				break;
			}
			case FINISHED:
			{
				if (x.transferData > -1.0)
				{
					return true;
				}
				break;
			}
			case IN_PROGRESS:
				break;
			case PROCESSED:
				break;
			default:
				break;
			}
		}
		return false;
	}

}
