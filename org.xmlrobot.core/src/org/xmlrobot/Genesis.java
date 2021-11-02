/**
 * 
 */
package org.xmlrobot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import org.xmlrobot.event.Tachyon;
import org.xmlrobot.util.Abort;

/**
 * @author joan
 *
 */
public abstract class Genesis
	extends Object
		implements Listener {

	/**
	 * 8953679534809472048L
	 */
	private static final long serialVersionUID = 8953679534809472048L;

	/**
	 * The maximum size of array to allocate.
	 * Some VMs reserve some header words in an array.
	 * Attempts to allocate larger arrays may result in
	 * OutOfMemoryError: Requested array size exceeds VM limit
	 */
	protected static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	/**
	 * The command being executed.
	 */
	Command command = Command.GENESIS;
	
	/**
	 * The parity.
	 */
	Parity gen;
	
	/**
	 * The listeners channel
	 */
	Listener listener;

	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getName()
	 */
	@Override
	public abstract java.lang.String getName();
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getCommand()
	 */
	@Override
	public Command getCommand() {
		return this.command;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#setCommand(org.xmlrobot.util.Command)
	 */
	@Override
	public void setCommand(Command command) {
		this.command = command;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#getGen()
	 */
	@Override
	public Parity getGen() {
		return gen;
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity gen) {
		this.gen = gen;
	}

	
	Thread runner;

	public Thread getRunner() {
		return runner;
	}

	public void setRunner(Thread runner) {
		this.runner = runner;
	}

	public Genesis() {
		this(Parity.YY);
	}
	public Genesis(Parity gen) {
		setGen(gen);
	}

	/**
	 * Sends mass event to parent
	 * @param event the recurred event
	 */
	protected void sendMass(Tachyon<?,?> event) {
		listener.event(this, event);
	}
	@Override
	public void execute(Runnable command) {
		try {
			newThread(command).start();
		}
		catch (Throwable t) {
			throw new Abort(t);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		switch (getCommand()) {
		case LISTEN:
			setCommand(Command.TRANSFER);
			break;
		default:
			setCommand(Command.LISTEN);
			break;
		}
	}
	@Override
	public Thread newThread(Runnable runnable) {
		return new Thread(runnable);
	}
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	@Override
	public abstract void event(Listener sender, Tachyon<?,?> event);
	
	/**
	 * The randomness.
	 */
	transient Random random;
	
	/**
	 * The random.
	 * @return the random.
	 */
	protected Random random() {
		return random == null ? (random = new Random()) : random;
	}
	
	/**
	 * Returns new instance of type X.
	 * @param type the type of the returned instance
	 * @param args the constructor arguments
	 * @return new instance of type X
	 */
	protected static <X> X instance(Class<X> type, Object... args) {
		try {
			return type.getDeclaredConstructor(getClasses(args)).newInstance(args);
		}
		catch(Throwable t) {
			throw new Abort(t);
		}
	}
	/**
	 * Returns an array containing the classes for an input object array.
	 * @param objects the input object array
	 * @return an array containing the classes for an input object array
	 */
	static Class<?>[] getClasses(Object... objects) {
		Class<?>[] types = new Class<?>[objects.length];
		for(int i = 0; i < objects.length; i++) {
			types[i] = objects[i].getClass();
		}
		return types;
	}
	/**
	 * Deserializes to Object from given file
     * @param fileName the file name
	 * @return the deserialized object
	 * @throws IOException when something is wrong
	 * @throws ClassNotFoundException when something is wrong
	 */
	public static Object deserialize(java.lang.String fileName) 
			throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        java.lang.Object obj = ois.readObject();
        ois.close();
        return obj;
    }
    
	/**
     * Serializes the given object and save it to file
     * @param obj the given object
     * @param fileName the file name
     * @throws java.io.IOException when something is wrong
     */
	public static void serialize(Object obj, java.lang.String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }
}