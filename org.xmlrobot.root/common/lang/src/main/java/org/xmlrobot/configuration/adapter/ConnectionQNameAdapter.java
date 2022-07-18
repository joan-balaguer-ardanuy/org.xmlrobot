package org.xmlrobot.configuration.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import org.xmlrobot.configuration.ConnectionQName;

/**
 * {@link XmlAdapter} that unmarshals from {@link ConnectionQName} to {@link QName},
 * and marshals from {@link QName} to {@link ConnectionQName}.
 * 
 * @author joan
 */
public class ConnectionQNameAdapter 
	extends XmlAdapter<ConnectionQName, QName> {

	public ConnectionQNameAdapter() {
	}
	
	@Override
	public QName unmarshal(ConnectionQName v) throws Exception {
		if (v.getPrefix() != null && v.getNamespaceURI() != null && v.getLocalPart() != null) {
			return new QName(v.getNamespaceURI(), v.getLocalPart(), v.getPrefix());
		} else if (v.getNamespaceURI() != null && v.getLocalPart() != null) {
			return new QName(v.getNamespaceURI(), v.getLocalPart());
		} else {
			throw new Exception();
		}
	}

	@Override
	public ConnectionQName marshal(QName v) throws Exception {
		ConnectionQName serviceQName = new ConnectionQName();
		serviceQName.setNamespaceURI(v.getNamespaceURI());
		serviceQName.setLocalPart(v.getLocalPart());
		serviceQName.setPrefix(v.getPrefix());
		return serviceQName;
	}
}
