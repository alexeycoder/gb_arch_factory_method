package edu.alexey.factorymethodpattern.concrete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import edu.alexey.factorymethodpattern.BaseReader;
import edu.alexey.factorymethodpattern.DataEntry;

public class ByTenBytesReader extends BaseReader {

	public static final int N = 10;
	private byte[] bytes;

	@Override
	public void setDataSource(Object data) {

		if (!(data instanceof byte[])) {
			throw new IllegalArgumentException();
		}

		this.bytes = (byte[]) data;
	}

	@Override
	public Iterable<TenBytes> readEntries() {

		List<TenBytes> result = new ArrayList<ByTenBytesReader.TenBytes>();

		int index = position * N - 1;

		while (index < bytes.length) {

			byte[] portionArray = new byte[N];
			int count = 0;
			while (count < N && index < bytes.length) {
				portionArray[count] = bytes[index];
				++count;
				++index;
			}
			result.add(new TenBytes(portionArray));
		}

		return result;
	}

	public static class TenBytes extends DataEntry {

		private byte[] tenBytes;

		public TenBytes(byte[] tenBytes) {
			super(Objects.requireNonNull(tenBytes));
			if (tenBytes.length != N) {
				throw new IllegalArgumentException();
			}
			this.tenBytes = tenBytes;
		}

		@Override
		public String toString() {
			return Arrays.toString(tenBytes);
		}
	}

}
