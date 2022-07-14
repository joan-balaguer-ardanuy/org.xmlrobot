package org.xmlrobot;

import hyperspace.Entry;

public interface Robot<K,V> extends Entry<K,V>, java.util.Collection<V> {

	void start();
	void stop();
}
