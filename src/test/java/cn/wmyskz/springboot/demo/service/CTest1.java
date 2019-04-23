package cn.wmyskz.springboot.demo.service;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年03月27日 20:38
 */

    public class CTest1 implements Runnable {

        private Logger log= LoggerFactory.getLogger(cn.wmyskz.springboot.demo.service.CTest.class);
        @Override
        public void run(){
            long start=System.currentTimeMillis();


            for (int i = 0; i <20000 ; i++) {
                log.info("asf");
                log.info("324");
            }
            long end=System.currentTimeMillis();
            log.info("耗时时间-->"+(end-start));
        }
    }

