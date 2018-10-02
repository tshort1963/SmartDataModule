package dataoutsys;

import java.util.ArrayList;

import dataout.DataSourceAccess;
import edu.ucsc.cross.jheq.core.object.DataStructure;

public class DataSourceSet extends DataStructure
{

	public double lastDataUpdate;
	public ArrayList<DataSourceAccess> outputs;

	public DataSourceSet()
	{
		outputs = new ArrayList<DataSourceAccess>();
		this.getProperties().setStoreTrajectory(true);
		lastDataUpdate = 0.0;

	}
}
