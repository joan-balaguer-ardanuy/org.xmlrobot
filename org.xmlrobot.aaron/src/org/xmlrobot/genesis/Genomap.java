/**
 * 
 */
package org.xmlrobot.genesis;

import org.xmlrobot.Listener;
import org.xmlrobot.Parity;
import org.xmlrobot.event.Tachyon;

/**
 * @author joan
 *
 */
public final class Genomap 
	extends Hypercube<Hyperstring,Hyperinteger> {

	/**
	 * -2840096610728389071L
	 */
	private static final long serialVersionUID = -2840096610728389071L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getName()
	 */
	@Override
	public java.lang.String getName() {
		StringBuilder sb = new StringBuilder();
		for(org.xmlrobot.Entry<Character,Integer> entry : getKey()) {
			sb.append(entry.getName());
		}
		return sb.toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getKey()
	 */
	@Override
	public Hyperstring getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setKey(java.lang.Object)
	 */
	@Override
	public Hyperstring setKey(Hyperstring key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getValue()
	 */
	@Override
	public Hyperinteger getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setValue(java.lang.Object)
	 */
	@Override
	public Hyperinteger setValue(Hyperinteger value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Genomap} default class constructor.
	 */
	public Genomap() {
		super();
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperstring} the key
	 */
	public Genomap(Hyperstring key) {
		super(Genomap.class, Parity.XX, key);
		key.setListener(this);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperstring} the key
	 * @param value {@link Hyperinteger} the value
	 */
	public Genomap(Hyperstring key, Hyperinteger value) {
		super(Genomap.class, Haploid.class, Parity.XX, key, value);
		key.setListener(this);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param key {@link Hyperstring} the key
	 * @param parent {@link Genomap} the parent
	 */
	public Genomap(Genomap parent, Hyperstring key) {
		super(parent, key);
		key.setListener(this);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param key {@link Hyperstring} the key
	 * @param value {@link Hyperinteger} the value
	 * @param parent {@link Genomap} the parent
	 */
	public Genomap(Genomap parent, Hyperstring key, Hyperinteger value) {
		super(Haploid.class, parent, key, value);
		key.setListener(this);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param root {@link Genomap} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperstring} the key
	 */
	public Genomap(Genomap root, Parity gen, Hyperstring key) {
		super(root, gen, key);
		key.setListener(this);
	}
	/**
	 * {@link Genomap} class constructor.
	 * @param root {@link Genomap} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperstring} the key
	 * @param value {@link Hyperinteger} the value
	 */
	public Genomap(Genomap root, Parity gen, Hyperstring key, Hyperinteger value) {
		super(Haploid.class, root, gen, key, value);
		key.setListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#mass(org.xmlrobot.MassListener, org.xmlrobot.event.Tachyon)
	 */
	@Override
	public void event(Listener sender, Tachyon<?,?> event) {
		super.event(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Hyperstring) {
				System.out.println("Genomap GENESIS: " + event.getName());
				Hyperstring entry = (Hyperstring) event.getSource();
				putValue(entry, (Hyperinteger) entry.getChild());
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Genomap) {
				Genomap entry = (Genomap) event.getSource();
				call().push(this, new Tachyon<>(entry));
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Genomap) {
				Genomap entry = (Genomap) event.getSource();
				entry.clear();
				pushChild(entry, entry.getChild());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Genesis#run()
	 */
	@Override
	public void run() {
		for(org.xmlrobot.Entry<Character,Integer> entry : getKey()) {
			entry.run();
		}
		super.run();
	}

	@Override
	public int compareTo(org.xmlrobot.Entry<Hyperinteger,Hyperstring> o) {
		getKey().comparator(null);
		getKey().comparator().compare(getKey(), o.getKey());
		Hyperstring key = (Hyperstring) getKey().comparator().source();
		comparator(key, (Hyperinteger) key.getChild());
		return 0;
	}
}