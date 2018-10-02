package dataout;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class DataSourceAccess extends DataStructure
{

	public String sourceId;
	public double value;
	public double age;
	public double created;

	public DataSourceAccess()
	{
		sourceId = "data source";
		value = 0.0;
		age = 0.0;
		created = 0.0;
		this.getProperties().setStoreTrajectory(true);
	}

	public DataSourceAccess(String source)
	{
		sourceId = source;
		value = 0.0;
		age = 0.0;
		created = 0.0;
		this.getProperties().setStoreTrajectory(true);
	}

}
