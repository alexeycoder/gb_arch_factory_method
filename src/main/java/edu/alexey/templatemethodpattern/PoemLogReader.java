package edu.alexey.templatemethodpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс реализует примитивные шаги алгоритма.
 */
public class PoemLogReader extends LogReader {

	private String data;

	@Override
	public Object getDataSource() {
		return data;
	}

	@Override
	public void setDataSource(Object data) {
		this.data = data.toString();
	}

	public PoemLogReader(String data) {
		this.data = data;
	}

	public PoemLogReader() {
	}

	@Override
	protected Iterable<String> readEntries(Integer position) {

		if (null == data) {
			throw new IllegalStateException("PoemReader instance isn't initialized yet.");
		}

		List<String> lines = new ArrayList<String>();
		try (Scanner scanner = new Scanner(data)) {
			int readPos = 0;
			while (scanner.hasNextLine()) {
				if (++readPos >= position) {
					lines.add(scanner.nextLine());
				} else {
					scanner.nextLine();
				}
			}
			position = readPos;
		}

		return lines;
	}

	@Override
	protected LogEntry parseLogEntry(String entryStr) {
		return new LogEntry(entryStr);
	}

}
