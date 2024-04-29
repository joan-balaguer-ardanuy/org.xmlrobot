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
		for(Entry<Andromeda,MilkyWay> entry : this) {
			stringBuilder.append(entry.getKey().getName());
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
		getKey().comparator().compare(getKey(), o.getKey());
		Entry<Sun,AlphaCentauri> entry = getKey().comparator().getSource();
		comparator((MilkyWay) entry, (Andromeda) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof MilkyWay) {
					MilkyWay key = (MilkyWay) e.getSource();
					putKey(key, (Andromeda) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Interstellar) {
					comparator().compare((Interstellar) e.getSource(), getStem());
					sendEvent(new EventArgs<>(comparator().getSource()));
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
	}
	public synchronized void run() {
		Enumerator<Andromeda> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}