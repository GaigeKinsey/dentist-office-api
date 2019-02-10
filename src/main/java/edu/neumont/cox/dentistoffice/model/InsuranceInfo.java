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
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
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
