package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.Entry;
import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Antimatter extends ScrewNut<Interstellar,Supercluster> {

	private static final long serialVersionUID = 3881553887199239558L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Interstellar,Supercluster>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Interstellar getKey() {
		return super.getKey();
	}
	@Override
	public Interstellar setKey(Interstellar key) {
		return super.setKey(key);
	}
	@Override
	public Supercluster getValue() {
		return super.getValue();
	}
	@Override
	public Supercluster setValue(Supercluster value) {
		return super.setValue(value);
	}
	@XmlElement
	public Antimatter getEntry() {
		return call() == getRoot() ? null : (Antimatter) call();
	}
	
	public Antimatter() {
		super();
	}
	public Antimatter(Parity parity) {
		super(parity);
	}
	public Antimatter(Interstellar key, Supercluster value) {
		super(Matter.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Antimatter(Antimatter parent) {
		super(parent);
	}
	public Antimatter(Antimatter parent, Interstellar key, Supercluster value) {
		super(Matter.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Antimatter(Antimatter root, Parity parity) {
		super(root, parity);
	}
	public Antimatter(Antimatter root, Parity parity, Interstellar key, Supercluster value) {
		super(Matter.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Supercluster, Interstellar> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<MilkyWay,Andromeda> entry = getKey().comparator().getSource();
		comparator((Supercluster) entry, (Interstellar) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof Antimatter) {
				Antimatter entry = (Antimatter) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof Antimatter) {
				Antimatter entry = (Antimatter) e.getSource();
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
