//package cn.wmyskz.springboot.util;
//
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @author haiyun.guo
// * @Description:
// * @date 2019年02月15日 21:12
// */
//@Component
//@EnableScheduling
//public class TestQua {
//    @Scheduled(cron = "0/3 * * * * ? ")
//    public void autoRemind(){
//        System.out.println("测试");
////        System.out.println(11);
////        logger.info("定时器开始");
////        try{
////            int autoRemindSuccessfulCount = VivoConfigManager.getInteger("autoRemindSuccessfulCount",3);
////            long outoRemindTime = VivoConfigManager.getInteger("outoRemindTime",4*60*60*1000);
////            Approval approval = approvalService.selectByKey(approvalId);
////            int state = approval.getState();    //状态
////            int autoRemindCount = approval.getAutoRemindCount();    //自动提醒次数
////            long currentTime = System.currentTimeMillis();      //当前时间
////
////            Example exampleApproval = new Example(Approval.class);
////            exampleApproval.createCriteria()
////                    .andGreaterThanOrEqualTo("autoRemindCount",autoRemindSuccessfulCount)           //自动提醒次数小于等于3
////                    .andEqualTo("state", 1);                    //  状态为 1 未审批的审批单
////            List<Approval> approvalList = approvalService.getMapper().selectByExample(exampleApproval);
////
////            for (Approval appro : approvalList){
////                long lastRemindTime = appro.getLastRemindTime().getTime();       //获取最后提醒时间
////                long remindTime = lastRemindTime+outoRemindTime;
////                if (currentTime > remindTime){
////                    Example exampleCongfig = new Example(ApprovalDetailForConfig.class);
////                    exampleCongfig.createCriteria()
////                            .andEqualTo("approvalId", approvalId);
////                    List<ApprovalDetailForConfig> approvalDetailForConfig = approvalDetailForConfigService.getMapper().selectByExample(exampleCongfig);
////                    int changeCount = 0;
////                    if (approvalDetailForConfig != null) {
////                        changeCount = approvalDetailForConfig.size();
////                    }
////                    String alarmMsg = String.format("您有未及时处理的配置变更审批单！(自动提醒)\n申请人：%s\n变更原因：%s\n变更配置条数：%s",
////                            approval.getApplicantName(),approval.getChangeRemark(),changeCount);
////                    notifyService.approvalTimeoutRemindNotify(approval.getId(), "Approver", alarmMsg);
////                    autoRemindCount++;
////                    Approval record = new Approval();
////                    record.setId(approval.getId());
////                    record.setLastRemindTime(approval.getLastRemindTime());
////                    record.setAutoRemindCount(autoRemindCount);
////                    approvalMapper.updateByPrimaryKeySelective(record);
////                }
////            }
////        }catch (Exception e){
////            logger.error("定时器异常：{}",e);
////        }
//    }
//
//}
