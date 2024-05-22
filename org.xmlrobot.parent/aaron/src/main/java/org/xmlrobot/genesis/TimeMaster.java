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
public final class TimeMaster extends ScrewNut<BigBong,BigBang> {

	private static final long serialVersionUID = 8232838480308268761L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<BigBong,BigBang>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public BigBong getKey() {
		return super.getKey();
	}
	@Override
	public BigBong setKey(BigBong key) {
		return super.setKey(key);
	}
	@Override
	public BigBang getValue() {
		return super.getValue();
	}
	@Override
	public BigBang setValue(BigBang value) {
		return super.setValue(value);
	}
	@XmlElement
	public TimeMaster getEntry() {
		return call() == getRoot() ? null : (TimeMaster) call();
	}
	
	public TimeMaster() {
		super();
	}
	public TimeMaster(Parity parity) {
		super(parity);
	}
	public TimeMaster(BigBong key, BigBang value) {
		super(Aaron.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public TimeMaster(TimeMaster parent) {
		super(parent);
	}
	public TimeMaster(TimeMaster parent, BigBong key, BigBang value) {
		super(Aaron.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public TimeMaster(TimeMaster root, Parity parity) {
		super(root, parity);
	}
	public TimeMaster(TimeMaster root, Parity parity, BigBong key, BigBang value) {
		super(Aaron.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	
	@Override
	public int compareTo(Entry<BigBang, BigBong> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Matter,Antimatter> entry = getKey().comparator().getSource();
		comparator((BigBang) entry, (BigBong) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case LISTEN:
			if(e.getSource() instanceof TimeMaster) {
				TimeMaster entry = (TimeMaster) e.getSource();
				entry.permuteChild(call(), get());	
			}
			break;
		case TRANSFER:
			if(e.getSource() instanceof TimeMaster) {
				TimeMaster entry = (TimeMaster) e.getSource();
				entry.release();
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