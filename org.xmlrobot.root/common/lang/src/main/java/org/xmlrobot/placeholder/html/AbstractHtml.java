package org.xmlrobot.placeholder.html;

import javax.xml.bind.annotation.XmlElement;

import org.xmlrobot.placeholder.string.AbstractString;

public abstract class AbstractHtml extends AbstractString {

	/**
	 * -6047806638957555356L
	 */
	private static final long serialVersionUID = -6047806638957555356L;

	String XPath;

	@XmlElement
	public String getXPath() {
		return XPath;
	}
	public void setXPath(String xPath) {
		this.XPath = xPath;
	}
	
	public AbstractHtml() {
		super();
	}
}