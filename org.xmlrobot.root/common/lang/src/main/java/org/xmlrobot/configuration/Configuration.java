package org.xmlrobot.configuration;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import hyperspace.XML;
import org.xmlrobot.content.ContentTypeRoot;
import org.xmlrobot.datatype.DataSource;

/**
 * The source XML message of the org.httprobot.
 * The parent instance will execute the orders set in this XML message.
 * It inherits {@link AbstractConfiguration} class and encapsulates
 * a {@link ContentTypeRoot}, that is the definition of the database for all data sources,
 * and {@link LinkedHashSet} of {@link DataSource} the contains all data to get information
 * from http servers.
 * @author joan
 *
 */
@XmlRootElement
public final class Configuration extends XML {

	/**
	 * 8762442432069232238L
	 */
	private static final long serialVersionUID = 8762442432069232238L;

	/**
	 * The root content type.
	 */
	ContentTypeRoot contentTypeRoot;
	/**
	 * The set of data sources.
	 */
	LinkedList<DataSource> dataSource;
	
	/**
	 * Returns the {@link ContentTypeRoot}.
	 * @return {@link ContentTypeRoot} the root content type.
	 */
	@XmlElement
	public ContentTypeRoot getContentTypeRoot() {
		return contentTypeRoot;
	}
	/**
	 * Sets the {@link ContentTypeRoot}.
	 * @param contentTypeRoot {@link ContentTypeRoot} the root content type.
	 */
	public void setContentTypeRoot(ContentTypeRoot contentTypeRoot) {
		this.contentTypeRoot = contentTypeRoot;
	}
	/**
	 * Returns a {@link LinkedHashSet} of {@link DataSource}.
	 * @return the {@link LinkedHashSet} of {@link DataSource}.
	 */
	@XmlElement
	public LinkedList<DataSource> getDataSource() {
		return dataSource;
	}
	/**
	 * Sets a {@link LinkedHashSet} of {@link DataSource}
	 * @param dataSource the {@link LinkedHashSet} of {@link DataSource}.
	 */
	public void setDataSource(LinkedList<DataSource> dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * {@link Configuration} default class constructor.
	 */
	public Configuration() {
		super();
	}
	@Override
	public Configuration clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
