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
public final class Andromeda extends ScrewNut<AlphaCentauri,Sun> {

	private static final long serialVersionUID = 1951089975362507507L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<AlphaCentauri,Sun>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public AlphaCentauri getKey() {
		return super.getKey();
	}
	@Override
	public AlphaCentauri setKey(AlphaCentauri key) {
		return super.setKey(key);
	}
	@Override
	public Sun getValue() {
		return super.getValue();
	}
	@Override
	public Sun setValue(Sun value) {
		return super.setValue(value);
	}
	@XmlElement
	public Andromeda getEntry() {
		return call() == getRoot() ? null : (Andromeda) call();
	}
	
	public Andromeda() {
		super();
	}
	public Andromeda(Parity parity) {
		super(parity);
	}
	public Andromeda(AlphaCentauri key, Sun value) {
		super(MilkyWay.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Andromeda(Andromeda parent) {
		super(parent);
	}
	public Andromeda(Andromeda parent, AlphaCentauri key, Sun value) {
		super(MilkyWay.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Andromeda(Andromeda root, Parity parity) {
		super(root, parity);
	}
	public Andromeda(Andromeda root, Parity parity, AlphaCentauri key, Sun value) {
		super(MilkyWay.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Sun, AlphaCentauri> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Earth,Gliese> entry = getKey().comparator().getSource();
		comparator((Sun) entry, (AlphaCentauri) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof Andromeda) {
				Andromeda entry = (Andromeda) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof Andromeda) {
				Andromeda entry = (Andromeda) e.getSource();
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