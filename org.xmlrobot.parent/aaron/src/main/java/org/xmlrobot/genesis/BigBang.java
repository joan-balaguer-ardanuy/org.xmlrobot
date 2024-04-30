package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class BigBang extends Screw<Matter,Antimatter> {

	private static final long serialVersionUID = 7325459897854775266L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(org.xmlrobot.Entry<Matter,Antimatter> entry : this) {
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
		super();
	}
	public BigBang(Parity parity) {
		super(parity);
	}
	public BigBang(Matter key, Antimatter value) {
		super(BigBong.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
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
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Interstellar, Supercluster> entry = getKey().comparator().getSource();
		comparator((Antimatter) entry, (Matter) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Antimatter) {
					Antimatter key = (Antimatter) e.getSource();
					putKey(key, (Matter) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof BigBang) {
					comparator().compare((BigBang) e.getSource(), getStem());
					sendEvent(new EventArgs(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof BigBang) {
					BigBang entry = (BigBang) e.getSource();
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
		Enumerator<Matter> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}