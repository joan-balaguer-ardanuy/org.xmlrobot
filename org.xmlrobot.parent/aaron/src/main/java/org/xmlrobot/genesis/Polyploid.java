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
public final class Polyploid extends ScrewNut<Tetraploid,Ribosome> {

	private static final long serialVersionUID = 3697213256533673578L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Tetraploid,Ribosome>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Tetraploid getKey() {
		return super.getKey();
	}
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	@Override
	public Ribosome getValue() {
		return super.getValue();
	}
	@Override
	public Ribosome setValue(Ribosome value) {
		return super.setValue(value);
	}
	@XmlElement
	public Polyploid getEntry() {
		return call() == getRoot() ? null : (Polyploid) call();
	}
	
	public Polyploid() {
		super();
	}
	public Polyploid(Parity parity) {
		super(parity);
	}
	public Polyploid(Tetraploid key, Ribosome value) {
		super(Operon.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Polyploid(Polyploid parent) {
		super(parent);
	}
	public Polyploid(Polyploid parent, Tetraploid key, Ribosome value) {
		super(Operon.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Polyploid(Polyploid root, Parity parity) {
		super(root, parity);
	}
	public Polyploid(Polyploid root, Parity parity, Tetraploid key, Ribosome value) {
		super(Operon.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Ribosome, Tetraploid> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Chromosome,Diploid> entry = getKey().comparator().getSource();
		comparator((Ribosome) entry, (Tetraploid) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof Polyploid) {
				Polyploid entry = (Polyploid) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof Polyploid) {
				Polyploid entry = (Polyploid) e.getSource();
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