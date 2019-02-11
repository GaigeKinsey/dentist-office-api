package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris and Gaige
 *
 */
public class InsuranceInfo extends Clinic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	private String groupId;
	private String memberId;

	/**
	 * Constructor for InsuranceInfo
	 * @param companyName
	 * @param groupId
	 * @param memberId
	 */
	public InsuranceInfo(String companyName, String groupId, String memberId) {
		this.setCompanyName(companyName);
		this.setGroupId(groupId);
		this.setMemberId(memberId);
	}

	/**
	 * @return String of the company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * sets the company name
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return String of the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * sets the groupId
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return String of the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * sets the memberId
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Company Name: " + this.getCompanyName() + ", Group ID: " + this.getGroupId() + ", Member ID: " + this.getMemberId();
	}

}
