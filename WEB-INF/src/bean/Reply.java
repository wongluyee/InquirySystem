package bean;

import java.time.LocalDateTime;

public class Reply {
	private int replyId;
	private int inquiryId;
	private int userId;
	private String subject;
	private String contents;
	private LocalDateTime repliedAt;

	public Reply() {

	}

	public Reply(int inquiryId, int userId, String subject, String contents, LocalDateTime currentDateTime) {
		this.inquiryId = inquiryId;
		this.userId = userId;
		this.subject = subject;
		this.contents = contents;
		this.repliedAt = currentDateTime;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getRepliedAt() {
		return repliedAt;
	}

	public void setRepliedAt(LocalDateTime repliedAt) {
		this.repliedAt = repliedAt;
	}

}
