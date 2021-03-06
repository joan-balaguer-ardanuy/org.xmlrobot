package org.xmlrobot.placeholder.string;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.xmlrobot.FieldType;

/**
 * TryParse XML message class. Inherits {@link AbstractString}.
 * It encapsulates a {@link FieldType} field type property.
 * @author joan
 *
 */
@XmlRootElement
public final class TryParse extends AbstractString {

	/**
	 * 6864269372865421299L
	 */
	private static final long serialVersionUID = 6864269372865421299L;

	/**
	 * The field type
	 */
	FieldType fieldType;
	
	/**
	 * Returns the {@link FieldType} field type.
	 * @return the {@link FieldType} field type.
	 */
	@XmlElement
	public FieldType getFieldType() {
		return fieldType;
	}
	/**
	 * Sets the {@link FieldType} field type.
	 * @param fieldType
	 */
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * {@link TryParse} default class constructor.
	 */
	public TryParse() {
		super();
	}
	@Override
	public TryParse clone() {
		// TODO Auto-generated method stub
		return null;
	}
}