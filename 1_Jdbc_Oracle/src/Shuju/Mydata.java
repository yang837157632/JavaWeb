package Shuju;

import java.util.Random;

public class Mydata {
	
	/**
	 * 获取学院名称
	 * @return
	 */
	public static String getXymc(){
		Random r = new Random();
		int r1 = r.nextInt(18);
		int r2 = r.nextInt(5);
		int r3 = r.nextInt(2);
		
		String[] s1 = { "北京", "上海", "武汉", "浙江", "河南", "湖南", "湖北", "香港", "河北", "陕西", "新疆",
				"内蒙古", "四川", "云南", "江西", "安徽", "福建", "广东"};
		String[] s2={"师范","理工","公商","经济管理","农业"};
		
		String[] s3={"大学","学院"};
		
		String name = s1[r1] + s2[r2] + s3[r3];
		
		return name;
	}
	
	/**
	 * 获取专业名称
	 * @return
	 */
	public static String getZymc(){
		Random r = new Random();
		int r1 = r.nextInt(10);
		int r2 = r.nextInt(5);
		int r3 = r.nextInt(2);
		
		String[] s1 = { "光电", "机械", "管理", "材料", "中德", "计算机", "理学", "能动", "外语", "环境"};
		String[] s2={"信息","科学","技术","测试","纳米"};
		
		String[] s3={"专业","工程"};
		
		String name = s1[r1] + s2[r2] + s3[r3];
		
		return name;
	}
	
	/**
	 * 获取班级名称
	 * @return
	 */
	public static String getBjmc(){
		Random r = new Random();
		int r1 = r.nextInt(10);
		int r2 = r.nextInt(5);
		int r3 = r.nextInt(7);
		
		String[] s1 = { "光电", "机械", "管理", "材料", "中德", "计算机", "理学", "能动", "外语", "环境"};
		
		String[] s2={"信息","科学","技术","测试","纳米"};
		
		String[] s3={"A","B","C","D","E","F","G",};
		
		String s4="班";
		
		String name = s1[r1] + s2[r2] + s3[r3] + s4;
		
		return name;
	}
	
	
	public static String getName() {
		Random r = new Random();
		int r1 = r.nextInt(25);
		int r2 = r.nextInt(118);
		int r3 = r.nextInt(117);

		String[] s1 = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "蒋",
				"沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔",
				"曹", "严" };

		String[] s2 = { "路", "上", "只", "我", "一", "个", "人", "背", "着", "手", "踱",
				"着", "一", "片", "天", "地", "好", "像", "是", "我", "我", "也", "像",
				"超", "出", "平", "常", "自", "己", "到", "另", "一", "世", "界", "里",
				"我", "爱", "热", "闹", "也", "爱", "冷", "静", "爱", "群", "居", "也",
				"爱", "独", "处", "像", "今", "晚", "上", "一", "个", "人", "在", "苍",
				"茫", "月", "下", "什", "么", "都", "可", "以", "想", "什", "么", "都",
				"可", "以", "不", "想", "便", "觉", "是", "个", "自", "由", "人", "白",
				"天", "里", "一", "定", "要", "做", "事", "一", "定", "要", "说", "话",
				"现", "在", "都", "可", "不", "理", "是", "独", "处", "妙", "处", "我",
				"且", "受", "用", "无", "边", "荷", "香", "月", "色", "好", "" };
		String[] s3 = { "路", "上", "只", "我", "一", "个", "人", "背", "着", "手", "踱",
				"着", "一", "片", "天", "地", "好", "像", "是", "我", "我", "也", "像",
				"超", "出", "平", "常", "自", "己", "到", "另", "一", "世", "界", "里",
				"我", "爱", "热", "闹", "也", "爱", "冷", "静", "爱", "群", "居", "也",
				"爱", "独", "处", "像", "今", "晚", "上", "一", "个", "人", "在", "苍",
				"茫", "月", "下", "什", "么", "都", "可", "以", "想", "什", "么", "都",
				"可", "以", "不", "想", "便", "觉", "是", "个", "自", "由", "人", "白",
				"天", "里", "一", "定", "要", "做", "事", "一", "定", "要", "说", "话",
				"现", "在", "都", "可", "不", "理", "是", "独", "处", "妙", "处", "我",
				"且", "受", "用", "无", "边", "荷", "香", "月", "色", "好" };
		String name = s1[r1] + s2[r2] + s3[r3];
		return name;
	}

	/***
	 * 随机获得地区名
	 * 
	 * @return
	 */
	public static String getAdd() {

		String[] s = { "北京", "上海", "广州", "深圳", "天津", "辽宁", "大连", "重庆", "成都",
				"杭州", "东莞", "西藏", "新疆", "内蒙古" ,"安徽","南京","江苏"};

		Random r = new Random();
		int n = r.nextInt(17);

		return s[n];
	}

	/***
	 * 返回随机公司名称
	 * 
	 * @return
	 */
	public static String getCom() {
		Random r1 = new Random();
		int n1 = r1.nextInt(21);
		int n2 = r1.nextInt(15);
		int n3 = r1.nextInt(15);
		int n4 = r1.nextInt(5);

		String[] s1 = { "中国", "中软", "东软", "IBM", "微软", "google", "搜狗", "火狐",
				"百度", "阿里", "360", "金山", "雅虎", "腾讯", "新浪", "soho", "搜狐", "苹果",
				"小米", "华为", "三星" };
		String[] s2 = { "创新", "联合", "国际", "瑞道", "锤子", "坚果", "巴巴", "数码", "电子",
				"咨询", "机械", "新能源", "百信", "世界", "" };
		String[] s3 = { "科技", "教育", "投资", "金融", "餐饮", "开发", "服务", "美食", "娱乐",
				"文化", "传媒", "影视", "中介", "环保", "" };
		String[] s4 = { "有限公司", "无限公司", "股份公司", "集团", "股份有限公司" };

		String s = s1[n1] + s2[n2] + s3[n3] + s4[n4];

		return s;
	}  
	
	/**
	 * 返回性别
	 * @return
	 */
	public static String getSex() {

		String[] s = { "男", "女"};

		Random r = new Random();
		int n = r.nextInt(2);

		return s[n];
	}
	
	/**
	 * 返回状态
	 * @return
	 */
	public static String getZT() {

		String[] s = { "优秀", "良好", "一般", "及格", "不及格"};

		Random r = new Random();
		int n = r.nextInt(5);

		return s[n];
	}
	
	/**
	 * 返回身份证号
	 * @return
	 */
	public static String getSfzh() {
		Random r1 = new Random();

		String s1 = r1.nextInt(50)+10+"";
		String s2 = r1.nextInt(30)+10+"";
		String s3 = r1.nextInt(30)+10+"";
		String s4 = r1.nextInt(10)+1990+"";
		String[] a5={"01","02","03","04","05","06","07","08","09","10","11","12"};
		String s5 = a5[r1.nextInt(12)];
		String[] a6={"01","02","03","04","05","06","07","08","09","10",
				"11","12","13","14","01","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","30"};
		String s6=a6[r1.nextInt(30)];

		String s = s1+s2+s3+s4+s5+s6;

		return s;
	}
	
	/**
	 * 获取时间
	 * @return
	 */
	public static String getTime() {
		Random r1 = new Random();

		String s1 = r1.nextInt(10)+2000+"";
		String[] a2 = {"01","02","03","04","05","06","07","08","09","10",
				"11","12"};
		String s2=a2[r1.nextInt(12)];
		String[] a6={"01","02","03","04","05","06","07","08","09","10",
				"11","12","13","14","01","16","17","18","19","20",
				"21","22","23","24","25","26","27","28"};
		String s3=a6[r1.nextInt(28)];
		String s4=Integer.toString(r1.nextInt(24));
		String s5=Integer.toString(r1.nextInt(60));		
		String s6=Integer.toString(r1.nextInt(60));

		String s = s1 + "-" + s2 + "-" + s3+" "+s4+":"+s5+":"+s6;
		return s;
	}
	
	public static String getTime2() {
		Random r1 = new Random();
		
		String[] a1={"01","02","03","04","05","06","07","08","09","10",
				"11","12","13","14","01","16","17","18","19","20",
				"21","22","23","24","25","26","27","28"};
		String s1=a1[r1.nextInt(28)];
		
		String s2=r1.nextInt(12)+1+"";

		String s3 = r1.nextInt(20)+2000+"";
		
		String s = s1 + "-" + s2 + "月-" + s3;
		return s;
	}
	
	/**
	 * 获取年龄
	 * @return
	 */
	public static int getAge() {
		Random r1 = new Random();

		int i=r1.nextInt(20)+20;
		
		return i;
	}
	
	/**
	 * 获取教师职位
	 * @return
	 */
	public static String getPos() {

		String[] s = { "讲师", "辅导员", "副教授", "教授", "高级教师", "博导", "实习讲师", "院士", "副院士" };

		Random r = new Random();
		int n = r.nextInt(9);

		return s[n];
	}
	
	/**
	 * 获取公司职位
	 * @return
	 */
	public static String getJob() {

		String[] s = { "工程师", "设计师", "程序员", "测试员", "CEO", "总监", "总管", "处理员", "销售" };

		Random r = new Random();
		int n = r.nextInt(9);

		return s[n];
	}
	
}
