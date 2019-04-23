package cn.wmyskz.springboot.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年01月19日 16:39
 */
@Data
@Component
public class MogoConfigBean {


 private String database="test";
 private List<String> address=new ArrayList<String>(){{add("localhost:27017");}};
 private String replicaSet;
 private String username;
 private String password;
 private Integer minConnectionsPerHost = 0;
 private Integer maxConnectionsPerHost = 100;
 private Integer threadsAllowedToBlockForConnectionMultiplier = 5;
 private Integer serverSelectionTimeout = 30000;
 private Integer maxWaitTime = 120000;
 private Integer maxConnectionIdleTime = 0;
 private Integer maxConnectionLifeTime = 0;
 private Integer connectTimeout = 10000;
 private Integer socketTimeout = 0;
 private Boolean socketKeepAlive = false;
 private Boolean sslEnabled = false;
 private Boolean sslInvalidHostNameAllowed = false;
 private Boolean alwaysUseMBeans = false;
 private Integer heartbeatFrequency = 10000;
 private Integer minHeartbeatFrequency = 500;
 private Integer heartbeatConnectTimeout = 20000;
 private Integer heartbeatSocketTimeout = 20000;
 private Integer localThreshold = 15;
// private String authenticationDatabase;

 public MogoConfigBean(){}

}
