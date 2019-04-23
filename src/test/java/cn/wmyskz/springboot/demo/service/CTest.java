package cn.wmyskz.springboot.demo.service;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年03月27日 20:27
 */

public class CTest implements Runnable {

    private Logger log= LoggerFactory.getLogger(CTest.class);
    @Override
    public void run(){
        long start=System.currentTimeMillis();


        for (int i = 0; i <20000 ; i++) {
            log.info("asfFDSA");
            log.info("324ASDFAS");
        }
        long end=System.currentTimeMillis();
        log.info("耗时时间-->"+(end-start));
    }
}
