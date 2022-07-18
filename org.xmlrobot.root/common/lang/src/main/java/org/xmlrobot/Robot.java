package org.xmlrobot;

import hyperspace.Entry;
import hyperspace.Message;

public interface Robot<K,V> extends Entry<K,V>, java.util.Collection<V> {

	Message getXML();
	
	void start();
	void stop();
}
