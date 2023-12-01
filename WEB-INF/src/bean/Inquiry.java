package bean;

import java.time.LocalDateTime;

public class Inquiry {
	private int inquiryId;
	private String email;
	private String name;
	private LocalDateTime sentAt;
	private String category;
	private String contents;
	private String age;
	private String gender;
	private String address;
	private int isReplied = 0;

	public Inquiry () {

	}

	public Inquiry (String email, String name, LocalDateTime sentAt, String category, String contents, String age, String gender, String address) {
		this.email = email;
		this.name = name;
		this.sentAt = sentAt;
		this.category = category;
		this.contents = contents;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsReplied() {
		return isReplied;
	}

	public void setIsReplied(int isReplied) {
		this.isReplied = isReplied;
	}

}
