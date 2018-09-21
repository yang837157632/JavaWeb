package com.Enum.season;

public enum Seasons {
	
	Spring(1,"春天万物复苏"),
	Summmer(2,"夏天生机勃勃"),
	Autumn(3,"秋天五谷丰登"),
	Winter(4,"冬天瑞雪丰年");
	
	private int order;
	private String desc;
	
	private Seasons(int order,String desc){
		this.order=order;
		this.desc=desc;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
