package org.xmlrobot.configuration;

import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import hyperspace.Message;
import hyperspace.XML;
import jakarta.xml.bind.annotation.XmlElement;

import org.xmlrobot.configuration.adapter.ConnectionQNameAdapter;
import org.xmlrobot.configuration.adapter.ConnectionUrlAdapter;

/**
 * Service connection {@link XML} {@link Message} class.
 * Encapsulates a {@link QName} and {@link URL} properties. It contains all
 * necessary data to connect to the WebService server which will
 * provide the {@link Configuration} configuration XML message.
 * @author joan
 *
 */
@XmlRootElement
public final class Connection 
	extends XML {

	/**
	 * 355219426287742894L
	 */
	private static final long serialVersionUID = 355219426287742894L;

	/**
	 * The QName property.
	 */
	private QName qName;
	/**
	 * The URL property
	 */
	private URL url;
	
	/**
	 * Returns the {@link QName} property.
	 * See {@link ConnectionQNameAdapter} to view how this class
	 * is marshalled and unmarshalled by JAXB framework.
	 * @return the {@link QName} property.
	 */
	@XmlJavaTypeAdapter(value = ConnectionQNameAdapter.class)
	public QName getQName() {
		return qName;
	}
	/**
	 * Sets the {@link QName} property.
	 * @param qName {@link QName} property to be set.
	 */
	public void setQName(QName qName) {
		this.qName = qName;
	}
	/**
	 * Returns the {@link URL} property-
	 * See {@link ConnectionUrlAdapter} to view how this class
	 * is marshalled and unmarshalled by JAXB framework.
	 * @return
	 */
	@XmlJavaTypeAdapter(value = ConnectionUrlAdapter.class)
	public URL getURL() {
		return url;
	}
	/**
	 * Sets the {@link URL} property.
	 * @param qName {@link URL} property to be set.
	 */
	public void setURL(URL url) {
		this.url = url;
	}
	
	/**
	 * {@link Connection} default class constructor.
	 */
	public Connection() {
		super();
	}
	
	
	@Override
	public Connection clone() {
		Connection serviceConnection = new Connection();
		serviceConnection.setQName(getQName());
		serviceConnection.setURL(getURL());
		return serviceConnection;
	}
}