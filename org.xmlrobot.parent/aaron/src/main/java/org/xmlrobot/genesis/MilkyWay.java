package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class MilkyWay extends Screw<Sun,AlphaCentauri> {

	private static final long serialVersionUID = 1253114982913774706L;
	
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(org.xmlrobot.Entry<Sun,AlphaCentauri> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Sun getKey() {
		return super.getKey();
	}
	@Override
	public Sun setKey(Sun key) {
		return super.setKey(key);
	}
	@Override
	public AlphaCentauri getValue() {
		return super.getValue();
	}
	@Override
	public AlphaCentauri setValue(AlphaCentauri value) {
		return super.setValue(value);
	}
	@XmlElement
	public MilkyWay getEntry() {
		return call() == getRoot() ? null : (MilkyWay) call();
	}
	
	public MilkyWay() {
		super();
	}
	public MilkyWay(Parity parity) {
		super(parity);
	}
	public MilkyWay(Sun key, AlphaCentauri value) {
		super(Andromeda.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public MilkyWay(MilkyWay parent) {
		super(parent);
	}
	public MilkyWay(MilkyWay parent, Sun key, AlphaCentauri value) {
		super(Andromeda.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public MilkyWay(MilkyWay root, Parity parity) {
		super(root, parity);
	}
	public MilkyWay(MilkyWay root, Parity parity, Sun key, AlphaCentauri value) {
		super(Andromeda.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<AlphaCentauri,Sun> o) {
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Gliese, Earth> entry = getKey().comparator().getSource();
		comparator((AlphaCentauri) entry, (Sun) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof AlphaCentauri) {
					AlphaCentauri key = (AlphaCentauri) e.getSource();
					putKey(key, (Sun) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof MilkyWay) {
					comparator().compare((MilkyWay) e.getSource(), getStem());
					sendEvent(new EventArgs<>(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof MilkyWay) {
					MilkyWay entry = (MilkyWay) e.getSource();
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
		Enumerator<Sun> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}