package org.xmlrobot.genesis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.xmlrobot.Entry;
import org.xmlrobot.EventArgs;
import org.xmlrobot.Parity;
import org.xmlrobot.recurrent.Enumerator;

@XmlRootElement
@XmlType(propOrder={"key", "value", "entry"})
public class Polyploid extends ScrewNut<Tetraploid,Ribosome> {

	private static final long serialVersionUID = 3697213256533673578L;

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		Enumerator<Entry<Tetraploid,Ribosome>> en = enumerator();
		while(en.hasMoreElements()) {
			Entry<Tetraploid,Ribosome> entry = en.nextElement();
			stringBuilder.append(entry.getKey().getName());
		}
		return stringBuilder.toString();
	}
	@Override
	public Tetraploid getKey() {
		return super.getKey();
	}
	@Override
	public Tetraploid setKey(Tetraploid key) {
		return super.setKey(key);
	}
	@Override
	public Ribosome getValue() {
		return super.getValue();
	}
	@Override
	public Ribosome setValue(Ribosome value) {
		return super.setValue(value);
	}
	@XmlElement
	public Polyploid getEntry() {
		return call() == getRoot() ? null : (Polyploid) call();
	}
	
	public Polyploid() {
		this(Operon.class, Parity.random());
	}
	public Polyploid(Parity parity) {
		super(parity);
	}
	public Polyploid(Class<Operon> childClass, Parity parity) {
		super(childClass, parity);
	}
	public Polyploid(Polyploid parent) {
		super(parent);
	}
	public Polyploid(Polyploid parent, Tetraploid key, Ribosome value) {
		super(Operon.class, parent, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	public Polyploid(Polyploid root, Parity parity) {
		super(root, parity);
	}
	public Polyploid(Polyploid root, Parity parity, Tetraploid key, Ribosome value) {
		super(Operon.class, root, parity, key, value);
		key.addEventListener(this);
		value.addEventListener(getChild());
	}
	
	@Override
	public int compareTo(Entry<Ribosome, Tetraploid> o) {
		getKey().comparator(new Ribosome()).compare(getKey(), o.getKey());
		Entry<Chromosome,Diploid> entry = getKey().comparator().source();
		comparator((Ribosome) entry, (Tetraploid) entry.getChild());
		return 0;
	}
	@Override
	public void event(EventArgs e) {
		super.event(e);
		if(e.getSource() instanceof Chromosome) {
			Chromosome entry = (Chromosome) e.getSource();
			switch (e.getCommand()) {
			case GENESIS:
				if(isRoot()) {
					Ribosome ribosome = new Ribosome();
					ribosome.putValue(entry, (Diploid) entry.getChild());
					sendEvent(new EventArgs(ribosome));
				}
				break;
			default:
				break;
			}
		} 
		else if(e.getSource() instanceof Tetraploid) {
			Tetraploid entry = (Tetraploid) e.getSource();
			switch (e.getCommand()) {
			case LISTEN:
				if (!isRoot()) {
					getKey().comparator(new Ribosome()).compare(entry, getValue());
					sendEvent(new EventArgs(getKey().comparator().source()));
				}
				break;
			default:
				break;
			}
		}
	}
	public void run() {
		getValue().run();
		super.run();
	}
}