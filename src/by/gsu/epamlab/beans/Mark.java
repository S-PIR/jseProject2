package by.gsu.epamlab.beans;


public class Mark {
	int value;

	public Mark(int value) {
		this.value = value;
	}

	public Mark(Mark value) {
		this.value = value.getValue();
	}

	public Mark(String value) {
		this.value = Integer.parseInt(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = Integer.parseInt(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
