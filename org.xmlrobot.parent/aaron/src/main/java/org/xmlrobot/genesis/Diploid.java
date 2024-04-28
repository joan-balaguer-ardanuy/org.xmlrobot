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
public final class Diploid extends ScrewNut<Haploid, Genomap> {

	private static final long serialVersionUID = -5814839388008604606L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Haploid,Genomap> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Haploid getKey() {
		return super.getKey();
	}
	@Override
	public Haploid setKey(Haploid key) {
		return super.setKey(key);
	}
	@Override
	public Genomap getValue() {
		return super.getValue();
	}
	@Override
	public Genomap setValue(Genomap value) {
		return super.setValue(value);
	}
	@XmlElement
	public Diploid getEntry() {
		return call() == getRoot() ? null : (Diploid) call();
	}
	
	public Diploid() {
		super();
	}
	public Diploid(Parity parity) {
		super(parity);
	}
	public Diploid(Haploid key, Genomap value) {
		super(Chromosome.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Diploid(Diploid parent) {
		super(parent);
	}
	public Diploid(Diploid parent, Haploid key, Genomap value) {
		super(Chromosome.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Diploid(Diploid root, Parity parity) {
		super(root, parity);
	}
	public Diploid(Diploid root, Parity parity, Haploid key, Genomap value) {
		super(Chromosome.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Genomap, Haploid> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		Entry<Hypercube,Hyperchain> entry = getKey().comparator().getSource();
		comparator((Genomap) entry, (Haploid) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Hypercube) {
					Hypercube key = (Hypercube) e.getKey();
					Hyperchain value = (Hyperchain) e.getValue();
					getValue().putValue(key, value);
				}
				break;
			case LISTEN:
				if(e.getSource() instanceof Haploid) {
					getKey().comparator().compare((Haploid) e.getKey(), getValue());
					getValue().comparator().compare((Genomap) e.getValue(), getKey());
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
//				if(e.getSource() instanceof Diploid) { 
//					Diploid entry = (Diploid) e.getSource();
//					entry.permuteChild(call(), get());
//				}
//				break;
			case TRANSFER:
				if(e.getSource() instanceof Diploid) {
					Diploid entry = (Diploid) e.getSource();
					entry.release();
				}
				break;
			default:
				break;
			}
		}
	}
	public synchronized void run() {
		Enumerator<Haploid> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}