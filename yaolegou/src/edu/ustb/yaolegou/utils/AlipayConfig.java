package edu.ustb.yaolegou.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "9021000123602542";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQC3W4YS4TL7DyiP2814fOyvomYB0G4gJ+LI8n3sOtSBusMogFRChNs8wz4W5bYZ2EyeHqj4zT4PuC7HXGuvRuQ8Z1O+Lcn6Z9t1Yg69Ip9we8Ss664/EJbp3wCyXTJ66l1NaZfihjLifqBPAMmfcL9ZrspRl9lNhh23MAWQw0cfyhhjjTmRmCFLBXA5xlUY4BpasmQMJs99pght1yVoEpFzEQ7RjeCOccYok2nNWfZ5n7LB60kSYb3oQC6lhJPCx6W/vp1A2ohbQkDP++KoAMZNVYiu3tFhhc8vOxl6ZLHs13ryTPZONAKX7aVxxRZmn5GMHhHcTK6dM71vn1rwfBAJAgMBAAECggEBAJPGhMkkjOUAs4019mScMlnfRd1Cce8ilkmj/k7snyarMeyreL1fvB49sQXdPyWXSTDKvx4+tD0REUqFtxg9x2bTVA/bcYSKPbpePEi85clPRxSiof2bzjVREIuwRyX/SxFAADSGOe6HZYYmuVjyEpYiJFccTfuIEtz4LBQe/mykI6hb977x76K5Ul7cCaUADT55qyp/H+HozpKgjpRD4wd+XfGbXg50UDU2NPXYppJntFmNGy0DUhCaZ0fIe5hueiD03wIBl1TnfM0mmwLD2Sux4xmlTreYbfciFf2f5JUW/MyApHssDb28hnJBFpceXtDDWoBH28IB9lTA9wKmyE0CgYEA5fgxk4GN44PkvogqHCm/WQInVNmCTW5OWFlM/ldh1zr+rcmbAP9w9IPoaJb3UhjKw0xRblyPmbdQY2505FcVjbiuN/45Aw90hYej8cCqlAu6bzLD59AaDyTlW/aljEFUNB2BIcno4XuWVmzKWf+e5PLYXBn2lNCzwZSXMzF7MnMCgYEAzByoj6RdyWAU1C6sbqtzFLAYW671yTqz9ms7kQkCxsZsajEHN3g7PkBVZpinpeFmYeY97DTWRToXBOA38MAU+W7QOZFH7BVYtpo2cwM6+jI8j11YggIaINnuJnogXyv6TbEcxBUWVsyP+dMTJlTrbSn3UUm39gzHXW56XDMLiJMCgYEAszq1QLYW5HvV2hz7XMm4pOFF0B5ZLInMq5SlqhBmY71J4h4fHS74VMk9Z85I4QYLeRxQ1sdy76VsFKJwncm1Naf6uA79VgJEmRE21+KFzy441hNllZSdyrHBw+O98Eq2GovoKXJYeuu8Jo1RQ8UyjFMsBtQBVsg1YKizEqX80zsCgYEAq0a5I6AXmy3nDI4F3/A653dFWVodobiC3xropzHahJZoz0tI9QENJZWylB8xPv8/fJNKDvXff8PZIRxNlNZ6Qzz7ufLxWWgoQ0Jwwl5JlT2ml98KsD23Uy3Mq7j7hSFQLvWaX+gaEMgjYM4AWcAUtkvq3ulvVyct/HcCcm/bE8UCgYEAgUwC38pnk1xMZLVp2L/nomhwENwpCV+q+4p5Q4S2GXnBgLrvr3rXL4DFOJpOpceaaXUL109mqj32Ojybvh2heHNA9IWS2NfvJlv2RYKGRfhEwR30B0mgVdTRkuvmX9g3ATcR16YPTpX5bjM7w3A/uU6ZjGCqOwZtCACL/iFPkR8=";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjiaZuzBSRS83i2sZjbrZZqRjTethYA3j0rGBe1rUO2EHDkspKkdYmrYmfmyox78po7gKS9GOkCwAlsLeQq9PqLKokW8NWucg3BpPLDCzNS+//y/87i62uXNM7PG740Zll2aD0FqN13//UplIxL8V7xL1B+kfv2WthGY9iiP0uAkyoPNREireL46LM1yG0UzRn37y4JvkUaGFJ1uQsCgkimex29KUT1pJ6flH7m7bKYJIv9tTUqkAoLrPAXfGLQrldyEZWSadm6Z9U9SLPaV4/bq1lr1ciMM+pX+Dta4ttclhHyJ0Iddl9kN0xpEB0BwyEB5iMTomctRxdCfBeCCh/wIDAQAB";
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:9000/yaolegou/order/payresult";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:9000/yaolegou/order/payresult";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关 //
	// public static String gatewayUrl ="https://openapi.alipay.com/gateway.do";// 正式
//	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";// 测试
	public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";// 测试

	// 支付宝网关 日志
	public static String log_path = "D:\\alipay\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}