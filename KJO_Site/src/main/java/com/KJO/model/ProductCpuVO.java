package com.KJO.model;

import java.util.Date;

public class ProductCpuVO {
	private String typeNum;
	private String cpuName;
	private String manufacturer;
	private String cpuType;
	private String generation;
	private String coreType;
	private String threadType;
	private String baseClock;
	private String boostClock;
	private String l2Cache;
	private String l3Cache;
	private String tdp;
	private String memoryType;
	private String memoryBus;
	private String memoryChannel;
	private String innerGPU;
	private Date releaseDate;
	
	
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getCpuName() {
		return cpuName;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCpuType() {
		return cpuType;
	}
	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getCoreType() {
		return coreType;
	}
	public void setCoreType(String coreType) {
		this.coreType = coreType;
	}
	public String getThreadType() {
		return threadType;
	}
	public void setThreadType(String threadType) {
		this.threadType = threadType;
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
	public String getL2Cache() {
		return l2Cache;
	}
	public void setL2Cache(String l2Cache) {
		this.l2Cache = l2Cache;
	}
	public String getL3Cache() {
		return l3Cache;
	}
	public void setL3Cache(String l3Cache) {
		this.l3Cache = l3Cache;
	}
	public String getTdp() {
		return tdp;
	}
	public void setTdp(String tdp) {
		this.tdp = tdp;
	}
	public String getMemoryType() {
		return memoryType;
	}
	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}
	public String getMemoryBus() {
		return memoryBus;
	}
	public void setMemoryBus(String memoryBus) {
		this.memoryBus = memoryBus;
	}
	public String getMemoryChannel() {
		return memoryChannel;
	}
	public void setMemoryChannel(String memoryChannel) {
		this.memoryChannel = memoryChannel;
	}
	public String getInnerGPU() {
		return innerGPU;
	}
	public void setInnerGPU(String innerGPU) {
		this.innerGPU = innerGPU;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "CpuVO [typeNum=" + typeNum + ", cpuName=" + cpuName + ", manufacturer=" + manufacturer + ", cpuType="
				+ cpuType + ", generation=" + generation + ", coreType=" + coreType + ", threadType=" + threadType
				+ ", baseClock=" + baseClock + ", boostClock=" + boostClock + ", l2Cache=" + l2Cache + ", l3Cache="
				+ l3Cache + ", tdp=" + tdp + ", memoryType=" + memoryType + ", memoryBus=" + memoryBus
				+ ", memoryChannel=" + memoryChannel + ", innerGPU=" + innerGPU + ", releaseDate=" + releaseDate + "]";
	}

	
	
	
	
}
