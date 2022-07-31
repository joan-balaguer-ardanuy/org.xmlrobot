package org.xmlrobot.source;

import org.xmlrobot.configuration.Connection;
import org.xmlrobot.configuration.Configuration;

import hyperspace.XML;
import jakarta.xml.bind.annotation.XmlElement;

public class Source extends XML {

	private static final long serialVersionUID = 7892122082813137356L;
	
	Connection connection;
	Configuration configuration;
	
	@XmlElement
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@XmlElement
	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public Source() {
		super();
	}

}
