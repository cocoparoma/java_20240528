package day21.socket2;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Ccontact implements	Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 101010L;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	String name;
	String phoneNumber;
	@Override
	public String toString() {
		return "[" + name + "][" + phoneNumber + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ccontact other = (Ccontact) obj;
		return Objects.equals(phoneNumber, other.phoneNumber);
	}
	@Override
	public int hashCode() {
		return Objects.hash(phoneNumber);
	}
	public void update(String name, String phoneNumber) {//사용안했음 그냥 깡으로 옮겼음
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	

}
