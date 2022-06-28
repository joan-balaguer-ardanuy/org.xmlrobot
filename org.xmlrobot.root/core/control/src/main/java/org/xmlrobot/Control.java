/**
 * 
 */
package org.xmlrobot;

import java.util.Map;

/**
 * @author joan
 *
 */
public interface Control 
	extends Robot<Control>, Map<Data, Object> {

	void initialitze();
	void load();
}