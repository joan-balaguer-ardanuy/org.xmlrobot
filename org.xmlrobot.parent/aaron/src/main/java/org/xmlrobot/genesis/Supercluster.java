package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Supercluster extends Screw<MilkyWay,Andromeda> {

	private static final long serialVersionUID = 306393406087450209L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(org.xmlrobot.Entry<MilkyWay,Andromeda> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public MilkyWay getKey() {
		return super.getKey();
	}
	@Override
	public MilkyWay setKey(MilkyWay key) {
		return super.setKey(key);
	}
	@Override
	public Andromeda getValue() {
		return super.getValue();
	}
	@Override
	public Andromeda setValue(Andromeda value) {
		return super.setValue(value);
	}
	@XmlElement
	public Supercluster getEntry() {
		return call() == getRoot() ? null : (Supercluster) call();
	}
	
	public Supercluster() {
		super();
	}
	public Supercluster(Parity parity) {
		super(parity);
	}
	public Supercluster(MilkyWay key, Andromeda value) {
		super(Interstellar.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Supercluster(Supercluster parent) {
		super(parent);
	}
	public Supercluster(Supercluster parent, MilkyWay key, Andromeda value) {
		super(Interstellar.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Supercluster(Supercluster root, Parity parity) {
		super(root, parity);
	}
	public Supercluster(Supercluster root, Parity parity, MilkyWay key, Andromeda value) {
		super(Interstellar.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Andromeda,MilkyWay> o) {
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<AlphaCentauri, Sun> entry = getKey().comparator().getSource();
		comparator((Andromeda) entry, (MilkyWay) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Andromeda) {
					Andromeda key = (Andromeda) e.getSource();
					putKey(key, (MilkyWay) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Supercluster) {
					comparator().compare((Supercluster) e.getSource(), getStem());
					sendEvent(new EventArgs(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof Supercluster) {
					Supercluster entry = (Supercluster) e.getSource();
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
		Enumerator<MilkyWay> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}