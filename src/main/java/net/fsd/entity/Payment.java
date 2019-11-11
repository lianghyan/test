package net.fsd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "training_id")
	private long trainingId;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "pay_progress")
	private int payProgress;

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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long mentorId) {
		this.userId = userId;
	}

	public int getPayProgress() {
		return payProgress;
	}

	public void setPayProgress(int payProgress) {
		this.payProgress = payProgress;
	}

}
