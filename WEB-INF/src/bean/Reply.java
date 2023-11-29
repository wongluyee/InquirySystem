package bean;

public class Reply {
	private int replyId;
	private int inquireId;
	private int userId;
	private String subject;
	private String contents;
	private String repliedAt;

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getInquireId() {
		return inquireId;
	}

	public void setInquireId(int inquireId) {
		this.inquireId = inquireId;
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

	public String getRepliedAt() {
		return repliedAt;
	}

	public void setRepliedAt(String repliedAt) {
		this.repliedAt = repliedAt;
	}

}
