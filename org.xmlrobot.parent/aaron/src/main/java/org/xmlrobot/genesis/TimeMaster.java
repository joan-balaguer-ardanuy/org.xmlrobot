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
		for(Entry<BigBong,BigBang> entry : this) {
			stringBuilder.append(entry.getKey().getName());
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
		getKey().comparator().compare(getKey(), o.getKey());
		Entry<Matter,Antimatter> entry = getKey().comparator().getSource();
		comparator((BigBang) entry, (BigBong) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof BigBang) {
					BigBang key = (BigBang) e.getSource();
					putKey(key, (BigBong) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof TimeMaster) {
					comparator().compare((TimeMaster) e.getSource(), getStem());
					sendEvent(new EventArgs(comparator().getSource()));
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
	}
	public synchronized void run() {
		Enumerator<BigBong> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}