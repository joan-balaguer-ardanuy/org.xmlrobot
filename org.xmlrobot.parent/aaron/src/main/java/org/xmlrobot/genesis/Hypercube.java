package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.Order;
import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Hypercube extends Screw<Character,Integer> {

	private static final long serialVersionUID = 2736421359601432040L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Character,Integer>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Character,Integer> entry = en.nextElement();
			stringBuilder.append(entry.getKey());
		}
		return stringBuilder.toString();
	}
	@Override
	@XmlElement
	public Character getKey() {
		return super.getKey();
	}
	@Override
	public Character setKey(Character key) {
		return super.setKey(key);
	}
	@Override
	@XmlElement
	public Integer getValue() {
		return super.getValue();
	}
	@Override
	public Integer setValue(Integer value) {
		return super.setValue(value);
	}
	@XmlElement
	public Hypercube getEntry() {
		return call() == getRoot() ? null : (Hypercube) call();
	}
	
	public Hypercube() {
		this(Hyperchain.class, Parity.random());
	}
	public Hypercube(Parity parity) {
		super(parity);
	}
	public Hypercube(Class<Hyperchain> childClass, Parity parity) {
		super(childClass, parity);
	}
	public Hypercube(Hypercube parent) {
		super(parent);
	}
	public Hypercube(Hypercube parent, Character key, Integer value) {
		super(Hyperchain.class, parent, key, value);
	}
	public Hypercube(Hypercube root, Parity parity) {
		super(root, parity);
	}
	public Hypercube(Hypercube root, Parity parity, Character key, Integer value) {
		super(Hyperchain.class, root, parity, key, value);
	}
	
	@Override
	public synchronized int compareTo(org.xmlrobot.Entry<Integer, Character> o) {
		switch (getParity()) {
		case XX:
			if (getValue() > o.getKey()) {
				comparator(getValue(), getKey());
				return 1;
			} else {
				comparator(o.getKey(), o.getValue());
				return -1;
			}
		default:
			if (getValue() < o.getKey()) {
				comparator(getValue(), getKey());
				return 1; 
			} else {
				comparator(o.getKey(), o.getValue());
				return -1;
			}
		}
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Hypercube) {
			Hypercube entry = (Hypercube) e.getSource();
			switch (e.getCommand()) {
			case LISTEN:
				entry.permuteChild(call(), get());
				break;
			default:
				break;
			}
		}
	}
	@Override
	public void run() {
		try {
			Thread.sleep(getValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}
}
