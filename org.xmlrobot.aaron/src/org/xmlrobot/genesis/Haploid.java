/**
 * 
 */
package org.xmlrobot.genesis;

import org.xmlrobot.Entry;
import org.xmlrobot.Listener;
import org.xmlrobot.Parity;
import org.xmlrobot.event.Tachyon;

/**
 * @author joan
 *
 */
public final class Haploid 
	extends Hyperchain<Hyperinteger,Hyperstring> {

	/**
	 * -8081218404976874317L
	 */
	private static final long serialVersionUID = -8081218404976874317L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getName()
	 */
	@Override
	public java.lang.String getName() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer,Character> listener : getKey()) {
			sb.append(listener.getName());
		}
		return sb.toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getKey()
	 */
	@Override
	public Hyperinteger getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setKey(java.lang.Object)
	 */
	@Override
	public Hyperinteger setKey(Hyperinteger key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getValue()
	 */
	@Override
	public Hyperstring getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setValue(java.lang.Object)
	 */
	@Override
	public Hyperstring setValue(Hyperstring value) {
		return super.setValue(value);
	}
	
	/**
	 * {@link Haploid} default class constructor.
	 */
	public Haploid() {
		super();
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperinteger} the key
	 */
	public Haploid(Hyperinteger key) {
		super(Haploid.class, Parity.XX, key);
		key.setListener(this);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperinteger} the key
	 * @param value {@link Hyperstring} the value
	 */
	public Haploid(Hyperinteger key, Hyperstring value) {
		super(Haploid.class, Genomap.class, Parity.XX, key, value);
		key.setListener(this);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param god {@link Haploid} the parent
	 * @param key {@link Hyperinteger} the key
	 */
	public Haploid(Haploid parent, Hyperinteger key) {
		super(parent, key);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param antitype {@link Class} the antitype
	 * @param god {@link Haploid} the parent
	 * @param key {@link Hyperinteger} the key
	 * @param value {@link Hyperstring} the value
	 */
	public Haploid(Haploid parent, Hyperinteger key, Hyperstring value) {
		super(Genomap.class, parent, key, value);
		key.setListener(this);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param root {@link Haploid} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperinteger} the key
	 */
	public Haploid(Haploid root, Parity gen, Hyperinteger key) {
		super(root, gen, key);
		key.setListener(this);
	}
	/**
	 * {@link Haploid} class constructor.
	 * @param root {@link Haploid} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Hyperinteger} the key
	 * @param value {@link Hyperstring} the value
	 */
	public Haploid(Haploid root, Parity gen, Hyperinteger key, Hyperstring value) {
		super(Genomap.class, root, gen, key, value);
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
			if(event.getSource() instanceof Hyperinteger) {
				System.out.println("Haploid GENESIS: " + event.getName());
				Hyperinteger entry = (Hyperinteger) event.getSource();
				putValue(entry, (Hyperstring) entry.getChild());
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Haploid) {
				Haploid entry = (Haploid) event.getSource();
				call().push(this, new Tachyon<>(entry));
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Haploid) {
				Haploid entry = (Haploid) event.getSource();
				entry.clear();
				pushChild(entry, entry.getChild());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Hyperspace#run()
	 */
	@Override
	public void run() {
		for(Entry<Integer,Character> entry : getKey()) {
			entry.run();
		}
		super.run();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.hyperspace.Recursion)
	 */
	@Override
	public int compareTo(Entry<Hyperstring,Hyperinteger> o) {
		getKey().comparator(null);
		getKey().comparator().compare(getKey(), o.getKey());
		Hyperinteger key = (Hyperinteger) getKey().comparator().source();
		comparator(key, (Hyperstring) key.getChild());
		return 0;
	}
}