package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.numbers.Enumerator;

import org.xmlrobot.Parity;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Chromosome extends Screw<Genomap, Haploid> {

	private static final long serialVersionUID = 4135008320029372246L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Genomap,Haploid>> en = enumerator();
		while(en.hasMoreElements()) {
			stringBuilder.append(en.nextElement().getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Genomap getKey() {
		return super.getKey();
	}
	@Override
	public Genomap setKey(Genomap key) {
		return super.setKey(key);
	}
	@Override
	public Haploid getValue() {
		return super.getValue();
	}
	@Override
	public Haploid setValue(Haploid value) {
		return super.setValue(value);
	}
	@XmlElement
	public Chromosome getEntry() {
		return call() == getRoot() ? null : (Chromosome) call();
	}
	
	public Chromosome() {
		super();
	}
	public Chromosome(Parity parity) {
		super(parity);
	}
	public Chromosome(Genomap key, Haploid value) {
		super(Diploid.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Chromosome(Chromosome parent) {
		super(parent);
	}
	public Chromosome(Chromosome parent, Genomap key, Haploid value) {
		super(Diploid.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Chromosome(Chromosome root, Parity parity) {
		super(root, parity);
	}
	public Chromosome(Chromosome root, Parity parity, Genomap key, Haploid value) {
		super(Diploid.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(org.xmlrobot.Entry<Haploid, Genomap> o) {
		getKey().comparator().compare(o.getValue(), getValue());
		org.xmlrobot.Entry<Hyperchain, Hypercube> entry = getKey().comparator().getSource();
		comparator((Haploid) entry, (Genomap) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs e) {
		super.event(sender, e);
		switch (e.getCommand()) {
		case GENESIS:
			if(sender.equals(getKey())) {
				if (e.getSource() instanceof Genomap) {
					Genomap entry = (Genomap) e.getSource();
					System.out.println("Genomap");
					putValue(entry, (Haploid) entry.getChild());
				}
			}
			break;
		case LISTEN:
			if(e.getSource() instanceof Chromosome) {
				comparator().compare((Chromosome) e.getSource(), getStem());
				sendEvent(new EventArgs(comparator().getSource()));
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