package org.xmlrobot.placeholder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.placeholder.html.AbstractHtml;
import org.xmlrobot.placeholder.html.Element;

@XmlRootElement
public final class Html extends AbstractHtml {

	/**
	 * -5625666546941269503L
	 */
	private static final long serialVersionUID = -5625666546941269503L;

	Element element;

	@XmlElement
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}

	public Html() {
		super();
	}
	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return null;
	}
}