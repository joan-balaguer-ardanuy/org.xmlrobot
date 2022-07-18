package org.xmlrobot;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import hyperspace.EventArgs;
import hyperspace.XML;
import hyperspace.genesis.DNA;

public abstract class ParentControl
	extends XML2<Stream<Data,Object>,Stream<Object,Data>>
		implements Stream<Data,Object> {

	private static final long serialVersionUID = -6986427437237528455L;

	DNA<Data,Object> dna;

	@Override
	public Data getInput() {
		return dna.getKey();
	}
	@Override
	public Data setInput(Data key) {
		return dna.setKey(key);
	}
	@Override
	public Object getOutput() {
		return dna.getValue();
	}
	@Override
	public Object setOutput(Object value) {
		return dna.setValue(value);
	}
	
	public ParentControl() {
		super();
	}
	public ParentControl(XML message) {
		super(message);
		dna = new DataObject(ObjectData.class, message);
		setCommand(EventType.STARTED);
	}	
	public ParentControl(Class<? extends ParentControl> parentClass, Class<? extends ChildControl> childClass, XML message) {
		super(parentClass, childClass, message);
		dna = new DataObject(ObjectData.class, message);
		setCommand(EventType.STARTED);
	}
	public ParentControl(ParentControl parent) {
		super(parent);
		dna = new DataObject(ObjectData.class, parent.getMessage());
		setCommand(EventType.STARTED);
	}
	public ParentControl(Class<? extends ChildControl> childClass, ParentControl parent, Stream<Data, Object> key, Stream<Object, Data> value) {
		super(childClass, parent, key, value);
		dna = new DataObject(ObjectData.class, parent.getMessage());
		setCommand(EventType.STARTED);
	}
	public ParentControl(ParentControl root, XML message) {
		super(root, message);
		dna = new DataObject(ObjectData.class, message);
		setCommand(EventType.STARTED);
	}
	public ParentControl(Class<? extends ChildControl> childClass, ParentControl root, XML message, Stream<Data, Object> key, Stream<Object, Data> value) {
		super(childClass, root, message, key, value);
		dna = new DataObject(ObjectData.class, message);
		setCommand(EventType.STARTED);
	}
	
	@Override
	public Object getOutput(Data key) {
		return dna.getValue(key);
	}
	@Override
	public Data getInput(Object value) {
		return dna.getKey(value);
	}
	@Override
	public Object getOutputOrDefault(Data key, Object defaultOutput) {
		return dna.getValueOrDefault(key, defaultOutput);
	}
	@Override
	public Data getInputOrDefault(Object value, Data defaultInput) {
		return dna.getKeyOrDefault(value, defaultInput);
	}
	@Override
	public int indexOfInput(Data key) {
		return dna.indexOfKey(key);
	}
	@Override
	public int indexOfOutput(Object value) {
		return dna.indexOfValue(value);
	}
	@Override
	public Object putOutput(Data key, Object value) {
		return dna.putValue(key, value);
	}
	@Override
	public Data putInput(Object value, Data key) {
		return dna.putKey(value, key);
	}
	@Override
	public Object putOutputIfAbsent(Data key, Object value) {
		return dna.putValueIfAbsent(key, value);
	}
	@Override
	public Data putInputIfAbsent(Object value, Data key) {
		return dna.putKeyIfAbsent(value, key);
	}
	@Override
	public Object replaceOutput(Data key, Object value) {
		return dna.replaceValue(key, value);
	}
	@Override
	public Data replaceInput(Object value, Data key) {
		return dna.replaceKey(value, key);
	}
	@Override
	public boolean replaceOutput(Data key, Object oldOutput, Object newOutput) {
		return dna.replaceValue(key, oldOutput, newOutput);
	}
	@Override
	public boolean replaceInput(Object value, Data oldInput, Data newInput) {
		return dna.replaceKey(value, oldInput, newInput);
	}
	@Override
	public void replaceAllOutputs(BiFunction<? super Data, ? super Object, ? extends Object> function) {
		dna.replaceAllValues(function);
	}
	@Override
	public void replaceAllInputs(BiFunction<? super Object, ? super Data, ? extends Data> function) {
		dna.replaceAllKeys(function);
	}
	@Override
	public boolean containsInput(Object key) {
		return dna.containsKey(key);
	}
	@Override
	public boolean containsOutput(Object value) {
		return dna.containsValue(value);
	}
	@Override
	public boolean removeInput(Data key) {
		return dna.removeKey(key);
	}
	@Override
	public boolean removeOutput(Object value) {
		return dna.removeValue(value);
	}
	@Override
	public boolean removeOutput(Data key, Object value) {
		return dna.removeValue(key, value);
	}
	@Override
	public boolean removeInput(Object value, Data key) {
		return dna.removeKey(value, key);
	}
	@Override
	public void forEachOutput(BiConsumer<? super Data, ? super Object> action) {
		dna.forEachValue(action);
	}
	@Override
	public void forEachInput(BiConsumer<? super Object, ? super Data> action) {
		dna.forEachKey(action);
	}
	@Override
	public Object computeOutputIfAbsent(Data key, Function<? super Data, ? extends Object> mappingFunction) {
		return dna.computeValueIfAbsent(key, mappingFunction);
	}
	@Override
	public Data computeInputIfAbsent(Object value, Function<? super Object, ? extends Data> mappingFunction) {
		return dna.computeKeyIfAbsent(value, mappingFunction);
	}
	@Override
	public Object computeOutputIfPresent(Data key, BiFunction<? super Data, ? super Object, ? extends Object> remappingFunction) {
		return dna.computeValueIfPresent(key, remappingFunction);
	}
	@Override
	public Data computeInputIfPresent(Object value, BiFunction<? super Object, ? super Data, ? extends Data> remappingFunction) {
		return dna.computeKeyIfPresent(value, remappingFunction);
	}
	@Override
	public Object computeOutput(Data key, BiFunction<? super Data, ? super Object, ? extends Object> remappingFunction) {
		return dna.computeValue(key, remappingFunction);
	}
	@Override
	public Data computeInput(Object value, BiFunction<? super Object, ? super Data, ? extends Data> remappingFunction) {
		return dna.computeKey(value, remappingFunction);
	}
	@Override
	public Object mergeOutput(Data key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
		return dna.mergeValue(key, value, remappingFunction);
	}
	@Override
	public Data mergeInput(Object value, Data key, BiFunction<? super Data, ? super Data, ? extends Data> remappingFunction) {
		return dna.mergeKey(value, key, remappingFunction);
	}
}