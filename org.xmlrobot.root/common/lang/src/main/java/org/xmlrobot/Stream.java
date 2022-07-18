package org.xmlrobot;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface Stream<K,V> extends Robot<Stream<K,V>,Stream<V,K>> {

	K getInput();
    K setInput(K key);

    V getOutput();
    V setOutput(V value);
    
    V getOutput(K key);
    K getInput(V value);

    V getOutputOrDefault(K key, V defaultOutput);
    K getInputOrDefault(V value, K defaultInput);
    
    int indexOfInput(K key);
    int indexOfOutput(V value);
    
    V putOutput(K key, V value);
    K putInput(V value, K key);

    V putOutputIfAbsent(K key, V value);
    K putInputIfAbsent(V value, K key);
    
    V replaceOutput(K key, V value);
    K replaceInput(V value, K key);

    boolean replaceOutput(K key, V oldOutput, V newOutput);
    boolean replaceInput(V value, K oldInput, K newInput);
    
    void replaceAllOutputs(BiFunction<? super K, ? super V, ? extends V> function);
    void replaceAllInputs(BiFunction<? super V, ? super K, ? extends K> function);
    
    boolean containsInput(Object key);
    boolean containsOutput(Object value);
    
    boolean removeInput(K key);
    boolean removeOutput(V value);
    
    boolean removeOutput(K key, V value);
    boolean removeInput(V value, K key);
    
    void forEachOutput(BiConsumer<? super K, ? super V> action);
    void forEachInput(BiConsumer<? super V, ? super K> action);
    
    V computeOutputIfAbsent(K key, Function<? super K, ? extends V> mappingFunction);
    K computeInputIfAbsent(V value, Function<? super V, ? extends K> mappingFunction);
    
    V computeOutputIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);
    K computeInputIfPresent(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction);
    
    V computeOutput(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);
    K computeInput(V value, BiFunction<? super V, ? super K, ? extends K> remappingFunction);
    
    V mergeOutput(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction);
    K mergeInput(V value, K key, BiFunction<? super K, ? super K, ? extends K> remappingFunction);
}