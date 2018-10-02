
package dataoutsys;

import java.util.HashMap;

import dataobject.BasicMetadata;
import dataobject.DataObject;
import dataobject.DataSource;
import dataout.DataSourceAccess;
import edu.ucsc.cross.jheq.core.model.JumpMap;
import edu.ucsc.cross.jheq.core.model.Variables;
import inbuffer.DataStorage;

public class G implements JumpMap<DataSourceSet, DataStorage> {

	@Override
	public void evaluateG(DataSourceSet x, DataSourceSet x_dot, DataStorage DataStorage, Variables vars) {

		HashMap<DataSourceAccess, DataObject<?>> rec = findMostRecent(x, x_dot, DataStorage, vars);
		if (rec.size() > 0) {
			// System.out.println(XMLParser.serializeObject(rec));
			updateMostRecent(x, x_dot, DataStorage, vars, rec);
		} else {

			x_dot.lastDataUpdate = System.currentTimeMillis();
		}
	}

	public void updateMostRecent(DataSourceSet x, DataSourceSet x_dot, DataStorage DataStorage, Variables vars,
			HashMap<DataSourceAccess, DataObject<?>> rec) {

		double envTime = System.currentTimeMillis();

		int ind = 0;
		for (DataSourceAccess dss : rec.keySet()) {
			DataObject<?> dsz = rec.get(dss);

			try {

				DataSource ds = (DataSource) dsz.getObject();
				dss.created = ds.created();
				dss.value = (Double) ds.content();
				dss.age = envTime - ds.created();
				// System.out.println(XMLParser.serializeObject(rec));
				x_dot.lastDataUpdate = System.currentTimeMillis();
			} catch (Exception badTry) {

				badTry.printStackTrace();
			}
		}

	}

	public HashMap<DataSourceAccess, DataObject<?>> findMostRecent(DataSourceSet x, DataSourceSet x_dot,
			DataStorage DataStorage, Variables vars) {

		HashMap<DataSourceAccess, DataObject<?>> rec = new HashMap<DataSourceAccess, DataObject<?>>();
		HashMap<String, DataSourceAccess> names = getSourceNameMap(x);

		for (DataObject<?> dat : DataStorage.getStored().getStoredData().values()) {
			try {

				// System.out.println(XMLParser.serializeObject(DataStorage));
				DataSourceAccess ds = matchingId(x_dot, dat);
				if (ds != null) {
					DataSource dss = (DataSource) dat.getObject();
					if (rec.containsKey(ds)) {
						if (rec.get(ds).getCreateDate() < dss.created()) {
							rec.put(ds, dat);
						}
					} else if (dss.created() > ds.created) {
						rec.put(ds, dat);
					}
				}
			} catch (Exception bad) {

			}
		}
		return rec;

	}

	public HashMap<String, DataSourceAccess> getSourceNameMap(DataSourceSet x)

	{

		HashMap<String, DataSourceAccess> names = new HashMap<String, DataSourceAccess>();
		for (DataSourceAccess val : x.outputs) {
			names.put(val.sourceId, val);
		}
		return names;
	}

	public HashMap<DataSourceAccess, DataObject<?>> getMostRecentMap(DataSourceSet x, DataSourceSet x_dot,
			DataStorage DataStorage, Variables vars) {

		HashMap<DataSourceAccess, DataObject<?>> rec = new HashMap<DataSourceAccess, DataObject<?>>();
		for (DataSourceAccess val : x.outputs) {
			BasicMetadata md = new BasicMetadata(val.sourceId);
			md.readTime = (long) val.created;
			DataObject<?> dat = new DataObject<Object>(val, md);
			rec.put(val, dat);
		}
		return rec;
	}

	public DataSourceAccess matchingId(DataSourceSet x, DataObject<?> dat) {

		String id = dat.getCreatorId();
		if (id == null)
			try {
				DataSource dss = (DataSource) dat.getObject();
				id = dss.getId();
				// System.out.println(id);
			} catch (

			Exception badTry) {
				badTry.printStackTrace();
			}
		if (id != null) {

			for (DataSourceAccess val : x.outputs) {
				{
					if (id.equals(val.sourceId)) {
						// System.out.println("match" + val.sourceId);
						return val;
					}
				}

			}
		}
		return null;
	}
}// 12;run -t 1 -j 20