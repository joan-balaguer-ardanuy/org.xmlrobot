package org.xmlrobot;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import hyperspace.XML;
import hyperspace.genesis.Chain;

public abstract class ChildControl 
	extends XML2<Stream<Object,Data>,Stream<Data,Object>> 
		implements Stream<Object,Data> {

	private static final long serialVersionUID = -666554516027637756L;

	Chain<Object,Data> chain;
	
	public ChildControl() {
		super();
	}
	public ChildControl(XML message) {
		super(message);
		chain = new ObjectData(DataObject.class, message);
	}
	public ChildControl(Class<? extends ChildControl> parentClass, Class<? extends ParentControl> childClass, XML message) {
		super(parentClass, childClass, message);
		chain = new ObjectData(DataObject.class, message.getMessage());
	}
	public ChildControl(ChildControl parent) {
		super(parent);
		chain = new ObjectData(DataObject.class, parent.getMessage());
	}
	public ChildControl(Class<? extends ParentControl> childClass, ChildControl parent, Stream<Object,Data> key, Stream<Data,Object> value) {
		super(childClass, parent, key, value);
		chain = new ObjectData(DataObject.class, parent.getMessage());
	}
	public ChildControl(ChildControl root, XML message) {
		super(root, message);
		chain = new ObjectData(DataObject.class, message);
	}
	public ChildControl(Class<? extends ParentControl> childClass, ChildControl root, XML message, Stream<Object,Data> key, Stream<Data,Object> value) {
		super(childClass, root, message, key, value);
		chain = new ObjectData(DataObject.class, message);
	}
	
	@Override
	public Object getInput() {
		return chain.getKey();
	}
	@Override
	public Object setInput(Object key) {
		return chain.setKey(key);
	}
	@Override
	public Data getOutput() {
		return chain.getValue();
	}
	@Override
	public Data setOutput(Data value) {
		return chain.setValue(value);
	}
	@Override
	public Data getOutput(Object key) {
		return chain.getValue(key);
	}
	@Override
	public Object getInput(Data value) {
		return chain.getKey(value);
	}
	@Override
	public Data getOutputOrDefault(Object key, Data defaultOutput) {
		return chain.getValueOrDefault(key, defaultOutput);
	}
	@Override
	public Object getInputOrDefault(Data value, Object defaultInput) {
		return chain.getKeyOrDefault(value, defaultInput);
	}
	@Override
	public int indexOfInput(Object key) {
		return chain.indexOfKey(key);
	}
	@Override
	public int indexOfOutput(Data value) {
		return chain.indexOfValue(value);
	}
	@Override
	public Data putOutput(Object key, Data value) {
		return chain.putValue(key, value);
	}
	@Override
	public Object putInput(Data value, Object key) {
		return chain.putKey(value, key);
	}
	@Override
	public Data putOutputIfAbsent(Object key, Data value) {
		return chain.putValueIfAbsent(key, value);
	}
	@Override
	public Object putInputIfAbsent(Data value, Object key) {
		return chain.putKeyIfAbsent(value, key);
	}
	@Override
	public Data replaceOutput(Object key, Data value) {
		return chain.replaceValue(key, value);
	}
	@Override
	public Object replaceInput(Data value, Object key) {
		return chain.replaceKey(value, key);
	}
	@Override
	public boolean replaceOutput(Object key, Data oldOutput, Data newOutput) {
		return chain.replaceValue(key, oldOutput, newOutput);
	}
	@Override
	public boolean replaceInput(Data value, Object oldInput, Object newInput) {
		return chain.replaceKey(value, oldInput, newInput);
	}
	@Override
	public void replaceAllOutputs(BiFunction<? super Object, ? super Data, ? extends Data> function) {
		chain.replaceAllValues(function);
	}
	@Override
	public void replaceAllInputs(BiFunction<? super Data, ? super Object, ? extends Object> function) {
		chain.replaceAllKeys(function);
	}
	@Override
	public boolean containsInput(Object key) {
		return chain.containsKey(key);
	}
	@Override
	public boolean containsOutput(Object value) {
		return chain.containsValue(value);
	}
	@Override
	public boolean removeInput(Object key) {
		return chain.removeKey(key);
	}
	@Override
	public boolean removeOutput(Data value) {
		return chain.removeValue(value);
	}
	@Override
	public boolean removeOutput(Object key, Data value) {
		return chain.removeValue(key, value);
	}
	@Override
	public boolean removeInput(Data value, Object key) {
		return chain.removeKey(value, key);
	}
	@Override
	public void forEachOutput(BiConsumer<? super Object, ? super Data> action) {
		chain.forEachValue(action);
	}
	@Override
	public void forEachInput(BiConsumer<? super Data, ? super Object> action) {
		chain.forEachKey(action);
	}
	@Override
	public Data computeOutputIfAbsent(Object key, Function<? super Object, ? extends Data> mappingFunction) {
		return chain.computeValueIfAbsent(key, mappingFunction);
	}
	@Override
	public Object computeInputIfAbsent(Data value, Function<? super Data, ? extends Object> mappingFunction) {
		return chain.computeKeyIfAbsent(value, mappingFunction);
	}
	@Override
	public Data computeOutputIfPresent(Object key, BiFunction<? super Object, ? super Data, ? extends Data> remappingFunction) {
		return chain.computeValueIfPresent(key, remappingFunction);
	}
	@Override
	public Object computeInputIfPresent(Data value, BiFunction<? super Data, ? super Object, ? extends Object> remappingFunction) {
		return chain.computeKeyIfPresent(value, remappingFunction);
	}
	@Override
	public Data computeOutput(Object key, BiFunction<? super Object, ? super Data, ? extends Data> remappingFunction) {
		return chain.computeValue(key, remappingFunction);
	}
	@Override
	public Object computeInput(Data value, BiFunction<? super Data, ? super Object, ? extends Object> remappingFunction) {
		return chain.computeKey(value, remappingFunction);
	}
	@Override
	public Data mergeOutput(Object key, Data value, BiFunction<? super Data, ? super Data, ? extends Data> remappingFunction) {
		return chain.mergeValue(key, value, remappingFunction);
	}
	@Override
	public Object mergeInput(Data value, Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
		return chain.mergeKey(value, key, remappingFunction);
	}
}