package org.xmlrobot;

import java.util.List;

public interface Stream<T> {
	T getInput();
	T setInput(T input);
	
	List<T> getOutput();
	List<T> setOutput(List<T> output);
	
	void start();
	void stop();
}
