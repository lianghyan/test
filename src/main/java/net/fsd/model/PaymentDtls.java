package net.fsd.model;

public class PaymentDtls {

	private long id;
	private long trainingId;
	private String trainingDes;
	private int payProgress;
	private long mentorId;
	private String mentorName;

	public String getTrainingDes() {
		return trainingDes;
	}

	public void setTrainingDes(String trainingDes) {
		this.trainingDes = trainingDes;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}

	public int getPayProgress() {
		return payProgress;
	}

	public void setPayProgress(int payProgress) {
		this.payProgress = payProgress;
	}

}
