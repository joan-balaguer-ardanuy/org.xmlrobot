package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Aaron extends Screw<BigBang,BigBong> {

	private static final long serialVersionUID = -4885033226486761983L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(org.xmlrobot.Entry<BigBang,BigBong> entry : this) {
			stringBuilder.append(entry.getKey().getName());
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
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Antimatter,Matter> entry = getKey().comparator().getSource();
		comparator((BigBong) entry, (BigBang) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof BigBong) {
					BigBong key = (BigBong) e.getSource();
					putKey(key, (BigBang) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Aaron) {
					comparator().compare((Aaron) e.getSource(), getStem());
					sendEvent(new EventArgs(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof Aaron) {
					Aaron entry = (Aaron) e.getSource();
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
		Enumerator<BigBang> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}