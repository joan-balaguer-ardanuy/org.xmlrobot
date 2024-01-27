package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Chromosome extends Screw<Genomap, Haploid> {

	private static final long serialVersionUID = 4135008320029372246L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Genomap,Haploid>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Genomap,Haploid> entry = en.nextElement();
			stringBuilder.append(entry.getKey().getName());
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
		this(Diploid.class, Parity.random());
	}
	public Chromosome(Parity parity) {
		super(parity);
	}
	public Chromosome(Class<Diploid> childClass, Parity parity) {
		super(childClass, parity);
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
		getKey().comparator(new Haploid()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Hyperchain, Hypercube> entry = getKey().comparator().source();
		comparator((Haploid) entry, (Genomap) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Chromosome) {
			Chromosome entry = (Chromosome) e.getSource();
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
		} else if(e.getSource() instanceof Genomap) {
			Genomap entry = (Genomap) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Haploid()).compare(entry, getValue());
					Haploid source = (Haploid) getKey().comparator().source();
					getStem().putValue(source, (Genomap) source.getChild());
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