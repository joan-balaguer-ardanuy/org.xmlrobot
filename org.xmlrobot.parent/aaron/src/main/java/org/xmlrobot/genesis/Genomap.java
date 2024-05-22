package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Genomap extends Screw<Hypercube, Hyperchain> {

	private static final long serialVersionUID = -3096574629565456019L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Hypercube,Hyperchain>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	
	@Override
	public Hypercube getKey() {
		return super.getKey();
	}
	@Override
	public Hypercube setKey(Hypercube key) {
		return super.setKey(key);
	}
	@Override
	public Hyperchain getValue() {
		return super.getValue();
	}
	@Override
	public Hyperchain setValue(Hyperchain value) {
		return super.setValue(value);
	}
	@XmlElement
	public Genomap getEntry() {
		return call() == getRoot() ? null : (Genomap) call();
	}

	public Genomap() {
		super();
	}
	public Genomap(Parity parity) {
		super(parity);
	}
	public Genomap(Hypercube key, Hyperchain value) {
		super(Haploid.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Genomap(Genomap parent) {
		super(parent);
	}
	public Genomap(Genomap parent, 	Hypercube key, Hyperchain value) {
		super(Haploid.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Genomap(Genomap root, Parity parity) {
		super(root, parity);
	}
	public Genomap(Genomap root, Parity parity, Hypercube key, Hyperchain value) {
		super(Haploid.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Hyperchain,Hypercube> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		org.xmlrobot.Entry<Integer,Character> entry = getKey().comparator().getSource();
		comparator((Hyperchain) entry, (Hypercube) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case GENESIS:
			if(sender.equals(getKey())) {
				if (e.getSource() instanceof Hypercube) {
					Hypercube entry = (Hypercube) e.getSource();
					System.out.println("Hypercube");
					putValue(entry, (Hyperchain) entry.getChild());
				}
			}
			break;
		case LISTEN:
			if(e.getSource() instanceof Genomap) {
				comparator().compare((Genomap) e.getSource(), getStem());
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