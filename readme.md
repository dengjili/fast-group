### 这是一个记录开发技术的项目，设计以下过程

**当前系统阶段为 2**

 1. 后台springmvc，spring，mybatis，页面jstl+jsp（ 前后端绑定），服务器tomcat，版本采用git管理，托管于github
 2. 完善ssm框架，提供分页，异常等框架的支持，完成一个基础blog的页面
 3. 引入layui/easyui/bootstrap框架（组件化，如维护唯一ajax请求）
 4. 支持 vue.js，前后端办分离（半分离，还是选择node.js 完全分离）
 5. 页面引入中间件，页面搜索。url支持restfull风格
 51. 持续集成之代码质量管理-Sonar，改变不良编写代码习惯，搭建周边系统
 6. 引入中间件，redis，mq等（针对某个业务演进），可以引入任意中间件
 61. 完善后台进程辅助功能,补偿系统
 7. 支持RPC，引入dubbo（分布式） ,kafaka 或者  spring boot 微服务方向，具体到时候讨论
 71. 系统若为分布式，应支持单点登录
 72. 扩大系统规模，提高系统性能，数据库读写分离，分表分库，前台引入nginx
 8. 自定义框架，如使用自定义springmvc，spring，mybatis，dubbo等，属于源码阅读，后续使用自定义的框架替代
 81. 是否考虑迁移数据库？
 82. Spring Cloud服务治理？
 9. 关于部署，jenkins自动化部署
 10. 工作流引入，业务流程化
 
### 计划可以在实际过程中修改
版本过程安排，每一个过程打大个版本0.00,1.00,2.00