package com.KJO.model;

public class ProductVgaVO {
	private String typeNum;
	private String vgaName;
	private String manufacturer;
	private String chipsetManufacturer;
	private String vgaSeries;
	private String baseClock;
	private String boostClock;
	private String processAmount;
	private String pciInterface;
	private String memoryType;
	private String memorySize;
	private String memoryBus;
	private int hdmiPort;
	private int dpPort;
	private int supportMonitorAmount;
	private boolean supportMultiVga;
	private boolean support4K;
	private boolean support5K;
	private String maxTDP;
	private String recommendTDP;
	private String powerPort;
	private String powerPhase;
	
	
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getVgaName() {
		return vgaName;
	}
	public void setVgaName(String vgaName) {
		this.vgaName = vgaName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getChipsetManufacturer() {
		return chipsetManufacturer;
	}
	public void setChipsetManufacturer(String chipsetManufacturer) {
		this.chipsetManufacturer = chipsetManufacturer;
	}
	public String getVgaSeries() {
		return vgaSeries;
	}
	public void setVgaSeries(String vgaSeries) {
		this.vgaSeries = vgaSeries;
	}
	public String getBaseClock() {
		return baseClock;
	}
	public void setBaseClock(String baseClock) {
		this.baseClock = baseClock;
	}
	public String getBoostClock() {
		return boostClock;
	}
	public void setBoostClock(String boostClock) {
		this.boostClock = boostClock;
	}
	public String getProcessAmount() {
		return processAmount;
	}
	public void setProcessAmount(String processAmount) {
		this.processAmount = processAmount;
	}
	public String getPciInterface() {
		return pciInterface;
	}
	public void setPciInterface(String pciInterface) {
		this.pciInterface = pciInterface;
	}
	public String getMemoryType() {
		return memoryType;
	}
	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}
	public String getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	public String getMemoryBus() {
		return memoryBus;
	}
	public void setMemoryBus(String memoryBus) {
		this.memoryBus = memoryBus;
	}
	public int getHdmiPort() {
		return hdmiPort;
	}
	public void setHdmiPort(int hdmiPort) {
		this.hdmiPort = hdmiPort;
	}
	public int getDpPort() {
		return dpPort;
	}
	public void setDpPort(int dpPort) {
		this.dpPort = dpPort;
	}
	public int getSupportMonitorAmount() {
		return supportMonitorAmount;
	}
	public void setSupportMonitorAmount(int supportMonitorAmount) {
		this.supportMonitorAmount = supportMonitorAmount;
	}
	public boolean isSupportMultiVga() {
		return supportMultiVga;
	}
	public void setSupportMultiVga(boolean supportMultiVga) {
		this.supportMultiVga = supportMultiVga;
	}
	public boolean isSupport4K() {
		return support4K;
	}
	public void setSupport4K(boolean support4k) {
		support4K = support4k;
	}
	public boolean isSupport5K() {
		return support5K;
	}
	public void setSupport5K(boolean support5k) {
		support5K = support5k;
	}
	public String getMaxTDP() {
		return maxTDP;
	}
	public void setMaxTDP(String maxTDP) {
		this.maxTDP = maxTDP;
	}
	public String getRecommendTDP() {
		return recommendTDP;
	}
	public void setRecommendTDP(String recommendTDP) {
		this.recommendTDP = recommendTDP;
	}
	public String getPowerPort() {
		return powerPort;
	}
	public void setPowerPort(String powerPort) {
		this.powerPort = powerPort;
	}
	public String getPowerPhase() {
		return powerPhase;
	}
	public void setPowerPhase(String powerPhase) {
		this.powerPhase = powerPhase;
	}
	
	@Override
	public String toString() {
		return "VgaVO [typeNum=" + typeNum + ", vgaName=" + vgaName + ", manufacturer=" + manufacturer
				+ ", chipsetManufacturer=" + chipsetManufacturer + ", vgaSeries=" + vgaSeries + ", baseClock="
				+ baseClock + ", boostClock=" + boostClock + ", processAmount=" + processAmount + ", pciInterface="
				+ pciInterface + ", memoryType=" + memoryType + ", memorySize=" + memorySize + ", memoryBus="
				+ memoryBus + ", hdmiPort=" + hdmiPort + ", dpPort=" + dpPort + ", supportMonitorAmount="
				+ supportMonitorAmount + ", supportMultiVga=" + supportMultiVga + ", support4K=" + support4K
				+ ", support5K=" + support5K + ", maxTDP=" + maxTDP + ", recommendTDP=" + recommendTDP + ", powerPort="
				+ powerPort + ", powerPhase=" + powerPhase + "]";
	}
	
	
	
}
