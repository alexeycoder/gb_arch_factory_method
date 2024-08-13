package edu.alexey.factorymethodpattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReader implements Reader {

	private Path path;
	private int position;

	@Override
	public void setDataSource(Object filepathStr) {

		this.path = Path.of(filepathStr.toString());
	}

	/**
	 * Zero-based!
	 */
	@Override
	public void setPosition(int pos) {

		if (pos < 0) {
			throw new IllegalArgumentException();
		}
		this.position = pos;
	}

	/**
	 * Zero-based!
	 */
	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public Iterable<TextEntry> readEntries() {

		try {
			return Files.lines(path).skip(position).map(line -> new TextEntry(line)).toList();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static class TextEntry extends DataEntry {

		public TextEntry(String content) {
			super(content);
		}

		@Override
		public String toString() {
			return this.entryContent.toString();
		}
	}

}
