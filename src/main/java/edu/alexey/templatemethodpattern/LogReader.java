package edu.alexey.templatemethodpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Основа работы алгоритма чтения данных.
 */
public abstract class LogReader {

	private int currentPosition;

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	/**
	 * Template Method!
	 * 
	 * @return Log entries as iterable object.
	 */
	public Iterable<LogEntry> readLogEntries() {

		List<LogEntry> logs = new ArrayList<LogEntry>();

		for (String str : readEntries(currentPosition)) {
			logs.add(parseLogEntry(str));
		}

		return logs;
	}

	public abstract Object getDataSource();

	public abstract void setDataSource(Object data);

	protected abstract Iterable<String> readEntries(Integer position);

	protected abstract LogEntry parseLogEntry(String entryStr);

}
