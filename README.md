# HTTP请求工具类说明:

## example1 LocalHttpClient工具类-get请求-返回string字符串·
```
HttpUriRequest request = RequestBuilder
  .get()
	.setUri(host + "/gas/getNearByStores.do")
	.addParameter("id",  "123")
	.build();
System.out.println(LocalHttpClient.executeString(request));
```

## example2 LocalHttpClient工具类-post请求-返回string字符串串
```
HttpUriRequest request = RequestBuilder
	.post()
	.setHeader(formHeader)
	.setUri(host + "/gas/getNearByStores.do")
	.addParameter("accessToken", "cf8918f60571a1baf5b6d373e9c1df74")
	.addParameter("lng",  "116.318393")
	.addParameter("lat",  "40.041916")
	.build();
System.out.println(LocalHttpClient.executeString(request));
```

## example3 LocalHttpClient工具类-post请求-返回json对象
```
HttpUriRequest request = RequestBuilder
	.post()
	.setHeader(formHeader)
	.setUri(host + "/gas/getNearByStores.do")
	.addParameter("accessToken", "cf8918f60571a1baf5b6d373e9c1df74")
	.addParameter("lng",  "116.318393")
	.addParameter("lat",  "40.041916")
	.build();
System.out.println(LocalHttpClient.executeJson(request, Result.class));
```


## example4 HttpUtil工具类-post请求-返回JSONObject对象
```
Map <String,String> map = new HashMap<String,String>();
map.put("accessToken", "cf8918f60571a1baf5b6d373e9c1df74");
map.put("lng", "116.318393");
map.put("lat",  "40.041916");
JSONObject obj  =HttpUtil.httpRequest(host + "/gas/getNearByStores.do", "POST", map);
System.out.println(g.toJson(obj));
```

