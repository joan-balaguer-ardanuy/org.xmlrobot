package org.xmlrobot;

import java.util.Iterator;

import hyperspace.recurrent.ListMapping;

public interface Robot<T> extends ListMapping<T>, Iterator<T> {
	void start();
	void stop();
	void reset();
}