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
		for(org.xmlrobot.Entry<Hypercube,Hyperchain> entry : this) {
			stringBuilder.append(entry.getKey().getName());
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
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				Hyperchain key = (Hyperchain) e.getSource();
				putKey(key, (Hypercube) key.getChild());
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Genomap) {
					comparator().compare((Genomap) e.getSource(), getStem());
					sendEvent(new EventArgs(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof Genomap) { 
					Genomap entry = (Genomap) e.getSource();
					entry.release();
				}
				break;
			default:
				break;
			}
		}
	}
	@Override
	public synchronized void run() {
		Enumerator<Hypercube> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}