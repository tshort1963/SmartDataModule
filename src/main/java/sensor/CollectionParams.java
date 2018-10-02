
package sensor;

import edu.ucsc.cross.jheq.core.object.DataStructure;

public class CollectionParams extends DataStructure {

	public double minSampleInterval;

	public double maxSampleInterval;

	public CollectionParams() {

		this.minSampleInterval = .1;
		this.maxSampleInterval = 1.0;

	}

	public CollectionParams(double min, double max) {

		this.minSampleInterval = min;
		this.maxSampleInterval = max;
	}
}
