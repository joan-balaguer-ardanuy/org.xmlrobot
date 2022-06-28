package org.xmlrobot;

import java.util.Iterator;
import java.util.List;
import hyperspace.TimeListener;

public interface Robot<K> extends TimeListener<K, List<K>>, Iterator<K> {

	void reset();
}