package org.xmlrobot;

import java.util.Iterator;

import hyperspace.recurrent.ListMap;

public interface Robot<T> extends ListMap<T>, Iterator<T> {
	void start();
	void stop();
	void reset();
}