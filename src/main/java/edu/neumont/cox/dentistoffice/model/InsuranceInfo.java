package edu.neumont.cox.dentistoffice.model;

public class InsuranceInfo {

	private String companyName;
	private String groupId;
	private String memberId;
	
	public InsuranceInfo(String companyName, String groupId, String memberId) {
		this.setCompanyName(companyName);
		this.setGroupId(groupId);
		this.setMemberId(memberId);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
