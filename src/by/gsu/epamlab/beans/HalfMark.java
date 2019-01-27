package by.gsu.epamlab.beans;

public class HalfMark extends Mark {
	public HalfMark(int value) {
		super(value);
	}
	
	public HalfMark(String value) {
		super((int)(Double.parseDouble(value) * 2));
	}
	
	@Override
	public void setValue(String value) {
		super.setValue((int)(Double.parseDouble(value) * 2));
	}

	@Override
	public String toString() {
		int value = getValue();
		String res = String.valueOf(getValue() / 2);
		int mod = value % 2;
		if (mod != 0) {
			res += "." + 5;
		}
		return res;
	}
}
