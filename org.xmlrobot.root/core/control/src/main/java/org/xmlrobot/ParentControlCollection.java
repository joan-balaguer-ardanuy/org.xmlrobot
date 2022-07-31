package org.xmlrobot;

import hyperspace.XML;
import hyperspace.recurrent.Hypercollection;

public class ParentControlCollection extends Hypercollection<ParentControl> {

	private static final long serialVersionUID = 3367035919464426851L;

	public ParentControlCollection() {
	}
	public ParentControlCollection(XML message) {
		super(message);
	}
	public ParentControlCollection(Class<? extends ParentControlCollection> antitype, XML message) {
		super(ParentControlCollection.class, antitype, message);
	}
	public ParentControlCollection(Class<? extends ParentControlCollection> antitype, Hypercollection<ParentControl> root, Hypercollection<ParentControl> stem, XML message, ParentControl element) {
		super(antitype, root, stem, message, element);
	}
	public ParentControlCollection(Class<? extends ParentControlCollection> antitype, Hypercollection<ParentControl> parent, XML message, ParentControl element) {
		super(antitype, parent, message, element);
	}
	public ParentControlCollection(Hypercollection<ParentControl> root, Hypercollection<ParentControl> stem, XML message) {
		super(root, stem, message);
	}
	public ParentControlCollection(Hypercollection<ParentControl> parent, XML message) {
		super(parent, message);
	}

}
