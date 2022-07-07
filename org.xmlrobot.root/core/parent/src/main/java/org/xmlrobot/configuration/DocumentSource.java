package org.xmlrobot.configuration;

import org.xmlrobot.DocumentLibrary;
import org.xmlrobot.datatype.DataSource;

import hyperspace.genesis.Hyperchain;

public class DocumentSource extends Hyperchain<DocumentLibrary,DataSource> {

	private static final long serialVersionUID = -1263337942296251178L;
	
	public DocumentSource() {
		super();
	}
	public DocumentSource(Class<? extends DocumentSource> type, String name, DocumentLibrary key) {
		super(type, name, key);
	}
	public DocumentSource(Class<? extends DocumentSource> type, Class<? extends SourceDocument> antitype, String name, DocumentLibrary key, DataSource value) {
		super(type, antitype, name, key, value);
	}
	public DocumentSource(DocumentSource parent, DocumentLibrary key) {
		super(parent, key);
	}
	public DocumentSource(Class<? extends SourceDocument> antitype, DocumentSource parent, DocumentLibrary key, DataSource value) {
		super(antitype, parent, key, value);
	}
	public DocumentSource(DocumentSource root, String name, DocumentLibrary key) {
		super(root, name, key);
	}
	public DocumentSource(Class<? extends SourceDocument> antitype, DocumentSource root, String name, DocumentLibrary key, DataSource value) {
		super(antitype, root, name, key, value);
	}
}