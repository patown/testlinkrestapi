# testlinkrestapi
TestLink REST API
Using com.testlinkrestapi.TLRestClient to handle TestLink operations via rest api. 

Below is an example

	@Test
	public void TestgetTestProjectByID(){    	
		Integer id =1;
		TestProjectBean bean=tlclient.getTestProjectByID(id);
		Assert.assertFalse("error while retriving a project",bean.getId()==id.toString());
		}

Please checkout the issues regrarding TestLink restapi from "issues" before you decide to merge this project with your framework. 
