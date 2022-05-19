package Clases;

import java.sql.ResultSet;

public class Response {
	public ResultSet rs;
	public int status;
	public String msg;
	
	public Response(ResultSet rs, int status, String msg) {
		this.rs =rs;
		this.status = status;
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "st: " + (status == 1?"Correcto":"Error") + "\nmsg:" + msg + "\nResult:"+rs;
	}
}
