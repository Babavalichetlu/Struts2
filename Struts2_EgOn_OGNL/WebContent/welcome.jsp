<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
 <head>
	<title>Struts 2 OGNL example</title>
 </head>
 <body>
	<h3>This is a OGNL example.</h3>
 
	<%-- <h5> All list items: <s:property value="myList" /> </h5>
	<h5> Second list item: <s:property value="myList[1]" /> </h5>
	<h5> List size: <s:property value="myList.size" /> </h5> --%>
	
	<b>Array Usage Examples</b>
        <br><hr>
<b>sampleArray :</b> <s:property value="sampleArray"/> <br>
<b>sampleArray.length :</b> <s:property value="sampleArray.length"/> <br>
<b>sampleArray[0] :</b> <s:property value="sampleArray[0]"/> <br>
<b>[0].sampleArray :</b> <s:property value="[0].sampleArray"/> <br>
<b>top.sampleArray :</b> <s:property value="top.sampleArray"/> <br>
 
 </body>
</html>