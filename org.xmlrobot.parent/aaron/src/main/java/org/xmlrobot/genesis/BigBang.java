package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class BigBang extends Screw<Matter,Antimatter> {

	private static final long serialVersionUID = 7325459897854775266L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Matter,Antimatter>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Matter,Antimatter> entry = en.nextElement();
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Matter getKey() {
		return super.getKey();
	}
	@Override
	public Matter setKey(Matter key) {
		return super.setKey(key);
	}
	@Override
	public Antimatter getValue() {
		return super.getValue();
	}
	@Override
	public Antimatter setValue(Antimatter value) {
		return super.setValue(value);
	}
	@XmlElement
	public BigBang getEntry() {
		return call() == getRoot() ? null : (BigBang) call();
	}
	
	public BigBang() {
		this(BigBong.class, Parity.random());
	}
	public BigBang(Parity parity) {
		super(parity);
	}
	public BigBang(Class<BigBong> childClass, Parity parity) {
		super(childClass, parity);
	}
	public BigBang(BigBang parent) {
		super(parent);
	}
	public BigBang(BigBang parent, Matter key, Antimatter value) {
		super(BigBong.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public BigBang(BigBang root, Parity parity) {
		super(root, parity);
	}
	public BigBang(BigBang root, Parity parity, Matter key, Antimatter value) {
		super(BigBong.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	@Override
	public int compareTo(org.xmlrobot.Entry<Antimatter,Matter> o) {
		getKey().comparator(new Antimatter()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Interstellar, Supercluster> entry = getKey().comparator().source();
		comparator((Antimatter) entry, (Matter) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof BigBang) {
			BigBang entry = (BigBang) e.getSource();
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
		} else if(e.getSource() instanceof Matter) {
			Matter entry = (Matter) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Antimatter()).compare(entry, getValue());
					Antimatter source = (Antimatter) getKey().comparator().source();
					getStem().putValue(source, (Matter) source.getChild());
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