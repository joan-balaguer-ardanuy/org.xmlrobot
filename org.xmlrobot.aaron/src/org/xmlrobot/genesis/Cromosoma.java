package org.xmlrobot.genesis;

import org.xmlrobot.Listener;
import org.xmlrobot.Parity;
import org.xmlrobot.event.Tachyon;

public class Cromosoma extends Hypercube<Genomap,Haploid> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4699545219864578189L;

	@Override
	public String getName() {
		return null;
	}
	
	/**
	 * {@link Cromosoma} default class constructor.
	 */
	public Cromosoma() {
		super();
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param gen {@link Parity} the gender
	 * @param key {@link Genomap} the key
	 */
	public Cromosoma(Genomap key) {
		super(Cromosoma.class, Parity.XX, key);
		key.setListener(this);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param gen {@link Parity} the gender
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public Cromosoma(Genomap key, Haploid value) {
		super(Cromosoma.class, Diploid.class, Parity.XX, key, value);
		key.setListener(this);
		
		setListener(getChild());
		getChild().setListener(this);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param key {@link Genomap} the key
	 * @param parent {@link Cromosoma} the parent
	 */
	public Cromosoma(Cromosoma parent, Genomap key) {
		super(parent, key);
		key.setListener(this);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 * @param parent {@link Cromosoma} the parent
	 */
	public Cromosoma(Cromosoma parent, Genomap key, Haploid value) {
		super(Diploid.class, parent, key, value);
		key.setListener(this);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param root {@link Cromosoma} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Genomap} the key
	 */
	public Cromosoma(Cromosoma root, Parity gen, Genomap key) {
		super(root, gen, key);
		key.setListener(this);
	}
	/**
	 * {@link Cromosoma} class constructor.
	 * @param root {@link Cromosoma} the root
	 * @param gen {@link Parity} the gender
	 * @param key {@link Genomap} the key
	 * @param value {@link Haploid} the value
	 */
	public Cromosoma(Cromosoma root, Parity gen, Genomap key, Haploid value) {
		super(Diploid.class, root, gen, key, value);
		key.setListener(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Genesis#run()
	 */
	@Override
	public void run() {
		for(org.xmlrobot.Entry<Hyperstring,Hyperinteger> entry : getKey()) {
			entry.run();
		}
		super.run();
	}
	
	@Override
	public void event(Listener sender, Tachyon<?, ?> event) {
		super.event(sender, event);
		
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Genomap) {
				execute(event.getSource());
			}
			break;
		default:
			break;
		}
	}

	@Override
	public int compareTo(org.xmlrobot.Entry<Haploid, Genomap> child) {
		// TODO Auto-generated method stub
		return 0;
	}
}
