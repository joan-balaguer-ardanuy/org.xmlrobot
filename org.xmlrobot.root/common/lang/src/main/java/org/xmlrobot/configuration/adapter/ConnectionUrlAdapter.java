package org.xmlrobot.configuration.adapter;

import java.net.URL;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.xmlrobot.configuration.ConnectionUrl;

/**
 * {@link XmlAdapter} that unmarshals from {@link ConnectionUrl} to {@link URL}
 * and marshals from {@link URL} to {@link ConnectionUrl}.
 * 
 * @author joan
 */
public class ConnectionUrlAdapter
	extends XmlAdapter<ConnectionUrl, URL>{

	public ConnectionUrlAdapter() {
	}
	
	@Override
	public URL unmarshal(ConnectionUrl v) throws Exception {
		if (v.getProtocol() != null && v.getHost() != null && v.getPort() != null && v.getFile() != null) {
			return new URL(v.getProtocol(), v.getHost(), v.getPort(), v.getFile());
		} else if (v.getProtocol() != null && v.getHost() != null && v.getFile() != null) {
			return new URL(v.getProtocol(), v.getHost(), v.getFile());
		} else if (v.getUrl() != null) {
			return new URL(v.getUrl());
		} else {
			throw new Exception();
		}
	}

	@Override
	public ConnectionUrl marshal(URL v) throws Exception {
		ConnectionUrl serviceUrl = new ConnectionUrl();
		serviceUrl.setUrl(v.toString());
		serviceUrl.setFile(v.getFile());
		serviceUrl.setHost(v.getHost());
		serviceUrl.setPort(v.getPort());
		serviceUrl.setProtocol(v.getProtocol());
		return serviceUrl;
	}

}
