package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.Entry;
import org.xmlrobot.EventArgs;
import org.xmlrobot.numbers.Enumerator;

import org.xmlrobot.Parity;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class BigBong extends ScrewNut<Antimatter,Matter> {

	private static final long serialVersionUID = 4131224918311712139L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Antimatter,Matter>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Antimatter getKey() {
		return super.getKey();
	}
	@Override
	public Antimatter setKey(Antimatter key) {
		return super.setKey(key);
	}
	@Override
	public Matter getValue() {
		return super.getValue();
	}
	@Override
	public Matter setValue(Matter value) {
		return super.setValue(value);
	}
	@XmlElement
	public BigBong getEntry() {
		return call() == getRoot() ? null : (BigBong) call();
	}
	
	public BigBong() {
		super();
	}
	public BigBong(Parity parity) {
		super(parity);
	}
	public BigBong(Antimatter key, Matter value) {
		super(BigBang.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public BigBong(BigBong parent) {
		super(parent);
	}
	public BigBong(BigBong parent, Antimatter key, Matter value) {
		super(BigBang.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public BigBong(BigBong root, Parity parity) {
		super(root, parity);
	}
	public BigBong(BigBong root, Parity parity, Antimatter key, Matter value) {
		super(BigBang.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Matter, Antimatter> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Supercluster,Interstellar> entry = getKey().comparator().getSource();
		comparator((Matter) entry, (Antimatter) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof BigBong) {
				BigBong entry = (BigBong) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof BigBong) {
				BigBong entry = (BigBong) e.getSource();
				entry.release();
			}
			break;
		default:
			break;
		}
	}
	@Override
	public void run() {
		org.xmlrobot.Entry<?,?> key = getKey();
		do {
			key = key.getParent();
			key.run();
		} while (key != getKey());
		super.run();
	}
}