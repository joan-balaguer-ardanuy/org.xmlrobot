package org.xmlrobot.event;

import java.util.EventObject;

import org.xmlrobot.Command;
import org.xmlrobot.Listener;
import org.xmlrobot.Parity;

/**
 * @author joan
 *
 */
public class Horizon<T extends Listener>
	extends EventObject
		implements Listener {

	/**
	 * 2764300352015912261L
	 */
	private static final long serialVersionUID = 2764300352015912261L;
	
	@Override
	public Command getCommand() {
		return getSource().getCommand();
	}
	@Override
	public void setCommand(Command command) {
		getSource().setCommand(command);
	}
	@Override
	public Parity getGen() {
		return getSource().getGen();
	}
	@Override
	public void setGen(Parity parity) {
		getSource().setGen(parity);
	}
	@Override
	public Thread getRunner() {
		return getSource().getRunner();
	}
	@Override
	public void setRunner(Thread runner) {
		getSource().setRunner(runner);
	}
	@Override
	public String getName() {
		return getSource().getName();
	}
	
	/**
	 * @param source
	 */
	public Horizon(T source) {
		super(source);
	}
	
	@SuppressWarnings("unchecked")
	public T getSource() {
		return (T) super.getSource();
	}
	@Override
	public Thread newThread(Runnable r) {
		return getSource().newThread(r);
	}
	@Override
	public void run() {
		getSource().run();
	}
	@Override
	public void execute(Runnable command) {
		getSource().execute(command);
	}
	@Override
	public void setListener(Listener channel) {
		getSource().setListener(channel);
	}
	@Override
	public void event(Listener sender, Tachyon<?,?> e) {
		getSource().event(sender, e);
	}
}