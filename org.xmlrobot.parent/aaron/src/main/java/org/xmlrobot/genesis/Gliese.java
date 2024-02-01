package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.Entry;
import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Gliese extends ScrewNut<Polyploid,Operon> {

	private static final long serialVersionUID = 8051144854716651556L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Polyploid,Operon>> en = enumerator();
		while(en.hasMoreElements()) {
			Entry<Polyploid,Operon> entry = en.nextElement();
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
		this(Earth.class, Parity.random());
	}
	public Gliese(Parity parity) {
		super(parity);
	}
	public Gliese(Class<Earth> childClass, Parity parity) {
		super(childClass, parity);
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
		getKey().comparator(new Operon()).compare(getKey(), o.getKey());
		Entry<Ribosome,Tetraploid> entry = getKey().comparator().source();
		comparator((Operon) entry, (Polyploid) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Ribosome) {
			Ribosome entry = (Ribosome) e.getSource();
			switch (e.getCommand()) {
			case GENESIS:
				if(isRoot()) {
					Operon operon = new Operon();
					operon.putValue(entry, (Tetraploid) entry.getChild());
					sendEvent(new EventArgs(operon));
				}
				break;
			default:
				break;
			}
		} 
		else if(e.getSource() instanceof Polyploid) {
			Polyploid entry = (Polyploid) e.getSource();
			switch (e.getCommand()) {
			case LISTEN:
				if (!isRoot()) {
					getKey().comparator(new Operon()).compare(entry, getValue());
					sendEvent(new EventArgs(getKey().comparator().source()));
				}
				break;
			default:
				break;
			}
		}
	}
	public void run() {
		getValue().run();
		super.run();
	}
}