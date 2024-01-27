package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Earth extends Screw<Operon,Polyploid> {

	private static final long serialVersionUID = -524858795429899605L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Operon,Polyploid>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Operon,Polyploid> entry = en.nextElement();
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
		this(Gliese.class, Parity.random());
	}
	public Earth(Parity parity) {
		super(parity);
	}
	public Earth(Class<Gliese> childClass, Parity parity) {
		super(childClass, parity);
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
		getKey().comparator(new Polyploid()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Tetraploid, Ribosome> entry = getKey().comparator().source();
		comparator((Polyploid) entry, (Operon) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Earth) {
			Earth entry = (Earth) e.getSource();
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
		} else if(e.getSource() instanceof Operon) {
			Operon entry = (Operon) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Polyploid()).compare(entry, getValue());
					Polyploid source = (Polyploid) getKey().comparator().source();
					getStem().putValue(source, (Operon) source.getChild());
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