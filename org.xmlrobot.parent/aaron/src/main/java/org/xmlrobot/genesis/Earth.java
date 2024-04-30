package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Earth extends Screw<Operon,Polyploid> {

	private static final long serialVersionUID = -524858795429899605L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();;
		for(org.xmlrobot.Entry<Operon,Polyploid> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Operon getKey() {
		return super.getKey();
	}
	@Override
	public Operon setKey(Operon key) {
		return super.setKey(key);
	}
	@Override
	public Polyploid getValue() {
		return super.getValue();
	}
	@Override
	public Polyploid setValue(Polyploid value) {
		return super.setValue(value);
	}
	@XmlElement
	public Earth getEntry() {
		return call() == getRoot() ? null : (Earth) call();
	}
	
	public Earth() {
		super();
	}
	public Earth(Parity parity) {
		super(parity);
	}
	public Earth(Operon key, Polyploid value) {
		super(Gliese.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Earth(Earth parent) {
		super(parent);
	}
	public Earth(Earth parent, Operon key, Polyploid value) {
		super(Gliese.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Earth(Earth root, Parity parity) {
		super(root, parity);
	}
	public Earth(Earth root, Parity parity, Operon key, Polyploid value) {
		super(Gliese.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Polyploid, Operon> o) {
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Tetraploid, Ribosome> entry = getKey().comparator().getSource();
		comparator((Polyploid) entry, (Operon) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Polyploid) {
					Polyploid key = (Polyploid) e.getSource();
					putKey(key, (Operon) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Earth) {
					comparator().compare((Earth) e.getSource(), getStem());
					sendEvent(new EventArgs(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof Earth) {
					Earth entry = (Earth) e.getSource();
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
		Enumerator<Operon> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}