package model;

import org.junit.Test;

import net.sf.json.JSONObject;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;
import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.util.DataUtils;


public class ProjectBean {
	@Test
	public void testProjectBean(){

	Options ops = new Options();
	ops.setAutomationEnabled(1);
	ops.setInventoryEnabled(1);
	ops.setRequirementsEnabled(1);
	ops.setTestPriorityEnabled(1);
	TestProjectBean tpBean=new TestProjectBean();
	tpBean.setName("projName").setActive(1).setIs_public(1).setOptions(ops);
	System.out.println(DataUtils.getJSONTestProject(tpBean));//JSONObject.fromObject(tpBean));
	}
}
