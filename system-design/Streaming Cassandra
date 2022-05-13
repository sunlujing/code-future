####  关系数据库
mysql 这类的关系数据库，提供了binlog这样的机制，我们可以把binlog 发送kafka，然后再加入分析系统，就可以很方便在分析平台处理我们的数据，并且数据是实时一致的；
####  NoSql 带来的问题
使用 cassandra这样的 nosql，一边是oltp平台，一边是 olap平台， 两边的数据要如何才能同步？
- Range query 想mysql这样，可以根据时间戳来不断的查询范围，来查询增量数据，在cassandra 不可行；
- Double-Writing；写入cassandra的时候，再写入 kafka。一个是性能的问题，另外如果要保持一致性，需要分布式事务；对于高吞吐要求的系统并不适用；
- Kafka as Event Source； 所有的操作先写到kafka，然后用不同的consumer来消费；cassandra是一个消费者；需要迁移应用层的代码，另外如果对 read 一致性要求较高，并不适合；

#### Cassandra的 Parsing Commit Logs
- Delayed Processing commitlog到达一定体量才会写入到cdc 目录，如果写入很少，延迟较长；
- Space Management，cdc 目录满了之后不会删除old；
- Duplicated Events； N个replica的节点，同一份数据会写N次；
- Out-of-Order Events；cdc数据顺序可能和 event-time的顺序不一致；
- Out-of-Band Schema Change 不支持 schema的变化
- Incomplete Row Data ；cdc只记录了change的columns；

#### 解决方案设计
##### 需求
- 不影响oltp的性能，或者影响很小；
- olap 和oltp 查询的结果一样，很小的延迟；

##### 方案
- node agent 在cassandra每个节点，由agent 处理log；时间去重排序；
- stream engine，在流计算平台处理重复和排序；
- 在终端应用端进行过滤；所有的数据都发给分析平台，然后查询的时候，使用view 来排序去重等工作；

#### 开源实现方案
https://debezium.io/documentation/reference/stable/connectors/cassandra.html
