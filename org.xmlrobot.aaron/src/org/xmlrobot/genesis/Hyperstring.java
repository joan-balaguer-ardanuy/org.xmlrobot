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
public final class Hyperstring 
	extends Hypercube<Character,Integer> {

	/**
	 * 7876576585717776247L
	 */
	private static final long serialVersionUID = 7876576585717776247L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getName()
	 */
	@Override
	public java.lang.String getName() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Character,Integer> entry : this) {
			sb.append(entry.getKey());
		}
		return sb.toString();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getKey()
	 */
	@Override
	public Character getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setKey(java.lang.Object)
	 */
	@Override
	public Character setKey(Character key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getValue()
	 */
	@Override
	public Integer getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setValue(java.lang.Object)
	 */
	@Override
	public Integer setValue(Integer value) {
		return super.setValue(value);
	}
	/**
	 * Returns the par.
	 * @return the par
	 */
	public Hyperstring getEntry() {
		return isEmpty() ? null : (Hyperstring) getPreviousParent();
	}
	
	/**
	 * {@link Hyperstring} default class constructor.
	 */
	public Hyperstring() {
		super();
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param key {@link Character} the key980
	 */
	public Hyperstring(Character key) {
		super(Hyperstring.class, Parity.XY, key);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperstring(Character key, Integer value) {
		super(Hyperstring.class, Hyperinteger.class, Parity.XY, key, value);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param parent {@link Hyperstring} the parent
	 * @param key {@link Character} the key
	 */
	public Hyperstring(Hyperstring parent, Character key) {
		super(parent, key);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param parent {@link Hyperstring} the parent
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperstring(Hyperstring parent, Character key, Integer value) {
		super(Hyperinteger.class, parent, key, value);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param root {@link Hyperstring} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Character} the key
	 */
	public Hyperstring(Hyperstring root, Parity gen, Character key) {
		super(root, gen, key);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param root {@link Hyperstring} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Character} the key
	 * @param value {@link Integer} the value
	 */
	public Hyperstring(Hyperstring root, Parity gen, Character key, Integer value) {
		super(Hyperinteger.class, root, gen, key, value);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#mass(org.xmlrobot.MassListener, org.xmlrobot.event.Tachyon)
	 */
	@Override
	public void event(Listener sender, Tachyon<?,?> event) {
		super.event(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
//			System.out.println("Hypercube GENESIS: " + event.getName() + " class: " + event.getSource().getClass());
			if(event.getSource() instanceof Hyperstring) {
				Hyperstring entry = (Hyperstring) event.getSource();
//				System.out.println(getName());
				entry.setRoot(this);
				entry.setListener(this);
				entry.setStem(getStem());
				entry.getChild().setListener(getStem());
				pushChild(entry, entry.getChild());
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Hyperstring) {
				spin();
				Hyperstring entry = (Hyperstring) event.getSource();
				call().push(this, new Tachyon<>(entry));
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperstring) {
				Hyperstring entry = (Hyperstring) event.getSource();
				entry.clear();
//				pushChild(entry, entry.getChild());
//				putValue(entry.getKey(), entry.getValue());
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
		try {
//			System.out.println("Hypercube run(), state: " + getCommand());
			Thread.sleep(getValue());
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			super.run();
		}
	}
	@Override
	public int compareTo(org.xmlrobot.Entry<Integer,Character> o) {
		System.out.println("hypercube compare: " + getKey() + " to: " + o.getValue());
		int cmp = getKey().compareTo(o.getValue());
		if(cmp < 0) {
			comparator(getKey(), getValue());
		}
		else {
			comparator(o.getValue(), o.getKey());
		}
		return cmp;
	}
}