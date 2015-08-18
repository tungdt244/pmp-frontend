package net.bees.frontend.client.history.recreate;

public class RecreateItem {

	private long orgId;
	private String boxType;
	private int orderId;
	private int filterType;
	private boolean resetOrderPanel;
	private String viewType;
	private long contractId;

	
	public RecreateItem(long orgId, String boxType, int orderId,
			int filterType, boolean resetOrderPanel) {
		super();
		this.orgId = orgId;
		this.boxType = boxType;
		this.orderId = orderId;
		this.filterType = filterType;
		this.resetOrderPanel = resetOrderPanel;
		
	}
	
	public RecreateItem(long orderId, long contractId){
		this.orderId = (int) orderId;
		this.contractId = contractId;
	}
	
	public RecreateItem() {
		
	}


	public long getOrgId() {
		return orgId;
	}
	
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	public String getBoxType() {
		return boxType;
	}
	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFilterType() {
		return filterType;
	}
	public void setFilterType(int filterType) {
		this.filterType = filterType;
	}
	public boolean isResetOrderPanel() {
		return resetOrderPanel;
	}
	public void setResetOrderPanel(boolean resetOrderPanel) {
		this.resetOrderPanel = resetOrderPanel;
	}


	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}


	public long getContractId() {
		return contractId;
	}


	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

}
