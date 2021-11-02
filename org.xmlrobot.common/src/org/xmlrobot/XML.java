/**
 * 
 */
package org.xmlrobot;

/**
 * The theory of XML.
 * @author joan
 */
public interface XML
	extends Entry<Integer,Integer>, CharSequence, Appendable {

	public static final char[] OPEN_INSTRUCTION = new char[]{ '<','?','x','m','l', ' ' };
	public static final char[] OPEN_BEGIN_MARKUP = new char[] { '<' };
	public static final char[] OPEN_END_MARKUP = new char[] { '<','/' };
	public static final char[] OPEN_COMMENT = new char[] { '<','!','-','-' };

	public static final char[] CLOSE_INSTRUCTION = new char[]{ '?','>' };
	public static final char[] CLOSE_MARKUP = new char[] { '>' };
	public static final char[] CLOSE_SIMPLE_MARKUP = new char[] { '/','>' };
	public static final char[] CLOSE_COMMENT = new char[] { '-','-','>' };
	
	public static final char[] ATTRIBUTE_NAMESPACE = new char[] { 'x','m','l','n','s' };
	public static final char[] ATTRIBUTE_VERSION = new char[] { 'v','e','r','s','i','o','n' };
	public static final char[] ATTRIBUTE_ENCODING = new char[] { 'e','n','c','o','d','i','n','g' };
	public static final char[] ATTRIBUTE_STANDALONE = new char[] { 's','t','a','n','d','a','l','o','n','e' };
	
	// Properties
	/**
	 * Gets the XML datagram.
	 * @return the XML datagram
	 */
	char[] getDatagram();
	/**
	 * Sets the XML datagram.
	 * @param datagram the XML datagram
	 */
	void setDatagram(char[] datagram);
	
	// Methods
	/* (non-Javadoc)
	 * @see java.lang.Appendable#append(char)
	 */
	XML append(char c);
	
	/* (non-Javadoc)
	 * @see java.lang.Appendable#append(java.lang.CharSequence)
	 */
	XML append(CharSequence csq);
	
	/* (non-Javadoc)
	 * @see java.lang.Appendable#append(java.lang.CharSequence, int, int)
	 */
	XML append(CharSequence csq, int start, int end);
	
	/**
	 * @param xml
	 */
	XML append(XML xml);
	
	/**
	 * Returns a clone of current XML.
	 * @return
	 */
	XML clone();

	/**
	 * @param xml
	 * @return
	 */
	boolean contains(int ch);
	
	/**
	 * @param prefix
	 * @return
	 */
	boolean startsWith(XML prefix);
	
	/**
	 * @param prefix
	 * @param offset
	 * @return
	 */
	boolean startsWith(XML prefix, int offset);
	
	/**
	 * @param prefix
	 * @return
	 */
	boolean endsWith(XML prefix);
	
	/**
	 * @param ch
	 * @return
	 */
	int indexOf(int ch);
	
	/**
	 * @param ch
	 * @param offset
	 * @return
	 */
	int indexOf(int ch, int offset);
	
	/**
	 * @param xml
	 * @return
	 */
	int indexOf(XML xml);
	
	/**
	 * @param xml
	 * @param offset
	 * @return
	 */
	int indexOf(XML xml, int offset);
	
	/**
	 * @param ch
	 * @return
	 */
	int lastIndexOf(int ch);
	
	/**
	 * @param ch
	 * @param offset
	 * @return
	 */
	int lastIndexOf(int ch, int offset);
	
	/**
	 * @param xml
	 * @return
	 */
	int lastIndexOf(XML xml);
	
	/**
	 * @param xml
	 * @param offset
	 * @return
	 */
	int lastIndexOf(XML xml, int offset);

	/**
	 * @param dst
	 * @param offset
	 */
	void load(char dst[], int offset);

	/**
	 * @param regex
	 * @return
	 */
	XML[] split(XML pattern);
	
	/**
	 * @param regex
	 * @param limit
	 * @return
	 */
	XML[] split(XML pattern, int limit);
	
	/**
	 * @param start
	 * @return
	 */
	XML subSequence(int start);
	
	/* (non-Javadoc)
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	XML subSequence(int start, int end);
	
	/**
	 * @return
	 */
	char[] toCharArray();
	
	/* (non-Javadoc)
	 * @see java.lang.CharSequence#toString()
	 */
	java.lang.String toString();
	
	/**
	 * @return
	 */
	XML toXML();
}