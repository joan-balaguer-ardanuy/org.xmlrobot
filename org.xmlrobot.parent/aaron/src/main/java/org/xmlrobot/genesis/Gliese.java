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
public final class Gliese extends ScrewNut<Polyploid,Operon> {

	private static final long serialVersionUID = 8051144854716651556L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Polyploid,Operon> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Polyploid getKey() {
		return super.getKey();
	}
	@Override
	public Polyploid setKey(Polyploid key) {
		return super.setKey(key);
	}
	@Override
	public Operon getValue() {
		return super.getValue();
	}
	@Override
	public Operon setValue(Operon value) {
		return super.setValue(value);
	}
	@XmlElement
	public Gliese getEntry() {
		return call() == getRoot() ? null : (Gliese) call();
	}
	
	public Gliese() {
		super();
	}
	public Gliese(Parity parity) {
		super(parity);
	}
	public Gliese(Polyploid key, Operon value) {
		super(Earth.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Gliese(Gliese parent) {
		super(parent);
	}
	public Gliese(Gliese parent, Polyploid key, Operon value) {
		super(Earth.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Gliese(Gliese root, Parity parity) {
		super(root, parity);
	}
	public Gliese(Gliese root, Parity parity, Polyploid key, Operon value) {
		super(Earth.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Operon, Polyploid> o) {
		getKey().comparator().compare(getKey(), o.getKey());
		Entry<Ribosome,Tetraploid> entry = getKey().comparator().getSource();
		comparator((Operon) entry, (Polyploid) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Operon) {
					Operon key = (Operon) e.getSource();
					putKey(key, (Polyploid) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Gliese) {
					comparator().compare((Gliese) e.getSource(), getStem());
					sendEvent(new EventArgs<>(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof Gliese) {
					Gliese entry = (Gliese) e.getSource();
					entry.release();
				}
				break;
			default:
				break;
			}
		}
	}
	public synchronized void run() {
		Enumerator<Polyploid> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}