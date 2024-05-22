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
public final class Interstellar extends ScrewNut<Andromeda,MilkyWay> {

	private static final long serialVersionUID = -609824198859953022L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Andromeda,MilkyWay>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Andromeda getKey() {
		return super.getKey();
	}
	@Override
	public Andromeda setKey(Andromeda key) {
		return super.setKey(key);
	}
	@Override
	public MilkyWay getValue() {
		return super.getValue();
	}
	@Override
	public MilkyWay setValue(MilkyWay value) {
		return super.setValue(value);
	}
	@XmlElement
	public Interstellar getEntry() {
		return call() == getRoot() ? null : (Interstellar) call();
	}
	
	public Interstellar() {
		super();
	}
	public Interstellar(Parity parity) {
		super(parity);
	}
	public Interstellar(Andromeda key, MilkyWay value) {
		super(Supercluster.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Interstellar(Interstellar parent) {
		super(parent);
	}
	public Interstellar(Interstellar parent, Andromeda key, MilkyWay value) {
		super(Supercluster.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Interstellar(Interstellar root, Parity parity) {
		super(root, parity);
	}
	public Interstellar(Interstellar root, Parity parity, Andromeda key, MilkyWay value) {
		super(Supercluster.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<MilkyWay, Andromeda> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Sun,AlphaCentauri> entry = getKey().comparator().getSource();
		comparator((MilkyWay) entry, (Andromeda) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof Interstellar) {
				Interstellar entry = (Interstellar) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof Interstellar) {
				Interstellar entry = (Interstellar) e.getSource();
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