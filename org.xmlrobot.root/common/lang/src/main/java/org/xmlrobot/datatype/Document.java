package org.xmlrobot.datatype;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import hyperspace.XML;
import org.xmlrobot.content.ContentTypeRef;
import org.xmlrobot.unit.Action;

@XmlRootElement
public final class Document extends XML {

	/**
	 * -6444128980718357234L
	 */
	private static final long serialVersionUID = -6444128980718357234L;

	Action action;
	ContentTypeRef contentTypeRef;
	FieldRoot fieldRoot;
	Document document;

	@XmlElement
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
	@XmlElement
	public ContentTypeRef getContentTypeRef() {
		return contentTypeRef;
	}
	public void setContentTypeRef(ContentTypeRef contentTypeRef) {
		this.contentTypeRef = contentTypeRef;
	}
	
	@XmlElement
	public FieldRoot getFieldRoot() {
		return fieldRoot;
	}
	public void setFieldRoot(FieldRoot fieldRoot) {
		this.fieldRoot = fieldRoot;
	}
	
	@XmlElement
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}

	public Document() {
		super();
	}
	@Override
	public Document clone() {
		// TODO Auto-generated method stub
		return null;
	}
}