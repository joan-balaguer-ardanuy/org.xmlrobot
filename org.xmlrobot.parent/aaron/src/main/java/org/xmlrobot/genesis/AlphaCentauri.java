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
public final class AlphaCentauri extends ScrewNut<Gliese,Earth> {

	private static final long serialVersionUID = -1649925660086238159L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Gliese,Earth>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Gliese getKey() {
		return super.getKey();
	}
	@Override
	public Gliese setKey(Gliese key) {
		return super.setKey(key);
	}
	@Override
	public Earth getValue() {
		return super.getValue();
	}
	@Override
	public Earth setValue(Earth value) {
		return super.setValue(value);
	}
	@XmlElement
	public AlphaCentauri getEntry() {
		return call() == getRoot() ? null : (AlphaCentauri) call();
	}
	
	public AlphaCentauri() {
		super();
	}
	public AlphaCentauri(Parity parity) {
		super(parity);
	}
	public AlphaCentauri(Gliese key, Earth value) {
		super(Sun.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public AlphaCentauri(AlphaCentauri parent) {
		super(parent);
	}
	public AlphaCentauri(AlphaCentauri parent, Gliese key, Earth value) {
		super(Sun.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public AlphaCentauri(AlphaCentauri root, Parity parity) {
		super(root, parity);
	}
	public AlphaCentauri(AlphaCentauri root, Parity parity, Gliese key, Earth value) {
		super(Sun.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Earth, Gliese> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Operon,Polyploid> entry = getKey().comparator().getSource();
		comparator((Earth) entry, (Gliese) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof AlphaCentauri) {
				AlphaCentauri entry = (AlphaCentauri) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof AlphaCentauri) {
				AlphaCentauri entry = (AlphaCentauri) e.getSource();
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