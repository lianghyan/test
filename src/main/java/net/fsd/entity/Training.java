package net.fsd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TRAINING")
public class Training {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "status")
	private String status;

	@Column(name = "progress")
	private Integer progress = 0;

	@Column(name = "fees")
	private Float fees = 0.0f;

	@Column(name = "commission_amount")
	private Float commissionAmount = 0.0f;

	@Column(name = "rating")
	private Integer rating = 0;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	private String startDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date")
	private String endDate;

	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name = "start_time")
	private String startTime;

	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name = "end_time")
	private String endTime;

	@Column(name = "amount_received")
	private Float amountReceived = 0.0f;

	@Column(name = "mentor_id")
	private Long mentorId;

	@Column(name = "skill_id")
	private Long skillId;

	@Column(name = "razorpay_payment_id")
	private String razorpayPaymentId;

	@Column(name = "descr")
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}

	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}

	public Training(long id) {
		this.id = id;
	}

	public Training() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Float getFees() {
		return fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}

	public Float getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(Float commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Float getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(Float amountReceived) {
		this.amountReceived = amountReceived;
	}

	public Long getMentorId() {
		return mentorId;
	}

	public void setMentorId(Long mentorId) {
		this.mentorId = mentorId;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}