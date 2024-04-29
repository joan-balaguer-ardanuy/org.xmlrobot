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
public final class Tetraploid extends ScrewNut<Diploid, Chromosome> {

	private static final long serialVersionUID = 5662230592227137983L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Diploid,Chromosome> entry : this) {
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Diploid getKey() {
		return super.getKey();
	}
	@Override
	public Diploid setKey(Diploid key) {
		return super.setKey(key);
	}
	@Override
	public Chromosome getValue() {
		return super.getValue();
	}
	@Override
	public Chromosome setValue(Chromosome value) {
		return super.setValue(value);
	}
	@XmlElement
	public Tetraploid getEntry() {
		return call() == getRoot() ? null : (Tetraploid) call();
	}
	
	public Tetraploid() {
		super();
	}
	public Tetraploid(Parity parity) {
		super(parity);
	}
	public Tetraploid(Diploid key, Chromosome value) {
		super(Ribosome.class, Parity.random(), key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Tetraploid(Tetraploid parent) {
		super(parent);
	}
	public Tetraploid(Tetraploid parent, Diploid key, Chromosome value) {
		super(Ribosome.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Tetraploid(Tetraploid root, Parity parity) {
		super(root, parity);
	}
	public Tetraploid(Tetraploid root, Parity parity, Diploid key, Chromosome value) {
		super(Ribosome.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Chromosome, Diploid> o) {
		getKey().comparator().compare(getKey(), o.getKey());
		Entry<Genomap,Haploid> entry = getKey().comparator().getSource();
		comparator((Chromosome) entry, (Diploid) entry.getChild());
		return 0;
	}
	@Override
	public void event(Object sender, EventArgs<?,?> e) {
		super.event(sender, e);
		if(sender.equals(getKey())) {
			switch (e.getCommand()) {
			case GENESIS:
				if(e.getSource() instanceof Chromosome) {
					Chromosome key = (Chromosome) e.getSource();
					putKey(key, (Diploid) key.getChild());
				}
				break;
			default:
				break;
			}
		} else {
			switch (e.getCommand()) {
			case LISTEN:
				if(e.getSource() instanceof Tetraploid) {
					comparator().compare((Tetraploid) e.getSource(), getStem());
					sendEvent(new EventArgs<>(comparator().getSource()));
				}
				break;
			case TRANSFER:
				if(e.getSource() instanceof Tetraploid) {
					Tetraploid entry = (Tetraploid) e.getSource();
					entry.release();
				}
				break;
			default:
				break;
			}
		}
	}
	public synchronized void run() {
		Enumerator<Diploid> en = enumerator();
		while(en.hasMoreElements()) {
			en.nextElement().run();
		}
		super.run();
	}
}