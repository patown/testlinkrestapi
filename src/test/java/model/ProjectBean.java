package model;

import org.junit.Test;

import net.sf.json.JSONObject;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;
import com.testlinkrestapi.model.Options;
import com.testlinkrestapi.model.TestProjectBean;
import com.testlinkrestapi.util.DataUtils;


public class ProjectBean {
	private static String json="{\"name\":\"FrenchToJD(month, day, year)\",\"notes\":\"This is a FrenchToJD\",\"color\":\"\",\"prefix\":\"FTJD\",\"active\":1,\"is_public\":1,\"options\":{\"requirementsEnabled\":0,\"testPriorityEnabled\":1,\"automationEnabled\":1,\"inventoryEnabled\":0}}\"";
	@Test
	public void testProjectBean(){

	Options ops = new Options();
	ops.setAutomationEnabled(1).setInventoryEnabled(1).setRequirementsEnabled(1).setTestPriorityEnabled(1);
	TestProjectBean tpBean=new TestProjectBean();
	tpBean.setName("projName").setIsActive(true).setIsPublic(true).setOptions(ops);
	System.out.println(DataUtils.getJSONTestProject(tpBean));//JSONObject.fromObject(tpBean));
	}
}
