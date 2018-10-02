
package storage;

import control.ScheduleControl;
import edu.ucsc.cross.jheq.core.model.JumpMap;
import edu.ucsc.cross.jheq.core.model.Variables;

public class G implements JumpMap<State, Input> {

	public Storage storage(Variables var) {

		return var.get(Storage.class);
	}

	public ScheduleControl scheduler(Variables var) {

		return var.get(ScheduleControl.class);
	}

	@Override
	public void evaluateG(State x, State x_plus, Input u, Variables vars) {

		Queue q = scheduler(vars).uD(x, u, vars);
		// System.out.println("here" + XMLParser.serializeObject(q));

		if (q != null) {
			switch (q.getState()) {
			case PENDING: {
				if (x.transferData <= 0.0) {
					x_plus.transferData = q.getStoredData().getSizeInBytes();
					q.setState(QueueState.IN_PROGRESS);
				}
				break;
			}
			case FINISHED: {
				x_plus.dataSize = storage(vars).getStoredData().getSizeInBytes();
				x_plus.transferData = -1.0;
				q.setState(QueueState.PROCESSED);
			}
			case IN_PROGRESS:
				break;
			case PROCESSED:
				break;
			default:
				break;
			}
		}

	}

}