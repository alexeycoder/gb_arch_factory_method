package edu.alexey.factorymethodpattern.concrete;

import edu.alexey.factorymethodpattern.BaseReader;
import edu.alexey.factorymethodpattern.concrete.TextFileReader.TextEntry;

public class PoemReader extends BaseReader {

	private String data;

	@Override
	public void setDataSource(Object data) {
		this.data = String.valueOf(data);
	}

	@Override
	public Iterable<PoemEntry> readEntries() {

		return this.data.lines().skip(position).map(PoemEntry::new).toList();
	}

	public static class PoemEntry extends TextEntry {

		public PoemEntry(String content) {
			super(content);
		}
	}
}
