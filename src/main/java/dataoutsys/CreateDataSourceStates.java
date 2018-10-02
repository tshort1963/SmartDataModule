
package dataoutsys;

import java.util.ArrayList;

import com.be3short.obj.access.FieldFinder;

import dataobject.DataSource;
import dataout.DataSourceAccess;
import edu.ucsc.cross.jheq.core.app.JavaHyEQExecute;
import edu.ucsc.cross.jheq.core.app.JavaHyEQTask;
import edu.ucsc.cross.jheq.core.environment.HSEnvironment;
import edu.ucsc.cross.jheq.core.model.HybridSystem;

/**
 * Task implementation to be executed after the systems have been generated
 */
public class CreateDataSourceStates implements JavaHyEQTask
{

	@Override
	public JavaHyEQTask create()
	{

		// TODO Auto-generated method stub
		return new CreateDataSourceStates();
	}

	/**
	 * Method to be executed after the systems have been generated
	 */
	@Override
	public void execute(HSEnvironment env, String input, JavaHyEQExecute app)
	{
		ArrayList<String> connectedSystems = new ArrayList<String>();
		for (HybridSystem sys : env.getSystems().getSystems())
		{
			if (FieldFinder.containsSuper(sys.getValue(), DataSource.class))
			{
				if (!connectedSystems.contains(sys.toString()))
				{
					connectedSystems.add(sys.toString());
				}
			}
		}
		for (HybridSystem sys : env.getSystems().getSystems())
		{
			if (sys.getState().getClass().equals(DataSourceSet.class))
			{
				DataSourceSet ds = (DataSourceSet) sys.getState();
				for (String name : connectedSystems)
				{
					ds.outputs.add(new DataSourceAccess(name));
				}
			}
		}

	}

}
