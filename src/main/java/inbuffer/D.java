
package inbuffer;

import edu.ucsc.cross.jheq.core.model.JumpSet;
import edu.ucsc.cross.jheq.core.model.Variables;

public class D implements JumpSet<State, Input>
{

	@Override
	public boolean evaluateD(State x, Input u, Variables params)
	{
		// System.out.println(XMLParser.serializeObject(u));

		boolean jump = false;
		for (String objSig : u.getInput().keySet())
		{
			if (!x.getContents().containsPath(objSig) && !u.delete.containsPath(objSig))
			{
				jump = true;
			}

		}
		for (String del : u.delete.getStoredData().keySet())
		{
			if (x.storedData.containsPath(del))
			{
				return true;
			}
		}

		return jump;
	}

}
