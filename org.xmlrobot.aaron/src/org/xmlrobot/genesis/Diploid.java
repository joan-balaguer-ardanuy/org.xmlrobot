package org.xmlrobot.genesis;

import org.xmlrobot.Listener;
import org.xmlrobot.Parity;
import org.xmlrobot.Entry;
import org.xmlrobot.event.Tachyon;

public class Diploid extends Hyperchain<Haploid,Genomap> {

	/**
	 * 248180961924818182L
	 */
	private static final long serialVersionUID = 248180961924818182L;

	@Override
	public String getName() {
		return null;
	}

	/**
	 * {@link Diploid} default class constructor.
	 */
	public Diploid() {
		super();
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param key {@link Haploid} the key
	 */
	public Diploid(Haploid key) {
		super(Diploid.class, Parity.XX, key);
		key.setListener(this);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Diploid(Haploid key, Genomap value) {
		super(Diploid.class, Cromosoma.class, Parity.XX, key, value);
		key.setListener(this);
		setListener(getChild());
		getChild().setListener(this);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param parent {@link Diploid} the parent
	 * @param key {@link Haploid} the key
	 */
	public Diploid(Diploid parent, Haploid key) {
		super(parent, key);
		key.setListener(this);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param parent {@link Diploid} the parent
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Diploid(Diploid parent, Haploid key, Genomap value) {
		super(Cromosoma.class, parent, key, value);
		key.setListener(this);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param root {@link Diploid} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Haploid} the key
	 */
	public Diploid(Diploid root, Parity gen, Haploid key) {
		super(root, gen, key);
		key.setListener(this);
	}
	/**
	 * {@link Diploid} class constructor.
	 * @param root {@link Diploid} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Haploid} the key
	 * @param value {@link Genomap} the value
	 */
	public Diploid(Diploid root, Parity gen, Haploid key, Genomap value) {
		super(Cromosoma.class, root, gen, key, value);
		key.setListener(this);
	}
	
	@Override
	public void event(Listener sender, Tachyon<?, ?> event) {
		super.event(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Haploid) {
				System.out.println("Diploid GENESIS: " + event.getName());
				execute(event.getSource());
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
		for(Entry<Hyperinteger,Hyperstring> entry : getKey()) {
			entry.run();
		}
		super.run();
	}

	@Override
	public int compareTo(Entry<Genomap, Haploid> child) {
		// TODO Auto-generated method stub
		return 0;
	}
}
