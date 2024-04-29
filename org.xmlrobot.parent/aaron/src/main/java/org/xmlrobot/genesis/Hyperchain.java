package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.Entry;
import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Hyperchain extends ScrewNut<Integer,Character> {

	private static final long serialVersionUID = -626650173493948273L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Integer,Character> entry : this) {
			stringBuilder.append(entry.getValue());
		}
		return stringBuilder.toString();
	}
	@Override
	@XmlElement
	public Integer getKey() {
		return super.getKey();
	}
	@Override
	public Integer setKey(Integer key) {
		return super.setKey(key);
	}
	@Override
	@XmlElement
	public Character getValue() {
		return super.getValue();
	}
	@Override
	public Character setValue(Character value) {
		return super.setValue(value);
	}
	@XmlElement
	public Hyperchain getEntry() {
		return call() == getRoot() ? null : (Hyperchain) call();
	}
	
	public Hyperchain() {
		super();
	}
	public Hyperchain(Parity parity) {
		super(parity);
	}
	public Hyperchain(Integer key, Character value) {
		super(Hypercube.class, Parity.random(), key, value);
	}
	public Hyperchain(Hyperchain parent) {
		super(parent);
	}
	public Hyperchain(Hyperchain parent, Integer key, Character value) {
		super(Hypercube.class, parent, key, value);
	}
	public Hyperchain(Hyperchain root, Parity parity) {
		super(root, parity);
	}
	public Hyperchain(Hyperchain root, Parity parity, Integer key, Character value) {
		super(Hypercube.class, root, parity, key, value);
	}
	
	@Override
	public int compareTo(Entry<Character, Integer> o) {
		switch (getParity()) {
		case XY:
			if(getKey() < o.getValue()) {
				comparator(getValue(), getKey());
				return -1;
			} else {
				comparator(o.getKey(), o.getValue());
				return 1;
			}
		default:
			if(getKey() > o.getValue()) {
				comparator(getValue(), getKey());
				return -1;
			} else {
				comparator(o.getKey(), o.getValue());
				return 1;
			}
		}
	}
	@Override
	public void event(Object sender, EventArgs<?, ?> e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			comparator().compare((Hyperchain) e.getKey(), getStem());
			sendEvent(new EventArgs<>(comparator().getSource()));
			break;
		default:
			break;
		}
	}
	@Override
	public synchronized void run() {
		try {
			Thread.sleep(getKey());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}
}