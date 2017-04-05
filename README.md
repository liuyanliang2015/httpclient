# httpclient

# example1 LocalHttpClient工具类-get请求-返回string字符串·
```
HttpUriRequest request = RequestBuilder
  .get()
	.setUri(host + "/gas/getNearByStores.do")
	.addParameter("id",  "123")
	.build();
System.out.println(LocalHttpClient.executeString(request));
```
