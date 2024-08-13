package edu.alexey.factorymethodpattern.concrete;

import java.util.NoSuchElementException;

import edu.alexey.factorymethodpattern.DataType;
import edu.alexey.factorymethodpattern.Reader;
import edu.alexey.factorymethodpattern.ReaderCreator;

public class ConcreteReaderCreator extends ReaderCreator {

	@Override
	protected Reader createReader(DataType dataType) {

		return switch (dataType) {
		case TEXT -> new TextFileReader();
		case POEM -> new PoemReader();
		case BINARY -> new ByTenBytesReader();
		case SYSLOG -> new SystemLogsReader();
		default -> throw new NoSuchElementException();
		};
	}

}
