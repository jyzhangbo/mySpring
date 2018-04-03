### 高级消息队列协议(AMQP)

#### JMS和AMQP区别
+ 在JMS中，有三个主要的参与者：消息的生产者、消息的消费者以及在生产者和消费者之间传递消息的通道（队列或主题）
+ AMQP的生产者并不会直接将消息发布到队列中。AMQP在消息的生产者以及传递信息的队列之间引入了一种间接的机制：Exchange

#### 四种标准的Exchange
+ Direct：如果消息的routing key与binding的routing key直接匹配的话，消息将会路由到该队列上；
+ Topic：如果消息的routing key与binding的routing key符合通配符匹配的话，消息将会路由到该队列上；
+ Headers：如果消息参数表中的头信息和值都与bingding参数表中相匹配，消息将会路由到该队列上；
+ Fanout：不管消息的routing key和参数表的头信息/值是什么，消息将会路由到所有队列上。

