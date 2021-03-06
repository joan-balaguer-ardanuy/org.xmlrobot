package org.xmlrobot.configuration;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import hyperspace.Message;
import hyperspace.XML;

/**
 * Service QName {@link XML} {@link Message} class.
 * It contains all the necessary data to instance a
 * {@link javax.xml.namespace.QName}. It encapsulates a 
 * namespaceURI, a localPart and a prefix. Look at
 * {@link org.xmlrobot.configuration.adapter.ConnectionQNameAdapter} 
 * to see how this object is marshalled and unmarshalled 
 * by JAXB framework.
 * @author joan
 *
 */
@XmlRootElement
public final class ConnectionQName extends XML {

	/**
	 * 5243372154742756420Ls
	 */
	private static final long serialVersionUID = 5243372154742756420L;

	/**
	 * The namespace URI.
	 */
	String namespaceURI;
	/**
	 * The local part.
	 */
	String localPart;
	/**
	 * The prefix.
	 */
	String prefix;
	
	/**
	 * Returns the namespace URI XML attribute.
	 * @return the namespace URI XML attribute.
	 */
	@XmlAttribute
	public String getNamespaceURI() {
		return namespaceURI;
	}
	/** 
	 * Sets the namespace URI XML attribute.
	 * @param namespaceURI the namespace URI XML attribute.
	 */
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	/**
	 * Returns the local part XML attribute.
	 * @return the local part XML attribute.
	 */
	@XmlAttribute
	public String getLocalPart() {
		return localPart;
	}
	/**
	 * Sets the local part XML attribute.
	 * @param localPart the local part XML attribute.
	 */
	public void setLocalPart(String localPart) {
		this.localPart = localPart;
	}

	/**
	 * Returns the prefix XML attribute.
	 * @return the prefix XML attribute.
	 */
	@XmlAttribute
	public String getPrefix() {
		return prefix;
	}
	/**
	 * Sets the prefix XML attribute.
	 * @param prefix the prefix XML attribute.
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * {@link ConnectionQName} default class constructor.
	 */
	public ConnectionQName() {
		super();
	}
	@Override
	public ConnectionQName clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
