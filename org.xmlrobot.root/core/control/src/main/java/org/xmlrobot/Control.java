package org.xmlrobot;

import hyperspace.recurrent.Map;

public interface Control extends Robot<Control,Control> {

	Map<Data,Object> data();
}
