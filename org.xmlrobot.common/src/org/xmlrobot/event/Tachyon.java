package org.xmlrobot.event;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.xmlrobot.TimeListener;
import org.xmlrobot.time.Recursive;


/**
 * @author joan
 *
 * @param <K>
 * @param <V>
 */
public class Tachyon<K,V> 
	extends Horizon<TimeListener<K,V>>
		implements TimeListener<K,V> {

	/**
	 * -7625491230729080861L
	 */
	private static final long serialVersionUID = -7625491230729080861L;

	@Override
	public K getParent() {
		return getSource().getParent();
	}
	@Override
	public K setParent(K past) {
		return getSource().setParent(past);
	}
	@Override
	public V getChild() {
		return getSource().getChild();
	}
	@Override
	public V setChild(V value) {
		return getSource().setChild(value);
	}
	@Override
	public K call() {
		return getSource().call();
	}
	@Override
	public K put(K parent) {
		return getSource().put(parent);
	}
	@Override
	public V get() {
		return getSource().get();
	}
	@Override
	public V set(V child) {
		return getSource().set(child);
	}
	@Override
	public Class<? extends K> getType() {
		return getSource().getType();
	}
	@Override
	public void setType(Class<? extends K> type) {
		getSource().setType(type);
	}
	@Override
	public Class<? extends V> getAntitype() {
		return getSource().getAntitype();
	}
	@Override
	public void setAntitype(Class<? extends V> antitype) {
		getSource().setAntitype(antitype);
	}
	
	/**
	 * {@link Tachyon} default class constructor.
	 * @param source {@link Recursive} the source time-listener
	 */
	public Tachyon(TimeListener<K,V> source) {
		super(source);
	}

	@Override
	public TimeListener<K,V> getSource() {
		return super.getSource();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public K clone()  {
		return getSource().clone();
	}
	@Override
	public void push(TimeListener<?,?> sender, Tachyon<K,V> event) {
		getSource().push(sender, event);
	}
	@Override
	public Iterator<K> iterator() {
		return getSource().iterator();
	}
	@Override
	public TimeListener.Transmitter<K,V> comparator() {
		return getSource().comparator();
	}
	@Override
	public int compareTo(V o) {
		return getSource().compareTo(o);
	}
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return getSource().cancel(mayInterruptIfRunning);
	}
	@Override
	public boolean isCancelled() {
		return getSource().isCancelled();
	}
	@Override
	public boolean isDone() {
		return getSource().isDone();
	}
	@Override
	public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return getSource().get(timeout, unit);
	}
	@Override
	public void clear() {
		getSource().clear();
	}
	@Override
	public boolean isEmpty() {
		return getSource().isEmpty();
	}
	@Override
	public Transmitter<K,V> comparator(K source) {
		return getSource().comparator(source);
	}
}