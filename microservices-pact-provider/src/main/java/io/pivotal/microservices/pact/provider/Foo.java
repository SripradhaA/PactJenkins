package io.pivotal.microservices.pact.provider;

public class Foo {

    @Override
	public String toString() {
		//return "Foo [zz=" + zz + "]";
		return zz;
	}

	//private int value;
    private String zz;

    public String getZz() {
		return zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	/*public Foo(int value) {
        this.value = value;
    }*/
	public Foo(String zz) {
        this.zz = zz;
    }
    /*public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }*/
}
