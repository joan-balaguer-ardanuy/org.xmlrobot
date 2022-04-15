package org.xmlrobot;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum FieldType
{
	BASE64,
	BOOLEAN,
	DATETIME,
	FLOAT,
	INTEGER,
	STRING,
	URL,
	UUID,
}
