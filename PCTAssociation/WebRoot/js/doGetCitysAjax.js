  var XMLHttpReq,pid;                                                             //创建XMLHttpRequest对象
  function createXMLHttpRequest()
  {
  	if(window.XMLHttpRequest)
  	{                               
  		//Mozilla浏览器
        XMLHttpReq = new XMLHttpRequest();
    }else if(window.ActiveXObject)
    {                           
    	//IE浏览器
        try
        {
            XMLHttpReq = new ActiveXObject( "Msxm12.XMLHTTP" );
        }catch(e)
        {
            try
            {
               XMLHttpReq = new ActiveXObject( "Microsoft.XMLHTTP" );
            }catch(e)
            {}
         }
      }
  }  
  //发送Ajax请求
  function sendAjaxRequest(url)
  {
     createXMLHttpRequest();                         //创建XMLHttpRequest对象
     XMLHttpReq.open("post",url,false);
     XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
     XMLHttpReq.send(null);
  }

  //回调函数processResponse
  function processResponse()
  {
      if(XMLHttpReq.readyState == 4)
      {
      	 if(XMLHttpReq.status == 200)
      	 {
            var citys = XMLHttpReq.responseXML.getElementsByTagName("city");
            var province = document.getElementById("province");
            var city = document.getElementById("city");
            if(pid == 0)
            {
                city.options.length = 0;
                addOption(province,citys);
                city.add(new Option("请选择",""));
            }else
            {
                city.options.length = 0;
                addOption(city,citys);
            }
         }else
         {    
         	  //响应未交互成功时，页面中的代码
              // "正在加载数据......"
         }
     }else
     {                                                  
     	//响应未加载成功时，页面中的代码
        // "正在验证用户名......"
     }
  }
  
  function addOption(selectObject,citys)
  {
 	 for( var i = 0; i < citys.length; i=i+1 ) 
 	 {
	     var cityi = citys[i];
	     var cityId = cityi.getElementsByTagName( "cityId" ).item(0).firstChild.nodeValue;
	     var cityName = cityi.getElementsByTagName( "cityName" ).item(0).firstChild.nodeValue;
	     if(i == 0)
	     {
	    	 selectObject.add(new Option("请选择",0));
		     selectObject.add(new Option(cityName,cityId));
	     }else
	     {
	    	 selectObject.add(new Option(cityName,cityId));
	     }	      
	 }
  }
  
  function getCitys(parent_id)
  {
	  pid = parent_id;
	  var url = "GetAllCountrys?parent_id="+parent_id;
	  sendAjaxRequest(url);
	  //window.alert("gff");
  } 
  function setUp()
  {
	  getCitys(0);
  }  
  onload = setUp;
  
  
  
  
  
  
  
  
  
  
  
  
  
 