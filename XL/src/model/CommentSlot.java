package model;


public class CommentSlot extends Slot {
	private String comment;

	public CommentSlot(String comment) {
		this.comment = comment;
	}

	public String toString() {
		return comment;
	}
	
	public String printString() {
		return comment.substring(1);
	}

	public String value() {
		return "0";
	}
}