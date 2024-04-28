package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.numbers.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public final class Operon extends Screw<Ribosome,Tetraploid> {

	private static final long serialVersionUID = -5797528494294094608L;
	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(org.xmlrobot.Entry<Ribosome,Tetraploid> entry : this) {
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
		super();
	}
	public Operon(Parity parity) {
		super(parity);
	}
	public Operon(Ribosome key, Tetraploid value) {
		super(Polyploid.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
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
		getKey().comparator().compare(getKey(), o.getKey());
		org.xmlrobot.Entry<Diploid, Chromosome> entry = getKey().comparator().getSource();
		comparator((Tetraploid) entry, (Ribosome) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Diploid) {
					Diploid key = (Diploid) e.getSource();
					Chromosome value = (Chromosome) e.getValue();
					getValue().putValue(key, value);
				}
				break;
			case LISTEN:
				if(e.getSource() instanceof Ribosome) {
					getKey().comparator().compare((Ribosome) e.getSource(), getValue());
					getValue().comparator().compare((Tetraploid) e.getValue(), getKey());
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
//				if(e.getSource() instanceof Operon) {
//					Operon entry = (Operon) e.getSource();
//					entry.permuteChild(call(), get());
//				}
//				break;
			case TRANSFER:
				if(e.getSource() instanceof Operon) {
					Operon entry = (Operon) e.getSource();
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
		Enumerator<Ribosome> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}