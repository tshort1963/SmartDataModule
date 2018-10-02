
package inbuffer;

import dataobject.SizeConverter;
import edu.ucsc.cross.jheq.core.model.JumpMap;
import edu.ucsc.cross.jheq.core.model.Variables;

public class G implements JumpMap<State, Input>
{

	@Override
	public void evaluateG(State x, State x_plus, Input u, Variables vars)
	{

		// get parameters
		InBufParams parameters = vars.get(InBufParams.class);

		addData(x, x_plus, u, parameters);
		for (String objSig : u.delete.getStoredData().keySet())
		{
			if (x.storedData.containsPath(objSig))
			{
				x.storedData.remove(objSig);
			}

		}

		x_plus.dataSize = SizeConverter.bytesToKb(x.storedData);

	}

	/**
	 * Timer reset mapping
	 * 
	 * @param x
	 *            current state
	 * @param parameters
	 *            timer parameters
	 * @return timer value (updated if necesssary)
	 */
	public void addData(State x, State x_plus, Input u, InBufParams parameters)
	{
		for (String objSig : u.getInput().keySet())
		{
			if (!x.getContents().containsPath(objSig) && !u.delete.containsPath(objSig))
			{
				Object obj = u.getInput().get(objSig);

				x.storedData.add(objSig, obj, x.getParentSystem().toString());
			}
		}

	}

}