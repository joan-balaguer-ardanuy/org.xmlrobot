package org.xmlrobot.configuration;

import org.xmlrobot.DocumentLibrary;
import org.xmlrobot.datatype.DataSource;

import hyperspace.genesis.Hypercube;

public class SourceDocument extends Hypercube<DataSource,DocumentLibrary> {

	private static final long serialVersionUID = 5336785334680110244L;
	
	public SourceDocument() {
	}
	public SourceDocument(String name) {
		super(name);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, String name, DataSource key, DocumentLibrary value) {
		super(SourceDocument.class, antitype, name, key, value);
	}
	public SourceDocument(SourceDocument parent) {
		super(parent);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, SourceDocument parent, DataSource key, DocumentLibrary value) {
		super(antitype, parent, key, value);
	}
	public SourceDocument(SourceDocument root, String name) {
		super(root, name);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, SourceDocument root, String name, DataSource key, DocumentLibrary value) {
		super(DocumentSource.class, root, name, key, value);
	}
}