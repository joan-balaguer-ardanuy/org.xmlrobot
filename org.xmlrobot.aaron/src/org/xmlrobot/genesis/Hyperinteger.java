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
public final class Hyperinteger 
	extends Hyperchain<Integer,Character> {

	/**
	 * 117696279492654338L
	 */
	private static final long serialVersionUID = 117696279492654338L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getKey()
	 */
	@Override
	public Integer getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setKey(java.lang.Object)
	 */
	@Override
	public Integer setKey(Integer key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#getValue()
	 */
	@Override
	public Character getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Individuality#setValue(java.lang.Object)
	 */
	@Override
	public Character setValue(Character value) {
		return super.setValue(value);
	}
	/**
	 * Returns the entry.
	 * @return the entry
	 */
	public Hyperinteger getEntry() {
		return isEmpty() ? null : (Hyperinteger) getPreviousParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getName()
	 */
	public java.lang.String getName() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer,Character> listener : this) {
			sb.append(listener.getValue());
		}
		return sb.toString();
	}
	/**
	 * {@link Hyperinteger} default class constructor.
	 */
	public Hyperinteger() {
		super();
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param key {@link Integer} the key
	 */
	public Hyperinteger(Integer key) {
		super(Hyperinteger.class, Parity.XX, key);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperinteger(Integer key, Character value) {
		super(Hyperinteger.class, Hyperstring.class, Parity.XX, key, value);
//		addMassListener(getChild());
//		getChild().addMassListener(this);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param parent {@link Hyperinteger} the parent
	 * @param key {@link Integer} the key
	 */
	public Hyperinteger(Hyperinteger parent, Integer key) {
		super(parent, key);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param parent {@link Hyperinteger} the parent
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperinteger(Hyperinteger parent, Integer key, Character value) {
		super(Hyperstring.class, parent, key, value);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param root {@link Hyperinteger} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Integer} the key
	 */
	public Hyperinteger(Hyperinteger root, Parity gen, Integer key) {
		super(root, gen, key);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param root {@link Hyperinteger} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Integer} the key
	 * @param value {@link Character} the value
	 */
	public Hyperinteger(Hyperinteger root, Parity gen, Integer key, Character value) {
		super(Hyperstring.class, root, gen, key, value);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#mass(org.xmlrobot.MassListener, org.xmlrobot.event.Tachyon)
	 */
	@Override
	public void event(Listener sender, Tachyon<?,?> event) {
		super.event(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
//			System.out.println("Hyperchain GENESIS: " + event.getName() + " class: " + event.getSource().getClass());
			if(event.getSource() instanceof Hyperinteger) {
				Hyperinteger entry = (Hyperinteger) event.getSource();
//				System.out.println(getName());
				entry.setRoot(this);
				entry.setListener(this);
				entry.setStem(getStem());
				entry.getChild().setListener(getStem());
				pushChild(entry, entry.getChild());
			}
			break;
		case LISTEN:
			if(event.getSource() instanceof Hyperinteger) {
				spin();
				Hyperinteger entry = (Hyperinteger) event.getSource();
				call().push(this, new Tachyon<>(entry));
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Hyperinteger) {
				Hyperinteger entry = (Hyperinteger) event.getSource();
				entry.clear();
//				pushChild(entry, entry.getChild());
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
		try {
//			System.out.println("Hyperchain run(), state: " + getCommand());
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
	public int compareTo(Entry<Character,Integer> o) {
		System.out.println("hyperchain compare: " + getValue() + " to: " + o.getKey());
		int cmp = getKey().compareTo(o.getValue());
		if(cmp > 0) {
			comparator(getKey(), getValue());
		}
		else {
			comparator(o.getValue(), o.getKey());
		}
		return cmp;
	}
}