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
public final class Haploid extends ScrewNut<Hyperchain, Hypercube> {

	private static final long serialVersionUID = 6871541139973062247L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Hyperchain,Hypercube> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Hyperchain getKey() {
		return super.getKey();
	}
	@Override
	public Hyperchain setKey(Hyperchain key) {
		return super.setKey(key);
	}
	@Override
	public Hypercube getValue() {
		return super.getValue();
	}
	@Override
	public Hypercube setValue(Hypercube value) {
		return super.setValue(value);
	}
	@XmlElement
	public Haploid getEntry() {
		return call() == getRoot() ? null : (Haploid) call();
	}
	
	public Haploid() {
		super();
	}
	public Haploid(Parity parity) {
		super(parity);
	}
	public Haploid(Hyperchain key, Hypercube value) {
		super(Genomap.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Haploid(Haploid parent) {
		super(parent);
	}
	public Haploid(Haploid parent, Hyperchain key, Hypercube value) {
		super(Genomap.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Haploid(Haploid root, Parity parity) {
		super(root, parity);
	}
	public Haploid(Haploid root, Parity parity, Hyperchain key, Hypercube value) {
		super(Genomap.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Hypercube, Hyperchain> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Character,Integer> entry = getKey().comparator().getSource();
		comparator((Hypercube) entry, (Hyperchain) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e); 
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Hyperchain) {
					getKey().comparator().compare((Hyperchain) e.getKey(), getValue());
					getValue().comparator().compare((Hypercube) e.getValue(), getKey());
					sendEvent(new EventArgs<>(getKey().comparator().getSource(),
							getValue().comparator().getSource()));
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
//			case LISTEN:
//				if(e.getSource() instanceof Haploid) { 
//					Haploid entry = (Haploid) e.getSource();
//					entry.permuteChild(call(), get());
//				}
//				break;
			case TRANSFER:
				if(e.getSource() instanceof Haploid) {
					Haploid entry = (Haploid) e.getSource();
					entry.release();
				}
				break;
			default:
				break;
			}
		}
	}
	public synchronized void run() {
		Enumerator<Hyperchain> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}