package com.microserivers.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午3:40:52
 * 
 * @Todo: 公寓实体
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

	private int iddept;
	private String deptname;
	private String deptaddress;
	private String db_id;

	public int getIddept() {
		return iddept;
	}

	public void setIddept(int iddept) {
		this.iddept = iddept;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptaddress() {
		return deptaddress;
	}

	public void setDeptaddress(String deptaddress) {
		this.deptaddress = deptaddress;
	}

	public String getDb_id() {
		return db_id;
	}

	public void setDb_id(String db_id) {
		this.db_id = db_id;
	}

	public Dept(int iddept, String deptname, String deptaddress, String db_id) {
		super();
		this.iddept = iddept;
		this.deptname = deptname;
		this.deptaddress = deptaddress;
		this.db_id = db_id;
	}

	public Dept() {
		super();
	}

	@Override
	public String toString() {
		return "Dept [iddept=" + iddept + ", deptname=" + deptname + ", deptaddress=" + deptaddress + ", db_id=" + db_id
				+ "]";
	}

}
