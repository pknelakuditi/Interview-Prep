package practise.initial;

public interface Foo {

Bar getBar();

public class Bar {

private String value;

public Bar(String value) {
this.setValue(value);
System.out.println("Bar is instantiated which will be defaultly static as it is nested in interface");
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}
}
}