package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.numbers.Enumerator;

import org.xmlrobot.Parity;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Sun extends Screw<Earth,Gliese> {
	
	private static final long serialVersionUID = 521974463465488019L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Earth,Gliese>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Earth getKey() {
		return super.getKey();
	}
	@Override
	public Earth setKey(Earth key) {
		return super.setKey(key);
	}
	@Override
	public Gliese getValue() {
		return super.getValue();
	}
	@Override
	public Gliese setValue(Gliese value) {
		return super.setValue(value);
	}
	@XmlElement
	public Sun getEntry() {
		return call() == getRoot() ? null : (Sun) call();
	}
	
	public Sun() {
		super();
	}
	public Sun(Parity parity) {
		super(parity);
	}
	public Sun(Earth key, Gliese value) {
		super(AlphaCentauri.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Sun(Sun parent) {
		super(parent);
	}
	public Sun(Sun parent, Earth key, Gliese value) {
		super(AlphaCentauri.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Sun(Sun root, Parity parity) {
		super(root, parity);
	}
	public Sun(Sun root, Parity parity, Earth key, Gliese value) {
		super(AlphaCentauri.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Gliese,Earth> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		org.xmlrobot.Entry<Polyploid, Operon> entry = getKey().comparator().getSource();
		comparator((Gliese) entry, (Earth) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case GENESIS:
			if(sender.equals(getKey())) {
				if (e.getSource() instanceof Earth) {
					Earth entry = (Earth) e.getSource();
					System.out.println("Earth");
					putValue(entry, (Gliese) entry.getChild());
				}
			}
			break;
		case LISTEN:
			if(e.getSource() instanceof Sun) {
				comparator().compare((Sun) e.getSource(), getStem());
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