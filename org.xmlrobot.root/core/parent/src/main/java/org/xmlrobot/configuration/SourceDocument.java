package org.xmlrobot.configuration;

import org.xmlrobot.DocumentLibrary;
import org.xmlrobot.datatype.DataSource;

import hyperspace.XML;
import hyperspace.genesis.Hypercube;

public class SourceDocument extends Hypercube<DataSource,DocumentLibrary> {

	private static final long serialVersionUID = 5336785334680110244L;
	
	public SourceDocument() {
	}
	public SourceDocument(XML name) {
		super(name);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, XML name) {
		super(SourceDocument.class, antitype, name);
	}
	public SourceDocument(SourceDocument parent) {
		super(parent);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, SourceDocument parent, DataSource key, DocumentLibrary value) {
		super(antitype, parent, key, value);
	}
	public SourceDocument(SourceDocument root, XML name) {
		super(root, name);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, SourceDocument root, XML name, DataSource key, DocumentLibrary value) {
		super(DocumentSource.class, root, name, key, value);
	}
}