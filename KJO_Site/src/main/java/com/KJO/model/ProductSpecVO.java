package com.KJO.model;

import java.util.List;

public class ProductSpecVO {
	private List Spec;

	public List getSpec() {
		return Spec;
	}

	public void setSpec(List spec) {
		Spec = spec;
	}

	@Override
	public String toString() {
		return "ProductSpecVO [Spec=" + Spec + "]";
	}
}
