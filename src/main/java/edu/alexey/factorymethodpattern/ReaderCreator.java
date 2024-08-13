package edu.alexey.factorymethodpattern;

public abstract class ReaderCreator {

	protected Reader createPreparedReader(DataType dataType, Object data) {

		Reader reader = createReader(dataType);
		reader.setDataSource(data);
		reader.setPosition(0);
		return reader;
	}

	protected abstract Reader createReader(DataType dataType);
}
