package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Matter extends Screw<Supercluster,Interstellar> {

	private static final long serialVersionUID = 1791464385185443458L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Supercluster,Interstellar>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Supercluster,Interstellar> entry = en.nextElement();
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Supercluster getKey() {
		return super.getKey();
	}
	@Override
	public Supercluster setKey(Supercluster key) {
		return super.setKey(key);
	}
	@Override
	public Interstellar getValue() {
		return super.getValue();
	}
	@Override
	public Interstellar setValue(Interstellar value) {
		return super.setValue(value);
	}
	@XmlElement
	public Matter getEntry() {
		return call() == getRoot() ? null : (Matter) call();
	}
	
	public Matter() {
		this(Antimatter.class, Parity.random());
	}
	public Matter(Parity parity) {
		super(parity);
	}
	public Matter(Class<Antimatter> childClass, Parity parity) {
		super(childClass, parity);
	}
	public Matter(Matter parent) {
		super(parent);
	}
	public Matter(Matter parent, Supercluster key, Interstellar value) {
		super(Antimatter.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Matter(Matter root, Parity parity) {
		super(root, parity);
	}
	public Matter(Matter root, Parity parity, Supercluster key, Interstellar value) {
		super(Antimatter.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	@Override
	public int compareTo(org.xmlrobot.Entry<Interstellar,Supercluster> o) {
		getKey().comparator(new Interstellar()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Andromeda, MilkyWay> entry = getKey().comparator().source();
		comparator((Interstellar) entry, (Supercluster) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Matter) {
			Matter entry = (Matter) e.getSource();
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
		} else if(e.getSource() instanceof Supercluster) {
			Supercluster entry = (Supercluster) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Interstellar()).compare(entry, getValue());
					Interstellar source = (Interstellar) getKey().comparator().source();
					getStem().putValue(source, (Supercluster) source.getChild());
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