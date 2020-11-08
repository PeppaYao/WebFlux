## TDD 测试驱动开发
- 主要关注单元测试UT
- 使用mockito进行模拟构建资源，通常是DAO层，或者协作开发时其他接口没有Ready
- 使用jacoco进行检测代码覆盖率和圈复杂度等
- 测试金字塔：ST 系统测试 IT 集成测试 UT 单元测试
## DDD 领域驱动模型 和 洋葱架构
- 【通常分为四层】
- Infrastructure 基础设施层
- Domain 领域层
- Application 应用层
- UserInterface 用户接口层
- 调用需求只能下层请求上层的调用
## BDD 行为驱动开发
- 重点关注从用户角度来看系统如何运作