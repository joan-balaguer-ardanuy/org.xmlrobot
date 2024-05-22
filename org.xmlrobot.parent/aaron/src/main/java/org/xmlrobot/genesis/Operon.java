package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Operon extends Screw<Ribosome,Tetraploid> {

	private static final long serialVersionUID = -5797528494294094608L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Ribosome,Tetraploid>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Ribosome getKey() {
		return super.getKey();
	}
	@Override
	public Ribosome setKey(Ribosome key) {
		return super.setKey(key);
	}
	@Override
	public Tetraploid getValue() {
		return super.getValue();
	}
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	@XmlElement
	public Operon getEntry() {
		return call() == getRoot() ? null : (Operon) call();
	}
	
	public Operon() {
		super();
	}
	public Operon(Parity parity) {
		super(parity);
	}
	public Operon(Ribosome key, Tetraploid value) {
		super(Polyploid.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Operon(Operon parent) {
		super(parent);
	}
	public Operon(Operon parent, Ribosome key, Tetraploid value) {
		super(Polyploid.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Operon(Operon root, Parity parity) {
		super(root, parity);
	}
	public Operon(Operon root, Parity parity, Ribosome key, Tetraploid value) {
		super(Polyploid.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Tetraploid, Ribosome> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		org.xmlrobot.Entry<Diploid, Chromosome> entry = getKey().comparator().getSource();
		comparator((Tetraploid) entry, (Ribosome) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case GENESIS:
			if(sender.equals(getKey())) {
				if (e.getSource() instanceof Ribosome) {
					Ribosome entry = (Ribosome) e.getSource();
					System.out.println("Ribosome");
					putValue(entry, (Tetraploid) entry.getChild());
				}
			}
			break;
		case LISTEN:
			if(e.getSource() instanceof Operon) {
				comparator().compare((Operon) e.getSource(), getStem());
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