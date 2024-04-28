package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Ribosome extends Screw<Chromosome,Diploid> {
	
	private static final long serialVersionUID = -126921398816799L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(org.xmlrobot.Entry<Chromosome,Diploid> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Chromosome getKey() {
		return super.getKey();
	}
	@Override
	public Chromosome setKey(Chromosome key) {
		return super.setKey(key);
	}
	@Override
	public Diploid getValue() {
		return super.getValue();
	}
	@Override
	public Diploid setValue(Diploid value) {
		return super.setValue(value);
	}
	@XmlElement
	public Ribosome getEntry() {
		return call() == getRoot() ? null : (Ribosome) call();
	}
	
	public Ribosome() {
		super();
	}
	public Ribosome(Parity parity) {
		super(parity);
	}
	public Ribosome(Chromosome key, Diploid value) {
		super(Tetraploid.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Ribosome(Ribosome parent) {
		super(parent);
	}
	public Ribosome(Ribosome parent, Chromosome key, Diploid value) {
		super(Tetraploid.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Ribosome(Ribosome root, Parity parity) {
		super(root, parity);
	}
	public Ribosome(Ribosome root, Parity parity, Chromosome key, Diploid value) {
		super(Tetraploid.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Diploid, Chromosome> o) {
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Haploid, Genomap> entry = getKey().comparator().getSource();
		comparator((Diploid) entry, (Chromosome) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Haploid) {
					Haploid key = (Haploid) e.getKey();
					Genomap value = (Genomap) e.getValue();
					getValue().putValue(key, value);
				}
				break;
			case LISTEN:
				if(e.getSource() instanceof Chromosome) {
					getKey().comparator().compare((Chromosome) e.getSource(), getValue());
					getValue().comparator().compare((Diploid) e.getValue(), getKey());
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
//				if(e.getSource() instanceof Ribosome) {
//					Ribosome entry = (Ribosome) e.getSource();
//					entry.permuteChild(call(), get());
//				}
//				break;
			case TRANSFER:
				if(e.getSource() instanceof Ribosome) {
					Ribosome entry = (Ribosome) e.getSource();
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
		Enumerator<Chromosome> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}