package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.numbers.Enumerator;

import org.xmlrobot.Parity;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Aaron extends Screw<BigBang,BigBong> {

	private static final long serialVersionUID = -4885033226486761983L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<BigBang,BigBong>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public BigBang getKey() {
		return super.getKey();
	}
	@Override
	public BigBang setKey(BigBang key) {
		return super.setKey(key);
	}
	@Override
	public BigBong getValue() {
		return super.getValue();
	}
	@Override
	public BigBong setValue(BigBong value) {
		return super.setValue(value);
	}
	@XmlElement
	public Aaron getEntry() {
		return call() == getRoot() ? null : (Aaron) call();
	}
	
	public Aaron() {
		super();
	}
	public Aaron(Parity parity) {
		super(parity);
	}
	public Aaron(BigBang key, BigBong value) {
		super(TimeMaster.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Aaron(Aaron parent) {
		super(parent);
	}
	public Aaron(Aaron parent, BigBang key, BigBong value) {
		super(TimeMaster.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Aaron(Aaron root, Parity parity) {
		super(root, parity);
	}
	public Aaron(Aaron root, Parity parity, BigBang key, BigBong value) {
		super(TimeMaster.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<BigBong,BigBang> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		org.xmlrobot.Entry<Antimatter,Matter> entry = getKey().comparator().getSource();
		comparator((BigBong) entry, (BigBang) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case GENESIS:
			if(sender.equals(getKey())) {
				if (e.getSource() instanceof BigBang) {
					BigBang entry = (BigBang) e.getSource();
					System.out.println("BigBang");
					putValue(entry, (BigBong) entry.getChild());
				}
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