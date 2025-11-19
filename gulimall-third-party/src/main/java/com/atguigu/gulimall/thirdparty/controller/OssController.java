package com.atguigu.gulimall.thirdparty.controller;


import com.aliyun.oss.common.auth.Credentials;
import com.aliyun.oss.common.auth.DefaultCredentials;
import com.aliyun.oss.common.auth.RequestSigner;
import com.aliyun.oss.common.comm.RequestMessage;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.internal.signer.OSSSignerParams;
import com.aliyun.oss.internal.signer.OSSV4Signer;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class OssController {
    public void policy(){
        //设置时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 设置未来时间为当前时间加上2小时
        LocalDateTime futureTime = currentTime.plus(2, ChronoUnit.HOURS);
        // 截至到秒单位
        LocalDateTime futureTimeTruncated = futureTime.truncatedTo(ChronoUnit.SECONDS);
        // 转换为Date类型
        Date futureDate = Date.from(futureTimeTruncated.atZone(ZoneId.systemDefault()).toInstant());


        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "";
        String accessKeySecret = "";
        String bucketName = "bucketname";
        String objectName = "1122.png";
        String resourcePath = "/bucketname/1122.png";
        String url = "https://"+bucketName+".oss-cn-beijing.aliyuncs.com/";

        Credentials credentials = new DefaultCredentials(accessKeyId,accessKeySecret);

        Set<String> additionalHeaderNames = new HashSet<>();
        additionalHeaderNames.add("host");

        OSSSignerParams ossSignerParams = new OSSSignerParams(resourcePath,credentials);
        ossSignerParams.setProduct("oss");
        ossSignerParams.setRegion("cn-beijing");
        ossSignerParams.setExpiration(futureDate);
        ossSignerParams.setAdditionalHeaderNames(additionalHeaderNames);

        RequestSigner requestSigner = OSSV4Signer.createRequestSigner(SignVersion.V4, ossSignerParams);
        RequestMessage requestMessage = new RequestMessage(bucketName, objectName);

        requestMessage.setMethod(HttpMethod.GET);
        URI enp =new URI(endpoint);
        //requestMessage.setEndpoint(enp);
        //requestMessage.setResourcePath(resourcePath);

        requestSigner.sign(requestMessage);

        System.out.println("Authorization:"+requestMessage.getHeaders().get(OSSHeaders.AUTHORIZATION));
        System.out.println("x-oss-date:"+requestMessage.getHeaders().get(OSSHeaders.OSS_DATE));

        System.out.println("URL:"+url+objectName);
    }
}
