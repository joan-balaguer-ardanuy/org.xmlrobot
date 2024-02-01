package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Supercluster extends Screw<MilkyWay,Andromeda> {

	private static final long serialVersionUID = 306393406087450209L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<MilkyWay,Andromeda>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<MilkyWay,Andromeda> entry = en.nextElement();
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
		this(Interstellar.class, Parity.random());
	}
	public Supercluster(Parity parity) {
		super(parity);
	}
	public Supercluster(Class<Interstellar> childClass, Parity parity) {
		super(childClass, parity);
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
		getKey().comparator(new Andromeda()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<AlphaCentauri, Sun> entry = getKey().comparator().source();
		comparator((Andromeda) entry, (MilkyWay) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Supercluster) {
			Supercluster entry = (Supercluster) e.getSource();
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
		} else if(e.getSource() instanceof MilkyWay) {
			MilkyWay entry = (MilkyWay) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Andromeda()).compare(entry, getValue());
					Andromeda source = (Andromeda) getKey().comparator().source();
					putKey(source, (MilkyWay) source.getChild());
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