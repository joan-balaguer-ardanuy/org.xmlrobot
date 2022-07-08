package org.xmlrobot;

import hyperspace.Message;
import hyperspace.recurrent.Hyperlist;
import hyperspace.recurrent.List;

public class XML2<T extends Robot<T>>
	extends Hyperlist<T>
		implements Robot<T> {

	private static final long serialVersionUID = 2893001885051512991L;
	
	int index = 0;
	Message xml;
	
	public Message getXml() {
		return xml;
	}
	public void setXml(Message xml) {
		this.xml = xml;
	}
	
	public XML2() {
		super();
	}
	public XML2(Class<? extends XML2<T>> type, String name) {
		super(type, name);
	}
	public XML2(Class<? extends XML2<T>> type, Message xml, T input, List<T> output) {
		super(type, xml.getName(), input, output);
		this.xml = xml;
		addEventListener(input);
	}
	public XML2(XML2<T> parent) {
		super(parent);
	}
	public XML2(XML2<T> parent, T input, List<T> output) {
		super(parent, input, output);
		this.xml = parent.xml;
		addEventListener(input);
	}
	public XML2(XML2<T> root, String name) {
		super(root, name);
	}
	public XML2(XML2<T> root, String name, T input, List<T> output) {
		super(root, name, input, output);
		this.xml = root.xml;
		addEventListener(input);
	}
	
	@Override
	public void start() {
		for(T xml : getValue()) {
			xml.start();
		}
		reset();
	}
	@Override
	public void stop() {
		for(T xml : getValue()) {
			xml.stop();
		}
		reset();
	}
	@Override
	public void reset() {
		index = 0;
	}
	@Override
	public boolean hasNext() {
		return index < getValue().size();
	}
	@Override
	public T next() {
		T child = getValue().get(index);
		index++;
		return child;
	}
}