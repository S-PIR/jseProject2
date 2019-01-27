package by.gsu.epamlab.beans;

public class DecimalMark extends Mark {

	public DecimalMark(int value) {
		super(value);
	}

	public DecimalMark(Mark value) {
		super(value.getValue());
	}

	public DecimalMark(String value) {
		super(value.replaceAll("\\.", ""));
	}

	@Override
	public void setValue(String value) {
		super.setValue(value.replaceAll("\\.", ""));
	}

	@Override
	public String toString() {
		int value = getValue();
		return value / 10 + "." + value % 10;
	}

}
