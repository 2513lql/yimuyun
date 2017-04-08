## API说明
1. api接口为http接口,接口返回采用json
2. 时间格式统一采用时间戳
3. 数据传输统一采用UTF-8编码
```
api正常返回
{
    "code": 0,
    "content": {
        "mobile": "18010181009",
        "code": "521952"
    }
}
api异常返回，当发生异常时，content内容直接为异常描述
{
    "code": 1,
    "content": "验证码发送失败"
}
token校验不通过返回编码为2，提示用户重新登录
{
    "code": 2,
    "content": "[token] cannot be null"
}
请求结果包含code，content 两项
code为返回编码 0，正常，1，异常
content为返回内容
```
发生错误时，HTTP Status Code为400错，如400,401,403,404

## 返回状态说明
|  状态码 |  含义 | 说明  |
| :------------ | :------------ | :------------ |
| 200 | OK   | 请求成功  |
| 201 | CREATED   | 创建成功  |
| 202 | ACCEPTED   | 更新成功   |
| 400  | BAD REQUEST  | 请求的地址不存在或者包含不支持的参数   |
| 401  |UNAUTHORIZED    | 未授权  |
| 403 |  FORBIDDEN  | 被禁止访问  |
| 404  | NOT FOUND  | 请求的资源不存在   |
| 500 | INTERNAL SERVER ERROR	   |  内部错误  |
