package org.xmlrobot.net;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.xmlrobot.configuration.Configuration;

public class WebService extends Service implements MessageService {

	@Override
	public Configuration getSource() {
		Configuration message = this.getPort(MessageService.class).getSource();
		return message;
	}

	public WebService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}
}