package day14;

class Contact implements Comparable<Contact> {
	public String nameString, phoneNumberString;

	public Contact(String nameString, String phoneNumberString) {
		this.nameString = nameString;
		this.phoneNumberString = phoneNumberString;
	}

	@Override
	public String toString() {
		return "Contact{" + "nameString='" + nameString + '\'' + ", phoneNumberString='" + phoneNumberString + '\''
				+ '}';
	}

	@Override
	public int compareTo(Contact other) {

		return nameString.compareTo(other.nameString);
	}

}
