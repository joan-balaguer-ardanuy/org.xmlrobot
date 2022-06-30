package org.xmlrobot;

import java.util.List;

/**
 * @author joan
 *
 */
public class AbstractStream<K,V,T> 
	extends AbstractRobot<K,V> 
		implements Stream<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1211820221428004748L;

	T input;
	List<T> output;

	@Override
	public T getInput() {
		return input;
	}
	@Override
	public T setInput(T input) {
		return null;
	}
	@Override
	public List<T> getOutput() {
		return output;
	}
	@Override
	public List<T> setOutput(List<T> value) {
		List<T> old  = this.output;
		this.output = value;
		return old;
	}
	public void start() {
		
	}
	public void stop() {
		
	}
}