package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.numbers.Enumerator;

import org.xmlrobot.Parity;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Matter extends Screw<Supercluster,Interstellar> {

	private static final long serialVersionUID = 1791464385185443458L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Supercluster,Interstellar>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Supercluster getKey() {
		return super.getKey();
	}
	@Override
	public Supercluster setKey(Supercluster key) {
		return super.setKey(key);
	}
	@Override
	public Interstellar getValue() {
		return super.getValue();
	}
	@Override
	public Interstellar setValue(Interstellar value) {
		return super.setValue(value);
	}
	@XmlElement
	public Matter getEntry() {
		return call() == getRoot() ? null : (Matter) call();
	}
	
	public Matter() {
		super();
	}
	public Matter(Parity parity) {
		super(parity);
	}
	public Matter(Supercluster key, Interstellar value) {
		super(Antimatter.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Matter(Matter parent) {
		super(parent);
	}
	public Matter(Matter parent, Supercluster key, Interstellar value) {
		super(Antimatter.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Matter(Matter root, Parity parity) {
		super(root, parity);
	}
	public Matter(Matter root, Parity parity, Supercluster key, Interstellar value) {
		super(Antimatter.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Interstellar,Supercluster> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		org.xmlrobot.Entry<Andromeda, MilkyWay> entry = getKey().comparator().getSource();
		comparator((Interstellar) entry, (Supercluster) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case GENESIS:
			if(sender.equals(getKey())) {
				if (e.getSource() instanceof Supercluster) {
					Supercluster entry = (Supercluster) e.getSource();
					System.out.println("Supercluster");
					putValue(entry, (Interstellar) entry.getChild());
				}
			}
			break;
		case LISTEN:
			if(e.getSource() instanceof Matter) {
				comparator().compare((Matter) e.getSource(), getStem());
				sendEvent(new EventArgs(comparator().getSource()));
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