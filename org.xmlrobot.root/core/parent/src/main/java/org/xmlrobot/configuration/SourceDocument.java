package org.xmlrobot.configuration;

import org.xmlrobot.DocumentLibrary;
import org.xmlrobot.datatype.DataSource;

import hyperspace.genesis.Hypercube;

public class SourceDocument extends Hypercube<DataSource,DocumentLibrary> {

	private static final long serialVersionUID = 5336785334680110244L;
	
	public SourceDocument() {
	}
	public SourceDocument(Class<? extends SourceDocument> type, String name, DataSource key) {
		super(type, name, key);
	}
	public SourceDocument(Class<? extends SourceDocument> type, Class<? extends DocumentSource> antitype, String name, DataSource key, DocumentLibrary value) {
		super(type, antitype, name, key, value);
	}
	public SourceDocument(SourceDocument parent, DataSource key) {
		super(parent, key);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, SourceDocument parent, DataSource key, DocumentLibrary value) {
		super(antitype, parent, key, value);
	}
	public SourceDocument(SourceDocument root, String name, DataSource key) {
		super(root, name, key);
	}
	public SourceDocument(Class<? extends DocumentSource> antitype, SourceDocument root, String name, DataSource key, DocumentLibrary value) {
		super(antitype, root, name, key, value);
	}
}