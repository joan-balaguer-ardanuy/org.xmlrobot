package org.xmlrobot;

import java.util.Iterator;

import hyperspace.recurrent.EntryList;

public interface Robot<T> extends EntryList<T>, Iterator<T> {
	void start();
	void stop();
	void reset();
}