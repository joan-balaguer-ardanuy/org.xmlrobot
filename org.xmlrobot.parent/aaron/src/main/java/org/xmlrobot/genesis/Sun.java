package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Sun extends Screw<Earth,Gliese> {
	
	private static final long serialVersionUID = 521974463465488019L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Earth,Gliese>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Earth,Gliese> entry = en.nextElement();
			stringBuilder.append(entry.getKey().getName());
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
		this(AlphaCentauri.class, Parity.random());
	}
	public Sun(Parity parity) {
		super(parity);
	}
	public Sun(Class<AlphaCentauri> childClass, Parity parity) {
		super(childClass, parity);
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
		getKey().comparator(new Gliese()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Polyploid, Operon> entry = getKey().comparator().source();
		comparator((Gliese) entry, (Earth) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Sun) {
			Sun entry = (Sun) e.getSource();
			switch (e.getCommand()) {
			case LISTEN:
				entry.permuteChild(call(), get());
				break;
			case TRANSFER:
				entry.release();
				break;
			default:
				break;
			}
		} else if(e.getSource() instanceof Earth) {
			Earth entry = (Earth) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Gliese()).compare(entry, getValue());
					Gliese source = (Gliese) getKey().comparator().source();
					putKey(source, (Earth) source.getChild());
				}
				break;
			default:
				break;
			}
		}
	}
	@Override
	public void run() {
		getValue().run();
		super.run();
	}
}