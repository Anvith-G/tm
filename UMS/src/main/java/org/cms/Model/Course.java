package org.cms.Model;

import java.util.Objects;

public class Course {
	private String cid;
	private	String cname;
	private String credit;
	private String ctype;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cid, cname, credit, ctype);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(cid, other.cid) && Objects.equals(cname, other.cname)
				&& Objects.equals(credit, other.credit) && Objects.equals(ctype, other.ctype);
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", credit=" + credit + ", ctype=" + ctype + "]";
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String cid, String cname, String credit, String ctype) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.credit = credit;
		this.ctype = ctype;
	}
	

}
