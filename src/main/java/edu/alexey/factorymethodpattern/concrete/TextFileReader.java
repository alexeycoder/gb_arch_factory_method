package edu.alexey.factorymethodpattern.concrete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import edu.alexey.factorymethodpattern.BaseReader;
import edu.alexey.factorymethodpattern.DataEntry;

public class TextFileReader extends BaseReader {

	private Path path;

	@Override
	public void setDataSource(Object filepathStr) {

		this.path = Path.of(filepathStr.toString());
	}

	@Override
	public Iterable<TextEntry> readEntries() {

		try {

			return Files.lines(path).skip(position).map(TextEntry::new).toList();

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
