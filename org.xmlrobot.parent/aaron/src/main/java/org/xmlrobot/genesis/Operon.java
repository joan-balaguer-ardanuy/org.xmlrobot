package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Operon extends Screw<Ribosome,Tetraploid> {

	private static final long serialVersionUID = -5797528494294094608L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<org.xmlrobot.Entry<Ribosome,Tetraploid>> en = enumerator();
		while(en.hasMoreElements()) {
			org.xmlrobot.Entry<Ribosome,Tetraploid> entry = en.nextElement();
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Ribosome getKey() {
		return super.getKey();
	}
	@Override
	public Ribosome setKey(Ribosome key) {
		return super.setKey(key);
	}
	@Override
	public Tetraploid getValue() {
		return super.getValue();
	}
	@Override
	public Tetraploid setValue(Tetraploid value) {
		return super.setValue(value);
	}
	@XmlElement
	public Operon getEntry() {
		return call() == getRoot() ? null : (Operon) call();
	}
	
	public Operon() {
		this(Polyploid.class, Parity.random());
	}
	public Operon(Parity parity) {
		super(parity);
	}
	public Operon(Class<Polyploid> childClass, Parity parity) {
		super(childClass, parity);
	}
	public Operon(Operon parent) {
		super(parent);
	}
	public Operon(Operon parent, Ribosome key, Tetraploid value) {
		super(Polyploid.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Operon(Operon root, Parity parity) {
		super(root, parity);
	}
	public Operon(Operon root, Parity parity, Ribosome key, Tetraploid value) {
		super(Polyploid.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	@Override
	public int compareTo(org.xmlrobot.Entry<Tetraploid, Ribosome> o) {
		getKey().comparator(new Tetraploid()).compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Diploid, Chromosome> entry = getKey().comparator().source();
		comparator((Tetraploid) entry, (Ribosome) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Operon) {
			Operon entry = (Operon) e.getSource();
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
		} else if(e.getSource() instanceof Ribosome) {
			Ribosome entry = (Ribosome) e.getSource();
			switch (e.getCommand()) {
			case TRANSFER:
				if(!isRoot()) {
					getKey().comparator(new Tetraploid()).compare(entry, getValue());
					Tetraploid source = (Tetraploid) getKey().comparator().source();
					putKey(source, (Ribosome) source.getChild());
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