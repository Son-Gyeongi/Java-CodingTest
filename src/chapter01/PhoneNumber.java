package chapter01;

public class PhoneNumber {
    public final String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PhoneNumber)) return false;
        return phoneNumber.equals(((PhoneNumber) obj).phoneNumber);
    }
}
